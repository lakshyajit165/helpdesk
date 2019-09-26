package com.stackroute.helpdesk.commandDesignFramework;

public class Ticket {
    private int id;
    private String userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Ticket(int id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                '}';
    }
}
