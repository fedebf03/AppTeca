package com.example.appteca

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("VIDA", "Detalle → onCreate")
        setContentView(R.layout.activity_detalle)

        val appId = intent.getIntExtra("appId", -1)
        val app = Catalogo.apps.find { it.id == appId }

        if (app == null) { finish(); return }

        findViewById<TextView>(R.id.tvDetNombre).text = app.nombre
        findViewById<TextView>(R.id.tvDetCategoria).text = app.categoria
        findViewById<TextView>(R.id.tvDetDescripcion).text = app.descripcion

        val btn = findViewById<Button>(R.id.btnFavorito)
        fun pintar() {
            btn.text = if (app.esFavorita) "★ Quitar de favoritas" else "☆ Marcar favorita"
        }

        pintar()
        btn.setOnClickListener {
            app.esFavorita = !app.esFavorita
            pintar()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("VIDA", "Detalle → onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("VIDA", "Detalle → onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("VIDA", "Detalle → onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("VIDA", "Detalle → onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("VIDA", "Detalle → onDestroy")
    }
}