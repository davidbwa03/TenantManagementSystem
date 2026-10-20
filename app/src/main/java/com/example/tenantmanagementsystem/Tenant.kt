package com.example.tenantmanagementsystem

// Serializable is built into Java/Kotlin: no plugin needed
import java.io.Serializable

// A data class holds data (name, phone, rent).
// ": Serializable" means "a Tenant can be packed up and sent to
// another screen". Safe Args needs this in Practical 3.
data class Tenant(
    val name: String,    // tenant's full name
    val phone: String,   // phone number, kept as text
    val rent: String     // rent paid, kept as text
) : Serializable {

    // Returns the text shown in the layout by @{tenant.summary()}
    fun summary(): String {
        return "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
    }
}