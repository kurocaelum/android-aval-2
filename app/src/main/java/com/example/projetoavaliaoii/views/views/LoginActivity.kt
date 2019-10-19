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

    lateinit var senha: String
    lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()

        val pref = getSharedPreferences("configuracoes", 0)
        senha = pref.getString("senha", "").toString()
        email = pref.getString("email", "").toString()


        edtSenhaLogin.setText(pref.getString("senha", ""))
        edtEmailLogin.setText(pref.getString("email", ""))
    }

    fun cadastrar(view: View){
        var intent = Intent(applicationContext, CadastroActivity::class.java)
        startActivity(intent)
    }

    fun entrar(view: View){
        val edtSenha = findViewById<EditText>(R.id.edtSenhaLogin)
        val edtEmail = findViewById<EditText>(R.id.edtEmailLogin)

        if(edtSenha.text.toString().equals(senha) && edtEmail.text.toString().equals(email)){
            var intent = Intent(applicationContext, ListActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Credenciais incorretas", Toast.LENGTH_LONG).show()
        }

//        finish() //TODO botao sair no menu de ListActivity chama essa activity
    }

}
