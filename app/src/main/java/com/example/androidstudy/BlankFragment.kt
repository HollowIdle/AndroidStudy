package com.example.androidstudy

import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment


class BlankFragment : Fragment() {

}

fun main() {
    var math = myMath()
    var strings = myStrings()
    var overStrings = overStrings()


    //myMath
    println("Square: " + math.square(number = 5))
    println("Subtract: " + math.subtract(num1 = 5, num2 = 10))
    println("Sum: " + math.sum(num1 = 11,num2 = 12))
    println()

    //myStrings
    println("Concat: " + strings.concatStrings(string1 = "Hello ", string2 = "World!"))
    strings.outputMessage(message = "This is my final message - Goodbye")
    //По позиции в сообщении получаем символ
    strings.charFromMessage(message = "This is my message", positionInMessage = 3)
    println()

    //overStrings - override from myStrings
    println("Concat: " + overStrings.concatStrings(string1 = "Hello ", string2 = "World!"))
    overStrings.outputMessage(message = "just a message")
    overStrings.charFromMessage(message = "just a message again", positionInMessage = 8)


}



open class myMath{

    fun square (number: Int) = number * number

    fun sum(num1: Int, num2: Int): Int{
        return num1 + num2
    }

    fun subtract(num1: Int,num2: Int): Int {
        return num1 - num2;
    }
}

open class myStrings{

    open fun concatStrings(string1: String,string2: String) : String{
        return string1 + string2
    }

    open fun outputMessage(message : String) : Unit {
        println("message: $message")
    }

    open fun charFromMessage(message: String, positionInMessage: Int) : Unit{
        var length = message.length

        if (positionInMessage < 0){
            println("wrong number")
            return
        }

        if(length < positionInMessage){
            println("number out of range")
            return
        }
        var pos = positionInMessage - 1
        var ch = message[pos];
        println("char from message: $ch")
    }

}

class overStrings : myStrings() {

    override fun concatStrings(string1: String,string2: String): String {
        println("strings before concatenation string1: $string1, string2: $string2")
        return string1 + string2
    }

    override fun outputMessage(message : String) : Unit {
        println("override fun message: $message")
    }

    override fun charFromMessage(message: String, positionInMessage: Int) : Unit{
        var length = message.length

        if (positionInMessage < 0){
            println("wrong number")
            return
        }

        if(length < positionInMessage){
            println("number out of range")
            return
        }

        var pos = positionInMessage - 1
        var ch = message[pos];
        println("message for char withdrawal: $message \nchar from message: |$ch| on position $positionInMessage")
    }

}








