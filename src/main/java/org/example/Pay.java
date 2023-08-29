package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Pay extends Goods {
    ArrayList<Double> costTotal = new ArrayList<>();//计算总花销
    double total;//计算总金额
    ArrayList<String> bought = new ArrayList<>();//存放曾经购买过的商品信息
    Customer people = new Customer();
    ShoppingMg shoppingMg = new ShoppingMg();
    Customer next=new Customer();
    int adds;

    //支付
    public void payFor() {
        try {
            costTotal.add(0,0.0);
            people.addCustomer0();
            super.addGoods0();
            System.out.println("\n请输入您想要购买的商品名：");
            shoppingMg.ownGoods.add("可口可乐");
            shoppingMg.ownGoodsCount.add(1);
            Scanner shp = new Scanner(System.in);
            String shoppingName = shp.next();
            if (shoppingMg.ownGoods.contains(shoppingName)) {
                System.out.println("请选择支付方式：");
                System.out.println("============================");
                System.out.println("\t1--微信");
                System.out.println("\t2--支付宝");
                System.out.println("\t3--银行卡");
                System.out.println("============================");
                Scanner chp = new Scanner(System.in);
                int payChoose = chp.nextInt();
                int address = shoppingMg.ownGoods.indexOf(shoppingName);//该商品在购物车中的位置
                int adr = goodsName.indexOf(shoppingName);//该商品在商品库中的位置
                System.out.println(goodsName);
                int count = shoppingMg.ownGoodsCount.get(address);//商品在购物车中的数量
                double price = goodsExitPrice.get(adr);//商品的价格
                total = count * price;//总价
                System.out.println("请输入用户名进行确认:");
                Scanner confirm = new Scanner(System.in);
                String local = confirm.next();
                adds = people.customerName.indexOf(local);//找到该用户的信息储存位置
                double cost1 = costTotal.get(adds);
                costTotal.set(adds, total + cost1);
                PersonalInformation admin = new PersonalInformation();
                admin.grade();
                switch (payChoose) {
                    case 1://微信支付
                        try {
                            System.out.println("是否确认支付？\n\t1--是\t2--否");
                            Scanner yee = new Scanner(System.in);
                            int yes = yee.nextInt();
                            switch (yes) {
                                case 1:
                                    System.out.println("购买成功！");
                                    bought.add(shoppingName);//产生购物历史
                                    next.chooseAfterSignIn();
                                    break;
                                case 2: {
                                    return;
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    case 2://支付宝支付
                        try {
                            System.out.println("是否确认支付？\n\t1--是\t2--否");
                            Scanner yee1 = new Scanner(System.in);
                            int yes1 = yee1.nextInt();
                            switch (yes1) {
                                case 1:
                                    System.out.println("购买成功！");
                                    bought.add(shoppingName);//产生购物历史
                                    next.chooseAfterSignIn();
                                    break;
                                case 2: {
                                    payFor();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    case 3://银行卡支付
                        try {
                            System.out.println("是否确认支付？\n\t1--是\t2--否");
                            Scanner yee2 = new Scanner(System.in);
                            int yes2 = yee2.nextInt();
                            switch (yes2) {
                                case 1:
                                    System.out.println("购买成功！");
                                    bought.add(shoppingName);//产生购物历史
                                    next.chooseAfterSignIn();
                                    break;
                                case 2: {
                                    payFor();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                }
            } else {
                System.out.println("您的购物车中无该商品！");
                payFor();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Customer err = new Customer();
            err.chooseAfterSignIn();
        }

    }
}