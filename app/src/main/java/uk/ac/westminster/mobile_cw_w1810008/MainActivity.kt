package uk.ac.westminster.mobile_cw_w1810008

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //created the two buttons in the first activity
        var aboutButton : Button = findViewById(R.id.about)

        var newGameButton : Button = findViewById(R.id.newGame)


        aboutButton.setOnClickListener {


            println("About");





        }



        newGameButton.setOnClickListener {


            var intentNewGame = Intent(this,NewGame::class.java)

            startActivity(intentNewGame)


        }





    }
}