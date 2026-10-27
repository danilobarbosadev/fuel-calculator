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

class PrecoCombustivelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco_combustivel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // FindViewById
        // Navegar proxima tela
        // Passar dados do preco digitado pelo usuario

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_preco_combustivel)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val edtPrecoCombustivel = findViewById<EditText>(R.id.edtPrecoCombustivel)
        val btnPrecoCombustivelProximo = findViewById<Button>(R.id.btnPrecoCombustivelProximo)

        btnPrecoCombustivelProximo.setOnClickListener {

            val edtPrecoCombustivelValor = edtPrecoCombustivel.text.toString().toDouble()
            val intent = Intent(this, ConsumoPorLitroActivity::class.java)
            intent.putExtra("PRECO_COMBUSTIVEL", edtPrecoCombustivelValor)
            startActivity(intent)

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}