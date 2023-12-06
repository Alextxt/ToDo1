package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.todo.room.AppDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var stubContainer: LinearLayout
    private lateinit var fab: FloatingActionButton
    private lateinit var recyclerview : RecyclerView
    private lateinit var adapter : CustomAdapter
    private lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("myapptag","OnCreate been started")

        recyclerview = findViewById<RecyclerView>(R.id.main_recycler_view)
        stubContainer = findViewById(R.id.main_no_items_container)
        fab = findViewById(R.id.main_fab)

        fab.setOnClickListener {
            val dialog = CustomDialog(this)
            dialog.show()

        }

        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ToDoItem>()

//        for (item in 1..15){
//            data.add(ToDoItem("title", "description", item))
//        }

        if(data.isEmpty()){
            Log.d("testinfifelse","List is empty")
            stubContainer.visibility = VISIBLE
            recyclerview.visibility = INVISIBLE
        }else{
            Log.d("testinfifelse","List NOT empty")
            stubContainer.visibility = INVISIBLE
            recyclerview.visibility = VISIBLE
        }


        adapter = CustomAdapter(data)

        recyclerview.adapter = adapter
        Log.d("myapptag","OnCreate been finished")

         db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"database-name"
        ).build()




    }

     fun addItem(item: ToDoItem) {
        stubContainer.visibility = INVISIBLE
        recyclerview.visibility = VISIBLE
        db.todoDao().insertItem(item)

//        adapter.addItem(item)
    }
}