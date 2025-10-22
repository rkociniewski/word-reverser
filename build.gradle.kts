import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import org.jetbrains.dokka.gradle.engine.parameters.VisibilityModifier
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

/**
 * artifact group
 */
group = "rk.powermilk"

/**
 * project version
 */
version = "1.0.12"

val javaVersion = JavaVersion.VERSION_21
val jvmTargetVersion = JvmTarget.JVM_21.target

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.test.logger)
    alias(libs.plugins.dokka)
    alias(libs.plugins.detekt)
    jacoco
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

// dependencies
dependencies {
    detektPlugins(libs.detekt)
    testImplementation(libs.junit.params)
    testImplementation(kotlin("test"))
}

testlogger {
    showStackTraces = false
    showFullStackTraces = false
    showCauses = false
    slowThreshold = 10000
    showSimpleNames = true
}

kotlin {
    compilerOptions {
        verbose = true // enable verbose logging output
        jvmTarget.set(JvmTarget.fromTarget(jvmTargetVersion)) // target version of the generated JVM bytecode
    }
}

detekt {
    source.setFrom("src/main/kotlin")
    config.setFrom("$projectDir/detekt.yml")
    autoCorrect = true
}

dokka {
    dokkaSourceSets.main {
        jdkVersion.set(java.targetCompatibility.toString().toInt()) // Used for linking to JDK documentation
        skipDeprecated.set(false)
    }

    pluginsConfiguration.html {
        dokkaSourceSets {
            configureEach {
                documentedVisibilities.set(
                    setOf(
                        VisibilityModifier.Public,
                        VisibilityModifier.Private,
                        VisibilityModifier.Protected,
                        VisibilityModifier.Internal,
                        VisibilityModifier.Package,
                    )
                )
            }
        }
    }
}

tasks.test {
    jvmArgs("-XX:+EnableDynamicAgentLoading")
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}


tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
        csv.required.set(false)
    }

    finalizedBy(tasks.jacocoTestCoverageVerification)
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.75".toBigDecimal()
            }
        }

        rule {
            enabled = true
            element = "CLASS"
            includes = listOf("rk.*")

            limit {
                counter = "LINE"
                value = "COVEREDRATIO"
                minimum = "0.75".toBigDecimal()
            }
        }
    }
}

tasks.register("cleanReports") {
    doLast {
        delete("${layout.buildDirectory}/reports")
    }
}

tasks.register("coverage") {
    dependsOn(tasks.test, tasks.jacocoTestReport, tasks.jacocoTestCoverageVerification)
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = jvmTargetVersion
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = jvmTargetVersion
}
