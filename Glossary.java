package com.example.beaty_saloon;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Glossary extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_glossary, container, false);
        ListView listView = view.findViewById(R.id.list);
        String[] servises = {"Дарсонвализация обычная","Линфодренаж тела","Кислородный лифтинг", "Плазмолифтинг лицевой", "Термаж лица",
               "Диагностика кожи","Ионофорез тела","Татуаж бровей","Фототерапия лица","Ботоксная процедура","Маникюр шеллкак"};
        ArrayAdapter<String> monthAdapter =
                new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, servises);
        listView.setAdapter(monthAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                String url = "https://www.google.ru/search?q=" + ((TextView) itemClicked).getText().toString().replace(" ", "+")+ " что это";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        return view;
    }

}