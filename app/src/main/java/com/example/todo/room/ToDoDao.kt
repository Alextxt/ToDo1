package com.example.todo.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todo.ToDoItem


@Dao
interface ToDoDao {

    //аннотация - запрос информации
    @Query("SELECT * FROM todoitem")
    fun getAllItems(): List<ToDoItem>

    //аннотация - размещение(вставка)
    @Insert
    fun insertItem(toDoItem: ToDoItem)

    //аннотация - удаление
    @Delete
    fun deleteItem(toDoItem: ToDoItem)

    //аннотация - обновление
    @Update
    fun updateItem(toDoItem: ToDoItem)
}