package ThrowError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class throwError {
    public static void main(String[] args) {
        try {
            methond();
        }catch (NullPointerException e){
            System.out.println(666);
        }
        System.out.println(444);

    }
    public static  void methond(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            simpleDateFormat.parse("2000/01/05");
            System.out.println(111);String s=null;
            s.length();
        }
        catch (ParseException | NullPointerException e) {
//            e.printStackTrace();
            System.out.println(555);
        }
//        catch (ParseException e) {
//            e.printStackTrace();
//            System.out.println(222);
//        }
//        catch (NullPointerException a) {
//            a.printStackTrace();
//            System.out.println(555);
//        }
        System.out.println(333);

    }
}
