package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformation extends Pay {//记录客户个人信息
    //客户ID、用户名、用户级别（金牌客户、银牌客户、铜牌客户）、用户注册时间、客户累计消费总金额、用户手机号、用户邮箱；
    ArrayList<String> customerGrade = new ArrayList<>();//用户级别
    ArrayList<String> registrationTime = new ArrayList<>();//用户注册时间
    ArrayList<String> customerPhoneNumber = new ArrayList<>();//用户手机号
    ArrayList<String> customerEmail = new ArrayList<>();//用户邮箱
    ArrayList<String> customerID=new ArrayList<>();//用户ID
    //设置用户ID
    public void setCustomerID() {
        try{
            customerID = (ArrayList<String>) customerPhoneNumber.clone();
            System.out.println("ID:"+customerID);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    //绑定手机号
    public void bindMobilePhoneNumber() {
        customerPhoneNumber.add("11122233344");
        System.out.println("请输入您的手机号进行绑定：");
        Scanner phn = new Scanner(System.in);
        String phoneNumber = phn.next();
        if (customerPhoneNumber.contains(phoneNumber)) {
            System.out.println("该号码已经被注册！请换个号码重试");
            bindMobilePhoneNumber();
        } else {
            customerPhoneNumber.add(phoneNumber);
            System.out.println("号码绑定成功");
        }

    }

    //绑定邮箱
    public void bindEmail() {
        customerEmail.add("yun.1923");
        System.out.println("请输入您的邮箱账号进行绑定：");
        Scanner phn = new Scanner(System.in);
        String emailInput = phn.next();
        if (customerPhoneNumber.contains(emailInput)) {
            System.out.println("该号码已经被注册！请换个号码重试");
            bindMobilePhoneNumber();
        } else {
            customerPhoneNumber.add(emailInput);
            System.out.println("号码绑定成功");
        }
    }

    //统计总花销
    public void statisticalConsumptionAmount() {
        super.costTotal.add(total);
        System.out.println("总消费："+costTotal);
    }

    //判断客户级别
    public void grade() {
        people.addCustomer0();
        this.statisticalConsumptionAmount();
        double customerCost = costTotal.get(super.adds);
        //金牌客户、银牌客户、铜牌客户
        if (customerCost >= 0.0 && customerCost < 1000.0) {
            customerGrade.add("铜牌客户");
            System.out.println("客户级别："+customerGrade.get(super.adds));
        }
        if (customerCost >= 1000.0 && customerCost < 5000.0) {
            customerGrade.add("银牌客户");
            System.out.println("客户级别："+customerGrade.get(super.adds));
        }
        if (customerCost >= 5000.0) {
            customerGrade.add("金牌客户");
            System.out.println("客户级别："+customerGrade.get(super.adds));
        }
        if(costTotal.get(super.adds)==null){
            customerGrade.add("铜牌客户");
            System.out.println("客户级别："+customerGrade.get(super.adds));
        }
    }
    //用户注册时间已经在customer类中解决

    //从文本文档里面获取用户数据
    public void acquireCustomerDate(){
        try{
            BufferedReader bfr = new BufferedReader(new FileReader("D:\\Java_exciese\\M1.1\\src\\test\\客户ID.txt"));
            BufferedReader bfr2 = new BufferedReader(new FileReader("D:\\Java_exciese\\M1.1\\src\\test\\用户级别.txt"));
            BufferedReader bfr4 = new BufferedReader(new FileReader("D:\\Java_exciese\\M1.1\\src\\test\\客户累计消费总金额.txt"));
            BufferedReader bfr5 = new BufferedReader(new FileReader("D:\\Java_exciese\\M1.1\\src\\test\\用户手机号.txt"));
            BufferedReader bfr6 = new BufferedReader(new FileReader("D:\\Java_exciese\\M1.1\\src\\test\\用户邮箱.txt"));

            String str;
            while ((str = bfr.readLine()) != null) {
                customerID.add(str);
            }
            while ((str = bfr2.readLine()) != null) {
                customerGrade.add(str);
            }
            while ((str = bfr4.readLine()) != null) {
                costTotal.add(Double.parseDouble(str));
            }
            while ((str = bfr5.readLine()) != null) {
                customerPhoneNumber.add(str);
            }
            while ((str = bfr6.readLine()) != null) {
                customerEmail.add(str);
            }
            bfr.close();
            bfr2.close();
            bfr4.close();
            bfr5.close();
            bfr6.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //把本次程序运行的数据存储至文本文档
    //当前为重写模式
    public void storageCustomerDate(){
        try{
            //客户ID、用户名、用户级别（金牌客户、银牌客户、铜牌客户）、用户注册时间、客户累计消费总金额、用户手机号、用户邮箱；
            BufferedWriter ID = new BufferedWriter(new FileWriter("D:\\Java_exciese\\M1.1\\src\\test\\客户ID.txt"));
            BufferedWriter grade = new BufferedWriter(new FileWriter("D:\\Java_exciese\\M1.1\\src\\test\\用户级别.txt"));
            BufferedWriter costs = new BufferedWriter(new FileWriter("D:\\Java_exciese\\M1.1\\src\\test\\客户累计消费总金额.txt"));
            BufferedWriter phone = new BufferedWriter(new FileWriter("D:\\Java_exciese\\M1.1\\src\\test\\用户手机号.txt"));
            BufferedWriter email = new BufferedWriter(new FileWriter("D:\\Java_exciese\\M1.1\\src\\test\\用户邮箱.txt"));
            for (String i : customerID) {
                ID.write(i);
                ID.newLine();
                ID.flush();
            }
            for (String i : customerGrade) {
                grade.write(i);
                grade.newLine();
                grade.flush();
            }
            for (double i : costTotal) {
                costs.write(String.valueOf(i));
                costs.newLine();
                costs.flush();
            }
            for (String i : customerPhoneNumber) {
                phone.write(i);
                phone.newLine();
                phone.flush();
            }
            for (String i : customerEmail) {
                email.write(i);
                email.newLine();
                email.flush();
            }


            ID.close();
            grade.close();
            costs.close();
            phone.close();
            email.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
