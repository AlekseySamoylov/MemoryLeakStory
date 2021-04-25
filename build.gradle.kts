plugins {
  java
  application
  kotlin("jvm") version "1.5.0-RC"
  id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  jcenter()
  mavenCentral()
}
project.setProperty("mainClassName", "com.samoilov.MainKt")

dependencies {
  implementation("org.rocksdb:rocksdbjni:6.19.3")

  implementation(kotlin("stdlib"))
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
  useJUnitPlatform()
}
