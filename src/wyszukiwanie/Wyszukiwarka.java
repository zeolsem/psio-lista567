package wyszukiwanie;

import osoba.Dane;
import osoba.Kurs;
import osoba.Osoba;
import osoba.Student;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Wyszukiwarka {
    private static IWyszukiwarka strategiaWyszukiwania;

    //make a singleton out of this
    private static Wyszukiwarka instance = null;
    public static Wyszukiwarka getInstance() {
        if (instance == null) {
            instance = new Wyszukiwarka();
        }
        return instance;
    }

    public static <T> ArrayList<Dane> wyszukajPoKlasie(Class<T> klasa, ArrayList<Dane> listaDanych) {
        listaDanych = listaDanych.stream().filter(data -> (data != null && data.getClass().getSimpleName().equals(klasa.getSimpleName()))).collect(Collectors.toCollection(ArrayList::new));
        return listaDanych;
    }

    public static <T> ArrayList<Dane> wyszukajPoDanych(Class<T> klasa, ArrayList<Dane> listaDanych, String dana, String klucz) {
        switch (klasa.getSimpleName()) {
            case "Student":
                strategiaWyszukiwania = new WyszukiwarkaStudentow();
                break;
            case "PracownikUczelni":
                strategiaWyszukiwania = new WyszukiwarkaPracownikow();
                break;
            case "Kurs":
                strategiaWyszukiwania = new WyszukiwarkaKursow();
                break;
            default:
//                System.out.println("nIE MA TAKIEJ KLASY");
                strategiaWyszukiwania = new WyszukiwarkaStudentow();
        }

        return strategiaWyszukiwania.wyszukaj(listaDanych, dana, klucz);
    }
}
