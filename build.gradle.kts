// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    // Safe Args: generates classes for passing data between screens.
    // "apply false" = make it available here, switch it on in the app module
    id("androidx.navigation.safeargs.kotlin") version "2.9.8" apply false
}