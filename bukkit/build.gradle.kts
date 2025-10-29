plugins {
    id("fawe.shadow-conventions")
}

dependencies {
    api(projects.faweCore)

    compileOnly(libs.paperApi) {
        exclude("net.md-5")
    }
    compileOnly("org.bukkit.craftbukkit:Craftbukkit_1_12:1.12.1")
    compileOnly("org.bukkit.craftbukkit:Craftbukkit_1_11:1.11")
    compileOnly("org.bukkit.craftbukkit:Craftbukkit_1_10:1.10")
    compileOnly("org.bukkit.craftbukkit:Craftbukkit_1_9:1.9.4")
    compileOnly("org.bukkit.craftbukkit:Craftbukkit_1_8:1.8.8")
    compileOnly("org.bukkit.craftbukkit:Craftbukkit_1_7:1.7.10")

    compileOnly(libs.askyblock)
    compileOnly(libs.factionsone)
    compileOnly(libs.griefprevention)
    compileOnly(libs.mapmanager) { isTransitive = false }
    compileOnly(libs.massiveCore)
    compileOnly(libs.massiveFactions)
    compileOnly(libs.regios)
    compileOnly(libs.residence)
    compileOnly(libs.towny)
    compileOnly(libs.plotmeCore)
    compileOnly(libs.protocollib)
    compileOnly(libs.vault)
    compileOnly(libs.worldeditBukkit)
    compileOnly(libs.worldguard)
}

tasks {
    processResources {
        val props = mutableMapOf(
            "version" to project.version.toString(),
        )
        inputs.properties(props)
        filesMatching("plugin.yml") {
            expand(props)
        }
    }
    shadowJar {
        relocate("com.google.gson", "com.sk89q.worldedit.internal.gson")
    }
    javadoc {
        val v = libs.versions
        applyLinks(
            "https://hub.spigotmc.org/javadocs/spigot/",
            "https://lib.alpn.cloud/javadoc/mirrors/com/wasteofplastic/askyblock/${v.askyblock.get()}/raw/",
            "https://lib.alpn.cloud/javadoc/mirrors/com/sk89q/worldguard/${v.worldguard.get()}/raw/",
            "https://intellectualsites.github.io/fastasyncworldedit-javadocs/worldedit-core/",
            "https://intellectualsites.github.io/fastasyncworldedit-javadocs/worldedit-bukkit/",
            "http://palmergames.com/javadoc/towny-bukkit/"
        )
    }
}
