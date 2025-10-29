plugins {
    id("fawe.blossom-conventions")
}

dependencies {
    api(libs.fastutilLite)
    api(libs.zstdJni)

    compileOnlyApi(libs.p2Core)
    compileOnlyApi(libs.blockshub)
    compileOnlyApi(libs.worldeditCore) {
        exclude("org.mockito")
    }

    compileOnly(libs.snakeyaml)
    compileOnly(libs.gson)
    compileOnly(libs.redprotect)

}

sourceSets {
    main {
        blossom {
            javaSources {
                property("commit", latestCommitHash())
                property("date", latestCommitDateTime())
                property("github_org", findProperty("github_org").toString())
                property("github_name", findProperty("github_name").toString())
                property("version", project.version.toString())
            }
        }
    }
}

tasks {
    javadoc {
        val v = libs.versions
        applyLinks(
            "https://intellectualsites.github.io/fastasyncworldedit-javadocs/worldedit-core/",
            "https://lib.alpn.cloud/javadoc/snapshots/co/crystaldev/plotsquared-core/${v.p2.get()}/raw/",
            "https://lib.alpn.cloud/javadoc/mirrors/it/unimi/dsi/fastutil/8.5.15/raw/",
            "https://lib.alpn.cloud/javadoc/mirrors/com/google/code/gson/gson/${v.gson.get()}/raw/",
            "https://lib.alpn.cloud/javadoc/mirrors/org/yaml/snakeyaml/${v.snakeyaml.get()}/raw/",
        )
    }
}