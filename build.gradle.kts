plugins {
    id("fawe.build-logic")
}

subprojects {
    apply {
        plugin("fawe.base-conventions")
        plugin("fawe.publish-conventions")
    }
}