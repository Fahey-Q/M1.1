package org.example;

import java.util.Scanner;
public class User {
    public static void main(String[] args) {
        try{
            System.out.println("============================");
            System.out.println("\t1--登录");
            System.out.println("\t2--注册");
            System.out.println("\t3--搜索");
            System.out.println("\t4--浏览商品");
            System.out.println("\t5--退出");
            System.out.println("============================");
            System.out.println("请输入您的选择:");
            Scanner ch = new Scanner(System.in);
            int choose = ch.nextInt();
            Admin admin = new Admin();
            Goods good = new Goods();
            Customer customer = new Customer();
            good.addGoods0();
            PersonalInformation personalInformation=new PersonalInformation();
            ShoppingHs shoppingHs=new ShoppingHs();
            ShoppingMg shoppingMg=new ShoppingMg();
            //文本文件导入
            shoppingMg.readShoppingCar();
            shoppingHs.readShoppingHs();
            customer.readCustomerKey();
            good.acquireGoodsInformation();
            personalInformation.acquireCustomerDate();

            if (choose > 0 && choose < 6) {
                switch (choose) {
                    //登录
                    case 1:
                        System.out.println("请选择您的身份\n\t1--管理员\n\t2--客户");
                        Scanner read = new Scanner(System.in);
                        int reader = read.nextInt();
                        switch (reader) {
                            //管理员登录
                            case 1:
                                admin.singIn();
                                admin.adminTrend();
                                break;
                            //客户登录
                            case 2:
                                customer. cuSignIn();
                                break;
                        }
                        break;
                        //注册
                    case 2:
                        //调用customer的方法
                        customer.customerRegister();
                        break;

                    //搜索商品（可以调用）
                    case 3:
                        //调用Goods类的方法
                        good.searchGoods();
                        break;
                    //浏览商品
                    case 4:
                        good.showAllGoods();
                        main(null);
                        break;
                    //退出
                    case 5:
                        good.writeGoods();//先写一次文件产生源
                        personalInformation.storageCustomerDate();//产生源
                        customer.writeCustomerKey();//先写一次产生源
                        shoppingHs.writeShoppingHs();//产生源
                        shoppingMg.writeShoppingCar();//产生源
                        System.exit(0);//退出程序
                }
            } else {
                System.out.println("请重新选择");
                main(null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}