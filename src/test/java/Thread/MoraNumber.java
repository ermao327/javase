package Thread;

import java.util.concurrent.Callable;

public class MoraNumber implements Callable {
    private Host host;
    private String name;
    private int time;

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public MoraNumber(Host host, String name, int time) {
        this.host = host;
        this.name = name;
        this.time = time;
    }

    public static void main(String[] args) throws InterruptedException {


    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
class Host{
    private int answer;
    private boolean flag;

    public Host(int answer, boolean flag) {
        this.answer = answer;
        this.flag = flag;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public  void start(){
        this.answer=(int)(Math.random()*20+1);
        System.out.println(answer);
    }
    public boolean check(MoraNumber moraNumber,int num){
        if(num==answer){
            this.flag=true;
            System.out.println(moraNumber.getName()+"猜对了");
            return true;
        }
        return false;
    }

}