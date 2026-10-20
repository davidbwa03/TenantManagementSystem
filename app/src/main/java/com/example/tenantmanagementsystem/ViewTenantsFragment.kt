package com.example.tenantmanagementsystem

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment

// This screen uses fragment_view_tenants.xml
class ViewTenantsFragment : Fragment(R.layout.fragment_view_tenants) {

    // The view exists: fill in the list of tenants
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the views by the ids written in fragment_view_tenants.xml
        val newTenantGroup = view.findViewById<Group>(R.id.newTenantGroup)
        val allTenantsTextView = view.findViewById<TextView>(R.id.allTenantsTextView)

        // For now, hide the "Just added" section
        // (label, tenant box and Call button are in one Group).
        // Practical 3 shows it when a tenant is passed in.
        newTenantGroup.visibility = View.GONE

        // Get the shared list of tenants
        val tenants = TenantRepository.tenants

        if (tenants.isEmpty()) {
            // Nothing saved yet: show a friendly message
            allTenantsTextView.text = "No tenants yet. Add one from the Dashboard."
        } else {
            // Turn each tenant into its summary text and join them,
            // leaving a blank line between each one
            allTenantsTextView.text = tenants.joinToString("\n\n") { it.summary() }
        }
    }
}