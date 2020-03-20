package com.saidur.corona.live_update;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saidur.corona.R;

public class MedicineActivity extends AppCompatActivity {
    private TextView affected, ok, death, affectedbd, okbd, deathbd;
    DatabaseReference datarefbd, datarefworld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        affected = findViewById(R.id.live_world_affectId);
        ok = findViewById(R.id.live_world_okId);
        death = findViewById(R.id.live_world_deathId);

        affectedbd = findViewById(R.id.live_bd_affectId);
        okbd = findViewById(R.id.live_bd_okId);
        deathbd = findViewById(R.id.live_bd_deathId);


        getdatatoFirebase();

    }

    private void getdatatoFirebase() {

        datarefbd = FirebaseDatabase.getInstance().getReference().child("livedatabd");
        datarefworld = FirebaseDatabase.getInstance().getReference().child("livedataworld");

        datarefbd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String bdalive = dataSnapshot.child("bdalive").getValue().toString();
                String bdaffected = dataSnapshot.child("bdaffected").getValue().toString();
                String bddeath = dataSnapshot.child("bddeath").getValue().toString();

                affectedbd.setText(bdaffected);
                okbd.setText(bdalive);
                deathbd.setText(bddeath);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        datarefworld.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String worldalive = dataSnapshot.child("worldalive").getValue().toString();
                String worldaffected = dataSnapshot.child("worldaffected").getValue().toString();
                String worlddeath = dataSnapshot.child("worlddeath").getValue().toString();

                affected.setText(worldaffected);
                ok.setText(worldalive);
                death.setText(worlddeath);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

 /*   // Get a reference to our posts
   final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("alive");

// Attach a listener to read the data at our posts reference
  ref.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            LivePojo liveupdate = dataSnapshot.getValue(LivePojo.class);
            //System.out.println(liveupdate);
            LivePojo live= new LivePojo();
            ok.setText(live.getOk());
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            System.out.println("The read failed: " + databaseError.getCode());
        }
    });*/

    }

}
