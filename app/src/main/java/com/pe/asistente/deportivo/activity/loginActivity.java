package com.pe.asistente.deportivo.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.pe.asistente.deportivo.R;
import com.pe.asistente.deportivo.adapter.LoginPagerAdapter;
import com.pe.asistente.deportivo.fragment.LoginFragmentPage;
import com.viewpagerindicator.CirclePageIndicator;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

public class loginActivity extends ActionBarActivity {

    private ViewPager pager;
    private CirclePageIndicator indicator;
    private LoginButton btnLoginFB;

    private static final String PERMISOS = "publish_actions";
    private CallbackManager callbackManager;
    private String LOG_TAG = this.getClass().getSimpleName().toString() + "-> ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        incializarControles();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActualizarUI();/*SI EL USUARIO YA SE LOGUEO ESTO HARA QUE INGRESE DIRECTAMENTE AL MAINACTIVITY*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void incializarControles() {
        getSupportActionBar().hide();
        pager = (ViewPager) findViewById(R.id.pager);
        indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        btnLoginFB = (LoginButton) findViewById(R.id.btnLoginFB);

        btnLoginFB.setReadPermissions(Arrays.asList("public_profile, email, user_birthday"));
        /*CallbackManager*/
        callbackManager = CallbackManager.Factory.create();
        btnLoginFB.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.e(LOG_TAG, "onSuccess");
                ActualizarUI();/*ESTA LINEA SOLO SE EJECUTARA LA PRIMERA VEZ QUE SE LOGUEE EL USUARIO*/

                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse) {
                        Toast.makeText(loginActivity.this, "Resultado JSON: " + jsonObject, Toast.LENGTH_LONG).show();
                        //Log.e(LOG_TAG, "Resultado: " + jsonObject);
                        ActualizarUI();
                    }
                });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                Log.e(LOG_TAG, "onCancel");
            }

            @Override
            public void onError(FacebookException e) {
                Log.e(LOG_TAG, "onError-> " + e.getMessage());
            }
        });

        indicator.setPageColor(getResources().getColor(R.color.celeste));
        indicator.setFillColor(getResources().getColor(R.color.plomo));

        ArrayList<Fragment> fragmentos = new ArrayList<Fragment>();
        fragmentos.add(new LoginFragmentPage());
        fragmentos.add(new LoginFragmentPage());
        fragmentos.add(new LoginFragmentPage());
        fragmentos.add(new LoginFragmentPage());
        fragmentos.add(new LoginFragmentPage());
        fragmentos.add(new LoginFragmentPage());

        LoginPagerAdapter adp = new LoginPagerAdapter(getSupportFragmentManager(), fragmentos);
        pager.setAdapter(adp);
        indicator.setViewPager(pager);
    }

    private void ActualizarUI() {
        //Log.e(LOG_TAG, getResources().getString(R.string.actualizandoUI));
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        Profile perfil = Profile.getCurrentProfile();

        if (accessToken != null && perfil != null) {
            startActivity(new Intent(loginActivity.this, MainActivity.class));
            loginActivity.this.finish();
        }else {

        }
    }
}
