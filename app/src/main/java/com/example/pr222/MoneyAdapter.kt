package com.example.pr222

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MoneyAdapter(private val moneys: List<Money>) :
    RecyclerView.Adapter<MoneyAdapter.MoneyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoneyHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_money, parent, false)
        return MoneyHolder(view)
    }

    override fun onBindViewHolder(holder: MoneyHolder, position: Int) {
        val money = moneys[position]
        holder.bind(money)
    }

    override fun getItemCount(): Int {
        return moneys.size
    }

    class MoneyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.money_title)
        private val dateTextView: TextView = itemView.findViewById(R.id.money_date)

        fun bind(money: Money) {
            titleTextView.text = money.title
            dateTextView.text = money.date.toString()
        }
    }
}
