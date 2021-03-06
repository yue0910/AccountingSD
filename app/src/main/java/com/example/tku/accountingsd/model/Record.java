package com.example.tku.accountingsd.model;

public class Record {
    long id;
    String title;
    String date;
    Float money;
    int exp_inc;
    int type;

    public Record(String title, String date, Float money, int type) {
        this.title = title;
        this.date = date;
        this.money = money;
        this.type = type;
    }


    public Record(String title, String date, Float money, int type, int exp_inc) {
        this.title = title;
        this.date = date;
        this.money = money;
        this.type = type;
        this.exp_inc = exp_inc;
    }

    public Record() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getMoney() {
        return this.money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getExp_inc() {
        return exp_inc;
    }

    public void setExp_inc(int exp_inc) {
        this.exp_inc = exp_inc;
    }
}
