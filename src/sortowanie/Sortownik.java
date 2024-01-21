package sortowanie;
import osoba.Dane;
import osoba.Kurs;
import osoba.Osoba;
import uczelnia.Uczelnia;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Sortownik {
    private Uczelnia uczelnia = Uczelnia.getInstance();
    public Sortownik() {
        this.uczelnia = Uczelnia.getInstance();
    }

    public void sortujListeOsob(ArrayList<Dane> list, String kryterium) {
        ArrayList<Osoba> listaOsob = new ArrayList<>();

        for (Dane dana : list) {
            if (dana instanceof Osoba) {
                listaOsob.add((Osoba) dana);
            }
        }

        list = new ArrayList<>(new HashSet<>(list));
        switch (kryterium) {
            case "nazwisko_i_imie":
                listaOsob.sort(Comparator.comparing(Osoba::getNazwisko).thenComparing(Osoba::getImie));
                break;
            case "imie":
                listaOsob.sort(Comparator.comparing(Osoba::getImie));
                break;
            case "nazwisko_i_wiek":
                listaOsob.sort(Comparator.comparing(Osoba::getNazwisko).thenComparing(Osoba::getWiek, Comparator.reverseOrder()));
                break;
            default:
                System.out.println("Nieprawidłowe kryterium");
                return;
        }

        ArrayList<Dane> noweDane = new ArrayList<>(listaOsob);
        uczelnia.setListaOsob(noweDane);
    }

    public void sortujListeKursow(ArrayList<Dane> list, String kryterium) {
        ArrayList<Kurs> listaKursow;
        ArrayList<Dane> noweDane = new ArrayList<>();
        listaKursow = list.stream().filter(dana -> dana instanceof Kurs).map(dana -> (Kurs) dana).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        switch (kryterium) {
            case "ects":
                Collections.sort(listaKursow, Comparator.comparing(Kurs::getPunktyECTS));
                break;
            case "prowadzacy_nazwisko":
                Collections.sort(listaKursow, Comparator.comparing(kurs -> kurs.getProwadzacy().getNazwisko()));
                break;
            default:
                System.out.println("NIeprawdilwe kryterium");
        }
        noweDane.addAll(listaKursow);
        uczelnia.setListaKursow(noweDane);
    }
}
