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
    private IWyszukiwarka strategiaWyszukiwania;
    public Wyszukiwarka() {
    }

    public void zmienStrategie(IWyszukiwarka strategia) {
        this.strategiaWyszukiwania = strategia;
    }

    public <T> ArrayList<Dane> wyszukajPoKlasie(Class<T> klasa, ArrayList<Dane> listaDanych) {
        listaDanych = listaDanych.stream().filter(data -> (data.getClass().getSimpleName().equals(klasa.getSimpleName()))).collect(Collectors.toCollection(ArrayList::new));
        return listaDanych;
    }

    public <T> ArrayList<Dane> wyszukajPoDanych(Class<T> klasa, ArrayList<Dane> listaDanych, String dana, String klucz) {
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
                System.out.println("nIE MA TAKIEJ KLASY");
        }

        return strategiaWyszukiwania.wyszukaj(listaDanych, dana, klucz);
    }
//    public Wyszukiwarka() {
//    }
//    private <T> ArrayList<Dane> filtrujPoDanych(Class<T> clazz, ArrayList<Dane> listaDanych, String klucz, String methodName) {
//        try {
//            Method method = clazz.getMethod(methodName);
//            return listaDanych.stream()
//                    .filter(clazz::isInstance)
//                    .map(data -> {
//                        try {
//                            Object propertyValue = method.invoke(data);
//                            if (propertyValue instanceof Dane) {
//                                return (Dane) propertyValue;
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        return null;
//                    })
////                    .filter(dane -> dane != null && dane.toString().equals(klucz))
//                    .filter(dane -> dane != null)
//                    .collect(Collectors.toCollection(ArrayList::new));
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//    }
//
//    public <T> ArrayList<Dane> wyszukaj(Class<T> typ, ArrayList<Dane> listaDanych, String dana, String klucz) {
//        ArrayList<Dane> nowaListaDanych = listaDanych.stream().filter(typ::isInstance).collect(Collectors.toCollection(ArrayList::new));
////        // loop through and print every element of nowaListaDanych
////        for (Dane dane : nowaListaDanych) {
////            System.out.println(dane);
////        }
//
//        switch (dana) {
//            case "nazwa" ->
//                    nowaListaDanych = listaDanych.stream().filter(nazwa -> nazwa.equals(klucz)).collect(Collectors.toCollection(ArrayList::new));
//            case "prowadzacy" ->
//                    nowaListaDanych = listaDanych.stream().filter(prowadzacy -> prowadzacy.equals(klucz)).collect(Collectors.toCollection(ArrayList::new));
//            case "ects" ->
//                    nowaListaDanych = listaDanych.stream().filter(ects -> ects.equals(Integer.parseInt(klucz))).collect(Collectors.toCollection(ArrayList::new));
//            case "imie" ->
////                    nowaListaDanych = listaDanych.stream().filter(imie -> imie.equals(klucz)).collect(Collectors.toCollection(ArrayList::new));
//                    nowaListaDanych = filtrujPoDanych(typ, listaDanych, klucz, "getImie");
//            case "nazwisko" ->
//                    nowaListaDanych = listaDanych.stream().filter(nazwisko -> nazwisko.equals(klucz)).collect(Collectors.toCollection(ArrayList::new));
//            case "index" ->
//                    nowaListaDanych = listaDanych.stream().filter(index -> index.equals(Integer.parseInt(klucz))).collect(Collectors.toCollection(ArrayList::new));
//            case "rok_studiow" ->
//                    nowaListaDanych = listaDanych.stream().filter(rok_studiow -> rok_studiow.equals(Integer.parseInt(klucz))).collect(Collectors.toCollection(ArrayList::new));
//            case "stanowisko" ->
//                    nowaListaDanych = listaDanych.stream().filter(stanowisko -> stanowisko.equals(klucz)).collect(Collectors.toCollection(ArrayList::new));
//            case "staz_pracy" ->
//                    nowaListaDanych = listaDanych.stream().filter(staz_pracy -> staz_pracy.equals(Integer.parseInt(klucz))).collect(Collectors.toCollection(ArrayList::new));
//            case "nadgodziny" ->
//                    nowaListaDanych = listaDanych.stream().filter(nadgodziny -> nadgodziny.equals(Integer.parseInt(klucz))).collect(Collectors.toCollection(ArrayList::new));
//            case "pensja" ->
//                    nowaListaDanych = listaDanych.stream().filter(pensja -> pensja.equals(Integer.parseInt(klucz))).collect(Collectors.toCollection(ArrayList::new));
//            case "nazwa_kursu" ->
//                    nowaListaDanych = listaDanych.stream().filter(nazwa_kursu -> nazwa_kursu.equals(klucz)).collect(Collectors.toCollection(ArrayList::new));
//            default -> System.out.println("Brak takiego typu danej");
//        }
//        return nowaListaDanych;
//    }
}
