package com.prem;

import java.util.Calendar;


public class Unit {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    private
    long id;
    boolean isVerbIrregular;
    boolean isTaught;

    String question;
    String question1;
    String question2;

    String answer;         //ENG - present             //ESP - indicativo (infitive)
    String answer1;        //ENG - past                //ESP - yo
    String answer2;        //ENG - past participle     //ESP - tú
    String answer3;                                    //ESP - él, ella, usted
    String answer4;                                    //ESP - nosotros/as
    String answer5;                                    //ESP - vosotros/as
    String answer6;                                    //ESP - ellos/ellas/ustedes

    int interval;                //interval i(1)=1, i(2)=6, dla i>2 i(n)=i(n-1)*EF
    Calendar repetitionDate;     //next repetition date
    double easinessFactor;

    public Unit(long id, boolean isTaught, boolean isVerbIrregular, String question, String question1, String question2,
                String answer, String answer1, String answer2, String answer3, String answer4, String answer5, String answer6,
                int interval, Calendar repetitionDate, double easinessFactor) {
        this.id = id;
        this.isTaught=isTaught;
        this.isVerbIrregular = isVerbIrregular;
        this.question = question;
        this.question1 = question1;
        this.question2 = question2;
        this.answer = answer;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.answer6 = answer6;
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

    public Calendar getRepetitionDate() {
        return repetitionDate;
    }

    public void setRepetitionDate(Calendar repetitionDate) {
        this.repetitionDate = repetitionDate;
    }

    public double getEasinessFactor() {
        return easinessFactor;
    }

    public void setEasinessFactor(double easinessFactor) {
        this.easinessFactor = easinessFactor;
    }


    public boolean isVerbIrregular() {
        return isVerbIrregular;
    }

    public void setVerbIrregular(boolean verbIrregular) {
        isVerbIrregular = verbIrregular;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public void setAnswer6(String answer6) {
        this.answer6 = answer6;
    }

    public void displayUnit() {
        this.displayAnswer();
        System.out.println("isTaught:       " + isTaught);
        System.out.println("isVerbIrregular:" + isVerbIrregular);
        System.out.println("interval:       " + interval);
        if(repetitionDate==null)
            System.out.println("repetitionDate: NULL");
        else
            System.out.println("repetitionDate: " + repetitionDate.getTime());
        System.out.println("easinessFactor: " + easinessFactor);
    }

    public void displayQuestion()
    {
        System.out.println();
        System.out.println("==================================================");
//        System.out.println("id="+id);
        System.out.println("q="+ANSI_YELLOW+question+ANSI_RESET);
        if (!question1.equals(""))
            System.out.println("q="+ANSI_YELLOW+question1+ANSI_RESET);
        if (!question2.equals(""))
            System.out.println("q="+ANSI_YELLOW+question2+ANSI_RESET);
        if(isVerbIrregular)
            System.out.println(ANSI_YELLOW+"Irregular verb"+ANSI_RESET);
        System.out.println("--------------------------------------------------");
    }

    public void displayAnswer()
    {
        System.out.println("--------------------------------------------------");
//        System.out.println("id="+id);
        System.out.println("q="+ANSI_YELLOW+question+ANSI_RESET);
        if (!question1.equals(""))
            System.out.println("q="+ANSI_YELLOW+question1+ANSI_RESET);
        if (!question2.equals(""))
            System.out.println("q="+ANSI_YELLOW+question2+ANSI_RESET);
        System.out.println("a="+ANSI_GREEN+answer+ANSI_RESET);
        if(isVerbIrregular)
        {
            System.out.println(ANSI_GREEN+answer1+"\t\t"+answer4+ANSI_RESET);
            System.out.println(ANSI_GREEN+answer2+"\t\t"+answer5+ANSI_RESET);
            System.out.println(ANSI_GREEN+answer3+"\t\t"+answer6+ANSI_RESET);
        }
        else
        {
            if (!answer1.equals(""))
                System.out.println("a="+ANSI_GREEN+answer1+ANSI_RESET);
            if (!answer2.equals(""))
                System.out.println("a="+ANSI_GREEN+answer2+ANSI_RESET);
            if (!answer3.equals(""))
                System.out.println("a="+ANSI_GREEN+answer3+ANSI_RESET);
            if (!answer4.equals(""))
                System.out.println("a="+ANSI_GREEN+answer4+ANSI_RESET);
            if (!answer5.equals(""))
                System.out.println("a="+ANSI_GREEN+answer5+ANSI_RESET);
            if (!answer6.equals(""))
                System.out.println("a="+ANSI_GREEN+answer6+ANSI_RESET);
        }

        System.out.println("--------------------------------------------------");
    }

    public boolean isTaught() {
        return isTaught;
    }

    public void setTaught(boolean taught) {
        isTaught = taught;
    }
}