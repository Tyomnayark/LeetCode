package printinorder

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock

class PrintInOrderAlternative {

    private val lock = ReentrantLock()
    val order: AtomicInteger = AtomicInteger(1)

    fun first(printFirst: () -> Unit) {
        while (order.get() != 1) {
            Thread.yield()
        }
        printFirst()
        order.getAndIncrement()
    }
    fun second(printSecond: () -> Unit) {
        while (order.get() != 2) {
            Thread.onSpinWait()
        }
        printSecond()
        order.getAndIncrement()
    }

    fun third(printThird: () -> Unit) {
        while (order.get() != 3) {
            Thread.yield()
        }
        printThird()
        order.getAndSet(1)
    }
}

fun main() {

    val printInOrder = PrintInOrderAlternative()

    val result = StringBuilder()

    val thread1 = Thread {
        printInOrder.first {
            result.append("first")
        }
    }

    val thread2 = Thread {
        printInOrder.second {
            result.append("second")
        }
    }

    val thread3 = Thread {
        printInOrder.third {
            result.append("third")
        }
    }

    thread3.start()
    thread2.start()
    thread1.start()

    thread1.join()
    thread2.join()
    thread3.join()

    println(result.toString())
}
