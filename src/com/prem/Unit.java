package com.prem;

import java.util.Date;

public class Unit {
    private
    long    id;
    String  question;
    String  answer;
    int     interval;           //interval i(1)=1, i(2)=6, dla i>2 i(n)=i(n-1)*EF
    Date    repetitionDate;      //next repetition date
    double  easinessFactor;

    public Unit(long id, String question, String answer, int interval, Date repetitionDate, double easinessFactor) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.interval = interval;
        this.repetitionDate = repetitionDate;
        this.easinessFactor = easinessFactor;
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

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public Date getRepetitionDate() {
        return repetitionDate;
    }

    public void setRepetitionDate(Date repetitionDate) {
        this.repetitionDate = repetitionDate;
    }

    public double getEasinessFactor() {
        return easinessFactor;
    }

    public void setEasinessFactor(double easinessFactor) {
        this.easinessFactor = easinessFactor;
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
