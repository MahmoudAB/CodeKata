package kata.chop

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class ChopTest{

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
   
    }

    private fun chop(value: Int, array_of_int: Array<Int>): Int {

        if(array_of_int.size == 0) return -1

        if (array_of_int[0] == value) return 0

        if(array_of_int.size == 1) return -1

        var firsthalf = array_of_int.sliceArray(IntRange(0, (array_of_int.size/2)-1))
        var secondhalf = array_of_int.sliceArray(IntRange(array_of_int.size/2, array_of_int.size-1))
        var position = array_of_int.size/2
        val done = false
        while(!done){
            if(secondhalf[0] == value || firsthalf[0] == value) return position

            if(value > secondhalf[0]){
                position = position + secondhalf.size/2
                secondhalf = secondhalf.sliceArray(IntRange(secondhalf.size/2, secondhalf.size-1))
                if (secondhalf.size == 0 || secondhalf.size ==1 && value > secondhalf[0]) break
            } else {
                position = position + firsthalf.size / 2
                firsthalf = firsthalf.sliceArray(IntRange(0, (firsthalf.size / 2) - 1))
                if (firsthalf.size == 0 || firsthalf.size == 1 && value > firsthalf[0]) break
            }

        }
        return -1



    }



}