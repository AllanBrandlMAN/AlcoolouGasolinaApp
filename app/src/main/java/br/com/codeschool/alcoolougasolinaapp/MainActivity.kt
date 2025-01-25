package br.com.codeschool.alcoolougasolinaapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Referencias os elementos da interface

        val editPrecoAlcool = findViewById<EditText>(R.id.editPrecoAlcool)
        val editPrecoGasolia = findViewById<EditText>(R.id.editPrecoGasolina)
        val calcularPreco = findViewById<Button>(R.id.button)
        val textResultado = findViewById<TextView>(R.id.editescolha)


        //Configurar click no botao
        calcularPreco.setOnClickListener{
            //Recuperar valores digitados
            val precoAlcool = editPrecoAlcool.text.toString()
            val precoGasolina = editPrecoGasolia.text.toString()

            //Validar os campos
            if (precoAlcool.isEmpty() || precoGasolina.isEmpty()){
                textResultado.text = "Preenchar os precos primeiro"
            }else {
                //calcular melhor preco
                calcularMelhorPreco(precoAlcool, precoGasolina , textResultado)
            }

        }

    }
    private fun calcularMelhorPreco(precoAlcool: String,precoGasolina: String, textResultado:TextView ){

        //converter os valores para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        //fazer o calculo (precoAlcool/precoGasoline)
        val resultadoPreco = valorAlcool / valorGasolina


        //condicional
        if(resultadoPreco >= 0.7){
            textResultado.text = "Melhor utilizar Gasolina"
        } else {
            textResultado.text = "Melhor Utilizar Alcool"
        }


    }
}
