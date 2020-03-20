package com.saidur.corona.emergency;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.saidur.corona.R;

import java.util.ArrayList;
import java.util.List;


public class HealthComplexFragment extends Fragment {

    private RecyclerView health_models_data;
    private HelthcomplexAdapter helthadapter;
    private List<helth> helth;
    private List<helth> check = new ArrayList<>();
    public HealthComplexFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    Spinner division,distric,upozila;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v= inflater.inflate(R.layout.fragment_other, container, false);

        health_models_data = v.findViewById(R.id.health_recycler);
        health_models_data.setLayoutManager(new LinearLayoutManager(null));
        helth = new ArrayList<>();



        helthadapter = new HelthcomplexAdapter(getActivity(),helth);
        health_models_data.setAdapter(helthadapter);


        String[] div=getResources().getStringArray(R.array.Div);
        String[] dic =getResources().getStringArray(R.array.District);
        String[] upo =getResources().getStringArray(R.array.Upozila);

        division = v.findViewById(R.id.spinner_division_id);
        distric = v.findViewById(R.id.spinner_district_id);
        upozila = v.findViewById(R.id.spinner_upzila_id);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_layout,R.id.text, div);
        division.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),R.layout.spinner_layout,R.id.text, dic);
        distric.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),R.layout.spinner_layout,R.id.text, upo);
        upozila.setAdapter(adapter2);

        String[] DhakaZila = getResources().getStringArray(R.array.ঢাকা);
        final ArrayAdapter<String> adapterDhaka = new ArrayAdapter<String>(getActivity(),R.layout.spinner_layout,R.id.text, DhakaZila);

        String[] BorisalZila = getResources().getStringArray(R.array.বরিশাল);
        final ArrayAdapter<String> adapterBorisal = new ArrayAdapter<String>(getActivity(),R.layout.spinner_layout,R.id.text, BorisalZila);




        String[] MadaripurUpozila = getResources().getStringArray(R.array.মাদারীপুর);
        final ArrayAdapter<String> adapterMadaripurUpozila = new ArrayAdapter<String>(getActivity(),R.layout.spinner_layout,R.id.text, MadaripurUpozila);

       // String[] NoakhaliUpozila = getResources().getStringArray(R.array.Noakhali);

        //Dhaka Adapter


        String[] BorisalUpozila = getResources().getStringArray(R.array.বরিশালজেলা);
        final ArrayAdapter<String> adapterBorisalUpozila = new ArrayAdapter<String>(getActivity(),R.layout.spinner_layout,R.id.text, BorisalUpozila);



       // upozila.setAdapter(adapter3);




        division.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              Toast.makeText(getActivity(), "Position : "+ i, Toast.LENGTH_SHORT).show();

              if(i == 1)
                  distric.setAdapter(adapterDhaka);

              if (i == 2)
                  distric.setAdapter(adapterBorisal);


            if(i != 0) {
                check.clear();
                for (int j = 0; j < helth.size(); j++) {

                    if (helth.get(j).getDivision().equals(division.getSelectedItem().toString()))
                    {
                        Toast.makeText(getActivity(), " Ja " + j, Toast.LENGTH_SHORT).show();
                        check.add(helth.get(j));
                    }
                }

                helthadapter = new HelthcomplexAdapter(getActivity(), check);
                health_models_data.setAdapter(helthadapter);

            }

          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {
              Toast.makeText(getActivity(), "Nothing : ", Toast.LENGTH_SHORT).show();

          }
      });


        distric.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                if(division.getSelectedItemPosition() == 1 && i == 1)
                {
                    upozila.setAdapter(adapterMadaripurUpozila);

                }

                if(division.getSelectedItemPosition() == 2 && i == 1)
                {
                    upozila.setAdapter(adapterBorisalUpozila);

                }




                if(i != 0) {
                    check.clear();
                    for (int j = 0; j < helth.size(); j++) {

                        if (helth.get(j).getZilla().equals(distric.getSelectedItem().toString()))
                        {
                            check.add(helth.get(j));
                        }
                    }

                    helthadapter = new HelthcomplexAdapter(getActivity(), check);
                    health_models_data.setAdapter(helthadapter);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        upozila.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if(i != 0)
                {
                    check.clear();
                    for (int j = 0; j < helth.size(); j++) {

                        if (helth.get(j).getUpozila().equals(upozila.getSelectedItem().toString()))
                        {
                            Toast.makeText(getActivity(), " Ja " + j, Toast.LENGTH_SHORT).show();
                            check.add(helth.get(j));
                        }
                    }

                    helthadapter = new HelthcomplexAdapter(getActivity(), check);
                    health_models_data.setAdapter(helthadapter);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        /*  division.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "Position : "+ i, Toast.LENGTH_SHORT).show();

            }
        });
*/



        return v;

    }
   /* private void Rongpur{
        //পঞ্চগড়
        helth.add(new Helth("রংপুর","পঞ্চগড় ","দেবীগঞ্জ ","দেবীগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324698"));
        helth.add(new Helth("রংপুর","পঞ্চগড়","বোদা ","বোদা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324697"));
        helth.add(new Helth("রংপুর","পঞ্চগড়","আটোয়ারী ","আটোয়ারী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324696"));
        helth.add(new Helth("রংপুর","পঞ্চগড়","তেতুলিয়া ","তেতুলিয়া উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324699"));
        helth.add(new Helth("রংপুর","পঞ্চগড়","পঞ্চগড় সদর","সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324814"));
//দিনাজপুর
        helth.add(new Helth("রংপুর","দিনাজপুর","দিনাজপুর সদর","সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324805"));
        helth.add(new Helth("রংপুর","দিনাজপুর","নবাবগঞ্জ","নবাবগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324644"));
        helth.add(new Helth("রংপুর","দিনাজপুর","বীরগঞ্জা","বীরগঞ্জা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324635"));
        helth.add(new Helth("রংপুর","দিনাজপুর","ঘোড়াঘাট","ঘোড়াঘাট উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324640"));
        helth.add(new Helth("রংপুর","দিনাজপুর","বিরামপুর","বিরামপুর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324634"));
        helth.add(new Helth("রংপুর","দিনাজপুর","পার্বতীপুরা","পার্বতীপুরা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324645"));
        helth.add(new Helth("রংপুর","দিনাজপুর","বোচাগঞ্জ","বোচাগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324637"));
        helth.add(new Helth("রংপুর","দিনাজপুর","কাহারোল","কাহারোল উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324642"));
        helth.add(new Helth("রংপুর","দিনাজপুর","ফুলবাড়ী","ফুলবাড়ী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324639"));
        helth.add(new Helth("রংপুর","দিনাজপুর","হাকিমপুর","হাকিমপুর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324641"));
        helth.add(new Helth("রংপুর","দিনাজপুর","খানসামা","খানসামা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324643"));
        helth.add(new Helth("রংপুর","দিনাজপুর","বিরল","বিরল উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324636"));
        helth.add(new Helth("রংপুর","দিনাজপুর","চিরিরবন্দর","চিরিরবন্দর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324638"));
//লালমনিরহাট
        helth.add(new Helth("রংপুর","লালমনিরহাট","লালমনিরহাট সদর","লালমনিরহাট সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324809"));
        helth.add(new Helth("রংপুর","লালমনিরহাট","কালীগঞ্জ","কালীগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324666"));
        helth.add(new Helth("রংপুর","লালমনিরহাট","হাতীবান্ধা","হাতীবান্ধা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324665"));
        helth.add(new Helth("রংপুর","লালমনিরহাট","পাটগ্রাম","পাটগ্রাম উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324667"));
        helth.add(new Helth("রংপুর","লালমনিরহাট","আদিতমারী","আদিতমারী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324664"));
        // নীলফামারী
        helth.add(new Helth("রংপুর","নীলফামারী","নীলফামারী সদর","নীলফামারী সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324812"));
        helth.add(new Helth("রংপুর","নীলফামারী","সৈয়দপুর","সৈয়দপুর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324687"));
        helth.add(new Helth("রংপুর","নীলফামারী","সৈয়দপুর","সৈয়দপুর ৫০ বেড স্বাস্থ্য কমপ্লেক্স","01730324822"));
        helth.add(new Helth("রংপুর","নীলফামারী","কিশোরগঞ্জ","কিশোরগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324686"));
        helth.add(new Helth("রংপুর","নীলফামারী","জলঢাকা","জলঢাকা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324685"));
        helth.add(new Helth("রংপুর","নীলফামারী","ডিমলা","ডিমলা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324683"));
        helth.add(new Helth("রংপুর","নীলফামারী","ডোমার","ডোমার উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324684"));

        //গাইবান্ধা
        helth.add(new Helth("রংপুর","গাইবান্ধা","গাইবান্ধা সদর","গাইবান্ধা জেলা স্বাস্থ্য কমপ্লেক্স","01730324806"));
        helth.add(new Helth("রংপুর","গাইবান্ধা","সাদুল্লাপুর","সাদুল্লাপুর স্বাস্থ্য কমপ্লেক্স","01730324649"));
        helth.add(new Helth("রংপুর","গাইবান্ধা","পলাশবাড়ী","পলাশবাড়ী স্বাস্থ্য কমপ্লেক্স","01730324648"));
        helth.add(new Helth("রংপুর","গাইবান্ধা","সাঘাটা","সাঘাটা স্বাস্থ্য কমপ্লেক্স","01730324650"));
        helth.add(new Helth("রংপুর","গাইবান্ধা","গোবিন্দগঞ্জ","গোবিন্দগঞ্জ স্বাস্থ্য কমপ্লেক্স","01730324647"));
        helth.add(new Helth("রংপুর","গাইবান্ধা","সুন্দরগঞ্জ","সুন্দরগঞ্জ স্বাস্থ্য কমপ্লেক্স","01730324651"));
        helth.add(new Helth("রংপুর","গাইবান্ধা","ফুলছড়ি","ফুলছড়ি স্বাস্থ্য কমপ্লেক্স","01730324646"));
        //ঠাকুরগাঁও
        helth.add(new Helth("রংপুর","ঠাকুরগাঁও","ঠাকুরগাঁও সদর","ঠাকুরগাঁও সদর স্বাস্থ্য কমপ্লেক্স","01730324816"));
        helth.add(new Helth("রংপুর","ঠাকুরগাঁও","পীরগঞ্জ","পীরগঞ্জ স্বাস্থ্য কমপ্লেক্স","01730324726"));
        helth.add(new Helth("রংপুর","ঠাকুরগাঁও","রাণীশংকৈল","রাণীশংকৈল স্বাস্থ্য কমপ্লেক্স","01730324727"));
        helth.add(new Helth("রংপুর","ঠাকুরগাঁও","হরিপুর","হরিপুর স্বাস্থ্য কমপ্লেক্স","01730324725"));
        helth.add(new Helth("রংপুর","ঠাকুরগাঁও","বালিয়াডাঙ্গী","বালিয়াডাঙ্গী স্বাস্থ্য কমপ্লেক্স","01730324724"));
        //রংপুরজেলা
        helth.add(new Helth("রংপুর","রংপুরজেলা","গংগাচড়া","গংগাচড়া স্বাস্থ্য কমপ্লেক্স","01730324710"));
        helth.add(new Helth("রংপুর","রংপুরজেলা","তারাগঞ্জা","তারাগঞ্জা স্বাস্থ্য কমপ্লেক্স","01730324715"));
        helth.add(new Helth("রংপুর","রংপুরজেলা","বদরগঞ্জ","বদরগঞ্জ স্বাস্থ্য কমপ্লেক্স","01730324709"));
        helth.add(new Helth("রংপুর","রংপুরজেলা","মিঠাপুকুর","মিঠাপুকুর স্বাস্থ্য কমপ্লেক্স","01730324712"));
        helth.add(new Helth("রংপুর","রংপুরজেলা","পীরগাছা","পীরগাছা স্বাস্থ্য কমপ্লেক্স","01730324713"));
        helth.add(new Helth("রংপুর","রংপুরজেলা","পীরগঞ্জ","পীরগঞ্জ স্বাস্থ্য কমপ্লেক্স","01730324714"));
        helth.add(new Helth("রংপুর","রংপুরজেলা","কাউনিয়া","কাউনিয়া স্বাস্থ্য কমপ্লেক্স","01730324711"));
//কুড়িগ্রাম
        helth.add(new Helth("রংপুর","কুড়িগ্রাম","কুড়িগ্রাম সদর","কুড়িগ্রাম সদর স্বাস্থ্য কমপ্লেক্স","01730324808"));
        helth.add(new Helth("রংপুর","কুড়িগ্রাম","নাগেশ্বরী","নাগেশ্বরী স্বাস্থ্য কমপ্লেক্স","01730324659"));
        helth.add(new Helth("রংপুর","কুড়িগ্রাম","ভুরুঙ্গামারী","ভুরুঙ্গামারী স্বাস্থ্য কমপ্লেক্স","01730324656"));
        helth.add(new Helth("রংপুর","কুড়িগ্রাম","ফুলবাড়ী","ফুলবাড়ী স্বাস্থ্য কমপ্লেক্স","01730324658"));
        helth.add(new Helth("রংপুর","কুড়িগ্রাম","রাজারহাট","রাজারহাট স্বাস্থ্য কমপ্লেক্স","01730324660"));
        helth.add(new Helth("রংপুর","কুড়িগ্রাম","উলিপুর","উলিপুর স্বাস্থ্য কমপ্লেক্স","01730324663"));
        helth.add(new Helth("রংপুর","কুড়িগ্রাম","চিলমারী","চিলমারী স্বাস্থ্য কমপ্লেক্স","01730324657"));
        helth.add(new Helth("রংপুর","কুড়িগ্রাম","রৌমারী","রৌমারী স্বাস্থ্য কমপ্লেক্স","01730324662"));
        helth.add(new Helth("রংপুর","কুড়িগ্রাম","চর রাজিবপুর","চর রাজিবপুর স্বাস্থ্য কমপ্লেক্স","01730324661"));



    };

private void borisal{
    //বরিশালজেলা
       // helth.add(new Helth("বরিশাল","বরিশালজেলা ","বরিশাল সদর ","বরিশাল সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324698"));
        helth.add(new Helth("বরিশাল","বরিশালজেলা ","বাকেরগঞ্জ ","বাকেরগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324410"));
        //helth.add(new Helth("বরিশাল","বরিশালজেলা ","বাবুগঞ্জ ","বাবুগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324698"));
        helth.add(new Helth("বরিশাল","বরিশালজেলা ","উজিরপুর ","উজিরপুর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324416"));
        //helth.add(new Helth("বরিশাল","বরিশালজেলা ","বানারীপাড়া ","বানারীপাড়া উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324698"));
        helth.add(new Helth("বরিশাল","বরিশালজেলা ","গৌরনদী ","গৌরনদী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324412"));
        helth.add(new Helth("বরিশাল","বরিশালজেলা ","আগৈলঝাড়া ","আগৈলঝাড়া উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324408"));
       // helth.add(new Helth("বরিশাল","বরিশালজেলা ","মেহেন্দিগঞ্জ ","মেহেন্দিগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324698"));
       // helth.add(new Helth("বরিশাল","বরিশালজেলা ","মুলাদী ","মুলাদী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324698"));
        helth.add(new Helth("বরিশাল","বরিশালজেলা ","হিজলা ","হিজলা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324413"));
        //ঝালকাঠি
        helth.add(new Helth("বরিশাল","ঝালকাঠি ","ঝালকাঠি সদর ","ঝালকাঠি সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324762"));
        helth.add(new Helth("বরিশাল","ঝালকাঠি ","কাঠালিয়া ","কাঠালিয়া উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324423"));
        helth.add(new Helth("বরিশাল","ঝালকাঠি ","নলছিটি ","নলছিটি উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324424"));
        helth.add(new Helth("বরিশাল","ঝালকাঠি ","রাজাপুর ","রাজাপুর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324425"));
        //পটুয়াখালী
        helth.add(new Helth("বরিশাল","পটুয়াখালী ","পটুয়াখালী সদর ","পটুয়াখালী সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324763"));
        helth.add(new Helth("বরিশাল","পটুয়াখালী ","বাউফল","বাউফল উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324426"));
        helth.add(new Helth("বরিশাল","পটুয়াখালী ","দুমকি","দুমকি উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324823"));
        helth.add(new Helth("বরিশাল","পটুয়াখালী ","দশমিনা","দশমিনা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324427"));
        helth.add(new Helth("বরিশাল","পটুয়াখালী ","কলাপাড়া","কলাপাড়া উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324429"));
        helth.add(new Helth("বরিশাল","পটুয়াখালী ","মির্জাগঞ্জ","মির্জাগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324430"));
        helth.add(new Helth("বরিশাল","পটুয়াখালী ","গলাচিপা","গলাচিপা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324428"));
       // helth.add(new Helth("বরিশাল","পটুয়াখালী ","রাঙ্গাবালী","রাঙ্গাবালী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324425"));
    //পিরোজপুর
        helth.add(new Helth("বরিশাল","পিরোজপুর ","পিরোজপুর সদর","পিরোজপুর সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324764"));
        helth.add(new Helth("বরিশাল","পিরোজপুর ","নাজিরপুর","নাজিরপুর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324435"));
        helth.add(new Helth("বরিশাল","পিরোজপুর ","কাউখালী","কাউখালী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324432"));
        helth.add(new Helth("বরিশাল","পিরোজপুর ","ভান্ডারিয়া","ভান্ডারিয়া উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324431"));
        helth.add(new Helth("বরিশাল","পিরোজপুর ","মঠবাড়ীয়া","মঠবাড়ীয়া উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324433"));
        helth.add(new Helth("বরিশাল","পিরোজপুর ","নেছারাবাদ","নেছারাবাদ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324434"));
        //helth.add(new Helth("বরিশাল","পিরোজপুর ","ইন্দুরকানী","ইন্দুরকানী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324428"));
        helth.add(new Helth("বরিশাল","পিরোজপুর ","ইন্দুরকানী","ইন্দুরকানী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324880"));
        // ভোলা
        helth.add(new Helth("বরিশাল","ভোলা ","ভোলা সদর","ভোলা সদর উপজেলা স্বাস্থ্য কমপ্লেক্স",""));
        helth.add(new Helth("বরিশাল","ভোলা ","বোরহান উদ্দিন","বোরহান উদ্দিন উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324417"));
        helth.add(new Helth("বরিশাল","ভোলা ","চরফ্যাশন","চরফ্যাশন উপজেলা স্বাস্থ্য কমপ্লেক্স",""));
        helth.add(new Helth("বরিশাল","ভোলা ","দৌলতখান","দৌলতখান উপজেলা স্বাস্থ্য কমপ্লেক্স",""));
        helth.add(new Helth("বরিশাল","ভোলা ","মনপুরা","মনপুরা উপজেলা স্বাস্থ্য কমপ্লেক্স",""));
        helth.add(new Helth("বরিশাল","ভোলা ","তজুমদ্দিন","তজুমদ্দিন উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324422"));
        helth.add(new Helth("বরিশাল","ভোলা ","লালমোহন","লালমোহন উপজেলা স্বাস্থ্য কমপ্লেক্স",""));
       //
        helth.add(new Helth("বরিশাল","বরগুনা ","বরগুনা সদর","বরগুনা সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324884"));
        helth.add(new Helth("বরিশাল","বরগুনা ","আমতলী","আমতলী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324759"));
        helth.add(new Helth("বরিশাল","বরগুনা ","বেতাগী","বেতাগী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324406"));
        helth.add(new Helth("বরিশাল","বরগুনা ","বামনা","বামনা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324405"));
        helth.add(new Helth("বরিশাল","বরগুনা ","পাথরঘাটা","পাথরঘাটা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324407"));
       //  helth.add(new Helth("বরিশাল","বরগুনা ","তালতলি","তালতলি উপজেলা স্বাস্থ্য কমপ্লেক্স",""));

    }
    private void Maymansing{
    //শেরপুর
        helth.add(new Helth("ময়মনসিংহ","শেরপুর ","শেরপুর সদর ","শেরপুর সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324791"));
        helth.add(new Helth("ময়মনসিংহ","শেরপুর ","নালিতাবাড়ী ","নালিতাবাড়ী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324558"));
        helth.add(new Helth("ময়মনসিংহ","শেরপুর ","শ্রীবরদী ","শ্রীবরদী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324559"));
        helth.add(new Helth("ময়মনসিংহ","শেরপুর ","নকলা","নকলা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324557"));
        helth.add(new Helth("ময়মনসিংহ","শেরপুর ","ঝিনাইগাতী ","ঝিনাইগাতী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324556"));

        //ময়মনসিংহজেলা
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","ফুলবাড়ীয়া","ফুলবাড়ীয়া উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324521"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","ত্রিশাল","ত্রিশাল উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324529"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","ভালুকা","ভালুকা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324519"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","মুক্তাগাছা","মুক্তাগাছা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324527"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","ময়মনসিংহ সদর ","ময়মনসিংহ সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324556"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","ধোবাউড়া ","ধোবাউড়া উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324520"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","ফুলপুর ","ফুলপুর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324522"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","হালুয়াঘাট","হালুয়াঘাট উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324525"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","গৌরীপুর","গৌরীপুর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324524"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","গফরগাঁও ","গফরগাঁও উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324523"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","ঈশ্বরগঞ্জ ","ঈশ্বরগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324526"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","তারাকান্দা ","তারাকান্দা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324556"));
        helth.add(new Helth("ময়মনসিংহ","ময়মনসিংহজেলা ","নান্দাইল ","নান্দাইল উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324528"));
       //জামালপুর
        helth.add(new Helth("ময়মনসিংহ","জামালপুর ","জামালপুর সদর ","জামালপুর সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324779"));
        helth.add(new Helth("ময়মনসিংহ","জামালপুর ","মেলান্দহ ","মেলান্দহ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324491"));
        helth.add(new Helth("ময়মনসিংহ","জামালপুর ","ইসলামপুর ","ইসলামপুর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324489"));
        helth.add(new Helth("ময়মনসিংহ","জামালপুর ","দেওয়ানগঞ্জ ","দেওয়ানগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324488"));
        helth.add(new Helth("ময়মনসিংহ","জামালপুর ","সরিষাবাড়ী ","সরিষাবাড়ী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324492"));
        helth.add(new Helth("ময়মনসিংহ","জামালপুর ","মাদারগঞ্জ ","মাদারগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324490"));
        helth.add(new Helth("ময়মনসিংহ","জামালপুর ","বকশীগঞ্জ ","বকশীগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324487"));
       //নেত্রকোণা
        helth.add(new Helth("ময়মনসিংহ","নেত্রকোণা ","বারহাট্টা ","বারহাট্টা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324540"));
        helth.add(new Helth("ময়মনসিংহ","নেত্রকোণা ","দুর্গাপুর ","দুর্গাপুর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324541"));
        helth.add(new Helth("ময়মনসিংহ","নেত্রকোণা ","কেন্দুয়া ","কেন্দুয়া উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324543"));
        helth.add(new Helth("ময়মনসিংহ","নেত্রকোণা ","আটপাড়া ","আটপাড়া উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324539"));
        helth.add(new Helth("ময়মনসিংহ","নেত্রকোণা ","মদন ","মদন উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324545"));
        helth.add(new Helth("ময়মনসিংহ","নেত্রকোণা ","খালিয়াজুরী ","খালিয়াজুরী উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324544"));
        helth.add(new Helth("ময়মনসিংহ","নেত্রকোণা ","কলমাকান্দা ","কলমাকান্দা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324542"));
        helth.add(new Helth("ময়মনসিংহ","নেত্রকোণা ","মোহনগঞ্জ ","মোহনগঞ্জ উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324546"));
        helth.add(new Helth("ময়মনসিংহ","নেত্রকোণা ","পূর্বধলা ","পূর্বধলা উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324547"));
        helth.add(new Helth("ময়মনসিংহ","নেত্রকোণা ","নেত্রকোণা সদর ","নেত্রকোণা সদর উপজেলা স্বাস্থ্য কমপ্লেক্স","01730324788"));




    }*/
}
