package HOME.Thread;

public class Thread01 {
    public static void main(String[] args) {
        String s = "abcdefg";
        for (int i = s.length()-1; i >= 0; i--) {
            System.out.println(s.charAt(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
