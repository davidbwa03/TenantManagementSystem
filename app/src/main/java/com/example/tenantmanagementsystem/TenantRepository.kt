package com.example.tenantmanagementsystem

// A single shared list that Dashboard, Add Tenant and View Tenants all use
object TenantRepository {

    private val _tenants = mutableListOf<Tenant>()
    val tenants: List<Tenant> get() = _tenants

    fun addTenant(tenant: Tenant) {
        _tenants.add(tenant)
    }

    // Rent is stored as text, so convert safely (bad input counts as 0)
    fun totalRent(): Double = _tenants.sumOf { it.rent.toDoubleOrNull() ?: 0.0 }
}