package com.mak.thread;

public class SendReceiveThread {

    public static void main(String[] args) throws Exception {
        var sent = new Flag();
        var sentThread = new SentThread(sent);
        var receivedThread = new ReceivedThread(sent);
        sentThread.start();
        receivedThread.start();
    }

    static class Flag {
        private boolean send;
        void change(){
            send = !send;
        }
        boolean isSend(){
            return send;
        }
    }

    static class SentThread extends Thread {
        private final Flag flag;
        SentThread(Flag flag){
            this.flag = flag;
        }

        @Override
        public void run() {
            int i = 1;
            while (i <= 10){
                synchronized (flag){
                    if(!flag.isSend()){
                        System.out.println("Msg Sent " + i);
                        flag.change();
                        flag.notify();
                        i++;
                    } else {
                        try {
                            //System.out.println("Sent thread waiting");
                            flag.wait();
                            //System.out.println("Sent thread release");
                        } catch (InterruptedException ignored) {
                        }
                    }
                }
            }
        }
    }

    static class ReceivedThread extends Thread {
        private final Flag flag;
        ReceivedThread(Flag flag){
            this.flag = flag;
        }

        @Override
        public void run() {
            var i = 1;
            while (i <= 10){
                synchronized (flag){
                    if(flag.isSend()){
                        System.out.println("Msg Received " + i);
                        flag.change();
                        flag.notify();
                        i++;
                    } else {
                        try {
                            //System.out.println("Receive thread waiting");
                            flag.wait();
                            //System.out.println("Receive thread release");
                        } catch (InterruptedException ignored) {
                        }
                    }
                }
            }
        }
    }

}
