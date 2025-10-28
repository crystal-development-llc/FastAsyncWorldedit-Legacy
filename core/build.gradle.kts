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

tasks {
    processResources {
        val props = mutableMapOf(
            "version" to project.version.toString(),
            "name" to project.rootProject.name,
        )
        inputs.properties(props)
        filesMatching("fawe.properties") {
            expand(props)
        }
    }
}