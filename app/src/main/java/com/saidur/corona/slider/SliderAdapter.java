package com.saidur.corona.slider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.saidur.corona.R;
import com.smarteist.autoimageslider.SliderViewAdapter;


public class SliderAdapter extends SliderViewAdapter<SliderAdapter.sliderViewHolder> {
    public Context context;


    public SliderAdapter(Context context) {
        this.context = context;
    }


    @Override
    public sliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_model, null,false);
        return new sliderViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(sliderViewHolder viewHolder, int position) {
        viewHolder.textViewDescription.setText("This is slider item " + position);
        switch (position) {
            case 0:

                Glide.with(viewHolder.itemView)
                        .load("https://cdn01.grameenphone.com/sites/default/files/GP-WS5--01_InnerPageBanner-S-768X378.jpg")
                        .into(viewHolder.imageViewBackground);
                break;
            case 1:
                Glide.with(viewHolder.itemView)
                        .load("https://www.theindependentbd.com/assets/news_images/COVID-19-Home-quarantine-guidelines1.jpg")
                        .into(viewHolder.imageViewBackground);
                break;
            case 2:
                Glide.with(viewHolder.itemView)
                        .load("https://allalo.com/wp-content/uploads/2020/03/Symptoms-of-Coronavirus.jpg")
                        .into(viewHolder.imageViewBackground);
                break;
            default:
                Glide.with(viewHolder.itemView)
                        .load("https://www.unicef.org/bangladesh/sites/unicef.org.bangladesh/files/Dos%20and%20Dont%27s.png")
                        .into(viewHolder.imageViewBackground);
                break;

        }
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return 4;
    }
     static class sliderViewHolder extends SliderViewAdapter.ViewHolder{
        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;
        public sliderViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }

    }
}
