package com.pa.mysmeagol

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.content.Intent
import android.media.MediaPlayer
import kotlinx.android.synthetic.main.activity_catch.*


class CatchTheSmeagol : AppCompatActivity() {

    var score : Int = 0
    var imageArray = ArrayList<ImageView>()
    var handler : Handler = Handler()
    var runnable: Runnable = Runnable {  }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catch)

        //// random background image
        val images = intArrayOf(R.drawable.img_0, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5)
        val imageId = (Math.random() * images.size).toInt()
        mainContainer.setBackgroundResource(images[imageId])


        score = 0
        imageArray = arrayListOf(imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView8,imageView9)

        hideSmeagols()



        //// countdown for 30 seconds on the timer text
        object: CountDownTimer(30000, 1000) {
            override fun onFinish() {

                timeText.text = "Time is up!"

                handler.removeCallbacks(runnable)

                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                //// show again dialog 3 seconds later
                val handler = Handler()
                handler.postDelayed({
                    wannaGoAgain()
                }, 3000)


            }

            override fun onTick(p0: Long) {
                timeText.text = "Time Left: " + p0 / 1000
            }

        }.start()

    }

    fun wannaGoAgain() {
        val againDialog = AlertDialog.Builder(this)
        againDialog.setTitle("Again?")
        againDialog.setMessage("Want to try again?")
        againDialog.setPositiveButton("Yes") { DialogInterface: DialogInterface, i: Int ->
            val intent = intent
            finish()
            startActivity(intent)
        }
        againDialog.setNegativeButton("No") {DialogInterface: DialogInterface, i: Int ->
            //
        }
        againDialog.show()
    }

    fun hideSmeagols() {

        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val randomImage = Random()
                val index = randomImage.nextInt(8 - 0)
                imageArray[index].visibility = View.VISIBLE


                handler.postDelayed(runnable, 300)
            }

        }
        handler.post(runnable)

    }

    //// increase score by one when imageview is clicked an report it into the scoretext
    fun increaseScore (view: View) {

        score++

        val mp = MediaPlayer.create(this, R.raw.meow)
        mp.start();
        scoreText.text = "Score: " + score

    }


}
