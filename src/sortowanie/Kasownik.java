package sortowanie;

import osoba.Dane;
import osoba.Kurs;
import osoba.PracownikUczelni;
import osoba.Student;
import serializacja.Serializator;
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
        Iterator<Dane> iterator = uczelnia.getListaOsob().iterator();
        while (iterator.hasNext()) {
            Dane pracownik = iterator.next();
            if (pracownik instanceof PracownikUczelni) {
                switch (kryterium) {
                    case "nazwisko":
                        if (((PracownikUczelni) pracownik).getNazwisko().equals(klucz)) {
                            iterator.remove();
                        }
                        break;
                    case "imie":
                        if (((PracownikUczelni) pracownik).getImie().equals(klucz)) {
                            iterator.remove();
                        }
                        break;
                    case "stazPracy":
                        if (((PracownikUczelni) pracownik).getStazPracy() == Integer.parseInt(klucz)) {
                            iterator.remove();
                        }
                        break;
                    case "stanowisko":
                        if (((PracownikUczelni) pracownik).getStanowisko().equals(klucz)) {
                            iterator.remove();
                        }
                        break;
                    default:
                        System.out.println("Niepoprawne kryterium");
                        return;
                }
            }
        }
        Serializator.serializujUczelnie();
    }

    public void usunStudenta(String kryterium, String klucz) {
        Iterator<Dane> iterator = uczelnia.getListaOsob().iterator();
        while (iterator.hasNext()) {
            Dane student = iterator.next();
            if (student instanceof Student) {
                switch (kryterium) {
                    case "nazwisko":
                        if (((Student) student).getNazwisko().equals(klucz)) {
                            iterator.remove();
                        }
                        break;
                    case "imie":
                        if (((Student) student).getImie().equals(klucz)) {
                            iterator.remove();
                        }
                        break;
                    case "index":
                        if (((Student) student).getNrIndeksu() == Integer.parseInt(klucz)) {
                            iterator.remove();
                        }
                        break;
                    case "rokStudiow":
                        if (((Student) student).getRokStudiow() == Integer.parseInt(klucz)) {
                            iterator.remove();
                        }
                        break;
                    default:
                        System.out.println("Niepoprawne kryterium");
                        return;
                }
            }
        }
        Serializator.serializujUczelnie();
    }

    public void usunKurs(String kryterium, String klucz) {
        Iterator<Dane> iterator = uczelnia.getListaKursow().iterator();
        while (iterator.hasNext()) {
            Dane kurs = iterator.next();
            if (kurs instanceof Kurs) {
                switch (kryterium) {
                    case "nazwa":
                        if (((Kurs) kurs).getNazwa().equals(klucz)) {
                            iterator.remove();
                        }
                        break;
                    case "prowadzacy":
                        if (((Kurs) kurs).getProwadzacy().getNazwisko().equals(klucz)) {
                            iterator.remove();
                        }
                        break;
                    case "ects":
                        if (((Kurs) kurs).getPunktyECTS() == Integer.parseInt(klucz)) {
                            iterator.remove();
                        }
                        break;
                    default:
                        System.out.println("Niepoprawne kryterium");
                        return;
                }
            }
        }
        Serializator.serializujUczelnie();
    }
}
