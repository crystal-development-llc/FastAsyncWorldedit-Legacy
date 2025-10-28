dependencies {
    compileOnly(projects.faweBukkit)
    compileOnly(libs.paperApi)
    compileOnly(libs.voxelsniper)
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
}