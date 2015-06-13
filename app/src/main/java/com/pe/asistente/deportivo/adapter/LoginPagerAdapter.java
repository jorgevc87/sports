package com.pe.asistente.deportivo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class LoginPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentos;

    public LoginPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentos) {
        super(fm);
        this.fragmentos = fragmentos;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentos.get(position);
    }

    @Override
    public int getCount() {
        return fragmentos.size();
    }
}
