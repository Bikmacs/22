package com.example.pr222

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pr222.database.MoneyRepository
import kotlinx.coroutines.launch

class data_base : AppCompatActivity() {

    private lateinit var moneyRecyclerView: RecyclerView
    private var adapter: MoneyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)

        moneyRecyclerView = findViewById(R.id.moneyrecyclerview)
        moneyRecyclerView.layoutManager = LinearLayoutManager(this)

        updateUI()
    }

    private fun updateUI() {
        lifecycleScope.launch {
            val moneyRepository = MoneyRepository.get()
            val moneys = moneyRepository.getMoneys()  // Получение данных из базы данных
            Log.d("MyLog", "Moneys: $moneys")
            adapter = MoneyAdapter(moneys)
            moneyRecyclerView.adapter = adapter
        }
    }
}
