plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.8.22"
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "io.axoniq"
version = "0.0.1-SNAPSHOT"

java {
    java.sourceCompatibility = JavaVersion.VERSION_17
    java.targetCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

extra["springCloudVersion"] = "2022.0.3"

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("org.axonframework:axon-spring-boot-starter:4.7.0")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:3.1.0")
    implementation("org.axonframework.extensions.kotlin:axon-kotlin:4.7.0")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.cloud:spring-cloud-starter-config:3.1.0")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap:3.1.0")
    implementation("net.logstash.logback:logstash-logback-encoder:7.4")
    implementation("org.postgresql:postgresql:42.6.0")
    runtimeOnly("com.h2database:h2")
    annotationProcessor("org.projectlombok:lombok")
    implementation(project(":core"))
    testImplementation("org.axonframework:axon-test:4.6.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
