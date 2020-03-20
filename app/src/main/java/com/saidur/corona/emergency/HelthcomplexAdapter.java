package com.saidur.corona.emergency;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.saidur.corona.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HelthcomplexAdapter extends RecyclerView.Adapter<HelthcomplexAdapter.HealthViewHolder> implements View.OnClickListener {
    private Context context;
    private List<helth> helth= new ArrayList<>();

    public HelthcomplexAdapter(Context context, List<helth> health) {
        this.context = context;
        this.helth = health;
    }

    @NonNull
    @Override
    public HealthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.model_health_show,null);
        return new HealthViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthViewHolder holder, final int position) {

        final helth helths = helth.get(position);
        // holder.location_map.setText(gurd.getLatitude());
        holder.hospitalname.setText(helths.getHospitalname());
        holder.upozila.setText(helths.getUpozila());
        holder.district.setText(helths.getZilla());
        holder.division.setText(helths.getDivision());
        holder.call2.setText("Call Hospital Now!!");

        holder.call2.setOnClickListener(this);
        //holder.location_map.setOnClickListener(this);

        holder.call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Call", Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://"+helths.getPhoneNumber(position)));
                context.startActivity(callIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return helth.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class HealthViewHolder extends RecyclerView.ViewHolder {
        TextView hospitalname,district,call2,upozila,division;

        public HealthViewHolder(@NonNull View itemView) {
            super(itemView);
            hospitalname = itemView.findViewById(R.id.model_tv_health_hospitalname_show);
            call2 = itemView.findViewById(R.id.model_tv_health_call_show);
            district = itemView.findViewById(R.id.model_tv_health_district_show);
            upozila = itemView.findViewById(R.id.model_tv_health_upozila);
            division = itemView.findViewById(R.id.model_tv_health_division_show);
        }
    }
}
