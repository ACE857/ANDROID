package com.example.ace.park;

public class model {
    public String name,num,type,sno;


    public model(String name, String num, String type, String sno) {
        this.name = name;
        this.num = num;
        this.type = type;
        this.sno = sno;
    }

    public model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
