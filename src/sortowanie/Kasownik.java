package sortowanie;

import osoba.Dane;
import osoba.PracownikUczelni;
import osoba.Student;
import uczelnia.Uczelnia;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Kasownik {
    private Uczelnia uczelnia;
    public Kasownik() {
        uczelnia = Uczelnia.getInstance();
    }

    public void usunPracownika(String kryterium, String klucz) {
        ArrayList<PracownikUczelni> listaPracownikow = new ArrayList<>();
        for (Dane dana : uczelnia.getListaOsob()) {
            if (dana instanceof PracownikUczelni) {
                listaPracownikow.add((PracownikUczelni) dana);
            }
        }

        Iterator<PracownikUczelni> iterator = listaPracownikow.iterator();
        switch (kryterium) {
            case "nazwisko":
                while (iterator.hasNext()) {
                    PracownikUczelni pracownik = iterator.next();
                    if (pracownik.getNazwisko().equals(klucz)) {
                        iterator.remove();
                    }
                }
                break;
            case "imie":
                while (iterator.hasNext()) {
                    PracownikUczelni pracownik = iterator.next();
                    if (pracownik.getImie().equals(klucz)) {
                        iterator.remove();
                    }
                }
                break;
            case "staz_pracy":
                while (iterator.hasNext()) {
                    PracownikUczelni pracownik = iterator.next();
                    if (pracownik.getStazPracy() == Integer.parseInt(klucz)) {
                        iterator.remove();
                    }
                }
                break;
            case "stanowisko":
                while (iterator.hasNext()) {
                    PracownikUczelni pracownik = iterator.next();
                    if (pracownik.getStanowisko().equals(klucz)) {
                        iterator.remove();
                    }
                }
                break;
            default:
                System.out.println("Niepoprawne kryterium");
        }
    }

    public void usunStudenta(String kryterium, String klucz) {
        ArrayList<Student> listaStudentow = new ArrayList<>();
        for (Dane dana : uczelnia.getListaOsob()) {
            if (dana instanceof Student) {
                listaStudentow.add((Student) dana);
            }
        }

        Iterator<Student> iterator = listaStudentow.iterator();
        switch (kryterium) {
            case "nazwisko":
                while (iterator.hasNext()) {
                    Student student = iterator.next();
                    if (student.getNazwisko().equals(klucz)) {
                        iterator.remove();
                    }
                }
                break;
            case "imie":
                while (iterator.hasNext()) {
                    Student student = iterator.next();
                    if (student.getImie().equals(klucz)) {
                        iterator.remove();
                    }
                }
                break;
            case "index":
                while (iterator.hasNext()) {
                    Student student = iterator.next();
                    if (student.getNrIndeksu() == Integer.parseInt(klucz)) {
                        iterator.remove();
                    }
                }
                break;
            case "rok_studiow":
                while (iterator.hasNext()) {
                    Student student = iterator.next();
                    if (student.getRokStudiow() == Integer.parseInt(klucz)) {
                        iterator.remove();
                    }
                }
                break;
            default:
                System.out.println("Niepoprawne kryterium");
        }
    }
}
