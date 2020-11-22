package com.cookandroid.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static com.cookandroid.afinal.R.drawable.wendu;
import static com.cookandroid.afinal.R.drawable.wenduliang;

public class lastActivity extends AppCompatActivity {
    private Button btn_LED,btn_blue;
    private ImageView tv,bl;
    private boolean status=false;
    private boolean statusw=false;
    private ImageView show;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        show = findViewById(R.id.wen);
        btn_LED = (Button) findViewById(R.id.btnLed);
//        btn_blue = (Button) findViewById(R.id.tooth);
        tv=findViewById(R.id.dengl);
//        bl=findViewById(R.id.blue);
//        btn_blue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(!statusw){
//
//                    bl.setBackgroundResource(R.drawable.lanbu);
//                    statusw=true;
//                }else{
//
//                    bl.setBackgroundResource(R.drawable.lan);
//                    statusw=false;
//                }
//            }
//        });
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
        show.setImageDrawable(getResources().getDrawable((wenduliang)));
//        searchIv.setBackgroundResource(R.drawable.search2);
        blink();


    }
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
//                    blink();
                        }
                    });
                    i++;
                }

            }
        }).start();
    }
}

