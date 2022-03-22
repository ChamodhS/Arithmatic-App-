package uk.ac.westminster.mobile_cw_w1810008

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class NewGame : AppCompatActivity() {

    var arith1 = createArith()
    var arith2 = createArith()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        val textView1: TextView = findViewById(R.id.textView1)
        val textView2: TextView = findViewById(R.id.textView2)
        val message: TextView = findViewById(R.id.notice)
        val greaterButton: Button = findViewById(R.id.greater)
        val lesserButton: Button = findViewById(R.id.lesser)
        val equalButton: Button = findViewById(R.id.equal)



        val (a, b) = arith1
        val (c, d) = arith2
        textView1.text = b
        textView2.text = d

        fun samplefun(x:Pair<Int,String>,y:Pair<Int,String>){
            val (a,b)=x
            val (c,d)=y
            textView1.text=b;
            textView2.text=d;
        }

        greaterButton.setOnClickListener {
            if (a > c) {
                buildPopUpCorrect()
                samplefun(createArith(),createArith())

            } else {

                buildPopUpIncorrect()
                samplefun(createArith(),createArith())
            }

        }


        lesserButton.setOnClickListener {
            if (a < c) {
                buildPopUpCorrect()
                samplefun(createArith(),createArith())

            } else {

                buildPopUpIncorrect()
                samplefun(createArith(),createArith())
            }

        }

        equalButton.setOnClickListener {
            if (a == c) {
                buildPopUpCorrect()
                samplefun(createArith(),createArith())

            } else {

                buildPopUpIncorrect()
                samplefun(createArith(),createArith())
            }

        }

    //}
    }

    //creating correct alert
    fun buildPopUpCorrect(){
    val popUp = AlertDialog.Builder(this);
    popUp.setMessage("CORRECT!")
    popUp.setPositiveButton("Continue")



    { _: DialogInterface, i: Int ->

    }
        popUp.show()


    }


    fun buildPopUpIncorrect(){
        val popUp = AlertDialog.Builder(this);
        popUp.setMessage("WRONG!!")
        popUp.setPositiveButton("Continue")



        { _: DialogInterface, i: Int ->

        }


        popUp.show();


    }



    //create function for returning random numbers
    //passing argument as the upper limit
    private fun randomizer( x:Int):Int{

        return (1..x).random()
    }


    //declare operator

    private fun operator():String{

        val op = when (randomizer(4)){

            1 -> ("+")
            2 -> ("-")
            3 -> ("*")
            else -> ("/")

        }


        return op

    }

    //function to calculate two terms
    private fun calculator(varOne:Int,varSecond:Int,operator:String):Int{

        val total =when (operator){

            "+" -> (varOne+varSecond)
            "-" -> (varOne-varSecond)
            "*" -> (varOne*varSecond)
            else -> (varOne/varSecond)

        }

        return total
    }


    //return a list of variables in a list

    private fun getVars(terms:Int):MutableList<Int> {

        val list = mutableListOf<Int>()
        var i =0
        while (i<terms){

            list.add(randomizer(20))
            i++
        }

        return list

    }










    //returning the arithmatic value and string as a pair
    private fun calculator2(x:Int, y:MutableList<Int>):Pair<Int,String>{

        var total =0
        var print="x"

        when (x){

            2 -> {

                val op1 = operator()

                total = calculator(y[0],y[1],op1)

                print = (("${y[0]}" +op1+"${y[1]}"))




            }
            3  ->{

                val op1 = operator()
                val op2 = operator()

                total = calculator(calculator(y[0],y[1],op1),y[2],op2)

                print = ("(${y[0]}" +op1+"${y[1]})"+op2+"${y[2]}")




            }
            4  -> {

                val op1 = operator()
                val op2 = operator()
                val op3 = operator()
                total = calculator(calculator(calculator(y[0],y[1],op1),y[2],op2),y[3],op3)

                print =("((${y[0]}" +op1+"${y[1]})"+op2+"${y[2]})"+op3+"${y[3]}")



            }
        }

        return Pair(total,print)


    }


    //creation of arithmetic
    private fun createArith():Pair<Int,String>{
        // get the number of terms
        val noTermsA = (2..4).random()

        //get list of values
        val valuesA = getVars(noTermsA)

        //make calculations
        return calculator2(noTermsA,valuesA)

    }
}