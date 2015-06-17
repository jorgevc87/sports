package com.pe.asistente.deportivo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pe.asistente.deportivo.R;

public class FragmentProgramacionEntrenamiento extends Fragment {

    private View v;

    public static FragmentProgramacionEntrenamiento newInstance(Bundle bundle) {
        FragmentProgramacionEntrenamiento f = new FragmentProgramacionEntrenamiento();
        if (bundle != null) {
            f.setArguments(bundle);
        }

        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_programacion_entrenamiento, container, false);
        incializarControles();
        return v;
    }

    private void incializarControles() {

    }

}
