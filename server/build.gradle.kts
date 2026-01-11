plugins {
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.spring)
    alias(libs.plugins.org.springframework.boot)
    alias(libs.plugins.io.spring.dependency.management)
}

group = "com.example.hshop.api"
version = "1.0.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.org.springframework.boot.starter.webmvc)
    implementation(libs.org.springframework.boot.starter.data.jdbc)
    implementation(libs.org.springframework.boot.starter.kotlinx.serialization.json)
    implementation(libs.org.jetbrains.kotlin.reflect)
    runtimeOnly(libs.org.postgresql)
    testImplementation(libs.org.springframework.boot.starter.webmvc.test)
    testImplementation(libs.org.springframework.boot.starter.data.jdbc.test)
    testImplementation(libs.org.springframework.boot.starter.kotlinx.serialization.json.test)
    testImplementation(libs.org.jetbrains.kotlin.test.junit5)
    testRuntimeOnly(libs.org.junit.platform.launcher)
}

kotlin {
  compilerOptions {
    freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
