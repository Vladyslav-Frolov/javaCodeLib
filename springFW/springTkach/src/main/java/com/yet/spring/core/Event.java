package com.yet.spring.core;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.id = randomIntFromNumberOfDigits(5);
        this.date = date;
        this.df = df;
    }

    public Event() {
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    static int randomIntFromNumberOfDigits(int numberOfDigits) {
        Random random = new SecureRandom();
        numberOfDigits = (int) Math.pow(10, numberOfDigits - 1.);
        if (numberOfDigits == 1) {
            return random.nextInt(10);
        }

        return random.nextInt(9 * numberOfDigits) + numberOfDigits;
    }



    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
