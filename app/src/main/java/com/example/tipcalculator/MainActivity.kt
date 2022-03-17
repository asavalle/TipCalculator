package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // val tipPercentage = calculateTip() //need to create function to calculate tip
        val button: Button = findViewById(R.id.calcBtn)
        val billAmount: EditText = findViewById(R.id.billAmount)
        val tipLabel: TextView = findViewById(R.id.tipLabel)
        val billLabel: TextView = findViewById(R.id.billLabel)
        val tipPercent: RadioGroup = findViewById(R.id.radioGroup)

        //TODO Broken: Was working, now doesn't set billLabel to entered number
        button.setOnClickListener {
            billLabel.text = billAmount.text.toString()
            //TODO Implement try, catch or other error capture. When radial button is not selected.

                    val radioCheckedId = tipPercent.checkedRadioButtonId
                    val checkedIdString = resources.getResourceEntryName(radioCheckedId)

            val billAmountDouble = billAmount.text.toString().toDouble()

            if (checkedIdString == "tip10") {
                val tip: Double = billAmountDouble * .10
                tipLabel.text = tip.toString()
            } //todo: Format decimal to two places


        } //end OnClick
    } //end onCreate

}