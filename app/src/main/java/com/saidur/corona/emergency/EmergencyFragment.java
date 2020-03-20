package com.saidur.corona.emergency;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saidur.corona.R;

import java.util.ArrayList;
import java.util.List;


public class EmergencyFragment extends Fragment
{

    private RecyclerView listavilable_gard;
    private EmergencyAdapter adapter;
    private List<emergency> emergency;
    public EmergencyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_emergency, container, false);
        listavilable_gard = v.findViewById(R.id.available);
        listavilable_gard.setLayoutManager(new LinearLayoutManager(null));

        emergency = new ArrayList<>();

        emergency.add(new emergency("1","করোনা সন্দেহ হলে কল করুন","+8801944333222"));
        emergency.add(new emergency("1","করোনা লক্ষন সমূহ দেখা দিলে চিকিৎসকের শরণাপন্ন হোন","+8801937000011"));
        emergency.add(new emergency("2","সচেতনতা করোনা প্রতিরোধ করে","+8801937110011"));
        emergency.add(new emergency("3","পরিষ্কার পরিচ্ছন্ন থাকুন","+8801927711784"));
        emergency.add(new emergency("4","নিজেকে অন্যের সংস্পর্শ থেকে দূরে রাখুন","+8801927711785"));
        emergency.add(new emergency("4","জন সমাগম ত্যাগ করুন","+8801550064901"));
        emergency.add(new emergency("4","নিজেকে অন্যের সংস্পর্শ থেকে দূরে রাখুন","+8801550064902"));
        emergency.add(new emergency("4","ঘন ঘন দুই হাত সাবান দিয়ে ধুয়ে নিন","+8801550064902"));
        emergency.add(new emergency("4","মৃদু গরম পানি পান করুন","+8801550064904"));
        emergency.add(new emergency("4","করোনা কে ভয় না পেয়ে প্রতিরোধ গড়ে তুলুন","+8801550064905"));


        adapter = new EmergencyAdapter(getActivity(),emergency);
        listavilable_gard.setAdapter(adapter);

        // emergency.get(0).getAddress();

        /*List<String> strings = Arrays.asList(getResources().getStringArray(R.array.district));
        Log.d("TAGDATA", "onCreateView: "+ strings.get(0));*/

        /*String[] stringss = getResources().getStringArray(R.array.district);
        Log.d("TAGDATA", "onCreateView: "+ stringss[1]);
        Log.d("TAGDATA", "onCreateView: "+ stringss[2]);
        Log.d("TAGDATA", "onCreateView: "+ stringss[3]);*/

        /*String[] stringssz = getResources().getStringArray(R.array.dis);
        Log.d("TAGDATA", "onCreateView: "+ stringssz[0]);*/

        return v;
    }

}
