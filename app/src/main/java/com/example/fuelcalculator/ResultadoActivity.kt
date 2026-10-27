package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Recuperando da tela anterior
        val valorTotal = intent.getDoubleExtra("DISTANCIA_CUSTO_TOTAL", 0.0)
        val precoPorLitro = intent.getDoubleExtra("DISTANCIA_PRECO_LITRO", 0.0)
        val consumoPorLitro = intent.getIntExtra("DISTANCIA_CONSUMO_LITRO", 0)
        val distanciaTotal = intent.getIntExtra("DISTANCIA_VALOR", 0)


        //Recuperando a view
        val tvPrecoViagem = findViewById<TextView>(R.id.tvPrecoViagem)
        val tvPrecoLitro = findViewById<TextView>(R.id.tvResultadoPreco)
        val tvConsumoLitro = findViewById<TextView>(R.id.tvResultadoConsumo)
        val tvDistancia = findViewById<TextView>(R.id.tvResultadoDistancia)
        val btnResultadoNovo = findViewById<Button>(R.id.btnResultadoNovo)


        // Colocando valor na tela
        tvPrecoViagem.text = valorTotal.toString()
        tvPrecoLitro.text = precoPorLitro.toString()
        tvConsumoLitro.text = consumoPorLitro.toString()
        tvDistancia.text = distanciaTotal.toString()
        btnResultadoNovo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}