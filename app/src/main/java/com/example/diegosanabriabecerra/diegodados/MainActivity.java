package com.example.diegosanabriabecerra.diegodados;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int score = 0;
    TextView TxtRollResult;
    Button btnLanzarDados;
    Random MyRand = new Random();
    public int die1;
    public int die2;
    public int die3;
    ArrayList<Integer> MyDice_Array;
    ArrayList<ImageView> diceImageViews;
    TextView scoreText;
    public  int diegoYear;


    Button entrar;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//Create the cointainer for dice
        TxtRollResult = (TextView) findViewById(R.id.scoreText);
        btnLanzarDados = (Button) findViewById(R.id.btnRollDice);
        MyDice_Array = new ArrayList<Integer>();
        ImageView die1Image = (ImageView) findViewById(R.id.die1Image);
        ImageView die2Image = (ImageView) findViewById(R.id.die2Image);
        ImageView die3Image = (ImageView) findViewById(R.id.die3Image);

        entrar =(Button) findViewById(R.id.btnIraOtraActividad);

        diceImageViews =new ArrayList<ImageView>();
        diceImageViews.add(die1Image);
        diceImageViews.add(die2Image);
        diceImageViews.add(die3Image);
        scoreText = (TextView) findViewById(R.id.scoreText);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             // Snackbar.make(view, "Diego Sanabria, es un gran programador Android!!!", Snackbar.LENGTH_LONG)
               //         .setAction("Action", null).show();

                Intent nuevaAct = new Intent(MainActivity.this, second.class);

                startActivity(  nuevaAct  );



    }



        });

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  String PeruPassword = password.getText().toString();
                int entry=5;
                if (entry==5){

                    Intent nuevaAct = new Intent(MainActivity.this, second.class);

                    startActivity(  nuevaAct  );




                }else{

                    Toast.makeText(MainActivity.this, "deberia servir", Toast.LENGTH_LONG).show();//Como Martha Show();
                }


            }
        });
    }




    private void TestGitHub()
    {
        int i = 1+2;
        int ii = i+2;
        int iii = ii+1;



    }

    public void rollDice(View v) {


        die1 = MyRand.nextInt(6)+1;
        die2 = MyRand.nextInt(6)+1;
        die3 = MyRand.nextInt(6)+1;
        //after rolling the dice, values in arrayList set clear.
        //and the values added to the arrayList
        MyDice_Array.clear();
        MyDice_Array.add(die1);
        MyDice_Array.add(die2);
        MyDice_Array.add(die3);


        for (int dieOfSet = 0; dieOfSet < 3; dieOfSet++){
            String imageName = "dado_"+MyDice_Array.get(dieOfSet)+".png";
diegoYear++;

            try
            {
                InputStream stream = getAssets().open(imageName);
                Drawable d = Drawable.createFromStream(stream, null);
                diceImageViews.get(dieOfSet).setImageDrawable(d);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }


                String msg = " " +die1 +" "+die2+ "" +die3 ;
        // for the other App.
        // int suma = die1+die2+die3;
        if(die1 == die2 && die1==die3)
        //condition for triples
        {
             int scoreDelta = die1 *100;
             msg =  "You rolled a triple  " + die1 + "!You Scored "+ scoreDelta + "points" ;
             score += scoreDelta;

        }else if(die1==die2 || die1==die3 || die2==die3)
        {
            //doubles
            msg ="You scored doubles for 50 points";
            score += 50;
        }else
            {
                msg = "You didn't score this roll. Try again";
            }

TxtRollResult.setText(msg);
        scoreText.setText("Score : " + score);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
