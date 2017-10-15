package org.my.education.Domain;

import java.util.ArrayList;

public class Client {

    private long id;
    private ArrayList<Subscriber> subscribers = new ArrayList<>();
    private long spentTotal;
    private boolean isBig;

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public ArrayList<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public long getSpentTotal() {
        return spentTotal;
    }

    public void setSpentTotal(long spentTotal) {
        this.spentTotal = spentTotal;
    }

    public boolean isBig() {
        return isBig;
    }

    public void setBig(boolean big) {
        isBig = big;
    }

}

