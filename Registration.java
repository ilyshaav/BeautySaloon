package com.example.beaty_saloon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Registration extends AppCompatActivity {

    private EditText login, pass, phone, name;
    private Button  btnReg,btnEX;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        login=(EditText)findViewById(R.id.editTextLogin);
        pass=(EditText)findViewById(R.id.editTextTextPassword2);
        phone=(EditText)findViewById(R.id.editTextPhone);
        name= (EditText)findViewById(R.id.editTextTextPersonNameReg);
        addListenerOnButton();
    }

    public void addListenerOnButton(){
        btnReg = (Button)findViewById(R.id.butReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = login.getText().toString()+" "+pass.getText().toString()+"\n"+phone.getText().toString()+ "\n"+name.getText().toString()+"\n";
                try {
                    FileOutputStream fileOut = openFileOutput("UsersBase.txt", MODE_APPEND);
                    fileOut.write(data.getBytes());
                    fileOut.close();
                    login.setText("");
                    pass.setText("");
                    phone.setText("");
                    name.setText("");
                    Toast.makeText(
                            Registration.this,  "Регистрация успешна",
                            Toast.LENGTH_LONG
                    ).show();
                    finish();
                } catch (FileNotFoundException e) {
                    Toast.makeText(
                            Registration.this,  "Что-то пошло не так, попробуйте позже",
                            Toast.LENGTH_SHORT
                    ).show();
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnEX=(Button)findViewById(R.id.buttonBack);
        btnEX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}