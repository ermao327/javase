package SysAtm;

import SYS_User_manage.User;
import stu_system.Student;

import java.util.Arrays;

public class BankSystemSever {
    private Customer[] customers = new Customer[3];
    private BankSystem[] bankSystems = new BankSystem[1];
    private AtmSysteam[] atmSysteams = new AtmSysteam[1];
    public BankSystemSever() {
        customers[0]=new Customer("abc","123123","65540","2000-05-06","410",5000,"1");
        customers[1]=new Customer("asd","123123","45645","2001-06-11","531",2000,"1");
        customers[2]=new Customer("qwe","123123","12324","2002-08-22","321",30000,"1");
        atmSysteams[0]=new AtmSysteam(100000);
        bankSystems[0]=new BankSystem("admin","000000");
    }
    public Customer[] selectAll(){
        return this.customers;
    }
    public boolean deleteById(String cid){
        boolean flag = false;
        for (int i = 0; i < customers.length; i++) {
            if(cid.equals(customers[i].getCardid())){
                flag = true;
                for (int j = i; j < customers.length-1; j++) {
                    customers[j] = customers[j+1];//往左移动
                }
                break;
            }
        }
        if(flag) {
            customers = Arrays.copyOf(customers, customers.length - 1);
            return true;
        }
        return false;
    }
    public void addOne(Customer customer){
        customers= Arrays.copyOf(customers, customers.length+1);
        customers[customers.length-1]=customer;
    }
    public int DecideInputadmin(String acc,String upassword){
        for (int i = 0; i <bankSystems.length; i++) {
            if(acc.equals(bankSystems[i].getUname())&&upassword.equals(bankSystems[i].getUpassword()))
            {
                return 1;
            }
            else if(upassword.length()!=6){
                return 9110;
            }
            else if(!acc.equals(bankSystems[i].getUname())&&upassword.equals(bankSystems[i].getUpassword()))
            {
                return 2;
            }
            else if(acc.equals(bankSystems[i].getUname())&&!upassword.equals(bankSystems[i].getUpassword()))
            {
                return 3;
            }
            else if(!acc.equals(bankSystems[i].getUname())&&!upassword.equals(bankSystems[i].getUpassword()))
            {
                return 4;
            }

        }
        return -99999;
    }
    public int CheckNewAcc(String name,String pwd,String cid,String id){
        for (int i = 0; i <customers.length; i++) {
             if(name.length()==3&&pwd.length()==6&&!cid.equals(customers[i].getCardid()))
            {
                return 888;
            }
            else if(name.length()!=3)
            {
                return 9187;
            }
            else if(pwd.length()!=6){
                return 9110;
            }
            else if(cid.equals(customers[i].getCardid()))
            {
                return -9878;
            }
            else if(id.length()!=3)
            {
                return 3;
            }

        }
        return -9999;
    }
    public boolean DecideInputCardid(String cardid,String upassword,String status){
        boolean flag=false;
        for (Customer customer : customers) {
            if (cardid.equals(customer.getCardid())
                    && upassword.equals(customer.getUpassword())
                    && status.equals(customer.getStatus())) {
                return true;
            }
        }
        return flag;
    }
    public int Transfer(String itid,String itname){
        for (int i = 0; i <customers.length; i++) {
            if(itid.equals(customers[i].getCardid())&&itname.equals(customers[i].getUname()))
            {
                return 1;
            }
            else if(!itid.equals(customers[i].getCardid())&&itname.equals(customers[i].getUname()))
            {
                return 2;
            }
            else if(itid.equals(customers[i].getCardid())&&!itname.equals(customers[i].getUname()))
            {
                return 3;
            }
        }
        return -99999;
    }
    public int DrawMoney(int drawmoney){
        for (int i = 0; i <customers.length; i++) {
            if(drawmoney>customers[i].getMoney()&&drawmoney<5000)
            {
                return 9876;
            }
            else if(drawmoney>=5000&&drawmoney<atmSysteams[0].getAtmmoeny())
            {
                return 9877;
            }
            else if(drawmoney<100)
            {
                return 9666;
            }
            else if(drawmoney>atmSysteams[0].getAtmmoeny())
            {
                return 9899;
            }
        }
        return 1;
    }
    public  int CheckTransferMoney(int checkTransferMoney){
        for (int i = 0; i <customers.length; i++) {
            if(checkTransferMoney>customers[i].getMoney()&&checkTransferMoney<5000)
            {
                return 9876;
            }
            else if(checkTransferMoney>=5000)
            {
                return 9877;
            }
            else if(checkTransferMoney<100)
            {
                return 9666;
            }
        }
        return 1;
    }
    public int SaveMoney(int savemoney){
        if(savemoney%100==0)
        {
            return 1;
        }
        return 0;
    }
    public Customer[] customers(){
        return this.customers;
    }
    public AtmSysteam[] atmSysteams(){
        return this.atmSysteams;
    }
    public BankSystem[] bankSystems(){
        return this.bankSystems;
    }
    public boolean decideInputId(String cid){
        boolean flag=true;
        for (int i = 0; i <customers.length; i++) {
            if(cid.equals(customers[i].getCardid())){
                return true;
            }
        }
        return false;
    }
}
