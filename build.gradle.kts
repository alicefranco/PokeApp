import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(PluginDependencies.GRADLE)
        classpath(PluginDependencies.KOTLIN)
        classpath(PluginDependencies.KTLINT)
        classpath(PluginDependencies.KOTLIN_SERIALIZATION)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = AppConfig.JVM_TARGET
    }
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}
