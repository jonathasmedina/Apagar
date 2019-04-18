package com.example.jonathas.apagar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner);

        ArrayList<String> dadosSpinner = new ArrayList<>();

        dadosSpinner.add("Opção 1");
        dadosSpinner.add("Opção 2");
        dadosSpinner.add("Opção 3");

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, dadosSpinner);

        spinner1.setAdapter(spinnerArrayAdapter);
        spinner1.setOnItemSelectedListener(ouvinteSpinner);


        //para ver qual selecionado, na ação de um botão
        //String esse = spinner1.getSelectedItem().toString();
        //long esseN = spinner1.getSelectedItemPosition();
    }

    //ouvinte do spinner
    AdapterView.OnItemSelectedListener ouvinteSpinner = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String itemSelecionado = spinner1.getSelectedItem().toString();
            if (position==1) {
                Intent i = new Intent(MainActivity.this, TrabalhoN1.class);
                startActivity(i);
            }


            if (position==2) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"emaildojonathas@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Assunto");
                i.putExtra(Intent.EXTRA_TEXT, "Corpo do e-mail");
                try {
                    startActivity(Intent.createChooser(i, "Enviando email..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "Configurar o app cliente de email,", Toast.LENGTH_SHORT).show();
                }
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

}
