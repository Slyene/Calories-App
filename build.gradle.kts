
buildscript {
    extra.apply {
        set("room_version", "2.6.1")
        set("lifecycle_version", "2.7.0")
        set("nav_version", "2.7.6")
        set("sqlite_version", "2.4.0")
    }
}

plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.devtools.ksp") version "1.9.22-1.0.17" apply false
}