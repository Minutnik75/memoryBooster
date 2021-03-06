package com.prem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

public class Units {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    public static final String ANSI_PURPLE = "\u001B[35m";
//    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static final String DATA_FILE_ENG_NAME="data_eng.txt";
    public static final String DATA_FILE_ESP_NAME="data_esp.txt";

    private final List<Unit> unitList = new ArrayList<>();
    private int totalUnitNumber=0;
    private int unitNumberToLearn=0;
    private String dataFileName="";
    private boolean isDataSaved=false;      //determine whether data has been saved or not

    private boolean isRepetitionDone=false; //determine whether repetition has been dane or not

    //Number of new units to learn - daily
    private static final int UNITS_TO_LEARN = 5;

    //How many time does unit needs to be repeated to be treated as learnt
    private static final int REP_TO_LEARN=3;

    //Constructor
    public Units() {
        try {
            if(loadFromDB())
                System.out.println("Data correctly imported from DB");
            else
                System.out.println("Data NOT correctly imported from DB");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Set total units number
        totalUnitNumber=totalUnits();
    }

    //Used in constructor to load data from DB
    boolean loadFromDB() throws ParseException {
        //  Load all unit from DateBase

        //Test data preparation
        Calendar rep_date = new GregorianCalendar(2021,Calendar.DECEMBER,28);

//        Unit    unit1 = new Unit(1, true, true, "ESP-robić", "", "",
//                "hacer", "hago", "haces", "hace", "hacemos", "hacéis", "hacen",
//                11, rep_date, 2.8);
//        unitList.add(unit1);
//
//        Unit    unit2 = new Unit(2, true, false, "dwa", "dwa_1", "",
//                "two", "", "", "", "", "", "",
//                11, rep_date, 2.8);
//        unitList.add(unit2);
//
//        rep_date = new GregorianCalendar(2021,Calendar.DECEMBER,27);
//
//        Unit    unit3 = new Unit(3, true, false, "trzy", "trzy_1", "trzy_2",
//                "three", "", "", "", "", "", "",
//                11, rep_date, 2.8);
//        unitList.add(unit3);
//
//        rep_date = new GregorianCalendar(2022,Calendar.MARCH,1);
//
//        Unit    unit4 = new Unit(4, true, false, "cztery", "", "",
//                "four", "", "", "", "", "", "",
//                1, rep_date, 2.3);
//        unitList.add(unit4);
//
//        Unit    unit5 = new Unit(5, true, false, "pięć", "", "",
//                "five", "", "", "", "", "", "",
//                1, rep_date, 2.3);
//        unitList.add(unit5);
//
//        Unit    unit6 = new Unit(6, true, false, "sześć", "", "",
//                "six", "", "", "", "", "", "",
//                1, rep_date, 1.3);
//        unitList.add(unit6);
//
//        Unit    unit7 = new Unit(7, true, false, "siedem", "", "",
//                "seven", "", "", "", "", "", "",
//                1, rep_date, 1.3);
//        unitList.add(unit7);
//
//        Unit    unit8 = new Unit(8, true, false, "osiem", "", "",
//                "eight", "", "", "", "", "", "",
//                1, rep_date, 1.3);
//        unitList.add(unit8);
//
//        Unit    unit9 = new Unit(9, true,  false, "dziewięć", "", "",
//                "nine", "", "", "", "", "", "",
//                1, rep_date, 1.3);
//        unitList.add(unit9);
//
//        Unit    unit10 = new Unit(10, false, false, "dziesięć", "", "",
//                "ten", "", "", "", "", "", "",
//                1, null, 1.3);
//        unitList.add(unit10);
//
//        Unit    unit11 = new Unit(11, true, false, "jedenaście", "", "",
//                "eleven", "", "", "", "", "", "",
//                1, rep_date, 1.3);
//        unitList.add(unit11);

//        Unit    unit1 = new Unit(1,false,true,"brać (też w znaczeniu pić, jeść)","","","tomar","tomo","tomas","toma","tomamos","tomáis","toman",1,null,1.3); unitList.add(unit1);
//        Unit    unit2 = new Unit(2,false,false,"wino","Nie pijam wina","","el vino","No bebo vino","","","","","",1,null,1.3); unitList.add(unit2);
//        Unit    unit3 = new Unit(3,false,false,"jeden","","","uno","","","","","","",1,null,1.3); unitList.add(unit3);
//        Unit    unit4 = new Unit(40,false,false,"dwa","","","dos","","","","","","",1,null,1.3); unitList.add(unit4);
//        Unit    unit5 = new Unit(5,false,false,"trzy ","","","tres","","","","","","",1,null,1.3); unitList.add(unit5);
//        Unit    unit6 = new Unit(6,false,false,"cztery","","","cuatro","","","","","","",1,null,1.3); unitList.add(unit6);
//        Unit    unit7 = new Unit(7,false,false,"pięć","","","cinco","","","","","","",1,null,1.3); unitList.add(unit7);
//        Unit    unit8 = new Unit(8,false,false,"sześć","","","seis","","","","","","",1,null,1.3); unitList.add(unit8);
//        Unit    unit9 = new Unit(9,false,false,"siedem","","","siete","","","","","","",1,null,1.3); unitList.add(unit9);
//        Unit    unit10 = new Unit(10,false,false,"osiem","","","ocho","","","","","","",1,null,1.3); unitList.add(unit10);
//        Unit    unit11 = new Unit(11,false,false,"dziewięć","","","nueve","","","","","","",1,null,1.3); unitList.add(unit11);
//        Unit    unit12 = new Unit(12,false,false,"dziesięć","Mam dziesięć lat","","diez","Tengo diez años","","","","","",1,null,1.3); unitList.add(unit12);
//        Unit    unit13 = new Unit(13,false,false,"jedenaście","","","once","","","","","","",1,null,1.3); unitList.add(unit13);
//        Unit    unit14 = new Unit(14,false,false,"dwanaście","","","doce","","","","","","",1,null,1.3); unitList.add(unit14);
//        Unit    unit15 = new Unit(15,false,false,"trzynaście","","","trece","","","","","","",1,null,1.3); unitList.add(unit15);
//        Unit    unit16 = new Unit(16,false,false,"czternaście","","","catorce","","","","","","",1,null,1.3); unitList.add(unit16);
//        Unit    unit17 = new Unit(17,false,false,"piętnaście","","","quince","","","","","","",1,null,1.3); unitList.add(unit17);
//        Unit    unit18 = new Unit(18,false,false,"szesnaście","","","dieciséis","","","","","","",1,null,1.3); unitList.add(unit18);
//        Unit    unit19 = new Unit(19,false,false,"siedemnaście","Mam siedemnaście lat","","diecisiete","Tengo diecisiete años","","","","","",1,null,1.3); unitList.add(unit19);
//        Unit    unit20 = new Unit(20,false,false,"osiemnaście","","","dieciocho","","","","","","",1,null,1.3); unitList.add(unit20);
//        Unit    unit21 = new Unit(21,false,false,"dziewiętnaście","","","diecinueve","","","","","","",1,null,1.3); unitList.add(unit21);
//        Unit    unit22 = new Unit(22,false,false,"dwadzieścia","On ma dwadzieścia lat","","veinte","Él tiene veinte años","","","","","",1,null,1.3); unitList.add(unit22);
//        Unit    unit23 = new Unit(23,false,false,"dwadzieścia jeden","Ona ma dwadzieścia jeden lat","","veintiuno","Ella tiene veintiun años","","","","","",1,null,1.3); unitList.add(unit23);
//        Unit    unit24 = new Unit(24,false,false,"dwadzieścia dwa","Mam dwadzieścia dwa lata","","veintidós","Tengo veintidós años","","","","","",1,null,1.3); unitList.add(unit24);
//        Unit    unit25 = new Unit(25,false,false,"dwadzieścia trzy ","On ma dwadzieścia trzy lata a ona dwadzieścia jeden","","veintitrés ","Él tiene veintitrés años y ella veintiuno","","","","","",1,null,1.3); unitList.add(unit25);
//        Unit    unit26 = new Unit(26,false,false,"Pan/Pani","Czy Pan jest Polakiem?","","usted","¿Es usted Polaco?","","","","","",1,null,1.3); unitList.add(unit26);
//        Unit    unit27 = new Unit(27,false,false,"być","ja jestem","ty jesteś, on jest","ser","yo soy","tú eres","él/ella es","","","",1,null,1.3); unitList.add(unit27);
//        Unit    unit28 = new Unit(28,false,false,"Polak","Polka","(Ja) jestem Polakiem","el polaco","la polaca","(Yo) soy polaco","","","","",1,null,1.3); unitList.add(unit28);
//        Unit    unit29 = new Unit(29,false,false,"ja","(ja) Jestem Paweł","","yo","(Yo) soy Pablo","","","","","",1,null,1.3); unitList.add(unit29);
//        Unit    unit30 = new Unit(30,false,false,"ona","Ona jest Polką","","ella","Ella es polaca","","","","","",1,null,1.3); unitList.add(unit30);
//        Unit    unit31 = new Unit(31,false,false,"on","On jest Hiszpanem","","él","Él es español","","","","","",1,null,1.3); unitList.add(unit31);
//        Unit    unit32 = new Unit(32,false,false,"Hiszpan","Hiszpanka","(Ty) jesteś Hiszpanką","el español","la española","(Tú) eres española","","","","",1,null,1.3); unitList.add(unit32);
//        Unit    unit33 = new Unit(33,false,false,"ty","(Ty) jesteś Agnieszka","","tú","(Tú) eres Inés","","","","","",1,null,1.3); unitList.add(unit33);
//        Unit    unit34 = new Unit(34,false,false,"kto?","Kim jesteś?","","¿quién?","¿?Quién eres?","","","","","",1,null,1.3); unitList.add(unit34);
//        Unit    unit35 = new Unit(35,false,false,"Cześć!","","","¡Hola!","","","","","","",1,null,1.3); unitList.add(unit35);
//        Unit    unit36 = new Unit(36,false,false,"jak?","Jak się masz?","","¿cómo?","¿Cómo estás?","","","","","",1,null,1.3); unitList.add(unit36);
//        Unit    unit37 = new Unit(37,false,false,"Ja bawie się","ty bawisz się","on/ona bawi się","yo toco","tú tocas","él/ella usted toca","","","","",1,null,1.3); unitList.add(unit37);
//        Unit    unit38 = new Unit(38,false,false,"Ja jem","Ty jesz","on/ona je","yo como","tú comes","él/ella come","","","","",1,null,1.3); unitList.add(unit38);
//        Unit    unit39 = new Unit(39,false,false,"dobrze","w porządku","Masz się dobrze?","bien","bien","¿Estás bien?","","","","",1,null,1.3); unitList.add(unit39);
//        Unit    unit40 = new Unit(40,false,false,"tak","Tak, mam się dobrze","","sí","Sí, estoy bien","","","","","",1,null,1.3); unitList.add(unit40);
//        Unit    unit41 = new Unit(41,false,false,"nie ","Nie, nie mam się dobrze","","no","No, no estoy bien","","","","","",1,null,1.3); unitList.add(unit41);
//        Unit    unit42 = new Unit(42,false,false,"Dziękuje","Mam się dobrze, dziękuje","","¡Gracias!","Estoy bien, gracias","","","","","",1,null,1.3); unitList.add(unit42);
//        Unit    unit43 = new Unit(43,false,false,"bardzo","Paweł ma się bardzo dobrze","","muy","Pablo está muy bien","","","","","",1,null,1.3); unitList.add(unit43);
//        Unit    unit44 = new Unit(44,false,false,"i; a","A jak się ma Paweł","","y","¿Y cómo está Pablo?","","","","","",1,null,1.3); unitList.add(unit44);
//        Unit    unit45 = new Unit(45,false,false,"gdzie?","","","¿dónde?","","","","","","",1,null,1.3); unitList.add(unit45);
//        Unit    unit46 = new Unit(46,false,false,"z","Skąd jesteś?","","de","¿De dónde eres?","","","","","",1,null,1.3); unitList.add(unit46);
//        Unit    unit47 = new Unit(47,false,false,"Polska","Jestem z Polski","","Polonia","Soy de Polonia","","","","","",1,null,1.3); unitList.add(unit47);
//        Unit    unit48 = new Unit(48,false,false,"Warszawa","Jesteś z Warszawy?","Nie, nie jestem z Warszawy","Varsovia","¿Eres de Varsovia?","No, no soy de Varsovia","","","","",1,null,1.3); unitList.add(unit48);
//        Unit    unit49 = new Unit(49,false,false,"w","Gdzie jesteś?","Jestem w Polsce","en","¿Dónde estás?","Estoy en Polonia","","","","",1,null,1.3); unitList.add(unit49);
//        Unit    unit50 = new Unit(50,false,false,"my (mężczyzni)","(My) jesteśmy w Polsce","","nosotros","(Nosotros) estamos en Polonia","","","","","",1,null,1.3); unitList.add(unit50);
//        Unit    unit51 = new Unit(51,false,false,"być (pochodzenie)","my jesteśmy","wy jesteście, oni są","ser","somos","sois, son","","","","",1,null,1.3); unitList.add(unit51);
//        Unit    unit52 = new Unit(52,false,false,"być (stanu emocjonalnego)","my jesteśmy","wy jesteście, oni są","estar","estamos","estáis, están","","","","",1,null,1.3); unitList.add(unit52);
//        Unit    unit53 = new Unit(53,false,false,"my (kobiety)","(My) jesteśmy z Polski","","nosotras","(Nosotras) somos de Polonia","","","","","",1,null,1.3); unitList.add(unit53);
//        Unit    unit54 = new Unit(54,false,false,"wy (mężczyźni)","Czy (wy) jesteście w Hiszpanii?","","vosotros","¿Estáis (vosotros) en España?","","","","","",1,null,1.3); unitList.add(unit54);
//        Unit    unit55 = new Unit(55,false,false,"oni","Czy oni są w Madrycie?","Tak, oni są w Madrycie","ellos","¿Están (ellos) en Madrid?","Sí, (ellos) están en Madrid","","","","",1,null,1.3); unitList.add(unit55);
//        Unit    unit56 = new Unit(56,false,false,"państwo","Czy państwo są z Warszawy?","","ustedes ","¿Son ustedes de Varsovia?","","","","","",1,null,1.3); unitList.add(unit56);
//        Unit    unit57 = new Unit(57,false,false,"Jak się masz?","","","¿Cómo estás?","","","","","","",1,null,1.3); unitList.add(unit57);
//        Unit    unit58 = new Unit(58,false,false,"skąd jesteś?","","","¿De dónde eres?","","","","","","",1,null,1.3); unitList.add(unit58);
//        Unit    unit59 = new Unit(59,false,false,"Mówisz po hiszpańsku?","","","¿Hablas español?","","","","","","",1,null,1.3); unitList.add(unit59);
//        Unit    unit60 = new Unit(60,false,false,"Ile masz lat?","","","¿Cuántos años tienes?","","","","","","",1,null,1.3); unitList.add(unit60);
//        Unit    unit61 = new Unit(61,false,false,"Hiszpania","Czy Piotr jest w Hiszpani?","Tak, Piotr jest w Hiszpanii","España","¿Está Pedro en España?","Sí, Pedro está en España","","","","",1,null,1.3); unitList.add(unit61);
//        Unit    unit62 = new Unit(62,false,false,"Madryt","Czy Pan jest z Madrytu?","","Madrit","¿Es usted de Madrid?","","","","","",1,null,1.3); unitList.add(unit62);
//        Unit    unit63 = new Unit(63,false,false,"wy (kobiety)","Czy (wy) jesteście z Hiszpanii?","","vosotras","¿Sois (vosotras) de España?","","","","","",1,null,1.3); unitList.add(unit63);
//        Unit    unit64 = new Unit(64,false,false,"one ","Czy one są z Madrytu?","Nie, one nie są z Madrytu","ellas","¿Son (ellas) de Madrid?","No, (ellas) no son de Madrid","","","","",1,null,1.3); unitList.add(unit64);
//        Unit    unit65 = new Unit(65,false,false,"język włoski","Mówicie po własku?","Nie, nie mówimy po włosku","el italiano","¿Habláis italiano","No, no hablamos italiano","","","","",1,null,1.3); unitList.add(unit65);
//        Unit    unit66 = new Unit(66,false,false,"język francuski","Mówi pan po francusku?","Tak, mówie po francusku ","el francés","¿Habla usted francés?","Sí, heblo francés","","","","",1,null,1.3); unitList.add(unit66);
//        Unit    unit67 = new Unit(67,false,false,"język niemiecki","Mówię dobrze po niemiecku","","el alemán","Hablo bien alemán","","","","","",1,null,1.3); unitList.add(unit67);
//        Unit    unit68 = new Unit(68,false,false,"język angielski","Mówisz po angielsku?","Tak, mówie po angielsku","el inglés","¿Hablas inglés?","Sí, hablo inglés","","","","",1,null,1.3); unitList.add(unit68);
//        Unit    unit69 = new Unit(69,false,true,"mówić","","","hablar","hablo","hablas","habla","hablamos","hablais","hablan",1,null,1.3); unitList.add(unit69);
//        Unit    unit70 = new Unit(70,false,false,"wszystko","Rozumiem wszystko","","todo","Entiendo todo","","","","","",1,null,1.3); unitList.add(unit70);
//        Unit    unit71 = new Unit(71,false,false,"język rosyjski","Oni mówią dobrze po rosyjsku","","el ruso","Ellos hablan bien ruso","","","","","",1,null,1.3); unitList.add(unit71);
//        Unit    unit72 = new Unit(72,false,false,"nazywać się ","ja/ty nazywam się","on/ona nazywa sie","Ilamarse","me Ilamo/te Ilamas","se Ilama","","","","",1,null,1.3); unitList.add(unit72);
//        Unit    unit73 = new Unit(73,false,false,"Anglia","Jestem z Anglii","","Inglaterra","Soy de Inglaterra","","","","","",1,null,1.3); unitList.add(unit73);
//        Unit    unit74 = new Unit(74,false,false,"Rosja","Jestem z Rosji","","Rusia","Soy de Rusia","","","","","",1,null,1.3); unitList.add(unit74);

 /*       Unit    unit1 = new Unit(1,false,false,"skąpy","","","stingy","","","","","","",1,null,1.3); unitList.add(unit1);
        Unit    unit2 = new Unit(2,false,false,"zrównoważony rozwój","","","sustainability","","","","","","",1,null,1.3); unitList.add(unit2);
        Unit    unit3 = new Unit(3,false,false,"koniczyny","","","shamrock","","","","","","",1,null,1.3); unitList.add(unit3);
        Unit    unit4 = new Unit(4,false,false,"kolega","","","fellow","","","","","","",1,null,1.3); unitList.add(unit4);
        Unit    unit5 = new Unit(5,false,false,"uwodzicielska moc","","","the seductive power ","","","","","","",1,null,1.3); unitList.add(unit5);
        Unit    unit6 = new Unit(6,false,false,"Co mogło wyjaśnić to odkrycie ?","","","What could account for this finding?","","","","","","",1,null,1.3); unitList.add(unit6);
        Unit    unit7 = new Unit(7,false,false,"oszukać","","","fool","","","","","","",1,null,1.3); unitList.add(unit7);
        Unit    unit8 = new Unit(8,false,false,"wprowadzenie","","","induction","","","","","","",1,null,1.3); unitList.add(unit8);
        Unit    unit9 = new Unit(9,false,false,"absencja","","","absenteeism","","","","","","",1,null,1.3); unitList.add(unit9);
        Unit    unit10 = new Unit(10,false,false,"partycypacyjne (wspólne) sposoby podejmowania decyzji","","","participatory ways of making decisions","","","","","","",1,null,1.3); unitList.add(unit10);
        Unit    unit11 = new Unit(11,false,false,"wyluzowany","","","easy going","","","","","","",1,null,1.3); unitList.add(unit11);
        Unit    unit12 = new Unit(12,false,false,"wykluczać","","","rule out","","","","","","",1,null,1.3); unitList.add(unit12);
        Unit    unit13 = new Unit(13,false,false,"dojrzewanie","","","maturation","","","","","","",1,null,1.3); unitList.add(unit13);
        Unit    unit14 = new Unit(14,false,false,"wynagrodzenia","","","wages","","","","","","",1,null,1.3); unitList.add(unit14);
        Unit    unit15 = new Unit(15,false,false,"epidemia odry","","","outbreak of measles","","","","","","",1,null,1.3); unitList.add(unit15);
        Unit    unit16 = new Unit(16,false,false,"dwuznaczoność, niejasność, zagadadkowosć","","","ambiguity","","","","","","",1,null,1.3); unitList.add(unit16);
        Unit    unit17 = new Unit(17,false,false,"miary dyspersji (czyli rozrzut )","","","measures of dispersion","","","","","","",1,null,1.3); unitList.add(unit17);
        Unit    unit18 = new Unit(18,false,false,"odchylenie standardowe","","","the standard deviation","","","","","","",1,null,1.3); unitList.add(unit18);
        Unit    unit19 = new Unit(19,false,false,"wyciąganie pierwiastka kwadratoweg","","","taking the square root","","","","","","",1,null,1.3); unitList.add(unit19);
        Unit    unit20 = new Unit(20,false,false,"stronniczość","","","bias","","","","","","",1,null,1.3); unitList.add(unit20);
        Unit    unit21 = new Unit(21,false,false,"płodny","","","fertile","","","","","","",1,null,1.3); unitList.add(unit21);
        Unit    unit22 = new Unit(22,false,false,"dependability","","","rzetelność","","","","","","",1,null,1.3); unitList.add(unit22);
        Unit    unit23 = new Unit(23,false,false,"sklepy (na o)","","","outlets","","","","","","",1,null,1.3); unitList.add(unit23);
        Unit    unit24 = new Unit(24,false,false,"Dziekan","","","Dean","","","","","","",1,null,1.3); unitList.add(unit24);
        Unit    unit25 = new Unit(25,false,false,"Prodziekan","","","Associate Dean","","","","","","",1,null,1.3); unitList.add(unit25);
        Unit    unit26 = new Unit(26,false,false,"współpracownik","","","associate","","","","","","",1,null,1.3); unitList.add(unit26);
        Unit    unit27 = new Unit(27,false,false,"skrawek, złom, resztka","","","scrap","","","","","","",1,null,1.3); unitList.add(unit27);
        Unit    unit28 = new Unit(28,false,false,"przewyższać","","","outperform","","","","","","",1,null,1.3); unitList.add(unit28);
        Unit    unit29 = new Unit(29,false,false,"silne poczucie osobisteg zaanagażowania","","","strong sense of personal commitment","","","","","","",1,null,1.3); unitList.add(unit29);
        Unit    unit30 = new Unit(30,false,false,"wzajemna odpowiedzialność","","","mutual accountability","","","","","","",1,null,1.3); unitList.add(unit30);
        Unit    unit31 = new Unit(31,false,false,"wspinać się","","","climb out","","","","","","",1,null,1.3); unitList.add(unit31);
        Unit    unit32 = new Unit(32,false,false,"smoła, pułap lotu","","","pitch","","","","","","",1,null,1.3); unitList.add(unit32);
        Unit    unit33 = new Unit(33,false,false,"wydający dyrektwy, rozkazy","","","directive","","","","","","",1,null,1.3); unitList.add(unit33);
        Unit    unit34 = new Unit(34,false,false,"dostrzec, zauważyć","","","perceive","","","","","","",1,null,1.3); unitList.add(unit34);
        Unit    unit35 = new Unit(35,false,false,"obejmujący, włącznie z","","","inclusive","","","","","","",1,null,1.3); unitList.add(unit35);
        Unit    unit36 = new Unit(36,false,false,"powstrzymuje","","","restrains","","","","","","",1,null,1.3); unitList.add(unit36);
        Unit    unit37 = new Unit(37,false,false,"pominięty","","","left out","","","","","","",1,null,1.3); unitList.add(unit37);
        Unit    unit38 = new Unit(38,false,false,"lekceważony","","","disrespected","","","","","","",1,null,1.3); unitList.add(unit38);
        Unit    unit39 = new Unit(39,false,false,"rozbieżny","","","divergent","","","","","","",1,null,1.3); unitList.add(unit39);
        Unit    unit40 = new Unit(40,false,false,"wzmocnienie, upodmiotowienie","","","empowerment","","","","","","",1,null,1.3); unitList.add(unit40);
        Unit    unit41 = new Unit(41,false,false,"omylny","","","fallible","","","","","","",1,null,1.3); unitList.add(unit41);
        Unit    unit42 = new Unit(42,false,false,"od stygmatyzować","","","destigmatize","","","","","","",1,null,1.3); unitList.add(unit42);
        Unit    unit43 = new Unit(43,false,false,"poczucie własnej wartości","","","self-esteem","","","","","","",1,null,1.3); unitList.add(unit43);
        Unit    unit44 = new Unit(44,false,false,"podoficer","","","non-commissioned officer","","","","","","",1,null,1.3); unitList.add(unit44);
        Unit    unit45 = new Unit(45,false,false,"układ napędowy","","","propulsion system","","","","","","",1,null,1.3); unitList.add(unit45);
        Unit    unit46 = new Unit(46,false,false,"statek handlowy","","","merchant ship","","","","","","",1,null,1.3); unitList.add(unit46);
        Unit    unit47 = new Unit(47,false,false,"szeregowych męższczyzn","","","enlisted men","","","","","","",1,null,1.3); unitList.add(unit47);
        Unit    unit48 = new Unit(48,false,false,"niechlujny","","","sloppy","","","","","","",1,null,1.3); unitList.add(unit48);
        Unit    unit49 = new Unit(49,false,false,"poważny cios","","","major blow","","","","","","",1,null,1.3); unitList.add(unit49);
        Unit    unit50 = new Unit(50,false,false,"Komandor","","","Commodore","","","","","","",1,null,1.3); unitList.add(unit50);
        Unit    unit51 = new Unit(51,false,false,"Dowódca","","","Commander","","","","","","",1,null,1.3); unitList.add(unit51);
        Unit    unit52 = new Unit(52,false,false,"zyskowność","","","viability","","","","","","",1,null,1.3); unitList.add(unit52);
        Unit    unit53 = new Unit(53,false,false,"atrakcyjność","","","desirability","","","","","","",1,null,1.3); unitList.add(unit53);
        Unit    unit54 = new Unit(54,false,false,"produkcja własna","","","in-house manufacturing","","","","","","",1,null,1.3); unitList.add(unit54);
        Unit    unit55 = new Unit(55,false,false,"produkcja kontraktowa (zlecona)","","","contract manufacturing","","","","","","",1,null,1.3); unitList.add(unit55);
        Unit    unit56 = new Unit(56,false,false,"towarzyszący","","","accompanying","","","","","","",1,null,1.3); unitList.add(unit56);
        Unit    unit57 = new Unit(57,false,false,"perspektywa rynku","","","market outlook","","","","","","",1,null,1.3); unitList.add(unit57);
        Unit    unit58 = new Unit(58,false,false,"poprawiać, zrewidować","","","revise","","","","","","",1,null,1.3); unitList.add(unit58);
        Unit    unit59 = new Unit(59,false,false,"prognoza zasięgu sieci","","","network coverage forecasts","","","","","","",1,null,1.3); unitList.add(unit59);
        Unit    unit60 = new Unit(60,false,false,"przeniesienie strat","","","loss carry forward","","","","","","",1,null,1.3); unitList.add(unit60);
        Unit    unit61 = new Unit(61,false,false,"ustawowa stawka podatku","","","statutory tax rate","","","","","","",1,null,1.3); unitList.add(unit61);
        Unit    unit62 = new Unit(62,false,false,"ze zdziwieniem, konsternacją","","","with bafflement","","","","","","",1,null,1.3); unitList.add(unit62);
        Unit    unit63 = new Unit(63,false,false,"istota ludzka","","","human being","","","","","","",1,null,1.3); unitList.add(unit63);
        Unit    unit64 = new Unit(64,false,false,"być podatnym","","","be susceptible","","","","","","",1,null,1.3); unitList.add(unit64);
        Unit    unit65 = new Unit(65,false,false,"błędy (na b)","","","blunders","","","","","","",1,null,1.3); unitList.add(unit65);
        Unit    unit66 = new Unit(66,false,false,"rutynowe uprzedzenia","","","routine biases","","","","","","",1,null,1.3); unitList.add(unit66);
*/

        Scanner scanner= new Scanner(System.in);
        int option=0;
        System.out.print("Choose the langage? 1-ENG, 2-ESP ");

        do {
            option=scanner.nextInt();
        } while ((option!=1) && (option!=2));

        if (option==1) dataFileName=DATA_FILE_ENG_NAME;
        if (option==2) dataFileName=DATA_FILE_ESP_NAME;

        return true;
    }

    //Option 0 - display all units
    void displayUnits() {
        System.out.println("DisplayBegin");
        for (Unit unit: unitList){
            unit.displayUnit();
        }
        System.out.println("DisplayFinish");
    }

    //Option 1 - repeat units
    void repeatUnits() {
        //Set the number of units to repeat
        int unitsToRepeat = unitsToRepeat();

        //Debug
//        System.out.println("unitsToRepeat="+unitsToRepeat);

        System.out.println("Number units to repeat:"+ ANSI_PURPLE + unitsToRepeat + ANSI_RESET);

        //Random unit to repeat
        while (unitsToRepeat >0){
            int selected = (int)(Math.random() * unitsToRepeat)+1;
            //System.out.println("Selected: " + selected);
            if(displayUnit(selected)==true) {
                unitsToRepeat = unitsToRepeat-1;
            };

        }

        isRepetitionDone=true;

    }

    //Option 1 - Count the number of units which have to be repeated today
    int unitsToRepeat() {

        int uToR = 0;

        //Today in string format
        Calendar today= new GregorianCalendar();

        //Unit next repetition date
        Calendar nextRepDate;

        for (Unit unit: unitList) {
            nextRepDate = unit.getRepetitionDate();

            //Debug
//            System.out.println("today="+today.getTime());
//            if (nextRepDate!=null)
//                System.out.println("nextRepDate="+nextRepDate.getTime());

            if (today.after(nextRepDate) || today.equals(nextRepDate)) {
                uToR++;
            }
        }

        return uToR;
    }

    //Option 2 - Count the number of all units
    int totalUnits() {

        int tU = unitList.size();
        System.out.println("Total units:"+tU);
        return tU;
    }

    //Option 1
    boolean displayUnit(int unitToDisplay){

        int uToR = 0;
        Unit selected=null;

        //Today in string format
        Calendar today= new GregorianCalendar();

        //Unit next repetition date
        Calendar nextRepDate;

        //Display question to repeat
        for (Unit unit: unitList) {
            nextRepDate = unit.getRepetitionDate();
            if (today.after(nextRepDate) || today.equals(nextRepDate)) {
                uToR++;
                if (uToR>=unitToDisplay){
                    unit.displayQuestion();
                    selected=unit;
                    break;
                }
            }
        }

        //Wait for remind by user
        System.out.print("Press "+ANSI_YELLOW+"Enter"+ANSI_RESET+" to continue");
        Scanner scanner= new Scanner(System.in);
        scanner.nextLine();

        //Display correct answer
        selected.displayAnswer();

        //Assess the quality of repetition response in 0-5 grade scale
        //displayGradeScale();

        //Input grade
        System.out.print("Enter your grade: 0 - 5: ");
        int grade=scanner.nextInt();

        //Calculate and set new grade and next repetition date

        boolean tOf=setNextRepDate(selected, grade);
        return tOf;
    }

    //Option 1 and 2 menu of quality of repetition response in 0-5 grade scale
    void displayGradeScale() {
        System.out.println("5 - prefect response");
        System.out.println("4 - correct response after a hesitation");
        System.out.println("3 - correct response recalled with serious difficulty");
        System.out.println("2 - incorrect response; where the correct one seemed easy to recall");
        System.out.println("1 - incorrect response; the correct one remembered");
        System.out.println("0 - complete blackout");
    }

    //Calculate and set new grade and next repetition date
    boolean setNextRepDate(Unit selected, int grade) {

        double newEF=1.3;  //the smallest value
        int newInterval=1; //the smallest value

        //Current Date
        Calendar newDate=new GregorianCalendar();

        if (grade<3) {
            selected.setRepeatedCorrectly(false);
            return false;
        } else
        {
            if (selected.isRepeatedCorrectly) {
                // For grades 3,4,5,6
                //EF':=EF+(0.1-(5-q)*(0.08+(5-q)*0.02))
                //q=quality of response = grade
                newEF = selected.easinessFactor +
                        (0.1 - (5 - grade) * (0.08 + (5 - grade) * 0.02));

                //If EF is less than 1.3 then let EF be 1.3.
                if (newEF < 1.3) newEF = 1.3;


                //if interval > 2 then: for n>2: I(n):=I(n-1)*EF
                if (selected.getInterval() > 2) {
                    newInterval = (int) (selected.getInterval() * newEF + 0.5);
                }

                if (selected.getInterval() == 2) {
                    newInterval = 6;
                }

                if (selected.getInterval() == 1) {
                    newInterval = 2;
                }

            }
            else {
                newEF=selected.getEasinessFactor();
                newInterval=1;

                //Set up only new interval
                selected.setInterval(newInterval);

            }

            //Set new date + newInterval
            newDate.add(Calendar.DAY_OF_MONTH, newInterval);


            //Set new interval and EF
            selected.setInterval(newInterval);
            selected.setEasinessFactor(newEF);
            selected.setRepetitionDate(newDate);

            //Debug
            //selected.displayUnit();

            return true;
        }
    }

    //Option 2
    void Learn(){

//        //Test DB Connection
//        try {
//
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "przemek", "przemek");
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery("select * from users");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("username"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        boolean isContinue=false;

        if (!isRepetitionDone) {
            System.out.print(ANSI_RED + "Repetitions have not been done. " + ANSI_RESET);
            System.out.print("Would you like to continue Y/N? ");

            Scanner scanner = new Scanner(System.in);
            String tmpAnswer = scanner.nextLine();

            if (tmpAnswer.equals("Y") || (tmpAnswer.equals("y"))) {

                //Continue without repetitions
                isContinue = true;
            }
        }
        else {
            isContinue=true;
        }

        if (isContinue) {

            int[] indexes = new int[UNITS_TO_LEARN];
            int[] repetitions = new int[UNITS_TO_LEARN];

            //Set repetitions number to 0
            for (int y=0;y<UNITS_TO_LEARN;y++)
                repetitions[y]=0;

            //Remember indexes of units to learn
            int i=0;
            for (Unit unit: unitList) {
//              System.out.println("id "+unit.getId());
                if (!unit.isTaught())
                {
                    //Remember unit's index
//                    System.out.println("remembered id "+unit.getId());
                    indexes[i]=unitList.indexOf(unit);
                    i++;

                    // if UNITS_TO_LEARN is reached -  break the loop
                    if (i>=UNITS_TO_LEARN){
                        break;
                    }
                }
            }

            //Debug
//            for (int y=0;y<UNITS_TO_LEARN;y++) {
//                System.out.println("repetitions[" + y + "]=" + repetitions[y]);
//                System.out.println("indexes[" + y + "]=" + indexes[y]);
//            }

            //Set LEFT_TO_LEARN to UNITS_TO_LEARN.
            //Number of new units left to learn - daily
            //initial value is UNITS_TO_LEARN
            int LEFT_TO_LEARN = i;
            int REAL_UNITS_TO_LEARN=i;

            //Debug
//            System.out.println("LEFT_TO_LEARN="+LEFT_TO_LEARN);

            if (LEFT_TO_LEARN==0)
                System.out.println(ANSI_YELLOW+"There is no unit to learn!!!"+ANSI_RESET);

            while(LEFT_TO_LEARN >0){

                //Draw a number from 1 to LEFT_TO_LEARN
                Random randomNumber = new Random();

                //Number from 0 to REAL_UNITS_TO_LEARN-1
                int random = randomNumber.nextInt(REAL_UNITS_TO_LEARN);

                //Debug
//                System.out.println("random="+random);
//                System.out.println("repetitions[random]="+repetitions[random]);
//                System.out.println("LEFT_TO_LEARN="+LEFT_TO_LEARN);

                //if correct repetition is lower than REP_TO_LEARN
                if (repetitions[random]<REP_TO_LEARN) {
                    //Display question
                    Unit unit=unitList.get(indexes[random]);
                    unit.displayQuestion();


                    //Wait for answer (in memory) by user
                    System.out.print("Press "+ANSI_YELLOW+"Enter"+ANSI_RESET+" to continue");
                    Scanner scanner = new Scanner(System.in);
                    scanner= new Scanner(System.in);
                    scanner.nextLine();

                    //Display answer
                    unit.displayAnswer();

                    //Evaluate answer
                    //Input grade
                    System.out.print("Enter your grade: 0 - 5: ");
                    int grade=scanner.nextInt();

                    //Grade higher than 3 means correct
                    if (grade>3)
                    {
                        //Increase repetition number
                        repetitions[random]=repetitions[random]+1;

    //                    System.out.println("rep[random]="+repetitions[random]);
    //                    System.out.println("REP_TO_LEARN="+REP_TO_LEARN);
                        if (repetitions[random]>=REP_TO_LEARN)
                        {
                            //Decrease number to left
                            LEFT_TO_LEARN--;

                            //Mark as Taught
                            unit.setTaught(true);

                            //Calculate and set new grade and next repetition date
                            setNextRepDate(unit, grade);

                            //Debug
//                            System.out.println("id="+unit.getId()+" learnt");
                        }
                    }

                }

            }
        }


    }

    //Option 3 - Add
    void Add()
    {


// Tu dodajemy jednostki
      /*  Unit    unit286 = new Unit(286,false,false,"interesować","Ją interesują wiadomości","","interesar","A ella le interesan las noticias","","","","","",1,null,1.3); unitList.add(unit286);
        Unit    unit287 = new Unit(287,false,false,"wiadomości","","","las noticias","","","","","","",1,null,1.3); unitList.add(unit287);
        Unit    unit288 = new Unit(288,false,false,"boleć","Nas boli głowa","","doler","A nosotros nos duele la cabeza","","","","","",1,null,1.3); unitList.add(unit288);
        Unit    unit289 = new Unit(289,false,false,"wydawać się","Wydaje mi się to nie w porządku ","","parecer","A mí no me parece correcto","","","","","",1,null,1.3); unitList.add(unit289);
        Unit    unit290 = new Unit(290,false,false,"brakować","Brakuje wam pieniędzy","","faltar","Os falta dinero","","","","","",1,null,1.3); unitList.add(unit290);
        Unit    unit291 = new Unit(291,false,false,"nudzić","Ta historia mnie nudzi","","aburrir","Me aburre la historia","","","","","",1,null,1.3); unitList.add(unit291);
        Unit    unit292 = new Unit(292,false,false,"uwielbiać","Uwielbiasz chodzić do kina w weekendy ","","encantar","Te encanta ir al cine los fines de semana","","","","","",1,null,1.3); unitList.add(unit292);
        Unit    unit293 = new Unit(293,false,false,"fascynować","Fascynuje go futbol","","fascinar","Le facina el fútbol","","","","","",1,null,1.3); unitList.add(unit293);
        Unit    unit294 = new Unit(294,false,false,"futobol","","","el fútbol","","","","","","",1,null,1.3); unitList.add(unit294);
        Unit    unit295 = new Unit(295,false,false,"być ważnym, obchodzić","Nic go nie obchodzi","","importar","No le importa nada","","","","","",1,null,1.3); unitList.add(unit295);
        Unit    unit296 = new Unit(296,false,false,"lubić (kogoś)","","","caer bien","","","","","","",1,null,1.3); unitList.add(unit296);
        Unit    unit297 = new Unit(297,false,false,"nie lubić (kogoś)","A my  nie lubimy naszego nauczyciela ","","caer mal","A nosotras nos cae mal nuestra profesora","","","","","",1,null,1.3); unitList.add(unit297);
        Unit    unit298 = new Unit(298,false,false,"przeszkadzać","Przeszkadzają mu jego przyjaciele","","molestar","A él le molestan sus amigos","","","","","",1,null,1.3); unitList.add(unit298);
        Unit    unit299 = new Unit(299,false,false,"mieć ochotę","Mam ochotę na lody","","apetecer","Me apetece comer helados","","","","","",1,null,1.3); unitList.add(unit299);
        Unit    unit300 = new Unit(300,false,false,"martwić się","Martwi mnie zmiana klimatyczna","","preocupar","Me preocupa el cambio climático","","","","","",1,null,1.3); unitList.add(unit300);
        Unit    unit301 = new Unit(301,false,false,"zmiana klimatyczna","","","el cambio climático","","","","","","",1,null,1.3); unitList.add(unit301);
        Unit    unit302 = new Unit(302,false,false,"pasować","","","quedar bien","","","","","","",1,null,1.3); unitList.add(unit302);
        Unit    unit303 = new Unit(303,false,false,"nie pasować","Wszystkie sukienki wyglądają na niej naprawdę źle (nie pasują na nią)","","quedar mal","Le quedan súper mal todos los vestidos","","","","","",1,null,1.3); unitList.add(unit303);
        Unit    unit304 = new Unit(304,false,false,"mieć dosyć","Ma dość egzaminów","","agobiar","Le agobian los exámenes","","","","","",1,null,1.3); unitList.add(unit304);
        Unit    unit305 = new Unit(305,false,false,"denerwować","Denerwują go korki (na drogach)","","fastidiar","Le fastidia el tráfico","","","","","",1,null,1.3); unitList.add(unit305);
        Unit    unit306 = new Unit(306,false,false,"korek uliczny","dwa znaczenia","","el tráfico","el atasco","","","","","",1,null,1.3); unitList.add(unit306);
        Unit    unit307 = new Unit(307,false,false,"pasjonować się","Pasjonują się siatkówką","","apasionar","Les apasiona el voleibol","","","","","",1,null,1.3); unitList.add(unit307);
        Unit    unit308 = new Unit(308,false,false,"grill","","","la parrillada","","","","","","",1,null,1.3); unitList.add(unit308);
        Unit    unit309 = new Unit(309,false,false,"przestraszyć się","","","asustarse","","","","","","",1,null,1.3); unitList.add(unit309);
        Unit    unit310 = new Unit(310,false,false,"wymowa GE, GI","","","[he] [hi]","gente, girar","","","","","",1,null,1.3); unitList.add(unit310);
        Unit    unit311 = new Unit(311,false,false,"pierwsze piętro","2 wersje","","primer piso","piso primero","","","","","",1,null,1.3); unitList.add(unit311);
        Unit    unit312 = new Unit(312,false,false,"wystarczający","","","suficiente","","","","","","",1,null,1.3); unitList.add(unit312);
        Unit    unit313 = new Unit(313,false,false,"słodzik","","","la edulcorante","","","","","","",1,null,1.3); unitList.add(unit313);
        Unit    unit314 = new Unit(314,false,false,"sekunda","","","el segundo","","","","","","",1,null,1.3); unitList.add(unit314);
        Unit    unit315 = new Unit(315,false,false,"minuta","","","el minuto","","","","","","",1,null,1.3); unitList.add(unit315);
        Unit    unit316 = new Unit(316,false,false,"godzina","Która jest godzina?","","la hora","¿Qué hora es?","","","","","",1,null,1.3); unitList.add(unit316);
        Unit    unit317 = new Unit(317,false,false,"Jest pierwsza","Jest druga","Jest punktualnie szósta","Es la una","Son las dos","Son las seis en punto","","","","",1,null,1.3); unitList.add(unit317);
        Unit    unit318 = new Unit(318,false,false,"o (w odniesieniu do czasu)","O której godzinie?","O pierwszej","a","¿A qué hora?","A la una","","","","",1,null,1.3); unitList.add(unit318);
        Unit    unit319 = new Unit(319,false,false,"czas","Jak długo?","długo","el tiempo","¿Cuánto tiempo?","mucho tiempo","","","","",1,null,1.3); unitList.add(unit319);
        Unit    unit320 = new Unit(320,false,false,"moment","Chwileczkę!","","el momento","¡Un momento!","","","","","",1,null,1.3); unitList.add(unit320);
        Unit    unit321 = new Unit(321,false,false,"suche","wilgotne","","seco","húmedo","","","","","",1,null,1.3); unitList.add(unit321);
        Unit    unit322 = new Unit(322,false,false,"szpica","miejsce ugryzienia np. komara","pikieta","el piquete","","","","","","",1,null,1.3); unitList.add(unit322);
        Unit    unit323 = new Unit(323,false,false,"cień","","","la sombra","","","","","","",1,null,1.3); unitList.add(unit323);
        Unit    unit324 = new Unit(324,false,false,"przed","przed jedzeniem","przed śniadaniem","antes","antes de comer","anter del desayuno","","","","",1,null,1.3); unitList.add(unit324);
        Unit    unit325 = new Unit(325,false,false,"po, potem","po obudzeniu","po pracy","después","después de despertarse","después del trabajo","","","","",1,null,1.3); unitList.add(unit325);
        Unit    unit326 = new Unit(326,false,false,"kiedy, gdy","Kiedy masz czas?","","cuando","¿Cuándo tienes tiempo?","","","","","",1,null,1.3); unitList.add(unit326);
        Unit    unit327 = new Unit(327,false,false,"wojsko, armia","","","el ejército","","","","","","",1,null,1.3); unitList.add(unit327);
        Unit    unit328 = new Unit(328,false,false,"nieśmiały","Moja siostra jest nieśmiała","","tímido","Mi hermana es tímida","","","","","",1,null,1.3); unitList.add(unit328);
        Unit    unit329 = new Unit(329,false,false,"21 kobiet","31 lat","","veintiuna mujeres","treinta y un años","","","","","",1,null,1.3); unitList.add(unit329);
        Unit    unit330 = new Unit(330,false,false,"nerwowy","","","nervioso","","","","","","",1,null,1.3); unitList.add(unit330);
        Unit    unit331 = new Unit(331,false,false,"narkotyt","","","la droga","","","","","","",1,null,1.3); unitList.add(unit331);
        Unit    unit332 = new Unit(332,false,false,"jasny","ciemny","","luminoso","oscuro","","","","","",1,null,1.3); unitList.add(unit332);
        Unit    unit333 = new Unit(333,false,false,"wystrzelić, oddać strzał","","","disparar","","","","","","",1,null,1.3); unitList.add(unit333);
        Unit    unit334 = new Unit(334,false,false,"rośliny strączkowe","","","las legumbres","","","","","","",1,null,1.3); unitList.add(unit334);
        Unit    unit335 = new Unit(335,false,false,"handlarz narkotykami","","","el narcotraficante","","","","","","",1,null,1.3); unitList.add(unit335);
        Unit    unit336 = new Unit(336,false,false,"zabawny, śmieszny","","","divertido","","","","","","",1,null,1.3); unitList.add(unit336);
        Unit    unit337 = new Unit(337,false,false,"jest wietrznie","jest przewiewnie","","hace viento","hace aire","","","","","",1,null,1.3); unitList.add(unit337);
        Unit    unit338 = new Unit(338,false,false,"charakter","charaktery","charakterystyczny","el carácter","los caracteres","característico","","","","",1,null,1.3); unitList.add(unit338);
        Unit    unit339 = new Unit(339,false,false,"cierpliwy","niecierpliwy","Moja przyjaciółka jest niecierpliwa","paciente","impaciente","Mi amiga es paciente","","","","",1,null,1.3); unitList.add(unit339);
        Unit    unit340 = new Unit(340,false,false,"poważny","","","serio","","","","","","",1,null,1.3); unitList.add(unit340);
        Unit    unit341 = new Unit(341,false,false,"sympatyczny","niesympatyczny","","simpático","antipático","","","","","",1,null,1.3); unitList.add(unit341);
        Unit    unit342 = new Unit(342,false,false,"ordynarny, grubiański","","","grosero","","","","","","",1,null,1.3); unitList.add(unit342);
        Unit    unit343 = new Unit(343,false,false,"zły, niegrzeczny","zły uczeń","zła uczennica","malo","un mal alumno (z przodu mal!!)","una mala alumna","","","","",1,null,1.3); unitList.add(unit343);
        Unit    unit344 = new Unit(344,false,false,"dobry, grzeczny","dobry uczeń","dobra uczennica","bueno","un buen alumno (z przodu buen)","una bueana alumna","","","","",1,null,1.3); unitList.add(unit344);
        Unit    unit345 = new Unit(345,false,false,"uprzejmy, miły","miła osoba","","amable","una persona amable","","","","","",1,null,1.3); unitList.add(unit345);
        Unit    unit346 = new Unit(346,false,false,"rożen","","","el asador","","","","","","",1,null,1.3); unitList.add(unit346);
        Unit    unit347 = new Unit(347,false,false,"mózg","","","el cerebro","","","","","","",1,null,1.3); unitList.add(unit347);
        Unit    unit348 = new Unit(348,false,false,"wina","","","la culpa","","","","","","",1,null,1.3); unitList.add(unit348);
        Unit    unit349 = new Unit(349,false,false,"Jest członkiem rodziny","","","Es un miembro de la familia","","","","","","",1,null,1.3); unitList.add(unit349);
        Unit    unit350 = new Unit(350,false,false,"zwierzę domowe","","","la mascota","","","","","","",1,null,1.3); unitList.add(unit350);
        Unit    unit351 = new Unit(351,false,false,"strefa czasowa","","","la zona horaria","","","","","","",1,null,1.3); unitList.add(unit351);
        Unit    unit352 = new Unit(352,false,false,"brązowy, opalony","opalenizna słoneczna","","bronceado","","","","","","",1,null,1.3); unitList.add(unit352);
        Unit    unit353 = new Unit(353,false,false,"sprzątać dom","","","limpiar la casa","","","","","","",1,null,1.3); unitList.add(unit353);
        Unit    unit354 = new Unit(354,false,false,"starszy niż","młodszy niż","","mayor que","menor que","","","","","",1,null,1.3); unitList.add(unit354);
        Unit    unit355 = new Unit(355,false,false,"spotkać","spotkałeś","","conocer","conociste","","","","","",1,null,1.3); unitList.add(unit355);
        Unit    unit356 = new Unit(356,false,false,"chodzić na tapas","","","tapear","","","","","","",1,null,1.3); unitList.add(unit356);
        Unit    unit357 = new Unit(357,false,false,"samochód sportowy","","","el coche deportivo","","","","","","",1,null,1.3); unitList.add(unit357);
        Unit    unit358 = new Unit(358,false,false,"skakać","","","saltar","","","","","","",1,null,1.3); unitList.add(unit358);
        Unit    unit359 = new Unit(359,false,false,"dużo","bardzo dużo","całkiem","mucho","muchísimo","bastante","","","","",1,null,1.3); unitList.add(unit359);
        Unit    unit360 = new Unit(360,false,false,"oszczędzać czas","Oszczędza mi czas","","ahorrar tiempo","Me ahorra tiempo","","","","","",1,null,1.3); unitList.add(unit360);
        Unit    unit361 = new Unit(361,false,false,"bez spiny/ciśnienia","(ang. no pressure)","","no hay presión","","","","","","",1,null,1.3); unitList.add(unit361);
        Unit    unit362 = new Unit(362,false,false,"podróż służbowa","delegacja","","el viaje de negocios","","","","","","",1,null,1.3); unitList.add(unit362);
        Unit    unit363 = new Unit(363,false,false,"prezent","","","el regalo","","","","","","",1,null,1.3); unitList.add(unit363);
        Unit    unit364 = new Unit(364,false,false,"zaraz przy (czymś stać, znajdować się)","","","juto al ","junto ala","","","","","",1,null,1.3); unitList.add(unit364);
        Unit    unit365 = new Unit(365,false,false,"stopnie celcjusza","","","los grados centígrados","","","","","","",1,null,1.3); unitList.add(unit365);
        Unit    unit366 = new Unit(366,false,false,"Słuchaj…przepraszam (Formalnie)","","","Oiga…perdone","","","","","","",1,null,1.3); unitList.add(unit366);
        Unit    unit367 = new Unit(367,false,false,"Słuchaj…przepraszam (NIEformalnie)","","","Oye…perdona","","","","","","",1,null,1.3); unitList.add(unit367);
        Unit    unit368 = new Unit(368,false,false,"początek","","","el principio","","","","","","",1,null,1.3); unitList.add(unit368);
        Unit    unit369 = new Unit(369,false,false,"Jestem na diecie","","","estoy a dieta","","","","","","",1,null,1.3); unitList.add(unit369);
        Unit    unit370 = new Unit(370,false,false,"prawda","fałsz","","la verdad","la falsedad","","","","","",1,null,1.3); unitList.add(unit370);
        Unit    unit371 = new Unit(371,false,false,"Spotkaliśmy na tinderze","","","Nosotros nos conocimos en tinder","","","","","","",1,null,1.3); unitList.add(unit371);
        Unit    unit372 = new Unit(372,false,false,"białko","tłuszcz","","la proteina","la grasa","","","","","",1,null,1.3); unitList.add(unit372);
        Unit    unit373 = new Unit(373,false,false,"zdrowe tłuszcze","","","las grasas bueanas","","","","","","",1,null,1.3); unitList.add(unit373);
        Unit    unit374 = new Unit(374,false,false,"Unia Europejska","","","La Unión Europea","","","","","","",1,null,1.3); unitList.add(unit374);
        Unit    unit375 = new Unit(375,false,false,"Możesz to zmienić?","","","¿Puedes cambiarlo?","","","","","","",1,null,1.3); unitList.add(unit375);
        Unit    unit376 = new Unit(376,false,false,"ukraść","","","robar","","","","","","",1,null,1.3); unitList.add(unit376);
        Unit    unit377 = new Unit(377,false,false,"tryb rozkazujący","","","el imperativo","","","","","","",1,null,1.3); unitList.add(unit377);
        Unit    unit378 = new Unit(378,false,false,"przystosować się","","","adaptarse","","","","","","",1,null,1.3); unitList.add(unit378);
        Unit    unit379 = new Unit(379,false,false,"najpierw","później (2 wersje)","","primero","despues, luego","","","","","",1,null,1.3); unitList.add(unit379);
        Unit    unit380 = new Unit(380,false,false,"na północy","na południu","","en el norte","en el sur","","","","","",1,null,1.3); unitList.add(unit380);
        Unit    unit381 = new Unit(381,false,false,"na wschód","na zachód","","en el este","en el oeste","","","","","",1,null,1.3); unitList.add(unit381);
        Unit    unit382 = new Unit(382,false,false,"wyginać, składać na pół","dubbingować","zakręcać","doblar","","","","","","",1,null,1.3); unitList.add(unit382);
        Unit    unit383 = new Unit(383,false,false,"chwytać","podnieść","skręcać","coger","","","","","","",1,null,1.3); unitList.add(unit383);
        Unit    unit384 = new Unit(384,false,false,"obracać","krążyć","zakręcać","girar","","","","","","",1,null,1.3); unitList.add(unit384);
        Unit    unit385 = new Unit(385,false,false,"tani","drogi","","caro","barato","","","","","",1,null,1.3); unitList.add(unit385);
        Unit    unit386 = new Unit(386,false,false,"skręć (3 wersje)","","","dobla","coge","gira","","","","",1,null,1.3); unitList.add(unit386);
        Unit    unit387 = new Unit(387,false,false,"schodzić w dół","wychodzić na górę","","bajar","subir","","","","","",1,null,1.3); unitList.add(unit387);
        Unit    unit388 = new Unit(388,false,false,"na rogu","w rogu","","en la esquina","","","","","","",1,null,1.3); unitList.add(unit388);
        Unit    unit389 = new Unit(389,false,false,"w środku","","","dentro de la","dentro del","","","","","",1,null,1.3); unitList.add(unit389);
        Unit    unit390 = new Unit(390,false,false,"Jest (coś) tutaj blisko.","","","Hay un/una aqui cerca","","","","","","",1,null,1.3); unitList.add(unit390);
        Unit    unit391 = new Unit(391,false,false,"Jak się idzie do...?","","","¿Cómo se va hasta...?","","","","","","",1,null,1.3); unitList.add(unit391);
        Unit    unit392 = new Unit(392,false,true ,"przechodzić (odmiana!)","(no cruzar)","","atravesar","atravieso","atraviesas","atraviesa","atravesamos","atravesáis","atraviesan",1,null,1.3); unitList.add(unit392);
        Unit    unit393 = new Unit(393,false,false,"przechodzić","(no atravesar)","","cruzar","","","","","","",1,null,1.3); unitList.add(unit393);
        Unit    unit394 = new Unit(394,false,false,"przejdź przez (2 wersje)","","","cruza","atraviesa","","","","","",1,null,1.3); unitList.add(unit394);
        Unit    unit395 = new Unit(395,false,false,"idź dalej prosto (2 wersje)","","","sigue todo recto","ve todo recto","","","","","",1,null,1.3); unitList.add(unit395);
        Unit    unit396 = new Unit(396,false,false,"zatrzymać","","","parar","","","","","","",1,null,1.3); unitList.add(unit396);
        Unit    unit397 = new Unit(397,false,false,"zawrócić","","","dar la vuelta","","","","","","",1,null,1.3); unitList.add(unit397);
*/


        //Set total units number
        totalUnitNumber=totalUnits();
    }
    //Option 7
    //Right now data will be load from text file
    void loadDataFromDB()
    {
        BufferedReader br = null;
        try {
            br = Files.newBufferedReader(Paths.get(dataFileName));
            int numberOfUnits=0;
            String extractedLine=br.readLine();
            numberOfUnits=Integer.valueOf(extractedLine);
            System.out.println("numberOfUnits: "+extractedLine);

            // =========
            extractedLine=br.readLine();
//            System.out.println("SEP: "+extractedLine);


            for (int i = 0; i < numberOfUnits; i++) {

                //Id
                extractedLine= br.readLine();
//                System.out.println("id: "+extractedLine);
                long id=Long.valueOf(extractedLine);

                //isTaught
                extractedLine= br.readLine();
//                System.out.println("isTaught: "+extractedLine);
                boolean isTaugth=Boolean.valueOf(extractedLine);

                //isVerbIrregular
                extractedLine= br.readLine();
//                System.out.println("isVerbIrregular: "+extractedLine);
                boolean isVerbIrregular=Boolean.valueOf(extractedLine);

                //question
                extractedLine=br.readLine();
                String question=extractedLine;
//                System.out.println("question: "+extractedLine);

                //question1
                extractedLine=br.readLine();
                String question1=extractedLine;
//                System.out.println("question1: "+extractedLine);

                //question2
                extractedLine=br.readLine();
                String question2=extractedLine;
//                System.out.println("question2: "+extractedLine);

                //answer
                extractedLine=br.readLine();
                String answer=extractedLine;
//                System.out.println("answer: "+extractedLine);

                //answer1
                extractedLine=br.readLine();
                String answer1=extractedLine;
//                System.out.println("answer1: "+extractedLine);

                //answer2
                extractedLine=br.readLine();
                String answer2=extractedLine;
//                System.out.println("answer2: "+extractedLine);

                //answer3
                extractedLine=br.readLine();
                String answer3=extractedLine;
//                System.out.println("answer3: "+extractedLine);

                //answer4
                extractedLine=br.readLine();
                String answer4=extractedLine;
//                System.out.println("answer4: "+extractedLine);

                //answer5
                extractedLine=br.readLine();
                String answer5=extractedLine;
//                System.out.println("answer5: "+extractedLine);

                //answer6
                extractedLine=br.readLine();
                String answer6=extractedLine;
//                System.out.println("answer6: "+extractedLine);

                //interval
                extractedLine= br.readLine();
//                System.out.println("interval: "+extractedLine);
                int interval=Integer.valueOf(extractedLine);

                //repetitionDate
                GregorianCalendar repetitionDate = new GregorianCalendar();
                repetitionDate=null;

                extractedLine= br.readLine();
//                System.out.println("repetitionDate: "+extractedLine);

                if(isTaugth) {

                    if(extractedLine.length()>0){
                        String year=extractedLine.substring(0,4);
//                        System.out.println("year: "+year);

                        String month=extractedLine.substring(5,7);
//                        System.out.println("month: "+month);

                        String day=extractedLine.substring(8,10);
//                        System.out.println("day: "+day);

                        int iYear=Integer.valueOf(year);
                        int iMonth=Integer.valueOf(month);
                        int iDay=Integer.valueOf(day);

                        switch (iMonth) {
                            case 1 -> iMonth=Calendar.JANUARY;
                            case 2 -> iMonth=Calendar.FEBRUARY;
                            case 3 -> iMonth=Calendar.MARCH;
                            case 4 -> iMonth=Calendar.APRIL;
                            case 5 -> iMonth=Calendar.MAY;
                            case 6 -> iMonth=Calendar.JUNE;
                            case 7 -> iMonth=Calendar.JULY;
                            case 8 -> iMonth=Calendar.AUGUST;
                            case 9 -> iMonth=Calendar.SEPTEMBER;
                            case 10 -> iMonth=Calendar.OCTOBER;
                            case 11 -> iMonth=Calendar.NOVEMBER;
                            case 12 -> iMonth=Calendar.DECEMBER;
                        }

                        repetitionDate = new GregorianCalendar(iYear,iMonth,iDay);

                        //Debug
//                        System.out.println("repetitionDate="+repetitionDate.getTime());
                    }
                }

                //easinessFactor
                extractedLine= br.readLine();
//                System.out.println("easinessFactor: "+extractedLine);
                double easinessFactor=Double.valueOf(extractedLine);

                //separator
                extractedLine= br.readLine();
//                System.out.println("SEP: "+extractedLine);

                //creates new unit
                Unit unit = new Unit(id,isTaugth,isVerbIrregular,question,question1,question2,answer,answer1,
                        answer2,answer3,answer4,answer5,answer6,interval,repetitionDate,easinessFactor);
                //unit.displayUnit();

                unitList.add(unit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Option 7 - Load data
    void Load() {
        unitList.clear();
        loadDataFromDB();

        //Set total units number
        totalUnitNumber=totalUnits();
    }


    //Option 8 and 9
    //Right now data will be store in text file
    void saveDataToDB() {

        String line = "";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(dataFileName));

            //Number of units
            line= String.valueOf(totalUnitNumber);
            writer.write(line);
            writer.newLine();
            line="--------------------------------------------------";
            writer.write(line);
            writer.newLine();

            //Save all units
            for (Unit unit: unitList) {
                //Id
                line=String.valueOf(unit.getId());
                writer.write(line);
                writer.newLine();

                //isTaught
                line=String.valueOf(unit.isTaught());
                writer.write(line);
                writer.newLine();

                //isVerbIrregular
                line=String.valueOf(unit.isVerbIrregular());
                writer.write(line);
                writer.newLine();

                //question
                line=unit.getQuestion();
                writer.write(line);
                writer.newLine();

                //question1
                line=unit.getQuestion1();
                writer.write(line);
                writer.newLine();

                //question2
                line=unit.getQuestion2();
                writer.write(line);
                writer.newLine();

                //answer
                line=unit.getAnswer();
                writer.write(line);
                writer.newLine();

                //answer1
                line=unit.getAnswer1();
                writer.write(line);
                writer.newLine();

                //answer2
                line=unit.getAnswer2();
                writer.write(line);
                writer.newLine();

                //answer3
                line=unit.getAnswer3();
                writer.write(line);
                writer.newLine();

                //answer4
                line=unit.getAnswer4();
                writer.write(line);
                writer.newLine();

                //answer5
                line=unit.getAnswer5();
                writer.write(line);
                writer.newLine();

                //answer6
                line=unit.getAnswer6();
                writer.write(line);
                writer.newLine();

                //interval
                line=String.valueOf(unit.getInterval());
                writer.write(line);
                writer.newLine();

                //repetitionDate
                if(unit.isTaught()) {
                    GregorianCalendar calendar = new GregorianCalendar();
                    String month="";
                    String day="";
                    calendar=(GregorianCalendar) unit.getRepetitionDate();

                    if (calendar.get(Calendar.MONTH)+1<10)
                        month="0"+String.valueOf(calendar.get(Calendar.MONTH)+1);
                    else
                        month=String.valueOf(calendar.get(Calendar.MONTH)+1);

                    if (calendar.get(Calendar.DAY_OF_MONTH)<10)
                        day="0"+String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
                    else
                        day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

                    line=String.valueOf(calendar.get(Calendar.YEAR))+"-"+
                            month+"-"+
                            day;
                }
                else
                    line="";

                writer.write(line);
                writer.newLine();

                //easinessFactor
                line=String.valueOf(unit.getEasinessFactor());
                writer.write(line);
                writer.newLine();

                //separator
                line="--------------------------------------------------";
                writer.write(line);
                writer.newLine();
            }
            writer.close();

            System.out.println("Data correctly saved in DB");

        } catch (IOException e) {
            System.out.println("Data NOT correctly saved in DB");
            e.printStackTrace();
        }

    }


    //Option 8 - Save data to File
    void Save() {
        saveDataToDB();
        isDataSaved=true;
    }

    //Option 9 - Exit & Save data to File
    void Exit() {
        if (!isDataSaved) {
            System.out.print(ANSI_RED+"Data has not been saved. "+ANSI_RESET);
            System.out.print("Would you like to save them Y/N? ");

            Scanner scanner= new Scanner(System.in);
            String tmpAnswer= scanner.nextLine();

            if (!tmpAnswer.equals("N") && (!tmpAnswer.equals("n")))
                saveDataToDB();
        }

    }

}
