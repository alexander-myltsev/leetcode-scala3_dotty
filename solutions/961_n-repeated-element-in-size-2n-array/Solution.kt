package main

class Solution0_kotlin {
    companion object {
        @JvmStatic
        fun repeatedNTimes(a: IntArray): Int {
            for (i in 0..a.size - 1) {
                for (j in 1..3) {
                    if (i + j >= a.size)
                        continue
                    if (a[i] == a[i + j])
                        return a[i]
                }
            }
            throw IllegalArgumentException()
        }
    }
}
