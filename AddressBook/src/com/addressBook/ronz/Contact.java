package com.addressBook.ronz;

public class Contact {
    private String contaName;
    private String contaNumber;
    private String contaEmail;
    private String groupName;

    public Contact(String contaName,String contaNumber,String contaEmail,String groupName){

        this.contaName = contaName;
        this.contaNumber = contaNumber;
        this.contaEmail = contaEmail;
        this.groupName = groupName;
    }

    public Contact(){

    }
    public String getContaName() {
        return contaName;
    }

    public void setContaName(String contaName) {
        this.contaName = contaName;
    }

    public String getContaNumber() {
        return contaNumber;
    }

    public void setContaNumber(String contaNumber) {
        this.contaNumber = contaNumber;
    }

    public String getContaEmail() {
        return contaEmail;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setContaEmail(String contaEmail) {
        this.contaEmail = contaEmail;
    }

    @Override
    public String toString() {
        return "联系人" +
                "姓名='" + contaName + '\'' +
                ", 号码='" + contaNumber + '\'' +
                ", 邮箱='" + contaEmail + '\'' +
                ", 【分组】='" + groupName + '\'';
    }
}
