package org.my.education.SubjectArea;

import java.util.ArrayList;

public class Client {

    private int id; // id клиента
    private ArrayList<Subscriber> subscribers = new ArrayList<>(); // список подписчиков клиента
    private int spentTotal; // общее количество потраченных средств
    private boolean isBig;

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public ArrayList<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public int getSpentTotal() {
        return spentTotal;
    }

    public void setSpentTotal(int spentTotal) {
        this.spentTotal = spentTotal;
    }

    public boolean isBig() {
        return isBig;
    }

    public void setBig(boolean big) {
        isBig = big;
    }

}

