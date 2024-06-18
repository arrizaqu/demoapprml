// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.4" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}

buildscript {
    repositories {
        google()
        jcenter()

        maven {
            url=uri( "C:/Users/arriz/OneDrive/Documents/training/traininggs/DexGuard-9.7.0/DexGuard-9.7.0/lib");
        }
    }

    dependencies {
        classpath("com.guardsquare:dexguard-gradle-plugin:9.7.0")
        classpath("com.android.tools.build:gradle:4.2.0")
        classpath("com.google.gms:google-services:4.3.8")
    }
}





