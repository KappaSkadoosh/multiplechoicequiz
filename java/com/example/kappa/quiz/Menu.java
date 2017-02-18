package com.example.kappa.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


/**
 * Created by Kappa on 2/18/2017.
 */

public class Menu extends Activity {

    private Button playbutton;
    private Button highbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        playbutton=(Button)findViewById(R.id.play);
        highbutton=(Button)findViewById(R.id.highscore);

        main();



    }

    public void main(){
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        highbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), Highscore.class);
                startActivity(i);
            }
        });
    }
}