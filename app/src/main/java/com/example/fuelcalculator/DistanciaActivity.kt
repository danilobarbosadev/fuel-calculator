package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

const val EXTRA_DISTANCIA_PRECO_LITRO = "DISTANCIA_PRECO_LITRO"
const val EXTRA_DISTANCIA_CONSUMO_LITRO = "DISTANCIA_CONSUMO_LITRO"
const val EXTRA_DISTANCIA_VALOR = "DISTANCIA_VALOR"
const val EXTRA_DISTANCIA_CUSTO_TOTAL = "DISTANCIA_CUSTO_TOTAL"

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // recuperar dados tela anterior
        // recuperar view pelo Id
        // fazer calculo
        // passar todos os dados para proxima tela


        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_distancia)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val precoCombustivel = intent.getDoubleExtra(EXTRA_PRECO_LITRO, 0.0)
        val consumoPorLitro = intent.getIntExtra(EXTRA_CONSUMO_LITRO, 0)

        val edtDistancia = findViewById<EditText>(R.id.edtDistancia)
        val btnDistanciaCalcular = findViewById<Button>(R.id.btnDistanciaCalcular)

        btnDistanciaCalcular.setOnClickListener {
            val distancia = edtDistancia.text.toString().toInt()
            val consumo = consumoPorLitro
            val precoLitro = precoCombustivel

            // Calculo de litros necessarios
            val litrosNecessarios = distancia / consumo

            // Calculo custo total
            val custoTotal = litrosNecessarios * precoLitro

            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra(EXTRA_DISTANCIA_PRECO_LITRO, precoLitro)
            intent.putExtra(EXTRA_DISTANCIA_CONSUMO_LITRO, consumo)
            intent.putExtra(EXTRA_DISTANCIA_VALOR, distancia)
            intent.putExtra(EXTRA_DISTANCIA_CUSTO_TOTAL, custoTotal)

            startActivity(intent)

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}