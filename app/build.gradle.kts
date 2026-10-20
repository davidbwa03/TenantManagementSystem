plugins {
    alias(libs.plugins.android.application)
    // Switch Safe Args ON. Must come BELOW the android.application line.
    // No version number here (it is set in the Project file)
    id("androidx.navigation.safeargs.kotlin")
    // ...keep any other plugin lines you already have
}

android {
    namespace = "com.example.tenantmanagementsystem"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.tenantmanagementsystem"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }


}



dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    // NavHostFragment and NavController
    implementation("androidx.navigation:navigation-fragment-ktx:2.9.8")
    // NavigationUI: connects the App Bar and menus to navigation
    implementation("androidx.navigation:navigation-ui-ktx:2.9.8")
    // ...keep all your existing dependencies below
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}