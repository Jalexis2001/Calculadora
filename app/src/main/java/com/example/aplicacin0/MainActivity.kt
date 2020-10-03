package com.example.abcd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplicacin0.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1 = 0.0
    private var num2 = 0.0
    private var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultadotextView.text = "0"
        operacion = SIN_OPERACION

        Boton1.setOnClickListener { numberPressed("1") }
        Boton2.setOnClickListener { numberPressed("2") }
        Boton3.setOnClickListener { numberPressed("3") }
        Boton4.setOnClickListener { numberPressed("4") }
        Boton5.setOnClickListener { numberPressed("5") }
        Boton6.setOnClickListener { numberPressed("6") }
        Boton7.setOnClickListener { numberPressed("7") }
        Boton8.setOnClickListener { numberPressed("8") }
        Boton9.setOnClickListener { numberPressed("9") }
        Boton0.setOnClickListener { numberPressed("0") }
        BotonPunto.setOnClickListener { numberPressed(".") }

        BotonBorrar.setOnClickListener { resetAll() }

        BotonMas.setOnClickListener { operationPressed(SUMA) }
        BotonMenos.setOnClickListener { operationPressed(RESTA) }
        BotonMulti.setOnClickListener { operationPressed(MULTIPLICACION) }
        BotonDivi.setOnClickListener { operationPressed(DIVISION) }

        BotonIgual.setOnClickListener { resolvePressed() }
    }

    private fun numberPressed(num: String){
        if(resultadotextView.text == "0" && num != ".") {
            resultadotextView.text = "$num"
        } else {
            resultadotextView.text = "${resultadotextView.text}$num"
        }

        if(operacion == SIN_OPERACION){
            num1 = resultadotextView.text.toString().toDouble()
        } else {
            num2 = resultadotextView.text.toString().toDouble()
        }
    }

    private fun operationPressed(operacion: Int){
        this.operacion = operacion
        num1 = resultadotextView.text.toString().toDouble()

        resultadotextView.text = "0"
    }

    private fun resolvePressed(){

        val result = when(operacion) {
            SUMA -> num1 + num2
            RESTA -> num1 - num2
            MULTIPLICACION -> num1 * num2
            DIVISION -> num1 / num2
            else -> 0
        }

        num1 = result as Double

        resultadotextView.text = if("$result".endsWith(".0")) { "$result".replace(".0","") } else { "%.2f".format(result) }
    }

    private fun resetAll(){
        resultadotextView.text = "0"
        num1 = 0.0
        num2 = 0.0
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val SIN_OPERACION = 0
    }
}