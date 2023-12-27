import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	id("java")
	id("org.jetbrains.kotlin.jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
//	kotlin("plugin.noarg") version "1.6.21"
//	id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
}

//allOpen {
//	annotations("org.springframework.boot.autoconfigure.SpringBootApplication",
//		"org.springframework.transaction.annotation.Transactional")
//}

//noArg {
//	annotation("jakarta.persistence.Entity")
//}

group = "com.fastcampus"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
