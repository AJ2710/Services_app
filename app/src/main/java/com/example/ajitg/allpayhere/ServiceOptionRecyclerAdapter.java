package com.example.ajitg.allpayhere;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ServiceOptionRecyclerAdapter extends RecyclerView.Adapter<ServiceOptionRecyclerAdapter.ServiceOptionsHolder>{

    public List<ServiceOptions> recentServiceOptions;
    Context mContext;

    public ServiceOptionRecyclerAdapter(Context mContext , List<ServiceOptions> recentServiceOptions ) {

        this.mContext = mContext;
        this.recentServiceOptions = recentServiceOptions;
    }




    @NonNull
    @Override
    public ServiceOptionsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_items_service_options , viewGroup ,false);
        return (new ServiceOptionsHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceOptionsHolder serviceOptionsHolder, final int i) {

        serviceOptionsHolder.personNameTextView.setText(recentServiceOptions.get(i).getPersonNameText());
        serviceOptionsHolder.personIdTextView.setText(recentServiceOptions.get(i).getPersonId());
        serviceOptionsHolder.serviceFieldTextView.setText(recentServiceOptions.get(i).getServiceProvides());
        Glide.with(mContext).load(recentServiceOptions.get(i).getImageOfPerson()).into(serviceOptionsHolder.servicerImage);

        serviceOptionsHolder.appointFlatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent appointIntent = new Intent(mContext , EBillActivity.class);
                appointIntent.putExtra("person_name" , recentServiceOptions.get(i).getPersonNameText());
                appointIntent.putExtra("person_Id" , recentServiceOptions.get(i).getPersonId());
                mContext.startActivity(appointIntent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return recentServiceOptions.size();
    }

    public static class ServiceOptionsHolder extends RecyclerView.ViewHolder{


        TextView personNameTextView , personIdTextView , serviceFieldTextView ;
        ImageView servicerImage;
        Button appointFlatbutton;

        public ServiceOptionsHolder(@NonNull View itemView) {

            super(itemView);

            personNameTextView = itemView.findViewById(R.id.personNameTextView);
            personIdTextView = itemView.findViewById(R.id.personIdTextView);
            serviceFieldTextView = itemView.findViewById(R.id.serviceFieldTextView);
            servicerImage = itemView.findViewById(R.id.servicerImage);
            appointFlatbutton = itemView.findViewById(R.id.appointFlatbutton);
        }
    }

}
