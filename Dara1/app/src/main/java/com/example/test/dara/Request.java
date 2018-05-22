package com.example.test.dara;

public class Request {

    private final int user_id;
    private final int request_id;
    private String start;
    private String end;
    private int size;
    private int due_date;
    private int offer;
    private final int creation_dt;
    private int matched_dt;

    Request (int user, int request, int creation_dt) {
        this.user_id = user;
        this.request_id = request;
        this.creation_dt = creation_dt;
    }

    void setStart(String address) {this.start = address;}
    void setEnd(String address) {this.end = address;}
    void setSize(int size) {this.size = size;}
    void setDueDate(int date) {this.due_date = date;}
    void setOffer(int offer) {this.offer = offer;}
    void setMatchDate(int date) {this.matched_dt = date;}

    int getUser() { return this.user_id;}
    int getRequest() {return this.request_id;}
    String getStart() {return this.start;}
    String getEnd() {return this.end;}
    int getSize() {return this.size;}
    int getDueDate() {return this.due_date;}
    int getOffer() {return this.offer;}
    int getCreationDate() {return this.creation_dt;}
    int getMatchDate() {return this.matched_dt;}
}
