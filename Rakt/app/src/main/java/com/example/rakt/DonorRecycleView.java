package com.example.rakt;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rakt.DonorInformation.DonorInformation;

import java.util.ArrayList;

public class DonorRecycleView extends RecyclerView.Adapter<DonorRecycleView.InnerDonorRecycleView> {


     ArrayList<DonorInformation> donorInformation=new ArrayList<>();

      public callBack callBack;


     public interface callBack
     {
         void callBack(DonorInformation donorInformation);
     }


    public DonorRecycleView(ArrayList<DonorInformation> donorInformation, DonorRecycleView.callBack callBack) {
        this.donorInformation = donorInformation;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public InnerDonorRecycleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerDonorRecycleView(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.request_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerDonorRecycleView holder, int position) {


        holder.txt_name.setText(donorInformation.get(position).getName());
        holder.txt_address.setText(donorInformation.get(position).getCity());
        holder.btn_B.setText(donorInformation.get(position).getBlood_type());

        if(!donorInformation.get(position).getImage().equals("no image"))
        {
            holder.img_donor.setImageURI(Uri.parse(donorInformation.get(position).getImage()));
        }


        holder.ask_for_help_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                callBack.callBack(donorInformation.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {
        return donorInformation.size();
    }

    static class InnerDonorRecycleView extends RecyclerView.ViewHolder
    {

        ImageView img_donor;
        TextView txt_name,txt_address;
        Button btn_B,ask_for_help_btn;

        public InnerDonorRecycleView(@NonNull View itemView) {
            super(itemView);

            img_donor=itemView.findViewById(R.id.img_donor);
            txt_name=itemView.findViewById(R.id.txt_name);
            txt_address=itemView.findViewById(R.id.txt_address);
            btn_B=itemView.findViewById(R.id.btn_B);
            ask_for_help_btn=itemView.findViewById(R.id.ask_for_help_btn);
        }
    }
}
