package com.example.beaty_saloon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;

public class Cabinet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet);
    }
    public void Change(View view){
        Fragment fragment= null;
        switch (view.getId()){
            case R.id.buttonAppoint:
                fragment = new Appointment();
                break;
            case R.id.buttonMyAppoint:
                fragment = new my_appointment();
                break;
            case R.id.buttonGlossary:
                fragment = new Glossary();
                break;
            case R.id.buttonAboutus:
                fragment = new About_us();
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fr_place, fragment);
        ft.commit();

    }
}