package com.pe.asistente.deportivo.activity;

import android.app.DownloadManager;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.pe.asistente.deportivo.R;
import com.pe.asistente.deportivo.adapter.DrawerLayoutAdapter;
import com.pe.asistente.deportivo.beans.DrawerLayoutItem;
import com.pe.asistente.deportivo.fragment.FragmentCalcInidiceMasaCorporal;
import com.pe.asistente.deportivo.fragment.FragmentProgramacionEntrenamiento;
import com.pe.asistente.deportivo.fragment.FragmentSalirCorrer;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout drawerLayout;
    private LinearLayout left_drawer;
    private CircleImageView profileImage;
    private TextView txtNomUsuario;
    private ListView menuList;
    private String LOG_TAG = MainActivity.this.getClass().getSimpleName() + "-> ";

    /*Identificador del fragment activo*/
    private static int intFragmentSelect = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarControles();
    }

    private void inicializarControles() {
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().hide();

        String urlProfileImageview = "https://graph.facebook.com/" + Profile.getCurrentProfile().getId() + "/picture?type=large";

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        left_drawer = (LinearLayout) findViewById(R.id.left_drawer);
        profileImage = (CircleImageView) findViewById(R.id.profileImage);
        txtNomUsuario = (TextView) findViewById(R.id.txtNomUsuario);
        menuList = (ListView) findViewById(R.id.menuList);
        drawerLayout.openDrawer(left_drawer);

        Picasso.with(this).load(urlProfileImageview).error(R.mipmap.ic_launcher).into(profileImage);
        txtNomUsuario.setText(Profile.getCurrentProfile().getFirstName());

        final ArrayList<DrawerLayoutItem> items = new ArrayList<DrawerLayoutItem>();
        items.add(new DrawerLayoutItem(R.mipmap.ic_launcher, getResources().getString(R.string.salir_correr), true));
        items.add(new DrawerLayoutItem(R.mipmap.ic_launcher, getResources().getString(R.string.calorias_consumidas), false));
        items.add(new DrawerLayoutItem(R.mipmap.ic_launcher, getResources().getString(R.string.mi_masa_muscular), false));
        items.add(new DrawerLayoutItem(R.mipmap.ic_launcher, getResources().getString(R.string.miProgramaEntrenamiento), false));
        items.add(new DrawerLayoutItem(R.mipmap.ic_launcher, getResources().getString(R.string.compartir_aplicacion), false));

        final DrawerLayoutAdapter adapter = new DrawerLayoutAdapter(MainActivity.this, items);
        menuList.setAdapter(adapter);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawer(left_drawer);
                for (DrawerLayoutItem mItem : items) {
                    mItem.isSelected(false);
                }

                DrawerLayoutItem item = items.get(position);
                item.isSelected(true);

                adapter.notifyDataSetChanged();

                /*DESCRIMINANDO QUE FRAGMENT SE MOSTRARÀ*/
                Fragment contentFragment = null;

                switch (position) {
                    case 0:
                        contentFragment = FragmentSalirCorrer.newInstance(null);
                        break;
                    case 1:
                        break;
                    case 2:
                        contentFragment = FragmentCalcInidiceMasaCorporal.newInstance(null);
                        break;
                    case 3:
                        contentFragment = FragmentProgramacionEntrenamiento.newInstance(null);
                        break;
                }

                if (intFragmentSelect != position) {
                    if (contentFragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, contentFragment).commit();
                    }
                } else {
                    drawerLayout.closeDrawer(left_drawer);
                }
                intFragmentSelect = position;
            }
        });

        /*POR DEFECTO MOSTRAR EL FRAGMENTO DE SALIR A CORRER AL INICIAR LA APLICACION*/
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, FragmentSalirCorrer.newInstance(null)).commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            if (drawerLayout.isDrawerOpen(left_drawer)) {
                drawerLayout.closeDrawer(left_drawer);
            } else {
                drawerLayout.openDrawer(left_drawer);
            }
        }

        return false;
    }
}
