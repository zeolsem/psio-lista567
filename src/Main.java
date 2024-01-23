import obserwator.DataEntryAmountListener;
import obserwator.DatabaseListener;
import obserwator.EventManager;
import osoba.Osoba;
import serializacja.Serializator;
import sortowanie.Kasownik;
import sortowanie.Sortownik;
import uczelnia.Uczelnia;
import wyszukiwanie.Wyszukiwarka;
import inputhandling.InputLoop;
import gui.GraphicsInputLoop;

import javax.swing.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EventManager eventManager = EventManager.getInstance();
        Uczelnia uczelnia = Uczelnia.getInstance();
        Wyszukiwarka wyszukiwarka = Wyszukiwarka.getInstance();
        Sortownik sortownik = new Sortownik();
        Kasownik kasownik = new Kasownik();
        // events
        DatabaseListener databaseListener = new DatabaseListener();
        DataEntryAmountListener dataEntryAmountListener = new DataEntryAmountListener();
        eventManager.subscribe("databaseUpdate", databaseListener);
        eventManager.subscribe("databaseUpdate", dataEntryAmountListener);


        //loading database
        Serializator.deserializujListeDanych("lista_kursow.txt");
        Serializator.deserializujListeDanych("lista_osob.txt");
        databaseListener.loadDatabaseAlterations();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                InputLoop inputLoop = new InputLoop();
//                inputLoop.loop();
                GraphicsInputLoop.createAndShowGUI();
            }
        });
//        System.out.println("W tej sesji aktualizowales baze danych " + databaseListener.getNewDatabaseAlterations() + " razy.");
//        int totalDBAlterations = databaseListener.getNewDatabaseAlterations() + databaseListener.getOldDatabaseAlterations();
//        System.out.println("Lacznie baza danych byla aktualizowana " + totalDBAlterations + " razy.");
//        databaseListener.saveDatabaseAlterations();

    }
}

//
//import java.util.List;
//
//public class Main {
//
//    public static void main(String[] args) {
//        // init
//        EventManager eventManager = EventManager.getInstance();
//        Uczelnia uczelnia = Uczelnia.getInstance();
//        Wyszukiwarka wyszukiwarka = Wyszukiwarka.getInstance();
//        Sortownik sortownik = new Sortownik();
//        Kasownik kasownik = new Kasownik();
//        // events
//        DatabaseListener databaseListener = new DatabaseListener();
//        eventManager.listeners.put("databaseUpdate", List.of(databaseListener));
//
//        //loading database
//        Serializator.deserializujListeDanych("lista_kursow.txt");
//        Serializator.deserializujListeDanych("lista_osob.txt");
//        databaseListener.loadDatabaseAlterations();
//
////
////        Serializator.serializujUczelnie();
//
//        // serializacja uczelni
////        Serializator.serializujUczelnie();
//
//        // Przykładowe wyszukiwanie i wyświetlanie
////        wyszukiwarka.wyszukajPoKlasie(Student.class, uczelnia.getListaOsob()).forEach(System.out::println);
////        wyszukiwarka.wyszukajPoKlasie(Kurs.class, uczelnia.getListaKursow()).forEach(System.out::println);
////        System.out.println("\nWyszukiwanie studentow po imieniu:");
////        wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "imie", "Maria").forEach(System.out::println);
//////        wyszukaj pracownikow po liczbie nadgodzin
////        System.out.println("\nWyszukiwanie pracownikow po liczbie nadgodzin:");
////        wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "nadgodziny", "10").forEach(System.out::println);
////        // wyszukaj wszystkich pracownikow administracyjnych
////        System.out.println("\nWyszukiwanie pracownikow administracyjnych:");
////        wyszukiwarka.wyszukajPoKlasie(PracownikAdministracyjny.class, uczelnia.getListaOsob()).forEach(System.out::println);
////        // wyszukaj kursy po liczbie pkt ects
////        System.out.println("\nWyszukiwanie kursow po liczbie pkt ects:");
////        wyszukiwarka.wyszukajPoDanych(Kurs.class, uczelnia.getListaKursow(), "ects", "5").forEach(System.out::println);
////
//        InputLoop inputLoop = new InputLoop();
//        inputLoop.loop();
//
////        sortownik.sortujListeOsob(uczelnia.getListaOsob(), "nazwisko_i_imie");
////        uczelnia.getListaOsob().forEach(System.out::println);
////        // sortuj kursy po ects
////        sortownik.sortujListeKursow(uczelnia.getListaKursow(), "ects");
////        uczelnia.getListaKursow().forEach(System.out::println);
//        System.out.println("W tej sesji aktualizowales baze danych " + databaseListener.getNewDatabaseAlterations() + " razy.");
//        int totalDBAlterations = databaseListener.getNewDatabaseAlterations() + databaseListener.getOldDatabaseAlterations();
//        System.out.println("Lacznie baza danych byla aktualizowana " + totalDBAlterations + " razy.");
//        databaseListener.saveDatabaseAlterations();
//    }
//}