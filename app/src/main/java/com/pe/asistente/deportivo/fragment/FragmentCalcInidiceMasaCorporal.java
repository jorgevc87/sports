package com.pe.asistente.deportivo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pe.asistente.deportivo.R;
import com.pe.asistente.deportivo.util.CalculadoraUtil;

/**
 * Created by JorgeLuis on 13/06/2015.
 */
public class FragmentCalcInidiceMasaCorporal extends Fragment {

    private View v;
    private Button btnCalculaImc;

    private EditText edtEstatura;
    private EditText edtPeso;
    private TextView txtImc;

    public static Fragment newInstance(Bundle bundle) {
        FragmentCalcInidiceMasaCorporal f = new FragmentCalcInidiceMasaCorporal();
        if (bundle != null) {
            f.setArguments(bundle);
        }

        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_calc_inidice_masa_corporal, container, false);
        inicializaControles();
        return v;
    }

    private void inicializaControles() {
        edtEstatura = (EditText) v.findViewById(R.id.edtEstatura);
        edtPeso = (EditText) v.findViewById(R.id.edtPeso);
        txtImc = (TextView) v.findViewById(R.id.txtImc);
        btnCalculaImc = (Button) v.findViewById(R.id.btnCalculaImc);

        btnCalculaImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtImc.setText(String.valueOf(Math.round(CalculadoraUtil.calcularIndiceMasaCorporal(Double.parseDouble(edtEstatura.getText().toString()), Double.parseDouble(edtPeso.getText().toString())))));
            }
        });
    }
}
