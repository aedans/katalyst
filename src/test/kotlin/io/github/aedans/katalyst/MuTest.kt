package io.github.aedans.katalyst

import arrow.test.UnitSpec
import io.github.aedans.katalyst.data.*
import io.github.aedans.katalyst.laws.BirecursiveLaws

class MuTest : UnitSpec() {
    init {
        testLaws(BirecursiveLaws.laws(Mu.birecursive()))
    }
}
