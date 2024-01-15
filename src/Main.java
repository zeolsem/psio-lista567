import osoba.*;
import osoba.Kurs;
import serializacja.Serializator;
import sortowanie.Sortownik;
import uczelnia.Uczelnia;
import wyszukiwanie.Wyszukiwarka;
import inputhandling.InputLoop;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Uczelnia uczelnia = Uczelnia.getInstance();
        Wyszukiwarka wyszukiwarka = new Wyszukiwarka();
        Serializator.deserializujListeDanych("lista_kursow.txt");
        Serializator.deserializujListeDanych("lista_osob.txt");

        PracownikBadawczoDydaktyczny prowadzacy1 = new PracownikBadawczoDydaktyczny("Jan", "Nowak", "12345678901", 35, 'M', "Wykladowca", 10, 10000, 10);
        PracownikBadawczoDydaktyczny prowadzacy2 = new PracownikBadawczoDydaktyczny("Anna", "Kowalska", "12345678901", 35, 'K', "Asystent", 20, 5000, 5000);
//        PracownikAdministracyjny pracownik = new PracownikAdministracyjny("Jan", "Kowalski", "12345678901", 35, 'M', "Dziekan", 10, 10000, 10);
//        Random rand = new Random();
//        for (int i = 0; i < 100; i ++) {
//            Osoba osoba_i;
//            char plec = rand.nextBoolean() ? 'M' : 'K';
//            if (rand.nextBoolean() && rand.nextBoolean()) {
//                osoba_i = new PracownikBadawczoDydaktyczny(uczelnia.generujTekst("imie"), uczelnia.generujTekst("nazwisko"), uczelnia.generujTekst("pesel"), rand.nextInt(80), plec, uczelnia.generujTekst("stanowiskoAdministracyjne"), rand.nextInt(30, 100), rand.nextInt(5000, 10000), rand.nextInt(0, 25));
//            }
//            else if (rand.nextBoolean() && rand.nextBoolean()) {
//                osoba_i = new PracownikAdministracyjny(uczelnia.generujTekst("imie"), uczelnia.generujTekst("nazwisko"), uczelnia.generujTekst("pesel"), rand.nextInt(80), plec, uczelnia.generujTekst("stanowiskoDydaktycznoBadawcze"), rand.nextInt(30, 100), rand.nextInt(5000, 10000), rand.nextInt(0, 30));
//            }
//            else {
//                osoba_i = new Student(uczelnia.generujTekst("imie"), uczelnia.generujTekst("nazwisko"), uczelnia.generujTekst("pesel"), rand.nextInt(30), plec,
//                rand.nextInt(200000, 300000), rand.nextInt(5));
//            }
//            uczelnia.dodajOsobe(osoba_i);
//        }
//
        Kurs kurs1 = new Kurs("Informatyka", prowadzacy1, 6);
        Kurs kurs2 = new Kurs("Matematyka", prowadzacy2, 5);

        uczelnia.dodajKurs(kurs1);
        uczelnia.dodajKurs(kurs2);
//        uczelnia.dodajOsobe(prowadzacy1);
//        uczelnia.dodajOsobe(prowadzacy2);
//        uczelnia.dodajOsobe(pracownik);

        // serializacja uczelni
//        Serializator.serializujUczelnie();

        // Przykładowe wyszukiwanie i wyświetlanie
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
//        InputLoop inputLoop = new InputLoop();
//        inputLoop.loop();

        Sortownik sortownik = new Sortownik();
        sortownik.sortujListeOsob(uczelnia.getListaOsob(), "nazwisko_i_imie");
        uczelnia.getListaOsob().forEach(System.out::println);
        // sortuj kursy po ects
        sortownik.sortujListeKursow(uczelnia.getListaKursow(), "ects");
        uczelnia.getListaKursow().forEach(System.out::println);
    }
}