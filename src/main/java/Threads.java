import java.util.Random;




public class Threads{
    public static String  str = "123";
    public static int mathod(){
        int x =10;
        try {

            String s = null;
            s.length();

        }catch (Exception e){
            System.out.println("hello");
            return x++;
        }finally {
            return ++x;
        }
    }
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        String sss = "123";
        String ssss = "12".concat("3").intern();
        String ww = "3";

        System.out.println(sss == ssss);

        }

    }


