package com.example.financeapp.ViewModel

import androidx.lifecycle.ViewModel
import com.example.financeapp.Repository.Mainrepository

class MainViewModel(val resposotory : Mainrepository) :ViewModel() {
    constructor() : this(Mainrepository())

    fun loadData() = resposotory.item
    fun loadBudger() = resposotory.budget
}