package com.part2;

import com.part2.imp.Subject;

public class Buyer implements Subject {
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void buy(int money) {
        System.out.println("--success--"+ money);
    }
}
