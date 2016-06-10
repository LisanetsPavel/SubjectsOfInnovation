import java.util.Random;

class Runnrer implements Runnable{
    static Random random = new Random();
    private Integer i;
    private Object o;

    Runnrer(Integer s, Object o){
        this.i = s;
        this.o = o;
    }


    @Override
    public void run() {
        synchronized (o){

            System.out.println(Thread.currentThread().getName() + " started");


            while (!(i == 25)){
                System.out.println(Thread.currentThread().getName() + " changed value to " + i);
                i = random.nextInt()*100;
                System.out.println(Thread.currentThread().getName() + " Notify");
                o.notifyAll();

                try {
                    System.out.println(Thread.currentThread().getName() + " Waiting");
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        System.out.println(Thread.currentThread().getName() + " finish");
    }
}


public class Threads{
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread();
        t1.setPriority(9);
        ThreadGroup tg=new ThreadGroup("TG");
        tg.setMaxPriority(6);

        Thread t2=new Thread(tg,"t2");
        t2.setPriority(9);
        System.out.print("приоритет t1="
                + t1.getPriority());
        System.out.print(", приоритет t2="
                + t2.getPriority());



        }

    }


