package com.example.tenantmanagementsystem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log                      // Log.d() writes messages to Logcat
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Gives us direct access to the views in activity_main.xml
    private lateinit var binding: ActivityMainBinding

    // The most recently saved tenant.
    // This variable lives inside the Activity, so it is LOST when the
    // phone rotates, unless we save it ourselves (see onSaveInstanceState).
    private var lastTenant: Tenant? = null

    // ── onCreate: Android calls this when the Activity is created ──
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)   // must always come first

        // Write a message to Logcat. "TENANT_LIFECYCLE" is the tag we
        // search for in Logcat; the second value is the message.
        Log.d("TENANT_LIFECYCLE", "MainActivity: onCreate")

        // Create the views from activity_main.xml and show them
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ── RESTORE STATE (only runs after a rotation) ────────────
        // savedInstanceState is the Bundle we filled in onSaveInstanceState().
        // It is null the FIRST time the Activity opens (nothing saved yet).
        if (savedInstanceState != null) {
            // Read each value back using the SAME keys we saved with
            val name = savedInstanceState.getString("tenant_name")
            val phone = savedInstanceState.getString("tenant_phone")
            val rent = savedInstanceState.getString("tenant_rent")

            // Only rebuild the tenant if all three values were saved
            if (name != null && phone != null && rent != null) {
                val tenant = Tenant(name, phone, rent)
                lastTenant = tenant      // so CALL TENANT works again
                binding.tenant = tenant  // so the summary shows again (Data Binding)
            }
        }

        // ── SAVE button ───────────────────────────────────────────
        binding.saveButton.setOnClickListener {
            // Read what the user typed into the three boxes
            val name = binding.tenantNameEditText.text.toString()
            val phone = binding.phoneEditText.text.toString()
            val rent = binding.rentEditText.text.toString()

            // Build a Tenant object from the typed values
            val tenant = Tenant(name, phone, rent)

            binding.tenant = tenant  // Data Binding displays the summary
            lastTenant = tenant      // remember it for the CALL TENANT button
        }

        // ── CALL TENANT button (implicit Intent) ──────────────────
        binding.callButton.setOnClickListener {
            val tenant = lastTenant

            // If nothing has been saved yet, tell the user and stop
            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Open the phone dialer with the tenant's number filled in
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${tenant.phone}"))
            startActivity(intent)
        }
    }

    // ── SAVE STATE ────────────────────────────────────────────────
    // Android calls this just before destroying the Activity
    // (for example, when the phone rotates).
    // outState is the Bundle that Android keeps for us.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("TENANT_LIFECYCLE", "MainActivity: onSaveInstanceState")

        // Copy into a val so Kotlin knows it can't change after the check
        val tenant = lastTenant
        if (tenant != null) {
            // Store each field under its own KEY.
            // onCreate() reads them back with the SAME keys.
            outState.putString("tenant_name", tenant.name)
            outState.putString("tenant_phone", tenant.phone)
            outState.putString("tenant_rent", tenant.rent)
        }
    }

    // ── LIFECYCLE METHODS ─────────────────────────────────────────
    // Android calls each of these automatically. We only add a log
    // line so we can watch the order in Logcat.
    // (They sit at class level, NOT inside onCreate.)

    // The screen is now VISIBLE
    override fun onStart() {
        super.onStart()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onStart")
    }

    // The screen is in FRONT and the user can interact with it
    override fun onResume() {
        super.onResume()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onResume")
    }

    // The screen is LEAVING the front (e.g. Home was pressed)
    override fun onPause() {
        super.onPause()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onPause")
    }

    // The screen is NO LONGER VISIBLE
    override fun onStop() {
        super.onStop()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onStop")
    }

    // The user came BACK to a stopped screen
    override fun onRestart() {
        super.onRestart()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onRestart")
    }

    // The screen is being DESTROYED
    override fun onDestroy() {
        super.onDestroy()
        Log.d("TENANT_LIFECYCLE", "MainActivity: onDestroy")
    }
}