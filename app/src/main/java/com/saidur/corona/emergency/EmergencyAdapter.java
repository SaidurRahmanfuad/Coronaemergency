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

public class EmergencyAdapter extends RecyclerView.Adapter<EmergencyAdapter.MyViewHolder> implements View.OnClickListener {

    private Context context;
    private List<emergency> emergencies= new ArrayList<>();

    public EmergencyAdapter(Context context, List<emergency> emergencies) {
        this.context = context;
        this.emergencies = emergencies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.model_emergency_show,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        final emergency emergency = emergencies.get(position);
       // holder.location_map.setText(gurd.getLatitude());

        holder.call.setText("Call Now!!!");

        holder.call.setOnClickListener(this);
        holder.status.setText(emergency.getStatus());

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Call Now!!!", Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://"+emergency.getPhoneNumber(position)));
                context.startActivity(callIntent);
            }
        });


      /*  if(emergency.getStatus().equals("on"))
        {
            holder.status.setImageResource(R.drawable.shape_circle_green);

        }else {
            holder.status.setImageResource(R.drawable.shape_circle_red);
        }*/

    }

    @Override
    public int getItemCount() {
        return emergencies.size();
    }

    @Override
    public void onClick(View view) {
        /*final emergency emergency = new emergency();
        switch (view.getId()){
            case R.id.model_tv_gurd_location_show:
                Intent gotomap = new Intent(context, TipsActivity.class);
                context.startActivity(gotomap);
                break;

        }*/
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView status,call;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            call = itemView.findViewById(R.id.model_tv_emergency_call_show);
            status = itemView.findViewById(R.id.model_tv_emergency_status_show);
        }
    }
}
