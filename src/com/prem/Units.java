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
/*
        Unit    unit75 = new Unit(75,false,true,"wiedzieć","","","saber","sé","sabes","sabe","sabemos","sabéis","saben",1,null,1.3); unitList.add(unit75);
        Unit    unit76 = new Unit(76,false,true,"rozumieć","","","entender","entiendo","entiendes","entiende","entendemos","entendéis","entienden",1,null,1.3); unitList.add(unit76);
        Unit    unit77 = new Unit(77,false,false,"Przykro mi (Przepraszam)","","","Lo siento","","","","","","",1,null,1.3); unitList.add(unit77);
        Unit    unit78 = new Unit(78,false,false,"Nic ","Nic nie rozumiem","","Nada","No entiendo nada","","","","","",1,null,1.3); unitList.add(unit78);
        Unit    unit79 = new Unit(79,false,true,"mieć","","","tener","tengo","tienes","tiene","tenemos","tenéis","tienen",1,null,1.3); unitList.add(unit79);
        Unit    unit80 = new Unit(80,false,false,"rok","","","el año","","","","","","",1,null,1.3); unitList.add(unit80);
        Unit    unit81 = new Unit(81,false,false,"ile?","ile masz lat?","","¿cuánto?","¿Cuántos años tienes?","","","","","",1,null,1.3); unitList.add(unit81);
        Unit    unit82 = new Unit(82,false,false,"Włochy","Jestem z Włoch","","Italia","Soy de Italia","","","","","",1,null,1.3); unitList.add(unit82);
        Unit    unit83 = new Unit(83,false,false,"Francja","Jestem z Francji","","Francia","Soy de Francia","","","","","",1,null,1.3); unitList.add(unit83);
        Unit    unit84 = new Unit(84,false,false,"Niemcy","Jestem z Niemiec","","Alemania","Soy de Alemania","","","","","",1,null,1.3); unitList.add(unit84);
        Unit    unit85 = new Unit(85,false,false,"Jego/Jej","Pana/Pani","Jaki jest jej numer telefonu?","su","¿Cuál es su número de teléfono?","","","","","",1,null,1.3); unitList.add(unit85);
        Unit    unit86 = new Unit(86,false,false,"Mój/moja/moje","Mój numer telefonu to 843","","mi","Mi número de teléfono es ocho cuatro tres","","","","","",1,null,1.3); unitList.add(unit86);
        Unit    unit87 = new Unit(87,false,false,"numer","","","el número","","","","","","",1,null,1.3); unitList.add(unit87);
        Unit    unit88 = new Unit(88,false,false,"telefon","","","el teléfono","","","","","","",1,null,1.3); unitList.add(unit88);
        Unit    unit89 = new Unit(89,false,false,"twój/twoja/twoja","Czy twój numer telefonu to 576?","","tu","¿Es tu número de teléfono cinco siete seis?","","","","","",1,null,1.3); unitList.add(unit89);
        Unit    unit90 = new Unit(90,false,false,"jaki/jaka/jakie?","Jaki jest twój numer telefonu?","","¿cuál?","¿Cuál es tu número de teléfono?","","","","","",1,null,1.3); unitList.add(unit90);
        Unit    unit91 = new Unit(91,false,false,"zero","Jej numer telefonu to 970","","cero","Su número de teléfono es nueve siete cero","","","","","",1,null,1.3); unitList.add(unit91);
        Unit    unit92 = new Unit(92,false,false,"kot","","","el gato","","","","","","",1,null,1.3); unitList.add(unit92);
        Unit    unit93 = new Unit(93,false,false,"pies","Mam psa","","el perro","Tengo un perro","","","","","",1,null,1.3); unitList.add(unit93);
        Unit    unit94 = new Unit(94,false,false,"Przyjaciel/przyjaciółka","Jest moją przyjaciółką","","el amigo/la amiga","Es mi amiga","","","","","",1,null,1.3); unitList.add(unit94);
        Unit    unit95 = new Unit(95,false,false,"żonaty/zamężna","Nie jestem zamężna","","casado/casada","No estoy casada","","","","","",1,null,1.3); unitList.add(unit95);
        Unit    unit96 = new Unit(96,false,false,"rodzeństwo","Masz rodzeństwo?","","los hermanos","¿Tienes hermanos?","","","","","",1,null,1.3); unitList.add(unit96);
        Unit    unit97 = new Unit(97,false,false,"brat/siostra","Paweł jest bratem Anny","","el hermano/la hermana","Pablo es hermano de Ana","","","","","",1,null,1.3); unitList.add(unit97);
        Unit    unit98 = new Unit(98,false,false,"syn/córka","Mam syna i córkę ","","el hijo/la hija","Tengo un hijo y una hija","","","","","",1,null,1.3); unitList.add(unit98);
        Unit    unit99 = new Unit(99,false,false,"dziecko(ch)/(dz)","To jest jego dziecko","","el niño/la niña","Este es su niño","","","","","",1,null,1.3); unitList.add(unit99);
        Unit    unit100 = new Unit(100,false,false,"rodzice","Kim są twoi rodzice","","los padres","¿Quiénes son tus padres?","","","","","",1,null,1.3); unitList.add(unit100);
        Unit    unit101 = new Unit(101,false,false,"matka","Moja matka jest pielęgniarką","","la madre","Mi madre es enfermera","","","","","",1,null,1.3); unitList.add(unit101);
        Unit    unit102 = new Unit(102,false,false,"ojciec","Mój ojciec jest strażakiem","","el padre","Mi padre es bombero","","","","","",1,null,1.3); unitList.add(unit102);
        Unit    unit103 = new Unit(103,false,false,"ulica","ulica Madrycka 16","","la calle","calle de Madrid dieciséis","","","","","",1,null,1.3); unitList.add(unit103);
        Unit    unit104 = new Unit(104,false,false,"język Hiszpański","","","el español","","","","","","",1,null,1.3); unitList.add(unit104);
        Unit    unit105 = new Unit(105,false,false,"tamto (rzecz nienazwana)","co to jest (tamto)?","","aquello","¿Qué es aquello?","","","","","",1,null,1.3); unitList.add(unit105);
        Unit    unit106 = new Unit(106,false,false,"to","Co to jest?","","esto","¿Qué es esto?","","","","","",1,null,1.3); unitList.add(unit106);
        Unit    unit107 = new Unit(107,false,false,"student/studentka","Jestem studentem","","el estudiante/la strudiante","Soy estudiante","","","","","",1,null,1.3); unitList.add(unit107);
        Unit    unit108 = new Unit(108,false,false,"uczeń/uczennica","Jestem uczennicą","","el alumno/la alumna","Soy alumna","","","","","",1,null,1.3); unitList.add(unit108);
        Unit    unit109 = new Unit(109,false,true,"robić","","","hacer","hago","haces","hace","hacemos","hacéis","hacen",1,null,1.3); unitList.add(unit109);
        Unit    unit110 = new Unit(110,false,false,"co?","co robisz?","","¿Qué?","¿Qué haces?","","","","","",1,null,1.3); unitList.add(unit110);
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
