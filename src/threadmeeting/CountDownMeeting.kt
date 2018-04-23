package threadmeeting

import java.util.concurrent.CountDownLatch

/**
 * Created by Allen on 2018/4/23.
 */
fun main(args: Array<String>) {

    var latch = CountDownLatch(1)

    for (i in 0 .. 50) {
        Thread(CountDownMeeting.RunableDemo("Thread" + i, latch)).start()
        Thread.sleep(10)
    }
    latch.countDown()
}
class CountDownMeeting{

    class RunableDemo : Runnable {
        private var threadName: String? = null
        var latch: CountDownLatch? = null

        constructor(name: String, countDownLatch: CountDownLatch) {
            threadName = name
            latch = countDownLatch;
        }

        override fun run() {

            latch?.await()
            println(threadName)
        }
    }

}


