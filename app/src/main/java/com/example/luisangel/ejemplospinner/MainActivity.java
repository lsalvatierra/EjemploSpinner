package com.example.luisangel.ejemplospinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner lstPaises, lstCiudades;
    String[] items;
    String[] itemsCiudades;
    List<String> listaCiudades;
    String nombreCiudad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Cargar Spinner desde archivo de valores
        lstPaises = (Spinner)findViewById(R.id.sppPais);
        items = getResources().getStringArray(R.array.opciones);
        ArrayAdapter<String> lstadapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,items);
        lstadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lstPaises.setAdapter(lstadapter);

        lstPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), items[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Cargar Spinner desde ArrayList
        lstCiudades = (Spinner)findViewById(R.id.sppCiudades);
        listaCiudades = new ArrayList<String>();
        itemsCiudades = new String[] {"Lima", "Trujillo", "Huancayo", "Piura", "Arequipa"};
        Collections.addAll(listaCiudades, itemsCiudades);
        ArrayAdapter<String> lstadapterCiudades = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listaCiudades);
        lstCiudades.setAdapter(lstadapterCiudades);

        lstCiudades.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.sppCiudades:
                //Almaceno el nombre de la ciudad seleccionada.
                nombreCiudad = itemsCiudades[position];
                Toast.makeText(this, "Ciudad: " + nombreCiudad, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
