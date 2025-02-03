package com.example.task2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val listView = findViewById<ListView>(R.id.listView)

        val data = arrayOf(
            "Item 1", "Item 2", "Item 3",
            "Item 4", "Item 5", "Item 6",
            "Item 7", "Item 8", "Item 9", "Item 10"
        )

        val adapter = ListAdapter(data)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this@DashboardActivity, DetailActivity::class.java)
            intent.putExtra("ITEM", data[position])
            startActivity(intent)
        }
    }

    inner class ListAdapter(private val data: Array<String>) : BaseAdapter() {
        override fun getCount(): Int = data.size

        override fun getItem(position: Int): Any = data[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
            val textView = view.findViewById<TextView>(R.id.textViewItem)
            textView.text = data[position]
            return view
        }
    }
}
