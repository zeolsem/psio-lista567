package wyszukiwanie;

import osoba.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class WyszukiwarkaPracownikow implements IWyszukiwarka {
    public ArrayList<Dane> wyszukaj(ArrayList<Dane> listaDanych, String dana, String klucz) {
        listaDanych = listaDanych.stream().filter(data -> (data instanceof PracownikUczelni)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Dane> listaPracownikow = new ArrayList<Dane>();

        switch (dana) {
            case "imie":
                for (Dane pracownik : listaDanych) {
                    if (((PracownikUczelni) pracownik).getImie().equals(klucz)) {
                        listaPracownikow.add(pracownik);
                    }
                }
                break;
            case "nazwisko":
                for (Dane pracownik : listaDanych) {
                    if (((PracownikUczelni) pracownik).getNazwisko().equals(klucz)) {
                        listaPracownikow.add(pracownik);
                    }
                }
                break;
            case "stanowisko":
                for (Dane pracownik : listaDanych) {
                    if (((PracownikUczelni) pracownik).getStanowisko().equals(klucz)) {
                        listaPracownikow.add(pracownik);
                    }
                }
                break;
            case "staz_pracy":
                for (Dane pracownik : listaDanych) {
                    if (((PracownikUczelni) pracownik).getStazPracy() == (Integer.parseInt(klucz))) {
                        listaPracownikow.add(pracownik);
                    }
                }
                break;
            case "nadgodziny":
                listaDanych = listaDanych.stream().filter(data -> (data instanceof PracownikAdministracyjny)).collect(Collectors.toCollection(ArrayList::new));
                for (Dane pracownik : listaDanych) {
                    if (((PracownikAdministracyjny) pracownik).getNadgodziny() == (Integer.parseInt(klucz))) {
                        listaPracownikow.add(pracownik);
                    }
                }
                break;
            case "pensja":
                for (Dane pracownik : listaDanych) {
                    if (((PracownikUczelni) pracownik).getPensja() == (Double.parseDouble(klucz))) {
                        listaPracownikow.add(pracownik);
                    }
                }
                break;
            default:
                System.out.println("Nie mozesz filtrowac pracownikow po tej danej");
        }
        return listaPracownikow;
    }
}
