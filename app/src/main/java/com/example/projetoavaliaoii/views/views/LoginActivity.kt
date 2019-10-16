package com.example.projetoavaliaoii.views.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.projetoavaliaoii.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun cadastrar(view: View){
        var intent = Intent(applicationContext, CadastroActivity::class.java)
        startActivity(intent)
    }

    fun entrar(view: View){
        val edtSenha = findViewById<EditText>(R.id.edtSenhaLogin)
        val edtEmail = findViewById<EditText>(R.id.edtEmailLogin)

        val admin = "admin" //TODO temporario

        if(edtSenha.text.toString().equals(admin) && edtEmail.text.toString().equals(admin)){ //&& edtEmail.text.equals(admin)
            var intent = Intent(applicationContext, ListActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Credenciais incorretas", Toast.LENGTH_LONG).show()
        }
    }

}
