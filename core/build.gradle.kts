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