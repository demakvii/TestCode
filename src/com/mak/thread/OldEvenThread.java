package com.mak.thread;

public class OldEvenThread {


    public static void main(String[] args) throws Exception {
        var number = new Number(1, 10);
        var t1 = new EvenThread(number);
        var t2 = new OddThread(number);
        var t3 = new PrimeThread(number);
        t1.start();
        t2.start();
        t3.start();
    }

    static class Number {
        private int i;
        private final int max;
        Number(int i, int max){
            this.i = i;
            this.max = max;
        }
        void change(){
            ++i;
        }
        int getMax(){
            return max;
        }
        int get() {
            return i;
        }
        boolean isEven(){
            return i % 2 == 0;
        }

        boolean isPrime() {
            if (i <= 1)
                return false;
            for (int j = 2; j < i; j++)
                if (i % j == 0)
                    return false;
            return true;
        }

    }

    static class EvenThread extends Thread {
        private final Number number;
        EvenThread(Number number){
            this.number = number;
        }

        @Override
        public void run() {
            while (true){
                synchronized (number){
                    if(number.isEven() && !number.isPrime()){
                        System.out.println("[Even Thread] " + number.get());
                        number.change();
                        number.notifyAll();
                    } else {
                        try {
                            number.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }
                    if (number.get() == number.getMax())
                        break;
                }
            }
        }
    }

    static class OddThread extends Thread {
        private final Number number;
        OddThread(Number number){
            this.number = number;
        }

        @Override
        public void run() {
            while (true){
                synchronized (number){
                    if(!number.isEven() && !number.isPrime()){
                        System.out.println("[Odd Thread] " + number.get());
                        number.change();
                        number.notifyAll();
                    } else {
                        try {
                            number.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }
                    if (number.get() == number.getMax())
                        break;
                }
            }
        }
    }

    static class PrimeThread extends Thread {
        private final Number number;
        PrimeThread(Number number){
            this.number = number;
        }

        @Override
        public void run() {
            while (true){
                synchronized (number){
                    if(number.isPrime()){
                        System.out.println("[Prime Thread] " + number.get());
                        number.change();
                        number.notifyAll();
                    } else {
                        try {
                            number.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }
                    if (number.get() == number.getMax())
                        break;
                }
            }
        }
    }
}
