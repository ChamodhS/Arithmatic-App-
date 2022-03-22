package uk.ac.westminster.mobile_cw_w1810008

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.TextView

class NewGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        var textView1:TextView = findViewById(R.id.textView1)
        var textView2:TextView = findViewById(R.id.textView2)
        var greaterButton :Button=findViewById(R.id.greater)
        var lesserButton :Button=findViewById(R.id.lesser)
        var  equalButton :Button=findViewById(R.id.equal)
        var (a,b) = createArith()
        var (c,d) =createArith()
        textView1.text=b;
        textView2.text =d;
        println(b)
        println(d)
        val Arg1 =  a
        val Arg2 = c


    }


    //create function for returning random numbers
    //passing argument as the upper limit
    fun randomizer( x:Int):Int{

        return (1..x).random()
    }


    //declare operator

    fun operator():String{

        var chance= randomizer(4)

        var op = when (chance){

            1 -> ("+")
            2 -> ("-")
            3 -> ("*")
            else -> ("/")

        }


        return op

    }

    //function to calculate two terms
    fun calculator(varOne:Int,varSecond:Int,operator:String):Int{

        var total =when (operator){

            "+" -> (varOne+varSecond)
            "-" -> (varOne-varSecond)
            "*" -> (varOne*varSecond)
            else -> (varOne/varSecond)

        }

        return total
    }


    //return a list of variables in a list

    fun getVars(terms:Int):MutableList<Int> {

        val list = mutableListOf<Int>()
        var i =0
        while (i<terms){

            list.add(randomizer(20))
            i++
        }

        return list

    }







    //function to get string of arithmatic expression



    fun calculator2(x:Int,y:MutableList<Int>):Pair<Int,String>{

        var total =0
        var print="x";

        when (x){

            2 -> {

                var op1 = operator()

                total = calculator(y[0],y[1],op1)

                print = (("${y[0]}" +op1+"${y[1]}"))




            }
            3  ->{

                var op1 = operator()
                var op2 = operator()

                total = calculator(calculator(y[0],y[1],op1),y[2],op2)

                print = ("(${y[0]}" +op1+"${y[1]})"+"${op2}"+"${y[2]}")




            }
            4  -> {

                var op1 = operator()
                var op2 = operator()
                var op3 = operator()
                total = calculator(calculator(calculator(y[0],y[1],op1),y[2],op2),y[3],op3)

                print =("((${y[0]}" +op1+"${y[1]})"+"${op2}"+"${y[2]})"+op3+"${y[3]}")



            }
        }

        return Pair(total,print)


    }


    //creation of aritmatic
    fun createArith():Pair<Int,String>{
        // get the number of terms
        var noTermsA = randomizer(4)

        //get list of values
        var valuesA = getVars(noTermsA)

        //make calculations
        return calculator2(noTermsA,valuesA)

    }
}