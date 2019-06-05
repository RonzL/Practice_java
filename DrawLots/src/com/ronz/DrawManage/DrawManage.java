package com.ronz.DrawManage;

import com.ronz.Student.Student;
import java.lang.reflect.Array;

import java.util.*;

public class DrawManage {

    private int[] arr = new int[1000];                          // 存放生成的随机数
    private Random random = new Random();
    ArrayList<Student> arrayList = new ArrayList<>();           // 存放 Student 对象
    TreeSet<Student> treeSet = new TreeSet<>();       // 排序用的集合

    /**
     * 生成随机数函数
     * */
    public int GenerateRan(){
        int ranNum = random.nextInt(100);

        return ranNum;
    }

    /**
     * 将随机数赋值给 ID
     * */
    public void Draw(ArrayList<Student> arrayList){
        this.arrayList = arrayList;
        for (int i = 0; i < this.arrayList.size(); i++){
            this.arr[i] = GenerateRan();
            this.arrayList.get(i).setId(this.arr[i]);                  // 将随机数赋值给 ID
        }
    }

    /**
     * 将 Student 对象通过ID大小排序
     * */
    public void sortById(){

        treeSet.addAll(arrayList);
        arrayList.clear();
        arrayList.addAll(treeSet);
        treeSet.clear();

        /*int len = arrayList.size();
        int[] newArr = Arrays.copyOf(arr,len);
        Arrays.sort(newArr);
        for (int i = 0; i < len; i++){
            Iterator iterator = arrayList.iterator();               // 使用迭代器
            while (iterator.hasNext()){
                Student student = (Student) iterator.next();
                if (student.getId()==newArr[i]&&!drawArrayList.contains(student))  // 判断对象的ID是否和排序后的数组元素相同 以及 对象是否已经添加
                    drawArrayList.add(student);
            }*/

            /*for (int j = 0; j < arrayList.size(); j++){           // 使用for循环给 drawArrayList 添加排序后的对象
                if(arrayList.get(j).getId()==newArr[i]){
                    drawArrayList.add(arrayList.get(j));
                    arrayList.remove(j);
                }
            }*/
    }

    public ArrayList<Student> getArrayList() {
        return arrayList;
    }
}
