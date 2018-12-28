package com.example.mark.logreg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private DB db;
    private EditText F_nev,J_szo,J_szo2,T_nev,T_szam;
    private Button Register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        Register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            adatRogzites();
            Intent vissza = new  Intent(Main2Activity.this,MainActivity.class);
            startActivity(vissza);
            finish();
            }
        });
    }


    public void init(){

        F_nev =(EditText) findViewById(R.id.F_nev);
        J_szo =(EditText) findViewById(R.id.J_szo);
        J_szo2 =(EditText) findViewById(R.id.J_szo2);
        T_nev =(EditText) findViewById(R.id.T_nev);
        T_szam =(EditText) findViewById(R.id.T_szam);

        Register_button = (Button) findViewById(R.id.Register_button);

        db = new DB(this);
    }
    public void adatRogzites()
    {
        String fnev = F_nev.getText().toString();
        String jelszo = J_szo.getText().toString();
        String jmegerosit = J_szo2.getText().toString();
        String tnev = T_nev.getText().toString();
        String tszam = T_szam.getText().toString();

        boolean eredmeny = db.adatRogzites(fnev,jelszo,jmegerosit,tnev,tszam);

        if (eredmeny)
        {
            Toast.makeText(this, "Sikeres Adatrögzítés.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Sikertelen Adatrögzités.", Toast.LENGTH_SHORT).show();
        }
    }
}
