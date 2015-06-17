package com.pe.asistente.deportivo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.pe.asistente.deportivo.R;
import com.pe.asistente.deportivo.service.Cronometro;

/**
 * Created by JorgeLuis on 13/06/2015.
 */
public class FragmentSalirCorrer extends Fragment {
    private Chronometer cronometro;

    private View v;
    private Button btnStartCronometro, btnPauseCronometro, btnSetCronometro, btnStopCronometro;

    public static FragmentSalirCorrer newInstance(Bundle bundle) {
        FragmentSalirCorrer f = new FragmentSalirCorrer();

        if (bundle != null) {
            f.setArguments(bundle);
        }

        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_salir_correr, container, false);
        inicializarControles();
        return v;
    }

    private void inicializarControles() {
        cronometro = (Chronometer)v.findViewById(R.id.cronometro);

        btnStartCronometro = (Button) v.findViewById(R.id.btnStartCronometro);
        btnPauseCronometro = (Button) v.findViewById(R.id.btnPauseCronometro);
        btnSetCronometro = (Button) v.findViewById(R.id.btnSetCronometro);
        btnStopCronometro = (Button) v.findViewById(R.id.btnStopCronometro);

        btnStartCronometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(new Intent(getActivity(), Cronometro.class));
            }
        });
        btnPauseCronometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnSetCronometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnStopCronometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(new Intent(getActivity(), Cronometro.class));
            }
        });
    }
}






























