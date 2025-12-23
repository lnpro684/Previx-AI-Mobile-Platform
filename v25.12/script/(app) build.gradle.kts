plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.previx.ai"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.previx.ai"
        minSdk = 33
        targetSdk = 36
        versionCode = 1
        versionName = "25.12"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // ARM Architecture Settings
        ndk {
            abiFilters.add("arm64-v8a")
            abiFilters.add("armeabi-v7a")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // GGUF Main Library
    implementation(libs.llama.android)
}
