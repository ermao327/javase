package OopTest;

public class Method01 {
    public static void main(String[] args) {
        xx xx=new xx();
        xx.print(2, 3, 'c');
    }

}
class xx{
    public void print(int row,int column,char c){
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <column; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
