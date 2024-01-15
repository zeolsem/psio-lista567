import osoba.*;
import osoba.Kurs;
import serializacja.Serializator;
import sortowanie.Kasownik;
import sortowanie.Sortownik;
import uczelnia.GeneratorDanych;
import uczelnia.Uczelnia;
import wyszukiwanie.Wyszukiwarka;
import inputhandling.InputLoop;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Uczelnia uczelnia = Uczelnia.getInstance();
        Wyszukiwarka wyszukiwarka = Wyszukiwarka.getInstance();
        Sortownik sortownik = new Sortownik();
        Kasownik kasownik = new Kasownik();

        Serializator.deserializujListeDanych("lista_kursow.txt");
        Serializator.deserializujListeDanych("lista_osob.txt");
//
//        Serializator.serializujUczelnie();

        // serializacja uczelni
//        Serializator.serializujUczelnie();

        // Przykładowe wyszukiwanie i wyświetlanie
//        wyszukiwarka.wyszukajPoKlasie(Student.class, uczelnia.getListaOsob()).forEach(System.out::println);
//        wyszukiwarka.wyszukajPoKlasie(Kurs.class, uczelnia.getListaKursow()).forEach(System.out::println);
//        System.out.println("\nWyszukiwanie studentow po imieniu:");
//        wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "imie", "Maria").forEach(System.out::println);
////        wyszukaj pracownikow po liczbie nadgodzin
//        System.out.println("\nWyszukiwanie pracownikow po liczbie nadgodzin:");
//        wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "nadgodziny", "10").forEach(System.out::println);
//        // wyszukaj wszystkich pracownikow administracyjnych
//        System.out.println("\nWyszukiwanie pracownikow administracyjnych:");
//        wyszukiwarka.wyszukajPoKlasie(PracownikAdministracyjny.class, uczelnia.getListaOsob()).forEach(System.out::println);
//        // wyszukaj kursy po liczbie pkt ects
//        System.out.println("\nWyszukiwanie kursow po liczbie pkt ects:");
//        wyszukiwarka.wyszukajPoDanych(Kurs.class, uczelnia.getListaKursow(), "ects", "5").forEach(System.out::println);
//
        InputLoop inputLoop = new InputLoop();
        inputLoop.loop();

//        sortownik.sortujListeOsob(uczelnia.getListaOsob(), "nazwisko_i_imie");
//        uczelnia.getListaOsob().forEach(System.out::println);
//        // sortuj kursy po ects
//        sortownik.sortujListeKursow(uczelnia.getListaKursow(), "ects");
//        uczelnia.getListaKursow().forEach(System.out::println);
    }
}