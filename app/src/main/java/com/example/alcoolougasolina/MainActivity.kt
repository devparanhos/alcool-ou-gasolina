package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(view:View) {
        val alcoholPrice = edit_alcohol_price.text.toString()
        val gasolinePrice = edit_gasoline_price.text.toString()

        val canCalculate = verifyFields(alcoholPrice, gasolinePrice)

        if (canCalculate){
            bestFuelPrice(alcoholPrice, gasolinePrice)
        }else{
            text_result.setText("Preencha os campos")
        }
    }

    fun verifyFields(alcoholPrice: String, gasolinePrice: String) : Boolean {
        var fieldsChecked: Boolean = true

        if (alcoholPrice == null || alcoholPrice.equals("")){
            fieldsChecked = false
        }else if(gasolinePrice == null || gasolinePrice.equals("")){
            fieldsChecked = false
        }
        return fieldsChecked
    }

    fun bestFuelPrice(alcoholPrice: String, gasolinePrice: String){
        val alcoholPrice = alcoholPrice.toDouble()
        val gasolinePrice = gasolinePrice.toDouble()

        val bestPrice = alcoholPrice / gasolinePrice

        if (bestPrice >= 0.7){
            text_result.setText("Melhor utilizar a gasolina")
        }else{
            text_result.setText("Melhor utilizar o álcool")
        }
    }
}