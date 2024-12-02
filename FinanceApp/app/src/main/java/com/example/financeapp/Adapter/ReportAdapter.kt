package com.example.financeapp.Adapter

import android.content.Context
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financeapp.Domain.BudgetDomain
import com.example.financeapp.R
import com.example.financeapp.databinding.ViewholderBudgetBinding

class ReportAdapter(val items: MutableList<BudgetDomain>) :RecyclerView.Adapter<ReportAdapter.ViewHolder>() {
    class ViewHolder (val binding: ViewholderBudgetBinding): RecyclerView.ViewHolder(binding.root)

    private lateinit var context: Context
    var format : DecimalFormat ?=null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportAdapter.ViewHolder {
        context = parent.context
        format = DecimalFormat("###,###,###,###")
        val binding = ViewholderBudgetBinding.inflate(LayoutInflater.from(context),parent,false)

        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ReportAdapter.ViewHolder, position: Int) {
        var item = items[position]

        holder.binding.titleTxt.text = item.title
        holder.binding.percentTxt.text = "%"+item.percent
        holder.binding.priceTxt.text = "$"+format?.format(item.price) +"Monthly"

        holder.binding.cicurlarProgressBar2.apply {
            progress = item.percent.toFloat()

            if(position%2==1){
                progressBarColor = context.resources.getColor(R.color.blue)
                holder.binding.percentTxt.setTextColor(progressBarColor)
            }
            else{
                progressBarColor = context.resources.getColor(R.color.pink)
                holder.binding.percentTxt.setTextColor(progressBarColor)
            }
        }

    }


    override fun getItemCount(): Int {
        return items.size
    }
}