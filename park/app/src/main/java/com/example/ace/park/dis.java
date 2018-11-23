package com.example.ace.park;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class dis extends AppCompatActivity {


    NavigationView navigationView;
    TextView textView;
    Intent intent;
    FirebaseRecyclerAdapter<model, displayAdapter> adapter;
    FirebaseRecyclerOptions<model> options;
    RecyclerView recyclerView;
    DatabaseReference mDatabase,query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis);

        recyclerView = findViewById(R.id.myRecView);



        mDatabase = FirebaseDatabase.getInstance().getReference().child("parkings");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        query = FirebaseDatabase.getInstance().getReference().child("parkings");

        options = new FirebaseRecyclerOptions.Builder<model>()
                .setQuery(query, model.class)
                .build();



        adapter = new FirebaseRecyclerAdapter<model, displayAdapter>(
                options) {
            @Override
            public displayAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler, parent, false);

                return new displayAdapter(v);
            }

            @Override
            protected void onBindViewHolder(displayAdapter holder, final int position, final model current) {

                if(current!=null && holder!=null){
                    holder.setName(current.name);
                    holder.setTitle(current.num);
                    holder.setType(current.type);
                    holder.setImage(getApplicationContext(),current.sno,current.sno);

                    holder.mview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                          //  Toast.makeText(dis.this, ""+position, Toast.LENGTH_SHORT).show();


                        }
                    });
                }
            }


        };

        //Populate Item into Adapter
        recyclerView.setAdapter(adapter);



    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();



    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}
