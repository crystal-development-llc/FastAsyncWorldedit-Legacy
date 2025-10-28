plugins {
    `java-library`
    idea
    eclipse
}

plugins.withId("java") {
    configure<JavaPluginExtension> {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
        sourceCompatibility = JavaVersion.VERSION_11
    }
}

configurations.all {
    attributes.attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 11)
}

base {
    archivesName.set("${project.name}-${latestCommitHash()}")
}

tasks {
    withType<JavaCompile>().configureEach {
        configureCompiler()
    }
    withType<ProcessResources>().configureEach {
        duplicatesStrategy = DuplicatesStrategy.WARN
        filteringCharset = Charsets.UTF_8.name()
    }
    withType<Javadoc>().configureEach {
        configureJavadocs()
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

fun JavaCompile.configureCompiler() {
    options.release.set(11)
    options.encoding = Charsets.UTF_8.name()
    options.compilerArgs.addAll(
        listOf(
            "-parameters",
            "-Xlint:-options",
        )
    )
}

fun Javadoc.configureJavadocs() {
    (options as StandardJavadocDocletOptions).apply {
        addStringOption("Xdoclint:all", "-quiet")
        charset(Charsets.UTF_8.name())
        encoding(Charsets.UTF_8.name())
        noTimestamp()
        use()

        links(
            "https://docs.oracle.com/en/java/javase/11/docs/api/",
        )
    }
}