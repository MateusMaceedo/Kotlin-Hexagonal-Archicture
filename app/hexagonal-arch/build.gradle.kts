import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "com.example.service.user"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_17

sourceSets {
	main {
		java {
			srcDirs("src/main/resources/avro", "scripts", "build/avro")
		}
	}
}

repositories {
	mavenCentral()
	jcenter()
	maven {
		url = uri("https://packages.confluent.io/maven/")
	}
}

buildscript {
	repositories {
		jcenter()
	}

	dependencies {
		classpath("com.commercehub.gradle.plugin:gradle-avro-plugin:0.17.0")
	}
}

apply(plugin = "com.commercehub.gradle.plugin.avro")

dependencies {

	// WEB
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	// JPA
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// TO USE NAME ANNOTATION
	implementation("javax.inject:javax.inject:1")

	// DB
	implementation("com.h2database:h2")
	implementation("org.postgresql:postgresql")
	implementation("org.liquibase:liquibase-core")

	// AVRO
	implementation("org.apache.avro:avro:1.10.2")
	implementation("org.apache.avro:avro-compiler:1.10.2")

	implementation("io.projectreactor.kafka:reactor-kafka:1.2.2.RELEASE")
	implementation("io.confluent:kafka-avro-serializer:5.4.0")

	// KAFKA
	implementation("org.apache.kafka:kafka-clients:2.8.0")

	// SQS
	implementation("software.amazon.awssdk:sqs:2.17.16")

	implementation("io.arrow-kt:arrow-core:1.0.1")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.mockk:mockk:1.12.3")
	testImplementation("com.tngtech.archunit:archunit-junit5:0.23.1")
	testImplementation("com.github.javafaker:javafaker:1.0.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}

	dependsOn("generateAvroJava")
}
