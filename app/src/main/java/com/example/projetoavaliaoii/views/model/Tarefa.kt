package com.example.projetoavaliaoii.views.model

import java.io.Serializable

data class Tarefa(val concluida: Int, val titulo: String, val descricao: String) : Serializable {

    var id: Long = 0

    constructor(id: Long, concluida: Int, titulo: String, descricao: String): this(concluida, titulo, descricao){
        this.id = id
    }
}