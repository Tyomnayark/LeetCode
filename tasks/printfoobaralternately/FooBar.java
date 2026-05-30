package printfoobaralternately;

public class FooBar {
    private int n;
    private volatile int thread = 1;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (thread != 1){
                wait();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            thread = 2;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (thread != 2){
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            thread = 1;
            notifyAll();
        }
    }
}
