package sortowanie;
import osoba.Dane;
import osoba.Kurs;
import osoba.Osoba;
import uczelnia.Uczelnia;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

public class Sortownik {
    private Uczelnia uczelnia;
    public Sortownik() {
        this.uczelnia = Uczelnia.getInstance();
    }

    public void sortujListeOsob(ArrayList<Dane> list, String kryterium) {
        ArrayList<Osoba> listaOsob;
        ArrayList<Dane> noweDane = new ArrayList<>();
        listaOsob = list.stream().filter(dana -> dana instanceof Osoba).map(dana -> (Osoba) dana).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        switch (kryterium) {
            case "nazwisko_i_imie":
                Collections.sort(listaOsob, Comparator.comparing(Osoba::getNazwisko).thenComparing(Osoba::getImie));
                break;
            case "imie":
                Collections.sort(listaOsob, Comparator.comparing(Osoba::getImie));
                break;
            case "nazwisko_i_wiek":
                Collections.sort(listaOsob, Comparator.comparing(Osoba::getNazwisko).thenComparing(Osoba::getWiek, Comparator.reverseOrder()));
                break;
            default:
                System.out.println("NIeprawdilwe kryterium");
        }
        noweDane.addAll(listaOsob);
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
