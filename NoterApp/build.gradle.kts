// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies{
        classpath ("com.android.tools.build:gradle:7.4.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")





    }


}

plugins {
    id("com.android.application") version "8.2.2" apply false
    id ("com.android.library") version "7.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
}