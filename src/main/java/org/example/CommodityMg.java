package org.example;

import java.util.Scanner;

public class CommodityMg extends Goods {//商品管理
    Admin admin = new Admin();
    Customer chooseAS=new Customer();

    //添加商品//商品的信息包括：商品编号、商品名称、生产厂家、生产日期、型号、进货价、零售价格、数量
    public void addGoods() {

        System.out.println("\n****你现在正在以管理员身份进行商品操作****");
        System.out.println("请添加商品编号：");
        Scanner goodsNum = new Scanner(System.in);
        int goodsNum1 = goodsNum.nextInt();
        goodsNumber.add(goodsNum1);
        System.out.println("请添加商品名：");
        Scanner goodsNam = new Scanner(System.in);
        String goodsNam1 = goodsNam.next();
        goodsName.add(goodsNam1);
        System.out.println("请添加商品生产厂商：");
        Scanner goodsMft = new Scanner(System.in);
        String goodsMft1 = goodsMft.next();
        goodsManufacturer.add(goodsMft1);
        System.out.println("请添加商品生产日期：");
        Scanner goodsDP = new Scanner(System.in);
        String goodsDP1 = goodsDP.next();
        goodsDateOfProduction.add(goodsDP1);
        System.out.println("请添加商品型号：");
        Scanner goodsTp = new Scanner(System.in);
        String goodsTp1 = goodsTp.next();
        goodsTypes.add(goodsTp1);
        System.out.println("请添加商品进价：");
        Scanner goodsIP = new Scanner(System.in);
        Double goodsIP1 = goodsIP.nextDouble();
        goodsImportPrice.add(goodsIP1);
        System.out.println("请添加商品零售价：");
        Scanner goodsEP = new Scanner(System.in);
        Double goodsEP1 = goodsEP.nextDouble();
        goodsExitPrice.add(goodsEP1);
        System.out.println("请添加商品数量：");
        Scanner goodsCt = new Scanner(System.in);
        int goodsCt1 = goodsCt.nextInt();
        goodsCount.add(goodsCt1);
        System.out.println("该商品已经添加完毕，是否继续");
        System.out.println("\t1--继续\n\t2--退出");
        Scanner choose = new Scanner(System.in);
        int select = choose.nextInt();
        switch (select) {
            case 1:
                System.out.println("\n添加下一件商品：");
                addGoods();
                break;
            case 2:
                admin.goodsManage();
                break;
        }

    }

    //修改商品信息
    public void modifyGoodsInformation() {
        addGoods0();
        System.out.println("****你现在正在执行商品信息修改操作****");
        System.out.println("请输入商品名进行修改：");
        Scanner gdsName = new Scanner(System.in);
        String gdName = gdsName.next();
        int adds = goodsName.indexOf(gdName);//定位商品地址
        if (goodsName.contains(gdName)) {
            System.out.println("请选择需要修改的商品信息：");
            System.out.println("\t1--商品编号");
            System.out.println("\t2--商品名称");
            System.out.println("\t3--生产厂家");
            System.out.println("\t4--生产日期");
            System.out.println("\t5--产品型号");
            System.out.println("\t6--进货价");
            System.out.println("\t7--零售价");
            System.out.println("\t8--商品数量");
            Scanner sel = new Scanner(System.in);
            int sel1 = sel.nextInt();
            switch (sel1) {
                case 1://修改商品编号
                    System.out.println("请输入修改后的商品编号：");
                    Scanner alt = new Scanner(System.in);
                    int alter = alt.nextInt();
                    goodsNumber.set(adds, alter);
                    break;
                case 2://修改商品名称
                    System.out.println("请输入修改后的商品名称：");
                    Scanner alt1 = new Scanner(System.in);
                    String alter1 = alt1.next();
                    goodsName.set(adds, alter1);
                    break;
                case 3://修改商品生产厂家
                    System.out.println("请输入新的商品厂家：");
                    Scanner alt2 = new Scanner(System.in);
                    String alter2 = alt2.next();
                    goodsManufacturer.set(adds, alter2);
                    break;
                case 4://修改生产日期
                    System.out.println("请输入新的生产日期：");
                    Scanner alt3 = new Scanner(System.in);
                    String alter3 = alt3.next();
                    goodsDateOfProduction.set(adds, alter3);
                    break;
                case 5://修改产品型号
                    System.out.println("请输入修改后的产品型号：");
                    Scanner alt4 = new Scanner(System.in);
                    String alter4 = alt4.next();
                    goodsTypes.set(adds, alter4);
                    break;
                case 6://修改商品进价
                    System.out.println("请输入修改后的商品进价：");
                    Scanner alt5 = new Scanner(System.in);
                    double alter5 = alt5.nextDouble();
                    goodsImportPrice.set(adds, alter5);
                    break;
                case 7://修改商品零售价
                    System.out.println("请输入修改后的商品零售价：");
                    Scanner alt6 = new Scanner(System.in);
                    double alter6 = alt6.nextDouble();
                    goodsImportPrice.set(adds, alter6);
                    break;
                case 8://修改商品数量
                    System.out.println("请输入修改后的商品零售价：");
                    Scanner alt7 = new Scanner(System.in);
                    int alter7 = alt7.nextInt();
                    goodsCount.set(adds, alter7);
                    break;
            }
            //判断是否继续重复这个操作
            System.out.println("是否继续修改？");
            System.out.println("\t1--是\n\t2--否");
            Scanner chic = new Scanner(System.in);
            int choice = chic.nextInt();
            switch (choice) {
                case 1:
                    modifyGoodsInformation();
                    break;
                case 2:
                    break;
            }
        } else {
            System.out.println("商品名不正确或商品不存在，重试1,返回上一级2：");
            Scanner choose1 = new Scanner(System.in);
            int select = choose1.nextInt();
            switch (select) {
                case 1:
                    modifyGoodsInformation();
                    break;
                case 2:
                    admin.goodsManage();
                    break;
            }

        }
    }

    //删除商品
    public void deleteGoodsInformation() {
        addGoods0();
        System.out.println("****你正在执行商品删除操作：****");
        System.out.println("请输入商品名进行删除：");
        Scanner gdName = new Scanner(System.in);
        String gdsName = gdName.next();
        int address = goodsName.indexOf(gdsName);//定位商品在商品库中的位置
        System.out.println("该操作执行后被删除的数据不可恢复，是否继续？");
        System.out.println("\t1--继续\n\t2--退出");
        Scanner choose = new Scanner(System.in);
        int choose1 = choose.nextInt();
        switch (choose1) {
            case 1:
                if (goodsName.contains(gdsName)) {
                    goodsNumber.remove(address);
                    goodsName.remove(address);
                    goodsManufacturer.remove(address);
                    goodsDateOfProduction.remove(address);
                    goodsTypes.remove(address);
                    goodsImportPrice.remove(address);
                    goodsExitPrice.remove(address);
                    goodsCount.remove(address);
                    System.out.println("商品已成功删除！");
                    System.out.println("是否继续删除操作？");
                    System.out.println("\t1--是\n\t2--否");
                    Scanner chic1 = new Scanner(System.in);
                    int choice1 = chic1.nextInt();
                    switch (choice1) {
                        case 1:
                            deleteGoodsInformation();
                            break;
                        case 2:
                            break;
                    }
                } else {
                    System.err.println("商品名不正确或商品不存在，请重试。");
                    modifyGoodsInformation();
                }
                break;
            case 2:
                break;
        }
        admin.goodsManage();
    }

    //罗列商品
    public void showAllGoodsToAdmin() {
        Goods goods1 = new Goods();
        addGoods0();
        goods1.showAllGoods();//调用goods类的方法罗列出所有商品信息
        System.out.println("进价：" + goodsExitPrice);//显示进价，此栏仅为管理员展示
        admin.goodsManage();
    }

}