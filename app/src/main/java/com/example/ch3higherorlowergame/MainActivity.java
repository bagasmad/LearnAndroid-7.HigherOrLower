package com.example.ch3higherorlowergame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int random;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = generateRand (20);
    }

    public int generateRand(int upperRange)
    {
        Random random = new Random();
        return random.nextInt(upperRange);

    }
    public void guessAction(View view)
    {
        EditText numberGuess = findViewById(R.id.numberGuess);
        if (numberGuess.length()>0)
        {
            int guessedNumber = Integer.parseInt(numberGuess.getText().toString());
            if (guessedNumber > random){
                Toast.makeText(this, "Lower!", Toast.LENGTH_SHORT).show();
            } else if (guessedNumber == random){
                Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show();
                random = generateRand(20);
                numberGuess.setText("");
            }
            else{
                Toast.makeText(this, "Higher!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this,"Enter a number!", Toast.LENGTH_SHORT).show();
        }

    }
}
