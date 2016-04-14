package com.epam.springadvanced.entity;

import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.epam.com/event")
public class Seat {
    private int number;
    private boolean vip;

    public Seat(int number, boolean vip) {
        this.number = number;
        this.vip = vip;
    }

    public Seat(int number) {
        this.number = number;
        this.vip = false;
    }

    public Seat() {}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
