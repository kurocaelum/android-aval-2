package com.example.projetoavaliaoii.views.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projetoavaliaoii.R
import com.example.projetoavaliaoii.views.adapter.TarefaAdapter
import com.example.projetoavaliaoii.views.model.Tarefa
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    private var tarefas: MutableList<Tarefa> = listaTarefas()
    private var adapter = TarefaAdapter(tarefas)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initRecyclerView()
    }

    fun initRecyclerView(){
        rvTarefas.adapter = adapter
        val layoutManager = GridLayoutManager(this, 1)
        rvTarefas.layoutManager = layoutManager
    }

    //TODO pegar do banco
    fun listaTarefas(): MutableList<Tarefa> {
        return mutableListOf(
            Tarefa(0, "t1", "d1"),
            Tarefa(0, "t2", "d2"),
            Tarefa(0, "t3", "d3")
        )
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
            logout(item)
            return true
        }else {
            return super.onOptionsItemSelected(item)
        }


    }

    fun cadastrarTarefa(item: MenuItem?){
        startActivity(Intent(this, CadastraTarefaActivity::class.java))
    }

    fun logout(item: MenuItem?){
        startActivity(Intent(this, LoginActivity::class.java))
    }

}
