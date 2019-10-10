package com.shadow.slideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = textView_progress.translationY
        seekBar6.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        textView_progress.text = progress.toString()
                val translationDistance = (initialTextViewTranslationY + progress * resources.getDimension(R.dimen.text_anim_step) -1)
                        textView_progress.animate().translationY(translationDistance)
                if (!fromUser)
                textView_progress.animate().setDuration(600).rotationBy(360f).translationY(initialTextViewTranslationY)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        button_reset.setOnClickListener{ v ->
            seekBar6.progress = 0                                  //below this it returns to initial 0
             //animate the reset to 0
        }
    }
}
