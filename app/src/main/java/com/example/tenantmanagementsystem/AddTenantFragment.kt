package com.example.tenantmanagementsystem

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

// This screen uses fragment_add_tenant.xml (the form: name, phone, rent, SAVE)
class AddTenantFragment : Fragment(R.layout.fragment_add_tenant) {

    // The view exists: this is where click listeners go
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // The SAVE button is wired up in Practical 3
    }
}