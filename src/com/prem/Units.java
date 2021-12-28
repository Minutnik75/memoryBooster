package com.prem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Units {
  private
    List<Unit> unitList = new ArrayList<>();

    public Units() {
        try {
            if(loadFromDB())
                System.out.println("Data correctly imported from DB");
            else
                System.out.println("Data NOT correctly imported from DB");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

//    Load all unit from DateBase
    boolean loadFromDB() throws ParseException {

        //Test data preparation
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date last_rep_date = formatter.parse("2021-12-27");
        Date next_rep_date = formatter.parse("2021-12-28");

        Unit    unit1 = new Unit(1, "jeden",
                "one", last_rep_date, next_rep_date,1);
        unitList.add(unit1);

        Unit    unit2 = new Unit(2, "dwa",
                "two", last_rep_date, next_rep_date,1);
        unitList.add(unit2);

        Unit    unit3 = new Unit(3, "trzy",
                "three", last_rep_date, next_rep_date,1);
        unitList.add(unit3);

        Unit    unit4 = new Unit(4, "cztery",
                "four", last_rep_date, next_rep_date,1);
        unitList.add(unit4);

        Unit    unit5 = new Unit(5, "pięć",
                "five", last_rep_date, next_rep_date,1);
        unitList.add(unit5);

        Unit    unit6 = new Unit(6, "sześć",
                "six", last_rep_date, next_rep_date,1);
        unitList.add(unit6);

        Unit    unit7 = new Unit(7, "siedem",
                "seven", last_rep_date, next_rep_date,1);
        unitList.add(unit7);

        Unit    unit8 = new Unit(8, "osiem",
                "eigth", last_rep_date, next_rep_date,1);
        unitList.add(unit8);

        Unit    unit9 = new Unit(9, "dziewięć",
                "nigth", last_rep_date, next_rep_date,1);
        unitList.add(unit9);

        Unit    unit10 = new Unit(10, "dziesięć",
                "ten", last_rep_date, next_rep_date,1);
        unitList.add(unit10);

        return true;
    }

    void DisplayUnits() {
        System.out.println("DisplayBegin");
        for (Unit unit: unitList){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("id="+unit.getId() +
                    " q="+unit.getQuestion()+
                    " a="+unit.getAnswer()+
                    " lst="+dateFormat.format(unit.getLast_rep_date())+
                    " nxt="+dateFormat.format(unit.getNext_rep_date())+
                    " ef="+unit.getEasiness_factor()
            );
        }
        System.out.println("DisplayFinish");
    }
}
