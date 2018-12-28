package com.example.mark.logreg;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button Login_button,Register_button;
    private EditText F_nev,J_szo;
    private DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        Register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg_adat = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(reg_adat);
                finish();
            }
        });
        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatLekeres();
                Intent user = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(user);
                finish();
            }
        });
    }


    public void init()
    {
        F_nev = (EditText) findViewById(R.id.F_nev);
        J_szo = (EditText) findViewById(R.id.J_szo);
        Login_button =(Button) findViewById(R.id.Login_button);
        Register_button =(Button) findViewById(R.id.Register_button);
        db = new DB(this);
    }

    public void adatLekeres()
    {
        Cursor eredmeny = db.adatLekerdezes();
        StringBuffer stringBuffer = new StringBuffer();

        if (eredmeny!=null && eredmeny.getCount()>0)
        {
            while(eredmeny.moveToNext())
            {
                stringBuffer.append("Felhasználó név" + eredmeny.getString(1)+"\n");
                stringBuffer.append("Jelszó" + eredmeny.getString(2));
                Toast.makeText(this, "Adat sikeresen lekérve!", Toast.LENGTH_SHORT).show();
            }
        }else
        {
            Toast.makeText(this, "Nincs ilyen adat!", Toast.LENGTH_SHORT).show();
        }
    }
}
