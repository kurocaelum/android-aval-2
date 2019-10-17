package com.example.projetoavaliaoii.views.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.projetoavaliaoii.views.model.Tarefa
import com.example.projetosqlite.repository.sqlite.*

class SQLiteRepository(ctx: Context): TarefaRepository {
    private val helper: TarefaSqlHelper = TarefaSqlHelper(ctx)

    private fun insert(tarefa: Tarefa){

        val db = helper.writableDatabase

        val cv = ContentValues().apply {
            put(COLUMN_COMPLETED, tarefa.concluida)
            put(COLUMN_TITLE, tarefa.titulo)
            put(COLUMN_DESCRIPTION, tarefa.descricao)
        }

        val id = db.insert(TABLE_NAME, null, cv)
        if (id != -1L){
            tarefa.id = id
        }
        db.close()
    }

    private fun update(tarefa: Tarefa){
        val db = helper.writableDatabase

        val cv = ContentValues().apply {
            put(COLUMN_COMPLETED, tarefa.concluida)
            put(COLUMN_TITLE, tarefa.titulo)
            put(COLUMN_DESCRIPTION, tarefa.descricao)
        }

        db.update(
            TABLE_NAME,
            cv,
            "$COLUMN_ID = ? ",
            arrayOf(tarefa.id.toString())
        )

        db.close()
    }

    override fun save(tarefa: Tarefa) {
        if (tarefa.id == 0L)
            insert(tarefa)
        else
            update(tarefa)
    }

    override fun remove(tarefa: Tarefa) {
        val db = helper.writableDatabase

        db.delete(
            TABLE_NAME,
            "$COLUMN_ID = ? ",
            arrayOf(tarefa.id.toString())
        )

        db.close()
    }

    override fun list(callback: (MutableList<Tarefa>) -> Unit) {
        var sql = "SELECT * FROM $TABLE_NAME"
        var args: Array<String>? = null

        sql += " ORDER BY $COLUMN_ID"
        val db = helper.writableDatabase
        val cursor = db.rawQuery(sql, args)
        val tarefas = ArrayList<Tarefa>()

        while (cursor.moveToNext()){
            val produto = tarefaFromCursor(cursor)
            tarefas.add(produto)
        }

        cursor.close()
        db.close()
        callback(tarefas)
    }

    private fun tarefaFromCursor(cursor: Cursor): Tarefa {
        val id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
        val concluida = cursor.getInt(cursor.getColumnIndex(COLUMN_COMPLETED))
        val titulo = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE))
        val descricao = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))

        return Tarefa(id, concluida, titulo, descricao)
    }

}