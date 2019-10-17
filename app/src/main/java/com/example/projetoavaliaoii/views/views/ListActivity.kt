package com.example.projetoavaliaoii.views.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.projetoavaliaoii.R

class ListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actions,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        val id = item.itemId    // Item clicado
        if (id == R.id.action_cadastrar){
            cadastrarTarefa(item)
            return true
        }else if (id == R.id.action_concluida){
            Toast.makeText(this,"Concluída", Toast.LENGTH_SHORT).show()
            return true
        }else if (id == R.id.action_sair){
            Toast.makeText(this,"Sair", Toast.LENGTH_SHORT).show()
            return true
        }else {
            return super.onOptionsItemSelected(item)
        }


    }

    fun cadastrarTarefa(item: MenuItem?){
        startActivity(Intent(this, CadastraTarefaActivity::class.java))
    }

}
