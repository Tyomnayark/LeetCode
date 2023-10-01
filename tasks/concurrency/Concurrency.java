package tasks.concurrency;

import java.util.concurrent.Semaphore;

public class Concurrency {
    class Foo {
        private Semaphore sem1, sem2;

        public Foo() {
            sem1 = new Semaphore(0);
            sem2 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            printFirst.run();
            sem1.release(); // Отпустить семафор для второго метода
        }

        public void second(Runnable printSecond) throws InterruptedException {
            sem1.acquire(); // Дождаться, пока будет вызван метод first()
            printSecond.run();
            sem2.release(); // Отпустить семафор для третьего метода
        }

        public void third(Runnable printThird) throws InterruptedException {
            sem2.acquire(); // Дождаться, пока будет вызван метод second()
            printThird.run();
        }
    }
}
