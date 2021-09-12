package jp.techacademy.yuki.nishimura.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.button1) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, hour, _ ->
                textView.text = judgeAisatsu(hour)
            },
            13, 0, true
        )
        timePickerDialog.show()
    }

    private fun judgeAisatsu(hour: Int): String {
        return if (hour in 2..9) {
            "おはよう"
        } else if (hour in 10..17) {
            "こんにちは"
        } else {
            "こんばんは"
        }
    }
}
