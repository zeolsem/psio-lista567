package uczelnia;
import osoba.*;

import java.util.ArrayList;

public class Uczelnia {
    private ArrayList<Dane> listaOsob;
    private ArrayList<Dane> listaKursow;
    private GeneratorDanych generator;
    private static Uczelnia uczelnia;

    private Uczelnia() {
        this.listaOsob = new ArrayList<>();
        this.listaKursow = new ArrayList<>();
        this.generator = new GeneratorDanych();
    }
    public static Uczelnia getInstance() {
        if (uczelnia == null) {
            uczelnia = new Uczelnia();
        }
        return uczelnia;
    }

    public ArrayList<Dane> getListaOsob() {
        return listaOsob;
    }

    public void setListaOsob(ArrayList<Dane> dlistaOsob) {
        listaOsob = dlistaOsob;
    }
    public ArrayList<Dane> getListaKursow() {
        return listaKursow;
    }

    public void setListaKursow(ArrayList<Dane> dListaKursow) {
        listaKursow = dListaKursow;
    }
    public void dodajOsobe(Osoba osoba) {
        listaOsob.add(osoba);
    }

    public void dodajKurs(Kurs kurs) {
        listaKursow.add(kurs);
    }

    // Metoda wyszukiwania

    // Metody wyświetlania
    public void wyswietlWyszukaneOsoby(ArrayList<Osoba> wyniki) {
        for (Osoba osoba : wyniki) {
            System.out.println(osoba);
        }
    }
    public void wyswietlWyszukaneKursy(ArrayList<Kurs> wyniki) {
        for (Kurs kurs : wyniki) {
            System.out.println(kurs);
        }
    }

    public String generujTekst(String dane) {
        return generator.generujTekst(dane);
    }

    public void wyswietlWszystkieOsoby() {
        for (Dane osoba : listaOsob) {
            System.out.println(osoba);
        }
    }

    public void wyswietlWszystkieKursy() {
        for (Dane kurs : listaKursow) {
            System.out.println(kurs);
        }
    }

}
