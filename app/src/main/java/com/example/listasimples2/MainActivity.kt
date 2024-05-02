package com.example.listasimples2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val novaTarefa = findViewById<EditText>(R.id.edtnovatarefa)
        val adicionar = findViewById<Button>(R.id.btnadd)
        val tarefas = findViewById<ListView>(R.id.lvtarefas)

        val Lista:ArrayList<String> = ArrayList()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Lista)

        tarefas.adapter = adapter

        adicionar.setOnClickListener {
            if (novaTarefa.text.isNullOrEmpty()) {
                Toast.makeText(this, "Digite uma tarefa", Toast.LENGTH_SHORT).show()
            } else {

                Lista.add(novaTarefa.text.toString())
                adapter.notifyDataSetChanged()
                novaTarefa.setText("")

                tarefas.setOnItemClickListener { _, _, position, _ ->

                    val alerta = AlertDialog.Builder(this)
                    alerta.setTitle("Atenção!!!!")
                    alerta.setMessage("Deseja mesmo excluir esse item?")
                    alerta.setPositiveButton( "Confirmar") {dialog, _ ->

                        Lista.removeAt(position)
                        adapter.notifyDataSetChanged()
                        dialog.dismiss() }
                        alerta.setNegativeButton("Cancelar") {dialog, _ ->
                            dialog.dismiss() }
                            alerta.create().show()
                            true
                        }
                    }


                }
            }
        }
