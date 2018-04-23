package threadmeeting

import java.util.concurrent.CountDownLatch

/**
 * Created by Allen on 2018/4/23.
 */
class CountDownTest {


    object CountDownMeetingTest {
        @JvmStatic
        fun main(args: Array<String>) {
            val latch = CountDownLatch(1)
            val count = 50
            for (i in 0 until count) {
                val threadName = "Thread" + i
                Thread(RunnableDemo(threadName, latch)).start()

                try {
                    Thread.sleep(20)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }

            latch.countDown()
        }
    }

    internal class RunnableDemo(private val threadName: String, var latch: CountDownLatch) : Runnable {

        override fun run() {
            try {
                this.latch.await()
                println("Running " + threadName)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }
    }


}