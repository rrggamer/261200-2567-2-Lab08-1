import java.util.Random;

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
        //เพราะบาง Thread มีโอกาสที่จะได้พิมพ์ก่อนและทำงานต่อเนื่องจนโดนขัดเลขจาก Thread นั้นจะเรียงกันต่อเนื่องเพราะไม่โดนขัด

        //After Adding Thread.sleep():
        //เลขจะปริ้นตามความหน่วงของ Thread เพราะฉะนั้นระหว่างที่ Thread Sleep อยู่จะเปิดโอกาสให้ Thread อื่นแทรกได้



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
    private Random random = new Random();

    public ThreadPrintNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public void run() {
//        nosleep();
        havesleep();
    }

    public void havesleep() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("Thread #" + threadNumber + ": " + i);
            try {
                Thread.sleep(random.nextInt(100)); // Delay here
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


