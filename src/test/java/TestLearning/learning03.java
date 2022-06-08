package TestLearning;

import java.util.Arrays;

public class learning03 {
    public static void main(String[] args) {
        User user = new User("张三");
        Alipay alipay = new Alipay();
        user.requestForTransfer(alipay,"10001","123",300, "10003");
        System.out.println(alipay);
    }
}
class Account{
    private String id;//账号

    private String password;//密码

    private int money;//余额

    public Account(String id, String password, int money) {
        this.id = id;
        this.password = password;
        this.money = money;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
class Alipay {
    private Account[] accounts = new Account[3];

    @Override
    public String toString() {
        return "Alipay{" +
                "accounts=" + Arrays.toString(accounts) +
                '}';
    }

    public Alipay() {
        accounts[0] = new Account("10001", "123", 1000);
        accounts[1] = new Account("10002", "123", 2000);
        accounts[2] = new Account("10003", "123", 3000);
    }

    /**
     * 服务端
     * 响应用户的转账请求
     * * 1.账号要正确
     * * 2.密码要正确
     * * 3.余额要足够
     * * 4.对方账户要存在
     * * 5.不能自己转给自己
     * * 6.转账成功
     */
//    public String responseForTransfer(String fromId, String password, int money, String toId) {
//        for (int i = 0; i <accounts.length; i++) {
//            if (fromId.equals(accounts[i].getId())) {
//                for(int a=0;a<accounts.length;a++)
//                {
//                    if(toId.equals(accounts[a].getId())){
//                        if(!fromId.equals(toId)){
//                            for (int j = 0; j <accounts.length; j++) {
//                                if (accounts[j].getPassword().equals(password)) {
//                                    for (int k = j; k <= j; k++) {
//                                        if (money < accounts[k].getMoney()) {
//                                            accounts[i].setMoney(accounts[i].getMoney()-money);
//                                            accounts[a].setMoney(accounts[a].getMoney()+money);
//                                            return "成功";
//                                        }
//                                        else {
//                                            return "钱不够";
//                                        }
//                                    }
//                                }
//                                else {
//                                    return "密码错误";
//                                }
//                            }
//                        }else {
//                            return "不能为自己";
//                        }
//                    }
//                }
//                    return "对方账户不存在";
//            }
//        }return "账号错误";
//    }
    /**
     * 根据输入的账号来找账户对象
     * @param id
     * @return
     */
    private Account findAccountbyid(String id){
        for (Account account : accounts) {
            //自己的账户存在
            if(id.equals(account.getId()))
            {
                return account;
            }
        }
        return null;
    }
    public String responseForTransfer2(String fromId, String password, int money, String toId){
        Account from=findAccountbyid(fromId);//假设自己的账户不存在
        if(from==null)
        {
            return "账户不存在";
        }
        if(!password.equals(from.getPassword()))
        {
            return "密码错误";
        }
        if(from.getMoney()<money)
        {
            return "钱不够";
        }
        Account to=findAccountbyid(toId);//假设对方的账户不存在
        if(to == null){
            return "对方账号不正确";
        }

        if(fromId.equals(toId)){
            return "不能自己转给自己";
        }

        from.setMoney(from.getMoney()-money);
        to.setMoney(to.getMoney()+money);
        return "转账成功";
    }
}

class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    //请求支付宝转账
    public void requestForTransfer(Alipay alipay,String id,String password,int money,String toId){
        System.out.println(alipay.responseForTransfer2(id, password, money, toId));
    }
}