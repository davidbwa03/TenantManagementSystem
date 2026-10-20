package com.example.tenantmanagementsystem

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

// Passing the layout to the Fragment() constructor tells Android which
// XML file to use for this screen, so we don't need onCreateView or a binding class.
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    // The view now exists, so find the two boxes and fill in the numbers
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the two metric boxes by the ids written in fragment_dashboard.xml
        val tenantCountTextView = view.findViewById<TextView>(R.id.tenantCountTextView)
        val totalRentTextView = view.findViewById<TextView>(R.id.totalRentTextView)

        // Read from the shared list of tenants
        val tenantCount = TenantRepository.tenants.size
        val totalRent = TenantRepository.totalRent()

        // Show the number of tenants in the first box
        tenantCountTextView.text = "Tenants\n$tenantCount"

        // Show the total rent in the second box.
        // "%,.0f" adds commas and no decimals: 75000.0 becomes 75,000
        totalRentTextView.text = "Total rent\nKSh %,.0f".format(totalRent)
    }
}