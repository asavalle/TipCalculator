package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.*
import java.math.RoundingMode


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
        val grandTotal: TextView = findViewById(R.id.grandTotal)



        button.setOnClickListener {
            billLabel.text = billAmount.text.toString()
            grandTotal.text = billAmount.text.toString()

            var radioCheckedId = tipPercent.checkedRadioButtonId  //retrieves the Id number (see RadioButton xml)
            var checkedIdString = resources.getResourceEntryName(radioCheckedId) //converts Id number to string Id name
            var billAmountDouble:Double = billAmount.text.toString().toDouble()
            var tip: Double = 0.00

            if (checkedIdString == "tip10") tip = 0.10 //todo: Format decimal to two places
            if (checkedIdString == "tip15") tip = 0.15
            if (checkedIdString == "tip18") tip = 0.18
            if (checkedIdString == "tip20") tip = 0.20

            tipLabel.text = (tip.toBigDecimal() * billAmountDouble.toBigDecimal()).setScale(2, RoundingMode.HALF_EVEN).toString()
            grandTotal.text = (tipLabel.text.toString().toBigDecimal() + billAmountDouble.toBigDecimal()).setScale(2, RoundingMode.HALF_EVEN).toString()

        } //end OnClick
    } //end onCreate

}