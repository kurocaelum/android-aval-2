package com.example.projetoavaliaoii.views.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetoavaliaoii.R
import kotlinx.android.synthetic.main.activity_cadastra_tarefa.*

class CadastraTarefaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastra_tarefa)



        btnCadastrarTarefa.setOnClickListener {
            cadastrarTarefa()
        }
    }

    fun cadastrarTarefa(){
//        Toast.makeText(this, "Teste", Toast.LENGTH_SHORT).show()
    }

}
