package Story.BuyWifeStory;

import Story.BuyWifeStory.utilites.Utility;

public class View {
     private  boolean loop=true;
     private  char key=' ';
     public void listWoman(){

     }
    public void buyWoman(){

    }
    public void diyWoman(){

    }
    public  void mainMenu(){
        do{
            System.out.println("买家你好,我这边有很多女人，你要挑挑看嘛");
            System.out.println("\t\t1 女 人 列 表");
            System.out.println("\t\t2 购 买 女 人");
            System.out.println("\t\t3 个 性 化 定 制");
            System.out.println("\t\t4 退    出");
            key= Utility.readChar();
            switch (key)
            {
                case '1':
                    listWoman();
                    break;
                case '2':
                    buyWoman();
                    break;
                case '3':
                    diyWoman();
                    break;
                case '4':
                    loop=false;
                    System.out.println("退    出");
                    break;
            }
        }while (loop);
    }
}
