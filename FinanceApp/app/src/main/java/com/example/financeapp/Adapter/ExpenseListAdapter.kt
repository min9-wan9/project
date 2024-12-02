package com.example.financeapp.Adapter

import android.content.Context
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.financeapp.Domain.ExpenseDomain
import com.example.financeapp.databinding.ViewholderItemBinding

class ExpenseListAdapter(private val items: MutableList<ExpenseDomain>) :
    RecyclerView.Adapter<ExpenseListAdapter.ViewHolder>() {
    class ViewHolder(val binding: ViewholderItemBinding) : RecyclerView.ViewHolder(binding.root)

    private lateinit var context: Context
    var formatter: DecimalFormat? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExpenseListAdapter.ViewHolder {
        context = parent.context
        formatter = DecimalFormat("###,###,###.##")
        val binding = ViewholderItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ExpenseListAdapter.ViewHolder, position: Int) {
        var item = items[position]
        holder.binding.apply {
            timeTxt.text = item.time
            titleTxxt.text = item.title
            priceTxt.text = "$" + formatter?.format(item.price)


        }

        val drawableId =
            holder.itemView.resources.getIdentifier(item.pic, "drawable", context.packageName)
        Glide.with(context)
            .load(drawableId)
            .into(holder.binding.pic)
    }


    override fun getItemCount(): Int {
        return items.size
    }
}