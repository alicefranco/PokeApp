import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(PluginDependencies.GRADLE)
        classpath(PluginDependencies.KOTLIN_GRADLE_PLUGIN)
        classpath(PluginDependencies.KTLINT)
        classpath(PluginDependencies.HILT_GRADLE_PLUGIN)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = AppConfig.JVM_TARGET
    }
}

tasks.register("clean").configure {
    delete(rootProject.layout.buildDirectory)
}
