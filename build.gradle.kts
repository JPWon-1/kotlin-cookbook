import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mockito:mockito-core:4.3.1")
    implementation("org.mockito:mockito-all:1.10.19")
    implementation("org.easymock:easymock:4.3")
    implementation("io.mockk:mockk:1.12.3")
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.22.0")
    // https://mvnrepository.com/artifact/org.mockito.kotlin/mockito-kotlin
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}