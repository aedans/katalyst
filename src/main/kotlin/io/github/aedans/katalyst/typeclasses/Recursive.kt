package io.github.aedans.katalyst.typeclasses

import arrow.*
import arrow.core.Eval
import arrow.typeclasses.Functor
import io.github.aedans.katalyst.Algebra
import io.github.aedans.katalyst.Coalgebra
import io.github.aedans.katalyst.hylo

/**
 * Typeclass for types that can be generically folded with algebras.
 */
interface Recursive<T> {
    /**
     * Implementation for project.
     */
    fun <F> projectT(FF: Functor<F>, t: Kind<T, F>): Kind<F, Kind<T, F>>

    /**
     * Creates a coalgebra given a functor.
     */
    fun <F> project(FF: Functor<F>): Coalgebra<F, Kind<T, F>> =
            { projectT(FF, it) }

    /**
     * Fold generalized over any recursive type.
     */
    fun <F, A> Kind<T, F>.cata(FF: Functor<F>, alg: Algebra<F, Eval<A>>): A =
            hylo(FF, alg, project(FF), this)
}
