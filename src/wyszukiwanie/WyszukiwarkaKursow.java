package wyszukiwanie;

import osoba.Dane;
import osoba.Kurs;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class WyszukiwarkaKursow implements IWyszukiwarka {
    public ArrayList<Dane> wyszukaj(ArrayList<Dane> listaDanych, String dana, String klucz) {
        listaDanych = listaDanych.stream().filter(data -> (data instanceof Kurs)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Dane> listaKursow = new ArrayList<>();

        switch (dana) {
            case "nazwa":
                for (Dane kurs : listaDanych) {
                    if (((Kurs) kurs).getNazwa().equals(klucz)) {
                        listaKursow.add(kurs);
                    }
                }
                break;
            case "prowadzacy":
                for (Dane kurs : listaDanych) {
                    if (((Kurs) kurs).getProwadzacy().getNazwisko().equals(klucz)) {
                        listaKursow.add(kurs);
                    }
                }
                break;
            case "ects":
                for (Dane kurs : listaDanych) {
                    if (((Kurs) kurs).getPunktyECTS() == (Integer.parseInt(klucz))) {
                        listaKursow.add(kurs);
                    }
                }
                break;
            default:
                System.out.println("Nie mozesz filtrowac kursow po tej danej");
        }
        return listaKursow;
    }
}
