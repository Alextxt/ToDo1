package com.example.todo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.widget.LinearLayout
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.constraintlayout.helper.widget.Carousel.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var stabContainer: LinearLayout
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.maim_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        stabContainer = findViewById(R.id.main_no_items_container)
        fab = findViewById(R.id.main_fab)

        fab.setOnClickListener{
            



        }

        val data = ArrayList<ToDoItem>()
        for (i in 1..10) {
            data.add(ToDoItem("Пробежал", "Вокруг парка", 5))
        }
        val adapter = CustomAdapter(data)
        recyclerView.adapter = adapter

        if (data.isEmpty()){
            stabContainer.visibility = VISIBLE
            recyclerView.visibility = INVISIBLE
        } else {
            stabContainer.visibility = INVISIBLE
            recyclerView.visibility = VISIBLE
        }

    }

}