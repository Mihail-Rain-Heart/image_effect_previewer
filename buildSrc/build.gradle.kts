plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

sourceSets.all {
    java.srcDirs(
        "src/$name/kotlin",
        "src/$name/test/kotlin",
        "src/$name/androidTest/kotlin"
    )
}