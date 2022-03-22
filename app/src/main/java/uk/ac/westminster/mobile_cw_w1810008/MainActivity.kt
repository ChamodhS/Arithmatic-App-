package uk.ac.westminster.mobile_cw_w1810008

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //created the two buttons in the first activity
        var aboutButton : Button = findViewById(R.id.about)

        var newGameButton : Button = findViewById(R.id.newGame)

        //creates dialog upon click
        aboutButton.setOnClickListener {

            val popUp = AlertDialog.Builder(this);
            popUp.setTitle("Student ID: w1810008 Author: S.M.C.P Samaranayake");
            popUp.setMessage(R.string.pledge)
            popUp.setPositiveButton("Okay") { dialogInterface: DialogInterface, i: Int ->


            }

            popUp.show();
        }



        newGameButton.setOnClickListener {


            var intentNewGame = Intent(this,NewGame::class.java)

            startActivity(intentNewGame)


        }





    }










}