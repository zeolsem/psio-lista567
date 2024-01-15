package wyszukiwanie;

import osoba.Dane;
import osoba.Osoba;
import osoba.PracownikUczelni;
import osoba.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class WyszukiwarkaStudentow implements IWyszukiwarka {
    public ArrayList<Dane> wyszukaj(ArrayList<Dane> listaDanych, String dana, String klucz) {
        listaDanych = listaDanych.stream().filter(data -> (data instanceof Student)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Dane> listaStudentow = new ArrayList<Dane>();

        switch (dana) {
            case "imie":
                for (Dane student : listaDanych) {
                    if (((Student) student).getImie().equals(klucz)) {
                        listaStudentow.add(student);
                    }
                }
                break;
            case "nazwisko":
                for (Dane student : listaDanych) {
                    if (((Student) student).getNazwisko().equals(klucz)) {
                        listaStudentow.add(student);
                    }
                }
                break;
            case "index":
                for (Dane student : listaDanych) {
                    if (((Student) student).getNrIndeksu() == (Integer.parseInt(klucz))) {
                        listaStudentow.add(student);
                    }
                }
                break;
            case "rok_studiow":
                for (Dane student : listaDanych) {
                    if (((Student) student).getRokStudiow() == (Integer.parseInt(klucz))) {
                        listaStudentow.add(student);
                    }
                }
                break;
            case "nazwa_kursu":
                for (Dane student : listaDanych) {
                    for (int i = 0; i < ((Student) student).getListaKursow().size(); i++) {
                        if (((Student) student).getListaKursow().get(i).getNazwa().equals(klucz)) {
                            listaStudentow.add(student);
                        }
                    }
                }
                break;
            default:
                System.out.println("Nie mozesz filtrowac studentow po tej danej");
        }

        return listaStudentow;
    }
}
