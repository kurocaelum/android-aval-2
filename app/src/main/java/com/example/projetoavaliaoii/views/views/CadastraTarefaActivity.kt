package com.example.projetoavaliaoii.views.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.projetoavaliaoii.R
import com.example.projetoavaliaoii.views.model.Tarefa
import com.example.projetoavaliaoii.views.repository.SQLiteRepository
import kotlinx.android.synthetic.main.activity_cadastra_tarefa.*

class CadastraTarefaActivity : AppCompatActivity() {

    private var edtTituloTarefa: EditText? = null
    private var edtDescricaoTarefa: EditText? = null
    private var tarefa: Tarefa? = null
    private var posicao: Int? = null

    private var tarefaRepository: SQLiteRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastra_tarefa)

        edtTituloTarefa = findViewById(R.id.edtTituloTarefa)
        edtDescricaoTarefa = findViewById(R.id.edtDescricaoTarefa)

        tarefaRepository = SQLiteRepository(this)
        tarefa = intent.getSerializableExtra("tarefa") as Tarefa?
        posicao = intent.getIntExtra("posicao", -1)

        if(tarefa != null){
            edtTituloTarefa?.setText(tarefa?.titulo)
            edtDescricaoTarefa?.setText(tarefa?.descricao)
        }

        btnCadastrarTarefa.setOnClickListener {
            cadastrarTarefa()
        }
    }

    fun cadastrarTarefa(){
        var titulo: String = edtTituloTarefa?.text.toString()
        var descricao: String = edtDescricaoTarefa?.text.toString()

        salvarTarefa(0, titulo, descricao)
    }

    fun salvarTarefa(concluida: Int, titulo: String, descricao: String){
        tarefa = Tarefa(concluida, titulo, descricao)
        tarefaRepository?.save(tarefa!!)

        Toast.makeText(this, "Tarefa salva com ID ${tarefa?.id}", Toast.LENGTH_LONG).show()

        finish()
    }

}
