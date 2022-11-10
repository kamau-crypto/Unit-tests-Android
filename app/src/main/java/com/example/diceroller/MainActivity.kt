package com.example.diceroller

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.button.setOnClickListener { rollDice() }
        //
        //Do a roll Dice when the application starts
        rollDice()
    }

    private fun rollDice() {
        //
        //Create the new Dice object with 6 sides and roll it
        val diceRoll = Dice(6).roll()
        val diceImage: ImageView = binding.imageView
        //
        //Determine which drawable resource ID to use based on the dice roll
        val drawableResource= when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //
        //Update the Imageview with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        //
        //update the content description
        diceImage.contentDescription= diceRoll.toString()
    }
}
/**
 * Roll the Dice an update the screen with the result
 * */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}