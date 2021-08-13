package com.example.x_o_game

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat

import android.widget.Button
import android.widget.Toast
import com.example.x_o_game.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var player1: ArrayList<Int> = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    var activePlayer = 1

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }



    private fun addCallbacks(v: View) {
        val btuClicked = v as Button
        if (activePlayer == 1) {
            binding.button12.setOnClickListener {
                var call = 1

            }
        } else if (activePlayer == 2) {

        }
    }
    private fun add(v:View ){

    }

    fun butSelcted(view: View) {
        val btuClicked = view as Button
        var cellId: Int = 0
        when (btuClicked.id) {
            R.id.button12 -> cellId = 1
            R.id.button13 -> cellId = 2
            R.id.button14 -> cellId = 3
            R.id.button15 -> cellId = 4
            R.id.button16 -> cellId = 5
            R.id.button17 -> cellId = 6
            R.id.button18 -> cellId = 7
            R.id.button19 -> cellId = 8
            R.id.button20 -> cellId = 9
        }
        Log.d("cellId:-", cellId.toString())
        playGame(cellId, btuClicked)

    }


    private fun playGame(cellId: Int, btuClicked: Button) {

        if (activePlayer == 1) {
                    val x=this.getString(R.string.app_name)
            btuClicked.background =
                ContextCompat.getDrawable(this, R.drawable.circle_ring)
            player1.add(cellId)
            activePlayer = 2


        } else {
            btuClicked.background =
                ContextCompat.getDrawable(this, R.drawable.closee);
            player2.add(cellId)
            activePlayer = 1
        }
        btuClicked.isEnabled = false
        checkWinner()
    }

    private fun checkWinner() {
        var winner = -1

        //Rows
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) winner = 1
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) winner = 2

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) winner = 1
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) winner = 2

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) winner = 1
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) winner = 2


        //Columns
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) winner = 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) winner = 2


        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) winner = 1
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) winner = 2

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) winner = 1
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) winner = 2


        //Diagonals
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) winner = 1
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) winner = 2

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) winner = 1
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) winner = 2



        if (winner == 1) {
            Toast.makeText(this, " playar 1 Win ", Toast.LENGTH_LONG).show()

        } else if (winner == 2) {
            Toast.makeText(this, "playar 2 Win  ", Toast.LENGTH_LONG).show()

        }
    }
}