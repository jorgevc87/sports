package com.pe.asistente.deportivo.util;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by JorgeLuis on 12/06/2015.
 */
public class HashCodeUtil {

    public static void getHashCode(Activity activity) {
        try {
            PackageInfo info = activity.getPackageManager().getPackageInfo(activity.getPackageName(), PackageManager.GET_SIGNATURES);

            for (Signature signature : info.signatures) {

                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("====Hash Key===", Base64.encodeToString(md.digest(),
                        Base64.DEFAULT));
                Toast.makeText(activity, Base64.encodeToString(md.digest(), Base64.DEFAULT), Toast.LENGTH_LONG).show();
            }

        } catch (PackageManager.NameNotFoundException e) {

            e.printStackTrace();

        } catch (NoSuchAlgorithmException ex) {

            ex.printStackTrace();

        }
    }
}
