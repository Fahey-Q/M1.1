package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingMg extends Goods {
    //客户的购物车
    ArrayList<String> ownGoods = new ArrayList<>();//购物车中的商品名称
    ArrayList<Integer> ownGoodsCount = new ArrayList<>();//购物车中每种商品的数量


    //增加商品至购物车
    public void addGoodsToShopCar() {
        super.addGoods0();
        ownGoods.add("可口可乐");
        ownGoodsCount.add(2);
        Customer tab=new Customer();
        System.out.println("\t1--商品名添加\n\t2--商品编号添加");
        //用户选择
        Scanner choose = new Scanner(System.in);
        int add = choose.nextInt();
        //用户输入
        switch (add) {
            case 1:
                System.out.println("请输入你要购买的商品名称:");
                Scanner buy = new Scanner(System.in);
                String buyThings = buy.next();
                if (goodsName.contains(buyThings)) {
                    ownGoods.add(buyThings);
                    int address4 = goodsName.indexOf(buyThings);
                    System.out.println("您购买的商品还剩余：");
                    System.out.println(goodsCount.get(address4));
                    System.out.println("请选择需要购买商品的数量");
                    Scanner num = new Scanner(System.in);
                    int number = num.nextInt();
                    ownGoodsCount.add(number);
                    //从商品库中减去被购买商品的数量
                    goodsCount.set(address4, goodsCount.get(address4) - number);
                    System.out.println("商品已成功添加至购物车，快去为宝贝买单吧！");
                    System.out.println("商品名："+ownGoods);
                    System.out.println("购买量："+ownGoodsCount);
                    System.out.println("\n\t1--继续\n\t2--返回");
                    Scanner trend=new Scanner(System.in);
                    int trends=trend.nextInt();
                    switch (trends){
                        case 1:
                            addGoodsToShopCar();//返回上一级
                            break;
                        case 2:
                            tab.chooseAfterSignIn();
                            break;
                    }


                } else {
                    System.out.println("暂时还未找到您想要的商品");//判断商品是否存在
                    addGoodsToShopCar();//返回上一级
                    break;
                }
            case 2:
                System.out.println("请输入你要购买的商品编号:");
                Scanner buyd = new Scanner(System.in);
                int buynum = buyd.nextInt();
                if (goodsNumber.contains(buynum)) {
                    int address4 = goodsNumber.indexOf(buynum);
                    ownGoods.add(goodsName.get(address4));
                    System.out.println("您购买的商品还剩余：");
                    System.out.println(goodsCount.get(address4));
                    System.out.println("请选择需要购买商品的数量");
                    Scanner num = new Scanner(System.in);
                    int number = num.nextInt();
                    ownGoodsCount.add(number);
                    //从商品库中减去被购买商品的数量
                    goodsCount.set(address4, goodsCount.get(address4) - number);
                    System.out.println("商品已成功添加至购物车，快去为宝贝买单吧！");
                    System.out.println("商品名："+ownGoods);
                    System.out.println("购买量："+ownGoodsCount);
                    System.out.println("\n\t1--继续\n\t2--返回");
                    Scanner trend=new Scanner(System.in);
                    int trends=trend.nextInt();
                    switch (trends){
                        case 1:
                            addGoodsToShopCar();//返回上一级
                            break;
                        case 2:
                            tab.chooseAfterSignIn();
                            break;
                    }


                } else {
                    System.out.println("暂时还未找到您想要的商品");//判断商品是否存在
                    addGoodsToShopCar();//返回上一级
                    break;
                }


        }
    }

    //把商品从购物车中清除
    public void deleteGoodsFromShopCar() {
        //先初始化添加第一位用户的购物车-->用于测试
        ownGoods.add("可口可乐");
        ownGoodsCount.add(2);
        //先展示购物车中的内容
        System.out.println("商品：" + ownGoods);
        System.out.println("数量：" + ownGoodsCount);
        try {
            System.out.println("请确认是否继续商品删除操作");
            System.out.println("\t1--继续\n\t2--退出");
            Scanner chs = new Scanner(System.in);
            int choose4 = chs.nextInt();
            switch (choose4) {
                case 1:
                    System.out.println("请输入需要删除的商品名：");
                    Scanner del1=new Scanner(System.in);
                    String delGoods=del1.next();
                    if(ownGoods.contains(delGoods)){
                        System.out.println("请选择删除方式：");
                        System.out.println("\t1--清除该商品的全部数量\n\t2--选择性清除");
                        Scanner del=new Scanner(System.in);
                        int delete=del.nextInt();
                        int address5=ownGoods.indexOf(delGoods);//找出商品在购物车中的位置
                        int address6=goodsName.indexOf(delGoods);//找出商品在商品库中的位置
                        switch (delete){
                            case 1:
                                ownGoods.remove(address5);
                                ownGoodsCount.remove(address5);
                                //把商品放回商品库
                                goodsCount.set(address6,goodsCount.get(address6)+ownGoodsCount.get(address5));
                                System.out.println("已清除该商品的全部数量。");
                                break;
                            case 2:
                                System.out.println("请输入需要删除的商品数量：");
                                Scanner deleteNumber=new Scanner(System.in);
                                int deleteCount=deleteNumber.nextInt();
                                if(deleteCount>ownGoodsCount.get(address5)||deleteCount<=0){
                                    System.out.println("购物车中的该商品数量少于待删除数量！");
                                }else {
                                    ownGoodsCount.set(address5,ownGoodsCount.get(address5)-deleteCount);
                                    System.out.println("删除成功。");
                                    //把商品放回商品库
                                    goodsCount.set(address6,goodsCount.get(address6)+deleteCount);
                                }

                                break;
                        }
                    }else {
                        System.err.println("购物车中没有此商品！");
                        System.err.println("请重新选择！");
                        deleteGoodsFromShopCar();
                    }
                    break;
                case 2:

                    break;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    //修改购物车中的商品//修改商品数量，当数量小于或等于0，则将该商品从购物车中清除。
    public void modifyGoodsOfShopCar() {
        if(ownGoodsCount.contains(0)){
            int goodsAddress=ownGoodsCount.indexOf(0);//判断商品数等于0的商品在购物车中的位置
            ownGoods.remove(goodsAddress);
        }
    }

    //从文本文档中读取购物车信息
    //商品名称和数量
    public void readShoppingCar(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("D:\\Java_exciese\\M1.1\\src\\test\\已添加的商品.txt"));
            BufferedReader br1 = new BufferedReader(new FileReader("D:\\Java_exciese\\M1.1\\src\\test\\已添加的商品数量.txt"));
            String str;
            while ((str = br.readLine()) != null) {
                ownGoods.add(str);
            }
            while ((str = br1.readLine()) != null) {
                ownGoodsCount.add(Integer.parseInt(str));
            }
            br.close();
            br1.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //把购物车信息写到文本文档中
    public void writeShoppingCar(){
        try{
            BufferedWriter og = new BufferedWriter(new FileWriter("D:\\Java_exciese\\M1.1\\src\\test\\已添加的商品.txt"));
            BufferedWriter og1 = new BufferedWriter(new FileWriter("D:\\Java_exciese\\M1.1\\src\\test\\已添加的商品数量.txt"));

            for (String i : ownGoods) {
                og.write(i);
                og.newLine();
                og.flush();
            }
            for (int i : ownGoodsCount) {
                og1.write(String.valueOf(i));
                og1.newLine();
                og1.flush();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}