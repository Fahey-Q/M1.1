package org.example;

import java.util.Scanner;

public class CustomerMg extends Customer {//客户管理
    PersonalInformation customerPersonalInformation=new PersonalInformation();//访问PersonalInformation类
    Admin admin = new Admin();
    public void ACust0(){
        addCustomer0();
        customerPersonalInformation. customerPhoneNumber.add("11122233344");
        super.customerSignInTime.add("2023-07-10-10-10-10");
        customerPersonalInformation.customerEmail.add("yun.1923");
    }


    //罗列出所有客户信息
    //客户信息包括：客户ID、用户名、用户级别（金牌客户、银牌客户、铜牌客户）、用户注册时间、客户累计消费总金额、用户手机号、用户邮箱；
    public void showCustomer() {
        ACust0();
        customerPersonalInformation.setCustomerID();//客户ID
        System.out.println("用户："+customerName);//用户名
        customerPersonalInformation.grade();//用户级别
        System.out.println("注册时间："+super.customerSignInTime);//用户注册时间
        customerPersonalInformation.statisticalConsumptionAmount();//客户累计消费总金额
        System.out.println("邮箱："+customerPersonalInformation.customerEmail);//用户邮箱
        System.out.println("手机号："+customerPersonalInformation.customerPhoneNumber);//用户手机号
    }

    //删除客户
    public void deleteCustomer() {
        ACust0();
        System.out.println("请输入用户名进行删除操作：");
        Scanner input=new Scanner(System.in);
        String input1=input.next();
        if(customerName.contains(input1)){
            System.out.println("你现在正在执行客户删除操作，是否继续？");
            System.out.println("\t1--是\n\t2--否");
            Scanner choose=new Scanner(System.in);
            int choose1=choose.nextInt();
            switch(choose1){
                case 1:
                    int address=customerName.indexOf(input1);//input1的索引位置
                    customerName.set(address,"null");//删除用户名
                    customerPersonalInformation.customerID.set(address,"null");//删除客户ID
                    customerPersonalInformation.customerGrade.set(address,"null");//删除客户级别
                    customerSignInTime.set(address,"null");//删除客户注册时间
                    customerPersonalInformation.costTotal.set(address,0.0);//删除客户花销
                    customerPersonalInformation.customerEmail.set(address,"null");//删除客户邮箱
                    customerPersonalInformation.customerPhoneNumber.set(address,"null");//删除客户手机号
                    System.out.println("\t客户已删除。");
                    break;
                case 2:
                    break;
            }
        }else{
            System.err.println("查询不到该用户的相关信息!");
        }
    }
    //搜索客户
    //可以根据客户ID或者客户的用户名进行查询，也可以一次查询所有客户的信息。
    public void searchCustomer(){
        ACust0();
        System.out.println("请选择查询方式：");
        System.out.println("\t1--通过客户ID进行查询\n\t2--通过客户的用户名进行查询");
        Scanner input=new Scanner(System.in);
        int input1=input.nextInt();
        switch(input1){
            case 1: //根据客户ID进行查询
                System.out.println("请输入客户ID：");
                Scanner inputs=new Scanner(System.in);
                String inputs1=inputs.next();
                if(customerPersonalInformation.customerID.contains(inputs1)) {
                    int address=customerPersonalInformation.customerID.indexOf(inputs1);//input1的索引位置
                    System.out.println("客户ID："+inputs1);//客户ID
                    System.out.println("用户名："+customerName.get(address));//用户名
                    System.out.println("用户级别："+customerPersonalInformation.customerGrade.get(address));//用户级别
                    System.out.println("用户注册时间："+customerPersonalInformation.registrationTime.get(address));//用户注册时间
                    System.out.println("用户消费总金额："+customerPersonalInformation.costTotal.get(address));//客户累计消费总金额
                    System.out.println("用户邮箱："+customerPersonalInformation.customerEmail.get(address));//用户邮箱
                    System.out.println("用户手机号："+customerPersonalInformation.customerPhoneNumber.get(address));//用户手机号
                }else {
                    System.out.println("用户ID错误或用户不存在！");
                    searchCustomer();
                }
                break;
            case 2://根据用户名进行查询
                System.out.println("请输入客户的用户名：");
                Scanner inputs3=new Scanner(System.in);
                String inputs2=inputs3.next();
                if(customerName.contains(inputs2)) {
                    int address1=customerName.indexOf(inputs2);//inputs2的索引位置
                    System.out.println("客户ID："+customerPersonalInformation.customerID.get(address1));//客户ID
                    System.out.println("用户名："+inputs2);//用户名
                    System.out.println("用户级别："+customerPersonalInformation.customerGrade.get(address1));//用户级别
                    System.out.println("用户注册时间："+customerPersonalInformation.registrationTime.get(address1));//用户注册时间
                    System.out.println("用户消费总金额："+customerPersonalInformation.costTotal.get(address1));//客户累计消费总金额
                    System.out.println("用户邮箱："+customerPersonalInformation.customerEmail.get(address1));//用户邮箱
                    System.out.println("用户手机号："+customerPersonalInformation.customerPhoneNumber.get(address1));//用户手机号
                }else {
                    System.out.println("用户名输入错误或用户不存在！");
                    searchCustomer();
                }
                break;
        }
    }
}