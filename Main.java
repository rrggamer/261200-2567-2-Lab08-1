public class Main {
    public static void main(String[] args) {

        //Before Adding Thread.sleep():
        //เลขจะไม่เรียงกัน แบบนี้
        //Thread #3: 1
        //Thread #3: 2
        //Thread #3: 3
        //Thread #3: 4
        //Thread #2: 1
        //Thread #2: 2
        //Thread #2: 3
        //Thread #2: 4
        //Thread #2: 5
        //Thread #2: 6
        //Thread #2: 7
        //Thread #2: 8
        //Thread #1: 1
        //Thread #3: 5
        //เพราะบาง Thread มีโอกาสที่จะได้พิมพ์ก่อน Thread อื่นจะได้พิมพ์

        //After Adding Thread.sleep():
        //เลขจะปริ้นเรียงกันแต่ Thread จะแย่งกันปริ้นเลขนั้น เพราะฉะนั้นลำดับของ Thread จะไม่เหมือนเดิม
        //Thread #3: 1
        //Thread #2: 1
        //Thread #1: 1
        //Thread #2: 2
        //Thread #1: 2
        //Thread #3: 2
        //Thread #2: 3
        //Thread #3: 3
        //Thread #1: 3
        //Thread #2: 4
        //Thread #3: 4
        //Thread #1: 4


        /*
         * MultiThread in Java:
         * - Java MultiThread ทำให้สามารถรันโปรแกรมแบบ Concurrently ได้
         * - การใช้ Thread.sleep() ช่วยทำให้การสลับเธรดเห็นได้ชัดเจนขึ้น
         * - ถ้าไม่มี Thread.sleep() ลำดับการทำงานจะไม่สามารถคาดเดาได้เลย
         * -
         */

        ThreadPrintNumber t1 = new ThreadPrintNumber(1);
        ThreadPrintNumber t2 = new ThreadPrintNumber(2);
        ThreadPrintNumber t3 = new ThreadPrintNumber(3);

        t1.start();
        t2.start();
        t3.start();

    }
}

class ThreadPrintNumber extends Thread {
    private int threadNumber;

    public ThreadPrintNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public void run() {
        nosleep();
//        havesleep();
    }

    public void havesleep() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("Thread #" + threadNumber + ": " + i);
            try {
                Thread.sleep(500); // Delay here
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void nosleep() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("Thread #" + threadNumber + ": " + i);
        }
    }
}


