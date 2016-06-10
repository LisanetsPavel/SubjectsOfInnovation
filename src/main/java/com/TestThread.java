package com;

/**
 * Created by pc9 on 08.06.16.
 */
class  Helper {
    private String  s;
     synchronized void methodone() throws InterruptedException {
         Thread.sleep(2000);
         s = "one";
         System.out.println(s);
     }

    synchronized void methodTwo() throws InterruptedException {
        Thread.sleep(2000);
        s = "two";
        System.out.println(s);

    }
}
class Runner implements Runnable{
   private Helper help;
    Runner(Helper help){
        this.help = help;
    }
    @Override
    public void run() {
        System.out.println("First");
        try {
            help.methodone();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class RunnerTwo implements Runnable{
    private Helper help;
    RunnerTwo(Helper help){
        this.help = help;
    }
    @Override
    public void run() {
        System.out.println("Second");
        try {
            help.methodTwo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class TestThread {
    public static void main(String[] args) {
        Helper helper = new Helper();
        Thread  t1 = new Thread(new Runner(helper));
        Thread  t2 = new Thread(new RunnerTwo(helper));
        t1.start();
        t2.start();
        while (t1.isAlive()){

        }
    }



}
