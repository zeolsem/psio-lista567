package sortowanie;

import osoba.Dane;
import osoba.Kurs;
import osoba.PracownikUczelni;
import osoba.Student;
import serializacja.Serializator;
import uczelnia.Uczelnia;

import java.util.Iterator;

public class Kasownik {
    private Uczelnia uczelnia;
    public Kasownik() {
        uczelnia = Uczelnia.getInstance();
    }

    public int usunPracownika(String kryterium, String klucz) {
        Iterator<Dane> iterator = uczelnia.getListaOsob().iterator();
        int usunieci = 0;
        while (iterator.hasNext()) {
            Dane pracownik = iterator.next();
            if (pracownik instanceof PracownikUczelni) {
                switch (kryterium) {
                    case "nazwisko" -> {
                        if (((PracownikUczelni) pracownik).getNazwisko().equals(klucz)) {
                            iterator.remove();
                            usunieci++;
                        }
                    }
                    case "imie" -> {
                        if (((PracownikUczelni) pracownik).getImie().equals(klucz)) {
                            iterator.remove();
                            usunieci++;
                        }
                    }
                    case "stazPracy" -> {
                        if (((PracownikUczelni) pracownik).getStazPracy() == Integer.parseInt(klucz)) {
                            iterator.remove();
                            usunieci++;
                        }
                    }
                    case "stanowisko" -> {
                        if (((PracownikUczelni) pracownik).getStanowisko().equals(klucz)) {
                            iterator.remove();
                            usunieci++;
                        }
                    }
                    default -> System.out.println("Niepoprawne kryterium");
                }
            }
        }
        Serializator.serializujUczelnie();
        return usunieci;
    }

    public int usunStudenta(String kryterium, String klucz) {
        Iterator<Dane> iterator = uczelnia.getListaOsob().iterator();
        int usunieci = 0;
        while (iterator.hasNext()) {
            Dane student = iterator.next();
            if (student instanceof Student) {
                switch (kryterium) {
                    case "nazwisko" -> {
                        if (((Student) student).getNazwisko().equals(klucz)) {
                            iterator.remove();
                            usunieci++;
                        }
                    }
                    case "imie" -> {
                        if (((Student) student).getImie().equals(klucz)) {
                            iterator.remove();
                            usunieci++;
                        }
                    }
                    case "index" -> {
                        if (((Student) student).getNrIndeksu() == Integer.parseInt(klucz)) {
                            iterator.remove();
                            usunieci++;
                        }
                    }
                    case "rokStudiow" -> {
                        if (((Student) student).getRokStudiow() == Integer.parseInt(klucz)) {
                            iterator.remove();
                            usunieci++;
                        }
                    }
                    default -> System.out.println("Niepoprawne kryterium");
                }
            }
        }
        Serializator.serializujUczelnie();
        return usunieci;
    }

    public int usunKurs(String kryterium, String klucz) {
        Iterator<Dane> iterator = uczelnia.getListaKursow().iterator();
        int usunieci = 0;
        while (iterator.hasNext()) {
            Dane kurs = iterator.next();
            if (kurs instanceof Kurs) {
                switch (kryterium) {
                    case "nazwa" -> {
                        if (((Kurs) kurs).getNazwa().equals(klucz)) {
                            iterator.remove();
                            usunieci++;
                        }
                    }
                    case "prowadzacy" -> {
                        if (((Kurs) kurs).getProwadzacy().getNazwisko().equals(klucz)) {
                            iterator.remove();
                            usunieci++;
                        }
                    }
                    case "ects" -> {
                        if (((Kurs) kurs).getPunktyECTS() == Integer.parseInt(klucz)) {
                            iterator.remove();
                            usunieci++;
                        }
                    }
                    default -> System.out.println("Niepoprawne kryterium");
                }
            }
        }
        Serializator.serializujUczelnie();
        return usunieci;
    }
}
