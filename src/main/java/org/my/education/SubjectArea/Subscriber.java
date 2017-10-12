package org.my.education.SubjectArea;

public class Subscriber {
    private int id;    // id подписчика клиента
    private int spent; // количество потраченых средств

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpent() {
        return spent;
    }

    public void setSpent(int spent) {
        this.spent = spent;
    }
}
