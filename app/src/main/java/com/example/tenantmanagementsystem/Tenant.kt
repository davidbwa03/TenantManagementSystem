package com.example.tenantmanagementsystem

import java.io.Serializable

// Serializable lets Safe Args pack a whole Tenant into the Fragment's arguments
data class Tenant(
    val name: String,
    val phone: String,
    val rent: String
) : Serializable {

    // Used by Data Binding: @{tenant.summary()}
    fun summary(): String = "Name: $name\nPhone: $phone\nRent: KSh $rent"
}