package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;

import com.example.lab2.Adapter.ContactAdapter;
import com.example.lab2.ModelClass.ModelContact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
private RecyclerView recyclerViewA, recyclerViewB, recyclerViewC;
private List<ModelContact> modelContactList;
private List <ModelContact> modelContactListB, modelContactListC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("My Contact");

        recyclerViewA=findViewById(R.id.contactphoneA);
        recyclerViewB=findViewById(R.id.contactphoneB);
        recyclerViewC=findViewById(R.id.contactphoneC);

        modelContactList= new ArrayList<>();
        modelContactList.add(new ModelContact(234,"Anisha"));
        modelContactList.add(new ModelContact(234,"Ashmi"));
        modelContactList.add(new ModelContact(234,"Ashmita"));


        ContactAdapter contactAdapter= new ContactAdapter(getApplicationContext(),modelContactList);
        recyclerViewA.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewA.setAdapter(contactAdapter);


       modelContactListB= new ArrayList<>();

       modelContactListB.add(new ModelContact(7468728,"Bimal"));
        modelContactListB.add(new ModelContact(7468728,"Bimarsh"));
        modelContactListB.add(new ModelContact(7468728,"Bimochan"));
        modelContactListB.add(new ModelContact(7468728,"Binita"));

       ContactAdapter contactAdapter1= new ContactAdapter(getApplicationContext(), modelContactListB);
       recyclerViewB.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
       recyclerViewB.setAdapter(contactAdapter1);


        modelContactListC= new ArrayList<>();

        modelContactListC.add(new ModelContact(7468728,"Centhia"));
        modelContactListC.add(new ModelContact(7468728,"charlotte"));

        ContactAdapter contactAdapter2= new ContactAdapter(getApplicationContext(), modelContactListC);
        recyclerViewC.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewC.setAdapter(contactAdapter2);
    }

}