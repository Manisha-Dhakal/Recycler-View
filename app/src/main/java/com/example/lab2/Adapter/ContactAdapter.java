package com.example.lab2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.MainActivity2;
import com.example.lab2.ModelClass.ModelContact;
import com.example.lab2.R;
import com.example.lab2.RecyclerViewInterface;

import java.security.CryptoPrimitive;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {


    private Context context;
    private List<ModelContact> modelContactList;

    public ContactAdapter( Context context, List<ModelContact> modelContactList) {
        this.context = context;
        this.modelContactList = modelContactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.cardview,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        String contactName= modelContactList.get(position).getName();
        holder.textView.setText(contactName);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context, MainActivity2.class);
                intent.putExtra("name",contactName);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelContactList.size();
    }

    public  class ContactViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView=itemView.findViewById(R.id.cardviewcontact);
            textView=itemView.findViewById(R.id.carviewtext);

        }
    }
}
