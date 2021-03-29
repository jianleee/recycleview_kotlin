package com.example.recycleview


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var todolist = mutableListOf(
            Todo("Follow Android Dev", false),
            Todo("Go to work", false),
            Todo("Learn native Android", true),
            Todo("Eat Lunch", false),
            Todo("Hello guys", false),
            Todo("Eat Lunch", false),
            Todo("Hello Jian", false),
            Todo("Eat Lunch", false),
            Todo("Hello guys", false)
        )
        val adapter = ToDoAdapter(todolist)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)
        btnAddToDo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todolist.add(todo)
            adapter.notifyItemInserted(todolist.size - 1)
            etTodo.setText(null)
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }

}