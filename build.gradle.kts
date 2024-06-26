plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
    id("com.android.library") version "8.1.2" apply false
    id("org.jetbrains.kotlin.kapt") version "1.9.0" apply false

    id("com.google.dagger.hilt.android") version "2.49" apply false
}

buildscript{
    dependencies{
        classpath("com.google.gms:google-services:4.4.1")
    }
}