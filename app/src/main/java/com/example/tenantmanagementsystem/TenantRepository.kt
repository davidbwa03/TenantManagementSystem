package com.example.tenantmanagementsystem

// An "object" is a class with exactly ONE instance shared by the
// whole app. Every screen sees the same list of tenants.
object TenantRepository {

    // The shared list of tenants. It lives in memory only,
    // so it is cleared when the app is closed.
    val tenants = mutableListOf<Tenant>()

    // Adds one tenant to the list
    fun addTenant(tenant: Tenant) {
        tenants.add(tenant)
    }

    // Adds up the rent of every tenant.
    // toDoubleOrNull() converts text to a number; if the text is not
    // a valid number it gives null, and "?: 0.0" turns that into 0.0
    // so the app does not crash.
    fun totalRent(): Double {
        return tenants.sumOf { it.rent.toDoubleOrNull() ?: 0.0 }
    }
}