package com.example.financeapp.Repository

import com.example.financeapp.Domain.BudgetDomain
import com.example.financeapp.Domain.ExpenseDomain

class Mainrepository {
    val item = mutableListOf(
        ExpenseDomain("Resturant", 573.12, "img1", "17 Jun 2024 19:15"),
        ExpenseDomain("ficDonald", 77.82, "img2", "16 jun 2024 13:57"),
        ExpenseDomain("Cinema", 23.47, "img3", "16 Jun 2024 20:45"),
        ExpenseDomain("Resturant", 341.12, "img1", "15 jun 2024 22:18")
    )
    var budget = mutableListOf(
        BudgetDomain( "Home Loan", 1200.0,  80.8),
    BudgetDomain( "Subscription", 1200.0,  10.0),
    BudgetDomain ( "Car Loan",  800.0, 30.0)
    )
}