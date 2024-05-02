package com.example.listasimples2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
=======
import android.os.Parcel
import android.os.Parcelable
>>>>>>> 44b68c2 (fab add)
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
<<<<<<< HEAD
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
=======
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

>>>>>>> 44b68c2 (fab add)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val novaTarefa = findViewById<EditText>(R.id.edtnovatarefa)
        val adicionar = findViewById<Button>(R.id.btnadd)
<<<<<<< HEAD
        val tarefas = findViewById<ListView>(R.id.lvtarefas)

        val Lista:ArrayList<String> = ArrayList()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Lista)

=======
        val tvtitulo = findViewById<TextView>(R.id.tvtitulo)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            tvtitulo.isVisible = false
            novaTarefa.isVisible = true
            novaTarefa.isEnabled = true
            adicionar.isVisible = true
        }

        val tarefas = findViewById<ListView>(R.id.lvtarefas)
        val listaTarefas: ArrayList<String> = ArrayList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTarefas)
>>>>>>> 44b68c2 (fab add)
        tarefas.adapter = adapter

        adicionar.setOnClickListener {
            if (novaTarefa.text.isNullOrEmpty()) {
<<<<<<< HEAD
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
=======
                Toast.makeText(this, "Digite uma tarefa...", Toast.LENGTH_SHORT).show()
            } else {
                listaTarefas.add(novaTarefa.text.toString())
                adapter.notifyDataSetChanged()
                novaTarefa.setText("")
                novaTarefa.isVisible = false
                novaTarefa.isEnabled = false
                adicionar.isVisible = false
                tvtitulo.isVisible = true
            }
        }

        tarefas.setOnItemLongClickListener { _, _, position, _ ->
            val alerta = AlertDialog.Builder(this)
            alerta.setTitle("Atenção")
            alerta.setMessage("Deseja mesmo excluir esse item?")
            alerta.setPositiveButton("Confirmar") { dialog, _ ->

                listaTarefas.removeAt(position)
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            alerta.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            alerta.create().show()
            true

        }
    }
}

>>>>>>> 44b68c2 (fab add)
