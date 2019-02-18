package kata.chop

class Iterative {
  companion object {
    fun chop(target: Int, numbers: Array<Int>): Int {
      var index = 0
      var searched = numbers.copyOf()

      while (searched.size > 1) {
        val midIndex = searched.size / 2
        val mid = searched[midIndex]

        if (mid > target) {
          searched = searched.sliceArray(0 until midIndex)
        } else {
          index += midIndex
          searched = searched.sliceArray(midIndex until searched.size)
        }
      }
      return if (searched.size == 0 || searched[0] != target) -1 else index
    }
  }
}