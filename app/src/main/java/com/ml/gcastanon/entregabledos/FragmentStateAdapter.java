package com.ml.gcastanon.entregabledos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentStateAdapter extends FragmentStatePagerAdapter {

    private List<DetalleFragment> listaFragments;

    public FragmentStateAdapter (FragmentManager fm, List<DetalleFragment> listaFragments){
        super(fm);
        this.listaFragments = listaFragments;

    }

    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }
}
