package com.pe.asistente.deportivo.fragment;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.pe.asistente.deportivo.R;

import java.util.List;

public class FragmentProgramacionEntrenamiento extends Fragment implements WeekView.MonthChangeListener, WeekView.EventClickListener, WeekView.EventLongPressListener {

    private View v;
    private WeekView mWeekView;

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

        //Get a reference for the week view in the layout.
        mWeekView = (WeekView) v.findViewById(R.id.weekView);

        // Set an action when any event is clicked.
        mWeekView.setOnEventClickListener(this);

        // The week view has infinite scrolling horizontally. We have to provide the events of a
        // month every time the month changes on the week view.
        mWeekView.setMonthChangeListener(this);

        // Set long press listener for events.
        mWeekView.setEventLongPressListener(this);


    }

    @Override
    public void onEventClick(WeekViewEvent weekViewEvent, RectF rectF) {

    }

    @Override
    public void onEventLongPress(WeekViewEvent weekViewEvent, RectF rectF) {

    }

    @Override
    public List<WeekViewEvent> onMonthChange(int i, int i2) {
        return null;
    }
}
