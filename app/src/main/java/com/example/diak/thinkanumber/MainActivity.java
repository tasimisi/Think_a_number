package com.example.diak.thinkanumber;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_plus, btn_negative, btn_submit;
    private TextView number;
    private ImageView imgV_1, imgV_2, imgV_3, imgV_4, imgV_5;
    private int kitalalando_szam = 0, tippelt_szam = 0;

    private AlertDialog.Builder alert_nyert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        alert_nyert = new AlertDialog.Builder(MainActivity.this);
        alert_nyert.setTitle("Gratulálok nyertél!")
                .setMessage("Újra akarod kezdeni a játékot?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener(){     //Pozitív gomb = jobb oldali gomb
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener(){    //Negatív gomb = bal oldali gomb
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //new_game();
                    }
                })
                .setCancelable(false)
                .create();

        Random rnd = new Random();
        kitalalando_szam = rnd.nextInt(50)+1;

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippelt_szam<50){
                    tippelt_szam++;
                }
                number.setText(""+tippelt_szam);
            }
        });

        btn_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippelt_szam>0){
                    tippelt_szam--;
                }
                number.setText(""+tippelt_szam);
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippelt_szam == kitalalando_szam)
                {
                    Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
                    alert_nyert.show();

                } else if (tippelt_szam > kitalalando_szam)
                {
                    Toast.makeText(MainActivity.this, "Lejjebb", Toast.LENGTH_SHORT).show();

                } else if (tippelt_szam < kitalalando_szam)
                {
                    Toast.makeText(MainActivity.this, "Feljebb", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init(){

        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_negative = (Button) findViewById(R.id.btn_negative);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        number = (TextView) findViewById(R.id.textView_szam);
        imgV_1 = (ImageView) findViewById(R.id.imageView_elet1);
        imgV_2 = (ImageView) findViewById(R.id.imageView_elet2);
        imgV_3 = (ImageView) findViewById(R.id.imageView_elet3);
        imgV_4 = (ImageView) findViewById(R.id.imageView_elet4);
        imgV_5 = (ImageView) findViewById(R.id.imageView_elet5);

    }
}
