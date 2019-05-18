package com.addressBook.ronz;

import java.util.ArrayList;
import java.util.Scanner;


public class Group {
    private String groupName;
    private ArrayList<Contact> arrayList = new ArrayList();
    private Scanner input = new Scanner(System.in);

    public Group(String groupName){
        this.groupName = groupName;
    }

    public Group(){

    }

    /**
     * 添加联系人
     * */
    public void addConta(String contaName,String contaNumber,String contaEmail,String groupName){

        Contact contact = new Contact(contaName,contaNumber,contaEmail,groupName);
        arrayList.add(contact);
        System.out.println(contact.getContaName()+" 的信息添加成功");
        System.out.println("添加的信息为：" + contact);
    }

    /**
     *
     * 删除某个联系人
     *
     * 找到联系人并删除则返回 true
     * 否则返回 false
     * */
    public boolean delConta(String delName){

        for (Contact eachCon:arrayList){
            if (eachCon.getContaName().equals(delName)){
                arrayList.remove(eachCon);
                return true;
            }
        }
        return  false;
    }

    public ArrayList<Contact> getArrayList() {
        return arrayList;
    }

    /**
     * 查找联系人
     * */
    public Contact searchCon(String seaInfo){

        for (Contact eachCon:arrayList){

            if ((eachCon.getContaName().contains(seaInfo))||(eachCon.getContaEmail().contains(seaInfo))
            ||(eachCon.getContaNumber().contains(seaInfo))){

                return eachCon;
            }
        }
        return null;
    }
}
