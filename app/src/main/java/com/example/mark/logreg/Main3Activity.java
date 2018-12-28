package com.example.mark.logreg;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    DB db;
    TextView Tv_nev;
    Button Kijelentkezes_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Cursor eredmeny = db.adatLekerdezes();
        StringBuffer stringBuffer = new StringBuffer();

        if (eredmeny != null && eredmeny.getCount() > 0 )
        {
            while(eredmeny.moveToNext())
            {
                stringBuffer.append("Felhasználó név" + eredmeny.getString(2));
            }
        }

        Tv_nev.setText(stringBuffer.toString());

        Toast.makeText(this, "Üdvözöllek," + DB.COL_2, Toast.LENGTH_SHORT).show();

        Kijelentkezes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza_fooldal = new Intent(Main3Activity.this,MainActivity.class);
                startActivity(vissza_fooldal);
                finish();
            }
        });

        init();
    }
    public void init(){

        Tv_nev = (TextView) findViewById(R.id.Tv_nev);

        Kijelentkezes_button =(Button) findViewById(R.id.Kijelentkezes_button);
        db = new DB(this);
    }
}
