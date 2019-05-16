package binary.chop

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class ChopTest {

    @Test
    fun test_chop() {
        assertEquals(-1, chop(3, emptyArray()))
        assertEquals(-1, chop(3, arrayOf(1)))
        assertEquals(0, chop(1, arrayOf(1)))

        assertEquals(0, chop(1, arrayOf(1, 3, 5)))
        assertEquals(1, chop(3, arrayOf(1, 3, 5)))
        assertEquals(2, chop(5, arrayOf(1, 3, 5)))
        assertEquals(-1, chop(0, arrayOf(1, 3, 5)))
        assertEquals(-1, chop(2, arrayOf(1, 3, 5)))
        assertEquals(-1, chop(4, arrayOf(1, 3, 5)))
        assertEquals(-1, chop(6, arrayOf(1, 3, 5)))

        assertEquals(0, chop(1, arrayOf(1, 3, 5, 7)))
        assertEquals(2, chop(5, arrayOf(1, 3, 5, 7)))
        assertEquals(3, chop(7, arrayOf(1, 3, 5, 7)))
        assertEquals(-1, chop(0, arrayOf(1, 3, 5, 7)))
        assertEquals(-1, chop(2, arrayOf(1, 3, 5, 7)))
        assertEquals(-1, chop(4, arrayOf(1, 3, 5, 7)))
        assertEquals(-1, chop(6, arrayOf(1, 3, 5, 7)))
        assertEquals(-1, chop(8, arrayOf(1, 3, 5, 7)))


        assertEquals(5, chop(6, arrayOf(1, 2, 3, 4, 5, 6, 7, 8)))
        assertEquals(2, chop(3, arrayOf(1, 2, 3, 4, 5, 6, 7, 8)))
        //assertEquals(50_432_987, chop(50_432_987, IntRange(0, 100_000_000).toList().toTypedArray()))

    }


    private fun chop(target: Int, candidates: Array<Int>): Int {
        return recursiveChop(target, candidates, 0)

    }

    private tailrec fun recursiveChop(target: Int, candidates: Array<Int>, accumulator: Int): Int {

        if (candidates.size == 0) return -1
        if (candidates[0] == target) return accumulator
        if (candidates.size == 1) return -1

        val midPoint = candidates.size / 2

        val firsthalf = candidates.sliceArray(0 until midPoint)
        val secondhalf = candidates.sliceArray(midPoint until candidates.size)

        return if(target >= secondhalf[0])
            recursiveChop(target, secondhalf, accumulator + midPoint)
        else
            recursiveChop(target, firsthalf, accumulator)



    }

    private fun iterativeChop(target: Int, candidates: Array<Int>): Int {

        var survivors = candidates.copyOf()
        var firsthalf: Array<Int>
        var secondhalf: Array<Int>
        var targetIndex = 0

        while (true) {
            if (survivors.size == 0) return -1
            if (survivors[0] == target) return targetIndex
            if (survivors.size == 1 || survivors[0] > target)  return -1

            firsthalf = survivors.sliceArray(0 until (survivors.size / 2))
            secondhalf = survivors.sliceArray((survivors.size / 2) until survivors.size)

            if (target >= secondhalf[0]) {
                targetIndex += survivors.size / 2
                survivors = secondhalf
            } else {
                survivors = firsthalf
            }

        }

    }

    private fun fib(n: Int) : Int {
        if (n < 0) return -1
        if (n < 2) return n
        return fib(n-2) + fib(n-1)
    }

    private fun factorial(n: Int): Int{
        return tailRecFac(n, 1)
    }

    private tailrec fun tailRecFac(n: Int, accumulator: Int): Int {
        if(n == 0) return accumulator
        if (n % 2 == 0) return -1
        return tailRecFac(n -1, n * accumulator)
    }

    private tailrec fun stupid() :Int {
        return stupid()
    }

//    private fun myand(x : Boolean, y: Boolean): Boolean {
//        if (x) {return y}
//    }
//
//    private fun myor(x: Boolean, y: Boolean) {
//        if (!x) {return y}
//    }


    @Test
    fun bla() {
        if(true || stupid() >1)
            println("if")
        else
            println("else")

    }


}