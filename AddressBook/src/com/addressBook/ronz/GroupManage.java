package com.addressBook.ronz;

import java.util.HashMap;
import java.util.Scanner;

public class GroupManage {

    private static HashMap hashMap = new HashMap();
    private Scanner input = new Scanner(System.in);
    private Contact searInfo = null;

    /**
     * 创建了一个新的分组
     *
     * */
    public void addGroup(){
        System.out.println("请输入您要添加的组的名称");
        String groupName = input.next();
        Group group = new Group(groupName);
        hashMap.put(groupName,group);
        System.out.println("分组"+ groupName + "创建成功！");
    }


    /**
     * 删除某个分组
     * */
    public boolean delGroup(String delname){

        for (Object eachGroup:hashMap.keySet()){

            if (eachGroup.equals(delname)){
                hashMap.remove(delname);
                return true;                //找到指定分组，删除成功
            }
        }
        return  false;                  //没有找到指定分组 删除失败
    }

    /**
     * 查找某个联系人
     * */
    public boolean searCon(String conInfo){

        for (Object eachGroup:hashMap.keySet()){

            Group group = (Group) hashMap.get(eachGroup);
            if(group.searchCon(conInfo)!=null) {
                this.searInfo = group.searchCon(conInfo);
                return true;
            }
        }
        this.searInfo = null;
        return false;
    }

    /**
     * 返回查找到的 联系人类
     * */
    public Contact getSearInfo() {
        return searInfo;
    }


    /**
     * 返回某个联系人分组
     *
     * */
    public Object getGroup(String groupName){
        if(hashMap.containsKey(groupName)){
            return hashMap.get(groupName);
        } else{

            return null;
        }
    }

    /**
     * 返回全部分组
     * */
    public HashMap getHashMap(){
        return hashMap;
    }

    /**
     * 打印所有分组
     * */
    public void printGroup(){

        if (hashMap.isEmpty()){
            System.out.println("当前没有分组！");
        } else{
            int i = 0;
            System.out.println("当前分组有：");
            for (Object eachGroup:hashMap.keySet())
                System.out.println("分组"+ (i++) + ": "+ eachGroup);
        }
    }
}
