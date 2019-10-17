package com.example.projetoavaliaoii.views.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.projetoavaliaoii.R
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btnCadastrarCad.setOnClickListener {
            salvarCadastro()
        }
    }

    fun salvarCadastro(){
        val cadSenha = findViewById<EditText>(R.id.edtSenhaCad)
        val cadEmail = findViewById<EditText>(R.id.edtEmailCad)

        val pref = getSharedPreferences("configuracoes", 0)

        val edit = pref.edit()
        edit.putString("senha", cadSenha.text.toString())
        edit.putString("email", cadEmail.text.toString())
        edit.commit()

        finish()
    }
}
