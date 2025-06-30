rootProject.name = "knotion"

plugins {
    id("org.ajoberstar.reckon.settings") version "0.19.2"
}

extensions.configure<org.ajoberstar.reckon.gradle.ReckonExtension> {
    snapshots()
    setStageCalc(calcStageFromProp())
    setScopeCalc(
        calcScopeFromProp()
            .or(calcScopeFromCommitMessages())
    )
}
