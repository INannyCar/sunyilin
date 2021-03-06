package com.cookandroid.afinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static com.cookandroid.afinal.R.drawable.wendu;
import static com.cookandroid.afinal.R.drawable.wendu1;
import static com.cookandroid.afinal.R.drawable.wenduliang;

public class lastActivity extends AppCompatActivity {
    private Button btn_LED,btn_zi,btn_break1,btn_break2;
    private ImageView tv;
    private boolean status=false;
    private boolean stazi=false;
    private boolean break1=false;
    private boolean breakz=false;
    private ImageView show;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        show = findViewById(R.id.wen);
        btn_LED = (Button) findViewById(R.id.btnLed);
        btn_zi=(Button)findViewById(R.id.btnLedMode);
        btn_break1=(Button)findViewById(R.id.btnbreak1);
        btn_break2=(Button)findViewById(R.id.btnBreak);
        tv=findViewById(R.id.dengl);

        btn_zi.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                if(!stazi){

                    btn_LED.setEnabled(false);
                    stazi=true;
                }else{

                    btn_LED.setEnabled(true);
                    stazi=false;
                }
            }
        });
        btn_break1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                if(!breakz){

                    btn_break2.setEnabled(false);
                    breakz=true;
                }else{

                    btn_break2.setEnabled(true);
                    breakz=false;
                }
            }
        });
        btn_LED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!status){

                    tv.setBackgroundResource(R.drawable.deng);
                    status=true;
                }else{

                    tv.setBackgroundResource(R.drawable.buliang);
                    status=false;
                }
            }
        });


    }
    public void click(View View){
        show.setImageDrawable(getResources().getDrawable((wendu1)));
        blink();


    }
    public void showdialog(View view)
    {

        AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(this);
        alertdialogbuilder.setMessage("종료하시겠습니까?");
        alertdialogbuilder.setPositiveButton("확인",click1);
        alertdialogbuilder.setNegativeButton("취소",click2);
        AlertDialog alertdialog1=alertdialogbuilder.create();
        alertdialog1.show();
     }

     private DialogInterface.OnClickListener click1=new DialogInterface.OnClickListener(){

    @Override
     public void onClick(DialogInterface arg0,int arg1)
    {
        android.os.Process.killProcess(android.os.Process.myPid());
    }
    };
    private DialogInterface.OnClickListener click2=new DialogInterface.OnClickListener()
    {
        @Override
        public void onClick(DialogInterface arg0,int arg1)
        {
            arg0.cancel();
        }
    };
    private void blink(){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(i<6){
                    int timeToBlink = 1000;    //in milissegunds
                    try{Thread.sleep(timeToBlink);}catch (Exception ignored) {}
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ImageView txt =  findViewById(R.id.wen);
                            if(txt.getVisibility() == View.VISIBLE){
                                txt.setVisibility(View.INVISIBLE);
                            }else{
                                txt.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                    i++;
                }

            }
        }).start();
    }
}

