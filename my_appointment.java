package com.example.beaty_saloon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class my_appointment extends Fragment {
    TextView text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myapp = inflater.inflate(R.layout.fragment_my_appointment, container, false);
        FileInputStream fileInput = null;
        try {
            fileInput = getContext().openFileInput("AppBase.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuffer strBuffer = new StringBuffer();

            String lines="";
            while ((lines= buffer.readLine())!= null){
            strBuffer.append(lines+"");}
            text=(TextView)myapp.findViewById(R.id.textView4);
            text.setText(strBuffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return myapp;
    }
}