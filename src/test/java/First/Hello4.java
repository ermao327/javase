package First;

public class Hello4 {
    public static void main(String[] args) {
        Word ming = new Word();
        Word hong = new Word();
        ming.setName("Xiao Ming");
        // TODO: 给Word增加重载方法setName(String, String):
        hong.setName("Xiao", "Hong");
        System.out.println(ming.getName());
        System.out.println(hong.getName());
    }

}
class Word {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setName(String name,String name1){
        this.name=name+name1;
    }
}
