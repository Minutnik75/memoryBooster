package com.prem;

import java.util.Date;

public class Unit {
    private
    long    id;
    String  question;
    String  answer;
    Date    last_rep_date;      //last repetition date
    Date    next_rep_date;      //next repetition date
    double  easiness_factor;

    public Unit(long id, String question, String answer, Date last_rep_date, Date next_rep_date, double easiness_factor) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.last_rep_date = last_rep_date;
        this.next_rep_date = next_rep_date;
        this.easiness_factor = easiness_factor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getLast_rep_date() {
        return last_rep_date;
    }

    public void setLast_rep_date(Date last_rep_date) {
        this.last_rep_date = last_rep_date;
    }

    public Date getNext_rep_date() {
        return next_rep_date;
    }

    public void setNext_rep_date(Date next_rep_date) {
        this.next_rep_date = next_rep_date;
    }

    public double getEasiness_factor() {
        return easiness_factor;
    }

    public void setEasiness_factor(double easiness_factor) {
        this.easiness_factor = easiness_factor;
    }

    /*
        I(1):=1
        I(2):=6
        for n>2: I(n):=I(n-1)*EF
        where:
        I(n) - inter-repetition interval after the n-th repetition (in days),
        EF - E-Factor of a given item
        If interval is a fraction, round it up to the nearest integer.
     */

}
