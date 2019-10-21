package com.example.projetoavaliaoii.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoavaliaoii.R
import com.example.projetoavaliaoii.views.model.Tarefa
import kotlinx.android.synthetic.main.item_tarefa.view.*

class TarefaAdapter(
    private val tarefas: List<Tarefa>
): RecyclerView.Adapter<TarefaAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)

        return VH(view)
    }

    override fun getItemCount(): Int = tarefas.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val tarefa = tarefas[position]
        holder.titulo.text = tarefa.titulo
        holder.descricao.text = tarefa.descricao
    }

    class VH(itemView: View): RecyclerView.ViewHolder(itemView) {
//        val id = itemView.txtId //TODO
        val titulo = itemView.txtTitulo
        val descricao = itemView.txtDescricao
    }
}