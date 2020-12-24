package com.example.beaty_saloon;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Appointment extends Fragment {
    private Button appoit;
    private CheckBox dars, linf, lifting, plazm, terma, diagn, ion, tatu, photo, botox, shell;
    private EditText date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewap = inflater.inflate(R.layout.fragment_appointment, container, false);
        Button button = (Button) viewap.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText date = (EditText)getView().findViewById(R.id.editTextDate);
                int sum = 0;
                String app="У вас запись на "+ date.getText().toString() + "\nВы записаны ан следующие процедуры: ";
                dars = (CheckBox) viewap.findViewById(R.id.checkDarsonval);
                linf = (CheckBox) viewap.findViewById(R.id.checkLinfodrenaj);
                lifting = (CheckBox) viewap.findViewById(R.id.checkLifting);
                plazm = (CheckBox) viewap.findViewById(R.id.checkPlazma);
                terma = (CheckBox) viewap.findViewById(R.id.checkRefactor);
                diagn = (CheckBox) viewap.findViewById(R.id.checkDiagnoz);
                ion = (CheckBox) viewap.findViewById(R.id.checkIonoforez);
                tatu = (CheckBox) viewap.findViewById(R.id.checkTatuaj);
                photo = (CheckBox) viewap.findViewById(R.id.checkPhototerapy);
                botox = (CheckBox) viewap.findViewById(R.id.checkBotox);
                shell = (CheckBox) viewap.findViewById(R.id.checkShellak);
                if (dars.isChecked()){ sum += 1500; app+="дарсонвализацию\n"; }
                if (linf.isChecked()){ sum += 4000; app+="Линфодренаж\n"; }
                if (lifting.isChecked()){ sum += 2000; app+="лифтинг \n";}
                if (plazm.isChecked()){ sum += 6000;app+="плазмолифтинг \n"; }
                if (terma.isChecked()){ sum += 700; app+="термаж \n";}
                if (diagn.isChecked()){ sum += 500; app+="диагностика \n";}
                if (ion.isChecked()){ sum += 3000; app+="ионофорез \n";}
                if (tatu.isChecked()){ sum += 1500; app+="татуаж \n";}
                if (photo.isChecked()){ sum += 700; app+="фототерапия \n";}
                if (botox.isChecked()){ sum += 17000; app+="ботокс \n";}
                if (shell.isChecked()){ sum += 1200; app+="шеллак \n";}
                app += "Сумма услуг: "+Integer.toString(sum) +" рублей";
                FileOutputStream OutSt =null;
                try {
                    OutSt = getContext().openFileOutput("AppBase.txt",0);
                    OutSt.write(app.getBytes());
                    OutSt.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return viewap;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}