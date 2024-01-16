package inputhandling;

import com.sun.tools.javac.Main;
import osoba.*;
import serializacja.Serializator;
import sortowanie.Kasownik;
import uczelnia.GeneratorDanych;
import uczelnia.Uczelnia;
import wyszukiwanie.Wyszukiwarka;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class InputLoop {
    Scanner scanner;
    Wyszukiwarka wyszukiwarka;
    Uczelnia uczelnia;
    Kasownik kasownik;
    boolean running;
    public InputLoop() {
        System.out.println("Witaj w programie do zarzadzania uczelnia\nCo chcesz zrobic?");
        scanner = new Scanner(System.in);
        wyszukiwarka = Wyszukiwarka.getInstance();
        uczelnia = Uczelnia.getInstance();
        running = true;
        kasownik = new Kasownik();
    }

    public void wyszukajPoKlasie() {
        System.out.println("1. Wyszukaj studentow");
        System.out.println("2. Wyszukaj pracownikow");
        System.out.println("3. Wyszukaj kursy");
        int choice2 = scanner.nextInt();
        switch (choice2) {
            case 1:
                System.out.println("Wyszukiwanie studentow");
                wyszukiwarka.wyszukajPoKlasie(Student.class, uczelnia.getListaOsob()).forEach(System.out::println);
                break;
            case 2:
                System.out.println("Wyszukiwanie pracownikow");
                System.out.println("1. Wyszukaj pracownikow administracyjnych");
                System.out.println("2. Wyszukaj pracownikow dydaktyczno-badawczych");
                int choice3 = scanner.nextInt();
                switch (choice3) {
                    case 1:
                        System.out.println("Wyszukiwanie pracownikow administracyjnych");
                        wyszukiwarka.wyszukajPoKlasie(PracownikAdministracyjny.class, uczelnia.getListaOsob()).forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Wyszukiwanie pracownikow dydaktyczno-badawczych");
                        wyszukiwarka.wyszukajPoKlasie(PracownikBadawczoDydaktyczny.class, uczelnia.getListaOsob()).forEach(System.out::println);
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji");
                }
                break;
            case 3:
                System.out.println("Wyszukiwanie kursow");
                wyszukiwarka.wyszukajPoKlasie(Kurs.class, uczelnia.getListaKursow()).forEach(System.out::println);
                break;
            default:
                System.out.println("Nie ma takiej opcji");
        }

    }

    public void wyszukajStudentowPoDanych() {
        System.out.println("1. Wyszukaj studentow po imieniu");
        System.out.println("2. Wyszukaj studentow po nazwisku");
        System.out.println("3. Wyszukaj studentow po indexie");
        System.out.println("4. Wyszukaj studentow po roku studiow");
        System.out.println("5. Wyszukaj studentow po nazwie kursu");
        int choice2 = scanner.nextInt();
        switch (choice2) {
            case 1:
                System.out.println("Wyszukiwanie studentow po imieniu");
                System.out.println("Podaj imie");
                wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "imie", scanner.next()).forEach(System.out::println);
                break;
            case 2:
                System.out.println("Wyszukiwanie studentow po nazwisku");
                System.out.println("Podaj nazwisko");
                wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "nazwisko", scanner.next()).forEach(System.out::println);
                break;
            case 3:
                System.out.println("Wyszukiwanie studentow po indexie");
                System.out.println("Podaj index");
                wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "index", scanner.next()).forEach(System.out::println);
                break;
            case 4:
                System.out.println("Wyszukiwanie studentow po roku studiow");
                System.out.println("Podaj rok studiow");
                wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "rok_studiow", scanner.next()).forEach(System.out::println);
                break;
            case 5:
                System.out.println("Wyszukiwanie studentow po nazwie kursu");
                System.out.println("Podaj nazwe kursu");
                wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "nazwa_kursu", scanner.next()).forEach(System.out::println);
                break;
            default:
                System.out.println("Nuh UHH");
        }

    }


    public void wyszukajPracownikowPoDanych() {
        System.out.println("Wyszukiwanie pracownikow po danych");
        System.out.println("Wyszukiwanie pracownikow administracyjnych po danych");
        System.out.println("1. Wyszukaj pracownikow administracyjnych po imieniu");
        System.out.println("2. Wyszukaj pracownikow administracyjnych po nazwisku");
        System.out.println("3. Wyszukaj pracownikow administracyjnych po staz_pracy");
        System.out.println("4. Wyszukaj pracownikow administracyjnych po stanowisku");
        System.out.println("5. Wyszukaj pracownikow administracyjnych po pensji");
        System.out.println("6. Wyszukaj pracownikow administracyjnych po liczbie nadgodzin");
        int choice2 = scanner.nextInt();
        switch (choice2) {
            case 1:
                System.out.println("Wyszukiwanie pracownikow administracyjnych po imieniu");
                System.out.println("Podaj imie");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "imie", scanner.next()).forEach(System.out::println);
                break;
            case 2:
                System.out.println("Wyszukiwanie pracownikow administracyjnych po nazwisku");
                System.out.println("Podaj nazwisko");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "nazwisko", scanner.next()).forEach(System.out::println);
                break;
            case 3:
                System.out.println("Wyszukiwanie pracownikow administracyjnych po staz_pracy");
                System.out.println("Podaj staz_pracy");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "staz_pracy", scanner.next()).forEach(System.out::println);
                break;
            case 4:
                System.out.println("Wyszukiwanie pracownikow administracyjnych po stanowisku");
                System.out.println("Podaj stanowisko");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "stanowisko", scanner.next()).forEach(System.out::println);
                break;
            case 5:
                System.out.println("Wyszukiwanie pracownikow administracyjnych po pensji");
                System.out.println("Podaj pensje");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "pensja", scanner.next()).forEach(System.out::println);
                break;
            case 6:
                System.out.println("Wyszukiwanie pracownikow administracyjnych po liczbie nadgodzin");
                System.out.println("Podaj liczbe nadgodzin");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "nadgodziny", scanner.next()).forEach(System.out::println);
                break;
            default:
                System.out.println("Nuh UHH");
        }
    }

    public void wyszukajKursyPoDanych() {
        System.out.println("1. Wyszukaj kursy po nazwie");
        System.out.println("2. Wyszukaj kursy po prowadzacym");
        System.out.println("3. Wyszukaj kursy po liczbie ects");
        int choice2 = scanner.nextInt();
        switch (choice2) {
            case 1:
                System.out.println("Wyszukiwanie kursow po nazwie");
                System.out.println("Podaj nazwe");
                wyszukiwarka.wyszukajPoDanych(Kurs.class, uczelnia.getListaKursow(), "nazwa", scanner.next()).forEach(System.out::println);
                break;
            case 2:
                System.out.println("Wyszukiwanie kursow po prowadzacym");
                System.out.println("Podaj prowadzacego");
                wyszukiwarka.wyszukajPoDanych(Kurs.class, uczelnia.getListaKursow(), "prowadzacy", scanner.next()).forEach(System.out::println);
                break;
            case 3:
                System.out.println("Wyszukiwanie kursow po liczbie ects");
                System.out.println("Podaj liczbe ects");
                wyszukiwarka.wyszukajPoDanych(Kurs.class, uczelnia.getListaKursow(), "ects", scanner.next()).forEach(System.out::println);
                break;
            default:
                System.out.println("Nuh UHH");
        }
    }

    public void loop() {
        while (running) {
            System.out.println("1. Wyszukaj wszystkich studentow/pracownikow/kursy");
            System.out.println("2. Wyszukaj studentow po danych");
            System.out.println("3. Wyszukaj pracownikow po danych");
            System.out.println("4. Wyszukaj kursy po danych");
            System.out.println("5. Wyjdz z programu");
            System.out.println("6. Generuj nowe osoby");
            System.out.println("7. Generuj nowe kursy");
            System.out.println("8. Zapis do bazy danych");
            System.out.println("9. Usuwanie duplikatow z bazy danych");
            System.out.println("10. Usuwanie wpisow z bazy danych");
            System.out.println("11. Usuwanie calej listy z bazy danych (OSTROZNIE!)");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Wyszukiwanie wszystkich studentow/pracownikow/kursow");
                    wyszukajPoKlasie();
                    break;
                case 2:
                    System.out.println("Wyszukiwanie studentow po danych");
                    wyszukajStudentowPoDanych();
                    break;
                case 3:
                    System.out.println("Wyszukiwanie pracownikow po danych");
                    wyszukajPracownikowPoDanych();
                    break;
                case 4:
                    System.out.println("Wyszukiwanie kursow po danych");
                    wyszukajKursyPoDanych();
                    break;
                case 5:
                    System.out.println("Do widzenia slepa Gienia");
                    running = false;
                    break;
                case 6:
                    System.out.println("Generowanie nowych osób");
                    System.out.println("1. Generuj studentow");
                    System.out.println("2. Generuj pracownikow");
                    System.out.println("3. Generuj wszystkie osoby");
                    int choice2 = scanner.nextInt();
                    System.out.println("Podaj liczbe osob do wygenerowania: ");
                    choice = scanner.nextInt();
                    switch (choice2) {
                        case 1:
                            GeneratorDanych.generujStudentow(uczelnia, choice);
                            break;
                        case 2:
                            GeneratorDanych.generujPracownikow(uczelnia, choice);
                            break;
                        case 3:
                            GeneratorDanych.generujOsoby(uczelnia, choice);
                            break;
                        default:
                            System.out.println("hUH");
                    }
                    break;
                case 7:
                    System.out.println("Generowanie nowych kursow");
                    System.out.println("Podaj liczbe kursow do wygenerowania: ");
                    choice = scanner.nextInt();
                    GeneratorDanych.generujKursy(uczelnia, choice);
                    break;
                case 8:
                    System.out.println("Zapis do bazy danych");
                    Serializator.serializujUczelnie();
                    break;
                case 9:
                    System.out.println("Usuwanie duplikatow z bazy danych");
                    uczelnia.setListaOsob(uczelnia.getListaOsob());
                    break;
                case 10:
                    System.out.println("Usuwanie wpisow z bazy danych");
                    System.out.println("1. Usun studenta");
                    System.out.println("2. Usun pracownika");
                    System.out.println("3. Usun kurs");
                    choice = scanner.nextInt();
                    String kryterium, wartosc;
                    switch (choice) {
                        case 1:
                            System.out.println("Usuwanie studenta");
                            System.out.println("Podaj dana po ktorej usuwasz i klucz usuniecia: ");
                            System.out.println("Mozliwe dane to: imie, nazwisko, index, rokStudiow");
                            kryterium = scanner.next();
                            wartosc = scanner.next();
                            kasownik.usunStudenta(kryterium, wartosc);
                            break;
                        case 2:
                            System.out.println("Usuwanie pracownika");
                            System.out.println("Podaj dana po ktorej usuwasz i klucz usuniecia: ");
                            System.out.println("Mozliwe dane to: imie, nazwisko, stazPracy, stanowisko");
                            kryterium = scanner.next();
                            wartosc = scanner.next();
                            kasownik.usunPracownika(kryterium, wartosc);
                            break;
                        case 3:
                            System.out.println("Usuwanie kursu");
                            System.out.println("Podaj dana po ktorej usuwasz i klucz usuniecia: ");
                            System.out.println("Mozliwe dane to: nazwa, prowadzacy (nazwisko), ects");
                            kryterium = scanner.next();
                            wartosc = scanner.next();
                            kasownik.usunKurs(kryterium, wartosc);
                            break;
                        default:
                            System.out.println("hUH");
                    }
                    break;
                case 11:
                    System.out.println("Usuwanie calej listy z bazy danych (OSTROZNIE!)");
                    System.out.println("1. Usun liste studentow");
                    System.out.println("2. Usun liste pracownikow");
                    System.out.println("3. Usun liste kursow");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Usun liste studentow");
                            uczelnia.getListaOsob().removeIf(osoba -> osoba instanceof Student);
                            break;
                        case 2:
                            System.out.println("Usun liste pracownikow");
                            uczelnia.getListaOsob().removeIf(osoba -> osoba instanceof PracownikUczelni);
                            break;
                        case 3:
                            System.out.println("Usun liste kursow");
                            uczelnia.getListaKursow().clear();
                            break;
                        default:
                            System.out.println("hUH");
                    }
                    break;
                default:
                    System.out.println("hUH");
            }
        }
    }
}
