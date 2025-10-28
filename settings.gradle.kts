@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        maven("https://lib.alpn.cloud/mirrors/")
        mavenCentral()
        maven("https://mvnrepository.com/artifact/")
        maven("https://repo.dmulloy2.net/content/groups/public/")
        maven("https://repo.destroystokyo.com/repository/maven-public/")
        maven("https://ci.emc.gs/nexus/content/groups/aikar/")
        maven("https://ci.athion.net/plugin/repository/tools/")
        maven("https://jitpack.io/")
        maven("https://repo.minebench.de/")
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://repo.codemc.org/repository/maven-public/")
        maven("https://hub.spigotmc.org/nexus/content/groups/public/")
        maven("https://maven.enginehub.org/repo/")
        maven("https://repo.maven.apache.org/maven2/")
        maven("https://ci.frostcast.net/plugin/repository/everything/")
        maven("https://repo.spongepowered.org/maven/")
        maven("https://repo.inventivetalent.org/content/groups/public/")
        maven("https://store.ttyh.ru/libraries/")
        maven("https://repo.dmulloy2.net/nexus/repository/public/")
        maven("https://maven.elmakers.com/repository/")
        maven("https://ci.ender.zone/plugin/repository/everything/")
    }
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
}

pluginManagement {
    includeBuild("build-logic")
}


plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("1.0.0")
}

rootProject.name = "fawe"

setOf(
    "core",
    "bukkit",
    "favs",
).forEach {
    include(it)
    project(":$it").name = "${rootProject.name}-${it.lowercase()}"
}