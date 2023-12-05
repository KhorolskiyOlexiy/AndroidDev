package com.example.lb1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animalList:RecyclerView = findViewById(R.id.animalList1)
        val animals = arrayListOf<Animal>()

        animals.add(Animal("Ася", "Персидський кіт, біло-сірий, півтора року", "cat"))
        animals.add(Animal("Яся", "Персидський кіт, світло-сірий, пів року", "cat"))
        animals.add(Animal("Лола", "Німецька вівчарка, коричново-чорна, 3 місяці", "cat"))

        animalList.layoutManager = LinearLayoutManager(this)
        animalList.adapter = AnimalAdapter(animals, this)
    }
}