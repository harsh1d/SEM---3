package PRACTICAL - 19;

class A extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread for class A i=" + i);
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread for class B i=" + i);
        }
    }
}

class C extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread for class C i=" + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        A t1 = new A();
        B t2 = new B();
        C t3 = new C();

        t1.start();
        t2.start();
        t3.start();
    }
}
