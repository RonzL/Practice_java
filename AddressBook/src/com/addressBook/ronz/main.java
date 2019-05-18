package com.addressBook.ronz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {

    private static Scanner input = new Scanner(System.in);
    private static GroupManage groupManage = new GroupManage();
    public static void main(String [] args){



        while(true) {

            showmenu();
            String choice = input.next();
            if (choice.equals("0")) {                                               //退出系统

                System.out.println("欢迎再次使用通信录，再见！");
                break;
            } else if (choice.equals("1")) {                                        //新建一个组

                groupManage.addGroup();
            } else if (choice.equals("2")) {                                        //删除一个组

                System.out.println("请输入要删除的分组的昵称：");
                String delName = input.next();
                if (groupManage.delGroup(delName))
                    System.out.println("分组 " + delName + "删除成功!");
                else
                    System.out.println("分组" + delName + "不存在！删除失败！");
            } else if (choice.equals("3")) {                                        //新建一个联系人

                System.out.println("请输入要新建联系人的组：");
                groupManage.printGroup();
                String groupName = input.next();
                Group group = (Group) groupManage.getGroup(groupName);              //可以看做是把地址给了group
                if (group==null){
                    System.out.println("分组"+ groupName + "不存在");
                    System.out.println("是否要创建分组 "+ groupName + " Y/N");
                    String flag = input.next();
                    if (flag.equals("Y")){

                        groupManage.addGroup();
                        group = (Group) groupManage.getGroup(groupName);
                    } else
                        continue;
                }
                System.out.println("请输入要添加的联系人的昵称：");
                String contaName = input.next();
                System.out.println("请输入联系人的号码：");
                String contaNumber = input.next();
                System.out.println("请输入联系人的邮箱：");
                String contaEmail = input.next();
                group.addConta(contaName, contaNumber, contaEmail, groupName);
            } else if (choice.equals("4")) {                                        //删除一个联系人

                System.out.println("请输入要删除的联系人的昵称：");
                String delName = input.next();
                if (groupManage.searCon(delName)){

                    Contact result = groupManage.getSearInfo();
                    Group resultGroup = (Group) groupManage.getGroup(result.getGroupName());
                    resultGroup.getArrayList().remove(result);
                    System.out.println("联系人 " + delName + "删除成功!");
                } else
                    System.out.println("联系人" + delName + "不存在！删除失败！");
            } else if (choice.equals("5")){                                         //显示所有联系人信息

                showAllCon();
            } else if (choice.equals("6")){                                         //查找联系人

                System.out.println("请输入要查找的联系人信息：");
                String info = input.next();
                if (groupManage.searCon(info)){

                    System.out.println("查找成功！");
                    System.out.println(groupManage.getSearInfo());
                } else
                    System.out.println("您要查找的联系人不存在！");
            }

        }
    }


    /**
     *
     *  显示菜单
     * */
    private static void showmenu(){
        System.out.println("================================");
        System.out.println("欢迎使用通讯录！");
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("1. 添加分组");
        System.out.println("2. 删除分组");
        System.out.println("3. 添加联系人");
        System.out.println("4. 删除联系人");
        System.out.println("5. 显示所有联系人");
        System.out.println("6. 查找联系人");
        System.out.println("0. 退出系统");
        System.out.println("================================");
    }

    /**
     * 显示所有联系人
     * */
    private static void showAllCon(){

        for (Object eachGroup:groupManage.getHashMap().keySet()){                       // 遍历所有的组
            Group group =(Group) groupManage.getGroup((String) eachGroup);              // 获取某个组
            System.out.println("分组:"+ eachGroup + " 有联系人：");
            for (Contact eachCon:group.getArrayList())          //遍历每个组中的所有联系人
            System.out.println(eachCon);
        }
    }
}
