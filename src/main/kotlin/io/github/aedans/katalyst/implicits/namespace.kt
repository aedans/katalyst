package io.github.aedans.katalyst.implicits

import io.github.aedans.katalyst.*
import io.github.aedans.katalyst.typeclasses.Corecursive
import io.github.aedans.katalyst.typeclasses.Recursive
import io.github.aedans.katalyst.typeclasses.corecursive
import io.github.aedans.katalyst.typeclasses.recursive
import kategory.*

// cata

inline fun <reified F, reified T, A> HK<T, F>.cata(
        RT: Recursive<T> = recursive(),
        FF: Functor<F> = functor(),
        noinline alg: Algebra<F, A>
) = RT.cata(this, alg, FF)

inline fun <reified F, reified M, reified T, A> HK<T, F>.cataM(
        RT: Recursive<T> = recursive(),
        TF: Traverse<F> = traverse(),
        MM: Monad<M> = monad(),
        noinline algM: AlgebraM<M, F, A>
) = RT.cataM(this, algM, TF, MM)

inline fun <reified F, reified W, reified T, A> HK<T, F>.gcata(
        RT: Recursive<T> = recursive(),
        FF: Functor<F> = functor(),
        CW: Comonad<W> = comonad(),
        dFW: DistributiveLaw<F, W>,
        noinline gAlg: GAlgebra<W, F, A>
) = RT.gcata(this, dFW, gAlg, FF, CW)

inline fun <reified F, reified W, reified M, reified T, A> HK<T, F>.gcataM(
        RT: Recursive<T> = recursive(),
        TF: Traverse<F> = traverse(),
        TW: Traverse<W> = traverse(),
        MM: Monad<M> = monad(),
        CW: Comonad<W> = comonad(),
        dFW: DistributiveLaw<F, W>,
        noinline gAlgM: GAlgebraM<W, M, F, A>
) = RT.gcataM(this, dFW, gAlgM, TF, TW, MM, CW)

// ana

inline fun <reified F, reified T, A> A.ana(
        CT: Corecursive<T> = corecursive(),
        FF: Functor<F> = functor(),
        noinline coalg: Coalgebra<F, A>
) = CT.ana(this, coalg, FF)

inline fun <reified F, reified M, reified T, A> A.anaM(
        CT: Corecursive<T> = corecursive(),
        TF: Traverse<F> = traverse(),
        MM: Monad<M> = monad(),
        noinline coalgM: CoalgebraM<M, F, A>
) = CT.anaM(this, coalgM, TF, MM)

inline fun <reified F, reified N, reified T, A> A.gana(
        CT: Corecursive<T> = corecursive(),
        FF: Functor<F> = functor(),
        MN: Monad<N> = monad(),
        dNF: DistributiveLaw<N, F>,
        noinline gCoalg: GCoalgebra<N, F, A>
) = CT.gana(this, dNF, gCoalg, FF, MN)

inline fun <reified F, reified N, reified M, reified T, A> A.ganaM(
        CT: Corecursive<T> = corecursive(),
        TF: Traverse<F> = traverse(),
        MN: Monad<N> = monad(),
        TN: Traverse<N> = traverse(),
        MM: Monad<M> = monad(),
        dNF: DistributiveLaw<N, F>,
        noinline gCoalgM: GCoalgebraM<N, M, F, A>
) = CT.ganaM(this, dNF, gCoalgM, TF, MN, TN, MM)

// hylo

inline fun <reified F, A, B> A.hylo(
        FF: Functor<F> = functor(),
        noinline alg: Algebra<F, B>,
        noinline coalg: Coalgebra<F, A>
) = io.github.aedans.katalyst.hylo(this, alg, coalg, FF)

inline fun <reified F, reified M, A, B> A.hyloM(
        TF: Traverse<F> = traverse(),
        MM: Monad<M> = monad(),
        noinline algM: AlgebraM<M, F, B>,
        noinline coalgM: CoalgebraM<M, F, A>
) = io.github.aedans.katalyst.hyloM(this, algM, coalgM, TF, MM)

inline fun <reified W, reified N, reified F, A, B> A.ghylo(
        CW: Comonad<W> = comonad(),
        MN: Monad<N> = monad(),
        FF: Functor<F> = functor(),
        dFW: DistributiveLaw<F, W>,
        dNF: DistributiveLaw<N, F>,
        noinline gAlg: GAlgebra<W, F, B>,
        noinline gCoalg: GCoalgebra<N, F, A>
) = io.github.aedans.katalyst.ghylo(this, dFW, dNF, gAlg, gCoalg, CW, MN, FF)

inline fun <reified W, reified N, reified M, reified F, A, B> A.ghyloM(
        CW: Comonad<W> = comonad(),
        TW: Traverse<W> = traverse(),
        MN: Monad<N> = monad(),
        TN: Traverse<N> = traverse(),
        MM: Monad<M> = monad(),
        TF: Traverse<F> = traverse(),
        dFW: DistributiveLaw<F, W>,
        dNF: DistributiveLaw<N, F>,
        noinline gAlgM: GAlgebraM<W, M, F, B>,
        noinline gCoalgM: GCoalgebraM<N, M, F, A>
) = io.github.aedans.katalyst.ghyloM(this, dFW, dNF, gAlgM, gCoalgM, CW, TW, MN, TN, MM, TF)

// other

inline fun <reified F> distCata() = distCata(traverse<F>())
