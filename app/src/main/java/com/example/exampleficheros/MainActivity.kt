package com.example.exampleficheros

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textview = findViewById<TextView>(R.id.textViewHola)
        var nombreFichero = "ficheroInterno.txt"
        var texto = findViewById<EditText>(R.id.editTextTextMultiLineFichero)

        var bufferedReader = BufferedReader(InputStreamReader(openFileInput(nombreFichero)))
        var textoLeido = bufferedReader.readLine()
        texto.setText(textoLeido)
        bufferedReader.close()

        var bufferedReaderRecurso = BufferedReader(InputStreamReader(resources.openRawResource(R.raw.fichero_recursos)))
        var textoLeidoR = bufferedReaderRecurso.readLine()
        textview.text = textoLeidoR
        bufferedReaderRecurso.close()
    }

    fun onGuardar(view: View) {
        var texto = findViewById<TextView>(R.id.editTextTextMultiLineFichero)
        var nombreFichero = "ficheroInterno.txt"
        var fileOutput = openFileOutput(nombreFichero, Context.MODE_PRIVATE)
        fileOutput.write(texto.text.toString().toByteArray())
        fileOutput.close()
    }
}