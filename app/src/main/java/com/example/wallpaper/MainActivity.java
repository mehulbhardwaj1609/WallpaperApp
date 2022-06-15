package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button b;
    ImageView iv;
    int images[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=findViewById(R.id.image);
        b=findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t=new Thread(new Runnable() {

                    public void run()
                    {
                        try {
                            while(i<6){
                                iv.setImageResource(images[i]);
                                i++;
                                if(i==6)
                                    i=0;
                                Thread.sleep(1000); //1 second
                            }

                        }
                        catch(Exception e)
                        {

                        }
                    }
                });
                t.start();

            }
        });



    }
}