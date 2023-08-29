package org.example;

import java.util.Scanner;

public class Admin extends User {
    //管理员登录:admin，密码为ynuinfo#777
    String name1 = "admin";
    String passWord1 = "ynuinfo#777";

    public void singIn() {
        System.out.println("请输入您的密码：");
        Scanner psa = new Scanner(System.in);
        String passWorda1 = psa.next();
        if (passWorda1.equals(passWord1)) {
            System.out.println("登陆成功！");
            adminTrend();
        } else {
            System.out.println("密码错误！请重新输入。");
            singIn();
        }
    }

    public void adminTrend() {

        System.out.println("\n请选择您接下来的操作：");
        System.out.println("============================");
        System.out.println("\t1--修改管理员密码");
        System.out.println("\t2--重置客户密码");
        System.out.println("\t3--客户管理");
        System.out.println("\t4--商品管理");
        System.out.println("\t5--退出");
        System.out.println("============================");
        Scanner trd1 = new Scanner(System.in);
        int trend1 = trd1.nextInt();
        switch (trend1) {
            //修改管理员密码
            case 1:
                setSelfPassWord();
                adminTrend();
                break;
            //修改客户密码
            case 2:
                changeCustomerPassword();
                adminTrend();
                break;
            //客户管理
            case 3:
                customerManagement();
                adminTrend();
                break;
            //商品管理
            case 4:
                goodsManage();
                adminTrend();
                break;
            case 5:
                main(null);
                break;
        }
    }

    //修改自身密码
    public String setSelfPassWord() {
        System.out.println("正在修改管理员密码！");
                System.out.println("请输入修改后的密码：");
                Scanner newPw = new Scanner(System.in);
                String newPassWord = newPw.next();
                System.out.println("请再次输入密码确认：");
                Scanner newPw1 = new Scanner(System.in);
                String newPassWord1 = newPw1.next();
                if (newPassWord.equals(newPassWord1)) {
                    passWord1=newPassWord1;
                    System.out.println("密码修改成功！");
                    System.out.println("是否查看新密码：\n\t1--是\n\t0--否");
                    Scanner choose = new Scanner(System.in);
                    int choose1 = choose.nextInt();
                    switch (choose1) {
                        case 1:
                            System.out.println(passWord1);
                            this.singIn();
                            break;
                        case 0:
                            this.singIn();
                            break;
                    }
                } else {
                    System.out.println("两次密码不一致，请检查后再次输入！");
                    return setSelfPassWord();
                }
        return setSelfPassWord();
    }


//修改用户密码
    public String changeCustomerPassword() {
        Customer customer = new Customer();
        customer.addCustomer0();
        System.out.println("正在重置用户密码！");
        System.out.println("请输入需要重置密码用户的用户名：");
        Scanner nma = new Scanner(System.in);
        String nameS = nma.next();
        int address = customer.customerName.indexOf(nameS);//定位用户地址
        try {
            if (customer.customerName.contains(nameS)) {
                Scanner newPw = new Scanner(System.in);
                String newPassWord ="Yh123456";
                    customer.cusPassword.set(address, newPassWord);
                    System.out.println("密码重置成功！");
                    this.adminTrend();
                    }
            else {
                System.out.println("用户名输入错误或用户不存在，请检查后再次输入");
                return changeCustomerPassword();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return changeCustomerPassword();
    }

    //客户管理
    public void customerManagement() {
        System.out.println("\n请选择你要执行的操作：");
        System.out.println("============================");
        System.out.println("\t1--罗列客户");
        System.out.println("\t2--删除客户");
        System.out.println("\t3--搜索客户");
        System.out.println("\t4--返回");
        System.out.println("============================");
        CustomerMg manage = new CustomerMg();
        Scanner opr = new Scanner(System.in);
        int operate = opr.nextInt();
        switch (operate) {
            case 1:
                //罗列客户
                manage.showCustomer();
                customerManagement();
                break;
            case 2:
                //删除客户
                manage.deleteCustomer();
                customerManagement();
                break;
            case 3:
                //搜索客户
                manage.searchCustomer();
                customerManagement();
                break;
            case 4:
                //搜索客户
                adminTrend();
                customerManagement();
                break;
        }
    }

    //商品管理
    public void goodsManage() {
        CommodityMg commodity = new CommodityMg();
        System.out.println("\n请选择你要执行的操作：");
        System.out.println("============================");
        System.out.println("\t1--添加商品信息");
        System.out.println("\t2--修改商品信息");
        System.out.println("\t3--删除商品信息");
        System.out.println("\t4--罗列商品");
        System.out.println("\t5--返回");
        System.out.println("============================");
        Goods good=new Goods();
        good.addGoods0();
        Scanner choose = new Scanner(System.in);
        int choose1 = choose.nextInt();
        switch (choose1) {
            //添加商品信息
            case 1:
                commodity.addGoods();
                goodsManage();
                break;
            //修改商品信息
            case 2:
                commodity.modifyGoodsInformation();
                goodsManage();
                break;
            //删除商品信息
            case 3:
                commodity.deleteGoodsInformation();
                goodsManage();
                break;
            //罗列商品
            case 4:
                commodity.showAllGoodsToAdmin();
                goodsManage();
                break;
            //返回
            case 5:
                this.adminTrend();
                break;
        }
    }
}