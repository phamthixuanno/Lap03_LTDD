package com.example.tictactoygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun butClick(view: View) {
        val butSelected : Button = view as Button
        var cellID = 0
        when(butSelected.id)
        {
            R.id.but1 -> cellID = 1
            R.id.but2 -> cellID = 2
            R.id.but3 -> cellID = 3
            R.id.but4 -> cellID = 4
            R.id.but5 -> cellID = 5
            R.id.but6 -> cellID = 6
            R.id.but7 -> cellID = 7
            R.id.but8 -> cellID = 8
            R.id.but9 -> cellID = 9
        }
        //Log.d("butClick:", butSelected.toString())
        //Log.d("butClick: cellID:", cellID.toString())
        playGame(cellID, butSelected)
    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    fun playGame(cellID:Int, butSelected:Button) {
        if (activePlayer == 1) {
            butSelected.text = "X"
            butSelected.setBackgroundResource(R.color.light_sea)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()
        }
        else {
            butSelected.text = "0"
            butSelected.setBackgroundResource(R.color.yellow_green)
            player2.add(cellID)
            activePlayer = 1
        }
        butSelected.isEnabled = false
        checkWinner()
    }
    fun checkWinner(){
        var winner = -1
        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3) )
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3) )
        {
            winner = 2
        }
        //row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6) )
        {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6) )
        {
            winner = 2
        }
        //row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9) )
        {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9) )
        {
            winner = 2
        }
        //col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7) )
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7) )
        {
            winner = 2
        }
        //col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8) )
        {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8) )
        {
            winner = 2
        }
        //col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9) )
        {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9) )
        {
            winner = 2
        }
        //other
        if (player1.contains(1) && player1.contains(5) && player1.contains(9) )
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9) )
        {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7) )
        {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7) )
        {
            winner = 2
        }

        if (winner==1){
            Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
        }
        else if(winner==2){
            Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
        }

    }
    fun autoPlay(){
        var emptyCells = ArrayList<Int>()
        for( cellId in 1..9){

            if( !(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }
        val r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randIndex]
        var butSelected:Button?
        butSelected = when(cellId){
            1 -> but1
            2 -> but2
            3 -> but3
            4 -> but4
            5 -> but5
            6 -> but6
            7 -> but7
            8 -> but8
            9 -> but9
            else -> { but1}

        }
        playGame(cellId, butSelected)
    }
}