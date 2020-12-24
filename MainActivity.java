package com.example.beaty_saloon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {

    private EditText login, pass;
    private Button btnAvt, btnReg,btnEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (EditText)findViewById(R.id.editTextTextPersonName);
        pass = (EditText)findViewById(R.id.editTextTextPassword);
        addListenerOnButton();
    }

    public void addListenerOnButton(){
        btnAvt = (Button)findViewById(R.id.buttonAvt);
        btnAvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag =0;
                try {
                    FileInputStream fileInput = openFileInput("UsersBase.txt");
                    InputStreamReader reader = new InputStreamReader(fileInput);
                    BufferedReader buffer = new BufferedReader(reader);
                    StringBuffer strBuffer = new StringBuffer();
                    String lines;
                    while ((lines= buffer.readLine())!= null){
                        strBuffer.append(lines+"\n");
                        if(lines.equals(login.getText().toString() + " " + pass.getText().toString())){
                            Toast.makeText(
                                    MainActivity.this,  "Добро пожаловать",
                                    Toast.LENGTH_LONG
                            ).show();
                            login.setText("");
                            pass.setText("");
                            Intent cab = new Intent(".Cabinet");
                            startActivity(cab);
                            flag=1;
                        }
                    }
                    if (flag==0){
                        Toast.makeText(
                                MainActivity.this,  "Неверный логин или пароль",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnReg = (Button)findViewById(R.id.buttonReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(".Registration");
                startActivity(intent);
            }
        });
        btnEx = (Button)findViewById(R.id.buttonExit);
        btnEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder exit_bilder = new AlertDialog.Builder(MainActivity.this);
                exit_bilder.setMessage("Закрыть приложение?")
                        .setCancelable(false)
                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog exit_alert = exit_bilder.create();
                exit_alert.setTitle("Выход");
                exit_alert.show();
            }
        });

    }


}