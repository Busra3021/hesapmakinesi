package com.example.soru2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_1 = (Button) findViewById(R.id.btn_1);
        Button btn_2 = (Button) findViewById(R.id.btn_2);
        Button btn_3 = (Button) findViewById(R.id.btn_3);
        Button btn_4 = (Button) findViewById(R.id.btn_4);
        Button btn_5 = (Button) findViewById(R.id.btn_5);
        Button btn_6 = (Button) findViewById(R.id.btn_6);
        Button btn_7 = (Button) findViewById(R.id.btn_7);
        Button btn_8 = (Button) findViewById(R.id.btn_8);
        Button btn_9 = (Button) findViewById(R.id.btn_9);
        Button btn_0 = (Button) findViewById(R.id.btn_0);


        sonuc = (EditText) findViewById(R.id.editTextNumber);

    }

    //texti temizleme butonu
    public void btn_c(View view) {
        number = null;
        sonuc.setText(String.valueOf(0));

    }

    String number = null;

    public void numbersClick(View view) {


        if (number == null)
        {
            number = view.getTag().toString();


        } else {
            number = number + view.getTag().toString();


        }
        operator=true;

        sonuc.setText(number);


    }

    int firstNumber = 0;
    int lastNumber = 0;
    boolean operator=false;
    String durum=null;


    public void topla()
    {
        if (firstNumber==1)
            firstNumber=0;
        lastNumber=Integer.parseInt(sonuc.getText().toString());
        firstNumber=firstNumber+lastNumber;
        sonuc.setText(""+firstNumber);


    }

    public void btn_topla(View view)
    {

        topla();
        if (durum=="carp")
        {
            if(operator)
                carp();

        }else if (durum=="bol")
        {
           if (operator)
               bol();

        }else if (durum=="cikar")
        {
            if (operator)
                cikar();
        }
        else
        {
            if (operator)
                topla();
        }
        durum="topla";

        number=null;
        operator=false;
    }
    public void carp()
    {
        if (firstNumber==0)
        firstNumber=1;
        lastNumber=Integer.parseInt(sonuc.getText().toString());
        firstNumber=firstNumber*lastNumber;
        sonuc.setText(""+firstNumber);
    }
    public  void btn_carpma(View view)
    {

        if (durum=="topla")
        {
            if(operator)
                topla();

        } else if (durum=="bol")
        {
            if (operator)
                bol();

        }else if (durum=="cikar")
        {
            if (operator)
                cikar();
        }
        else
        {
            if (operator)
                carp();
        }

        durum="carp";

        number=null;
        operator=false;
    }
    public void bol()
    {
        if (firstNumber==0)
            firstNumber=1;
        lastNumber=Integer.parseInt(sonuc.getText().toString());
        firstNumber=firstNumber/lastNumber;
        sonuc.setText(""+firstNumber);
    }
    public void btn_bolme(View view)
    {


            if (durum=="topla")
            {
                if(operator)
                    topla();

            } else if (durum=="carp")
            {
                if (operator)
                    carp();

            }else if (durum=="cikar")
            {
                if (operator)
                    cikar();
            }
            else
            {
                if (operator)
                    bol();
            }

            durum="bol";



            number=null;
            operator=false;
    }
    public void cikar()
    {
        lastNumber=Integer.parseInt(sonuc.getText().toString());
        firstNumber=firstNumber-lastNumber;
        sonuc.setText(""+firstNumber);
    }
    public void btn_eksi(View view) {

        if (durum == "topla") {
            if (operator)
                topla();

        } else if (durum == "carp") {
            if (operator)
                carp();

        } else if (durum == "bol") {
            if (operator)
                bol();
        }
        else
        {


                if (operator)
                    cikar();
            }

        durum="cikar";


        number=null;
        operator=false;

    }
    public void btn_esittir(View view)
    {
        if(operator==true){
            if (durum=="topla")
                firstNumber=firstNumber+Integer.parseInt(sonuc.getText().toString());
            if (durum=="carp")
                firstNumber=firstNumber*Integer.parseInt(sonuc.getText().toString());
            if (durum=="bol")
                firstNumber=firstNumber+Integer.parseInt(sonuc.getText().toString());
            if (durum=="cikar")
                firstNumber=firstNumber-Integer.parseInt(sonuc.getText().toString());
            sonuc.setText(""+firstNumber);
        }
        operator=false;
    }

    }

















