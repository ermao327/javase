package Story.BuyWifeStory;

import Story.BuyWifeStory.utilites.Utility;

/**
 * 1.买家张三花了10w块向卖家李四买了一个菲律宾老婆(年龄30岁，颜值60)，一年以后，生了一个女娃(身长40cm，体重4kg)
 * 2.一年后，就离婚了。又花了20w向卖家李四买了一个越南老婆(年龄20岁，颜值90)，一年以后，生了一个男孩(身长50cm,体重5kg)
 *
 * 增加功能，改成oop
 * 1.从买家进入，买家从买家手里卖女人，可以从库里挑，直接实现增加老婆和减少女人得操作；
 *   可以指定要指定区域的符合条件的女人，指定完之后，等待一会，卖家的库里就多了指定的女人
 *   卖家提示，女人给你搞到手了，你可以买了，交易成功
 * 2.把生的小孩性别，身高，体重改为随机
 * 3.给孩子的生命加上血条，随机血条，为了测试做成出生1~5s内随机死亡或者存活，存活得概率加大一点，弹出死亡提示，显示性别，身高，体重，存活时间
 * 4.老婆的年龄和颜值在一眼后发生改变，年龄增加，颜值变化；年龄增加为固定，颜值为随机增加或减少；
 * 5.离婚事件，随机离婚事件（男孩不离婚，女孩离婚）孩子死了，触发离婚；孩子是女的还活下来了还是离婚
 *    （1）男方和平离婚：孩子随机归属男方或女方，孩子判给男方，如果反杀女人，触发事件，再去买一个女人生孩子，直到生出来男孩mg落幕美好生活，被女人反杀直接gg
 *                                       判给女方,女的带着孩子走了，没过多久被卖家找到，女的被杀，男的继续买女人生孩子
 *                                                                   女的反杀卖家，并成功解救剩余女方，然后把买家杀死，mg落幕，带着孩子归隐了
 *                                      如果没有判给女方，女方把男方杀死，夺回孩子，mg落幕，带着孩子归隐了；杀男人随机，有几率被反杀
 *    （2）非和平离婚：直接开始刀人，直接进入杀与被杀，增加一个事件，男人被杀之后，卖家有几率被杀
 */
public class Story {


    public static void main(String[] args) throws InterruptedException {
        boolean loop=true;
        char key=' ';
        Seller ls = new Seller("李四", 10);
        Woman[] women = new Woman[6];
        women[0] = new PhilippinesWoman(30, 60);
        women[1] = new PhilippinesWoman(40, 70);
        women[2] = new VietnamWoman(20, 90);
        women[3] = new VietnamWoman(35, 80);
        women[4] = new PhilippinesWoman(20, 60);
        women[5] = new CambodiaWoman(20, 60);
        //建立李四和woman数组之间的合成关系（has-a）
        ls.setWomen(women);
        Buyer zs = new Buyer("张三", 100);
        do{
            System.out.println("买家: "+zs.getName()+" 你好 ，我这边有很多女人，你要挑挑看嘛");
            System.out.println("\t\t1 查 看 女 人");
            System.out.println("\t\t2 个 性 化 定 制");
            System.out.println("\t\t3 退    出");
            key= Utility.readChar();
            switch (key)
            {
                case '1':
                    System.out.println("查 看 女 人");
                    break;
                case '2':
                    System.out.println("个 性 化 定 制");
                    break;
                case '3':
                    loop=false;
                    System.out.println("退    出");
                    break;
            }
        }while (loop);


        System.out.println(zs);
        System.out.println(ls);

        //买了一个越南老婆
        zs.buy(ls, 5, 10);
        System.out.println("---买了老婆之后----");
        System.out.println(zs);
        System.out.println(ls);
        Thread.sleep(1000);//一年之后
        System.out.println("----------一年之后-----------");
        System.out.println("张三生了一个娃");
        zs.bear();
        System.out.println(zs);
        Thread.sleep(1000);//一年之后
        System.out.println("----------一年之后-----------");
        System.out.println("张三离婚了");
        zs.setWife(null);
        zs.buy(ls, 1, 20);
        System.out.println("张三又买了一个越南老婆");
        System.out.println(zs);
        System.out.println(ls);
        Thread.sleep(1000);//一年之后
        System.out.println("----------一年之后-----------");
        System.out.println("张三又生了一个娃");
        zs.bear();
        System.out.println(zs);
    }
}
