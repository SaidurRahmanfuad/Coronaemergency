package com.saidur.corona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.saidur.corona.emergency.Emergency_Activity;
import com.saidur.corona.slider.SliderAdapter;
import com.saidur.corona.tips.LiveUpdateActivity;
import com.saidur.corona.live_update.MedicineActivity;
import com.saidur.corona.tips.SymptomActivity;
import com.saidur.corona.tips.TipsActivity;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
CardView helthtips,emergency,symptom,medicine,aboutus;
RelativeLayout liveupdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slider_init(MainActivity.this);
        helthtips =findViewById(R.id.helth_tipsId);
        emergency=findViewById(R.id.emergencyID);
        symptom=findViewById(R.id.symptomID);
        medicine=findViewById(R.id.medicineID);
        aboutus=findViewById(R.id.aboutus);
        liveupdate=findViewById(R.id.liveView);

        helthtips.setOnClickListener(this);
        emergency.setOnClickListener(this);
        symptom.setOnClickListener(this);
        medicine.setOnClickListener(this);
        aboutus.setOnClickListener(this);
        liveupdate.setOnClickListener(this);

    }
    private void slider_init(MainActivity view)
    {
        SliderView sliderView = view.findViewById(R.id.imageSlider);
       // SliderView sliderView2 = view.findViewById(R.id.imageSlider2);
        SliderAdapter adapter = new SliderAdapter(this);
        sliderView.startAutoCycle();
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.helth_tipsId:
                Intent helth = new Intent(MainActivity.this, TipsActivity.class);
                startActivity(helth);
                break;

                case R.id.emergencyID:
                    Intent emergen = new Intent(MainActivity.this, Emergency_Activity.class);
                    startActivity(emergen);
                break;

                case R.id.symptomID:
                    Intent symptom = new Intent(MainActivity.this, SymptomActivity.class);
                    startActivity(symptom);
                break;

                case R.id.medicineID:
                    Intent medicine = new Intent(MainActivity.this, MedicineActivity.class);
                    startActivity(medicine);
                break;
                case R.id.aboutus:
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://securesoftbd.com/"));
                    startActivity(browserIntent);
                break;
            case R.id.liveView:
                Intent gotoIntent = new Intent(MainActivity.this, LiveUpdateActivity.class);
                startActivity(gotoIntent);
                break;



        }



    }
}
