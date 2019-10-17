package com.example.projetoavaliaoii.views.repository

import com.example.projetoavaliaoii.views.model.Tarefa

interface TarefaRepository {
    fun save(tarefa: Tarefa)
    fun remove(tarefa: Tarefa)
    fun list(callback: (MutableList<Tarefa>) -> Unit)
}