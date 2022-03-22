package uk.ac.westminster.mobile_cw_w1810008

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NewGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)
    }

    //create function for returning random numbers
    //passing argument as the upper limit
    fun randomizer( x:Int):Int{

        return (0..x).random()
    }

    //declare number of terms

    var noTerms = randomizer(3)

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

        val list = mutableListOf<Int>();
        var i =0;
        while (i<terms){

            list.add(randomizer(20))
        }

        return list

    }



    //select the number of terms


    fun selector1(x:Int){

        println(x)



    }
        //function to get string of arithmatic expression
    fun printer(A:String,B:Int){

        when (B){

            2-> {
                println("A"+A+"B")
            }

            3->{

                println("(A"+A+"B)"+A+"C")
            }

            4 -> {

                println("((A+B)+C)+D")
            }

        }



    }


    fun calculator2(x:Int,y:MutableList<Int>):Int{

        var total = when (x){

            2 -> calculator(y[0],y[1],operator())
            3  -> calculator(calculator(y[0],y[1],operator()),y[2],operator())
            else -> calculator(calculator(calculator(y[0],y[1],operator()),y[2],operator()),y[3],operator())
        }

        return total


    }


    //creation of aritmatic
    fun createArith():Int{
        // get the number of terms
        var noTermsA = randomizer(4)


        //get list of values
        var valuesA = getVars(noTermsA)


        //make calculations

       return calculator2(noTermsA,valuesA)

    }


}