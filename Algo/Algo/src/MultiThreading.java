public class MultiThreading {

    private static final int MAX_THREAD_SIZE = 10;
    private static int count = 0;

    private static void startThread() {
        Thread[] thread = new Thread[MAX_THREAD_SIZE];

        for (int i = 0; i < MAX_THREAD_SIZE; i++) {
            int finalI = i;
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        System.out.println("Thread is running " + thread[finalI].getName());
                        incrementByOne(count);
                        System.out.println();

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }, "TH" + i);
            thread[i].start();
        }
    }

    private static synchronized void incrementByOne(int cnt) {

        cnt++;

        if (cnt >= 1000000) {
            count = 0;
        }

        System.out.println("The value of count is " + cnt);
    }

    public static void main(String[] args) {
        System.out.println("Thread pool is starting...");
        startThread();
        System.out.println("Thread pool is terminated...");
    }
}
