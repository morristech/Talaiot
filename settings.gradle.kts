pluginManagement {
    repositories {
        maven { url = uri("./talaiot/build/repository") }
        gradlePluginPortal()

    }
}

include (":talaiot")