package inputhandling;

import obserwator.EventManager;
import osoba.*;
import serializacja.Serializator;
import sortowanie.Kasownik;
import sortowanie.Sortownik;
import uczelnia.GeneratorDanych;
import uczelnia.Uczelnia;
import wyszukiwanie.Wyszukiwarka;

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
        int choice2 = safeScanInt();
        switch (choice2) {
            case 1 -> {
                System.out.println("Wyszukiwanie studentow");
                wyszukiwarka.wyszukajPoKlasie(Student.class, uczelnia.getListaOsob()).forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Wyszukiwanie pracownikow");
                System.out.println("1. Wyszukaj pracownikow administracyjnych");
                System.out.println("2. Wyszukaj pracownikow dydaktyczno-badawczych");
                int choice3 = safeScanInt();
                switch (choice3) {
                    case 1 -> {
                        System.out.println("Wyszukiwanie pracownikow administracyjnych");
                        wyszukiwarka.wyszukajPoKlasie(PracownikAdministracyjny.class, uczelnia.getListaOsob()).forEach(System.out::println);
                    }
                    case 2 -> {
                        System.out.println("Wyszukiwanie pracownikow dydaktyczno-badawczych");
                        wyszukiwarka.wyszukajPoKlasie(PracownikBadawczoDydaktyczny.class, uczelnia.getListaOsob()).forEach(System.out::println);
                    }
                    default -> System.out.println("Nie ma takiej opcji");
                }
            }
            case 3 -> {
                System.out.println("Wyszukiwanie kursow");
                wyszukiwarka.wyszukajPoKlasie(Kurs.class, uczelnia.getListaKursow()).forEach(System.out::println);
            }
            default -> System.out.println("Nie ma takiej opcji");
        }

    }

    public void wyszukajStudentowPoDanych() {
        System.out.println("1. Wyszukaj studentow po imieniu");
        System.out.println("2. Wyszukaj studentow po nazwisku");
        System.out.println("3. Wyszukaj studentow po indexie");
        System.out.println("4. Wyszukaj studentow po roku studiow");
        System.out.println("5. Wyszukaj studentow po nazwie kursu");
        int choice2 = safeScanInt();
        switch (choice2) {
            case 1 -> {
                System.out.println("Wyszukiwanie studentow po imieniu");
                System.out.println("Podaj imie");
                wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "imie", scanner.next()).forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Wyszukiwanie studentow po nazwisku");
                System.out.println("Podaj nazwisko");
                wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "nazwisko", scanner.next()).forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("Wyszukiwanie studentow po indexie");
                System.out.println("Podaj index");
                wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "index", scanner.next()).forEach(System.out::println);
            }
            case 4 -> {
                System.out.println("Wyszukiwanie studentow po roku studiow");
                System.out.println("Podaj rok studiow");
                wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "rok_studiow", scanner.next()).forEach(System.out::println);
            }
            case 5 -> {
                System.out.println("Wyszukiwanie studentow po nazwie kursu");
                System.out.println("Podaj nazwe kursu");
                wyszukiwarka.wyszukajPoDanych(Student.class, uczelnia.getListaOsob(), "nazwa_kursu", scanner.next()).forEach(System.out::println);
            }
            default -> System.out.println("Nuh UHH");
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
        int choice2 = safeScanInt();
        switch (choice2) {
            case 1 -> {
                System.out.println("Wyszukiwanie pracownikow administracyjnych po imieniu");
                System.out.println("Podaj imie");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "imie", scanner.next()).forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Wyszukiwanie pracownikow administracyjnych po nazwisku");
                System.out.println("Podaj nazwisko");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "nazwisko", scanner.next()).forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("Wyszukiwanie pracownikow administracyjnych po staz_pracy");
                System.out.println("Podaj staz_pracy");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "staz_pracy", scanner.next()).forEach(System.out::println);
            }
            case 4 -> {
                System.out.println("Wyszukiwanie pracownikow administracyjnych po stanowisku");
                System.out.println("Podaj stanowisko");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "stanowisko", scanner.next()).forEach(System.out::println);
            }
            case 5 -> {
                System.out.println("Wyszukiwanie pracownikow administracyjnych po pensji");
                System.out.println("Podaj pensje");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "pensja", scanner.next()).forEach(System.out::println);
            }
            case 6 -> {
                System.out.println("Wyszukiwanie pracownikow administracyjnych po liczbie nadgodzin");
                System.out.println("Podaj liczbe nadgodzin");
                wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "nadgodziny", scanner.next()).forEach(System.out::println);
            }
            default -> System.out.println("Nuh UHH");
        }
    }

    public void wyszukajKursyPoDanych() {
        System.out.println("1. Wyszukaj kursy po nazwie");
        System.out.println("2. Wyszukaj kursy po prowadzacym");
        System.out.println("3. Wyszukaj kursy po liczbie ects");
        int choice2 = safeScanInt();
        switch (choice2) {
            case 1 -> {
                System.out.println("Wyszukiwanie kursow po nazwie");
                System.out.println("Podaj nazwe");
                wyszukiwarka.wyszukajPoDanych(Kurs.class, uczelnia.getListaKursow(), "nazwa", scanner.next()).forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Wyszukiwanie kursow po prowadzacym");
                System.out.println("Podaj prowadzacego");
                wyszukiwarka.wyszukajPoDanych(Kurs.class, uczelnia.getListaKursow(), "prowadzacy", scanner.next()).forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("Wyszukiwanie kursow po liczbie ects");
                System.out.println("Podaj liczbe ects");
                wyszukiwarka.wyszukajPoDanych(Kurs.class, uczelnia.getListaKursow(), "ects", scanner.next()).forEach(System.out::println);
            }
            default -> System.out.println("Nuh UHH");
        }
    }

    public int safeScanInt() throws NumberFormatException {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Zly input");
            return 0;
        }
    }

    public String safeScanString(){
            return scanner.next();
    }

    public void loop() {
        Sortownik sortownik = new Sortownik();
        while (running) {
            System.out.println("1. Wyszukaj wszystkich studentow/pracownikow/kursy");
            System.out.println("2. Wyszukaj studentow po danych");
            System.out.println("3. Wyszukaj pracownikow po danych");
            System.out.println("4. Wyszukaj kursy po danych");
            System.out.println("5. Wyjdz z programu");
            System.out.println("6. Generuj nowe osoby");
            System.out.println("7. Generuj nowe kursy");
            System.out.println("8. Zapis do bazy danych");
            System.out.println("9. Sortowanie list kursow i osob po kryterium");
            System.out.println("10. Usuwanie wpisow z bazy danych");
            System.out.println("11. Usuwanie calej listy z bazy danych (OSTROZNIE!)");
            int choice = safeScanInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Wyszukiwanie wszystkich studentow/pracownikow/kursow");
                    wyszukajPoKlasie();
                }
                case 2 -> {
                    System.out.println("Wyszukiwanie studentow po danych");
                    wyszukajStudentowPoDanych();
                    scanner.nextLine();
                }
                case 3 -> {
                    System.out.println("Wyszukiwanie pracownikow po danych");
                    wyszukajPracownikowPoDanych();
                    scanner.nextLine();
                }
                case 4 -> {
                    System.out.println("Wyszukiwanie kursow po danych");
                    wyszukajKursyPoDanych();
                    scanner.nextLine();
                }
                case 5 -> {
                    System.out.println("Do widzenia slepa Gienia");
                    running = false;
                }
                case 6 -> {
                    System.out.println("Generowanie nowych osób");
                    System.out.println("1. Generuj studentow");
                    System.out.println("2. Generuj pracownikow");
                    System.out.println("3. Generuj wszystkie osoby");
                    int choice2 = safeScanInt();
                    System.out.println("Podaj liczbe osob do wygenerowania: ");
                    choice = safeScanInt();
                    switch (choice2) {
                        case 1 -> GeneratorDanych.generujStudentow(uczelnia, choice);
                        case 2 -> GeneratorDanych.generujPracownikow(uczelnia, choice);
                        case 3 -> GeneratorDanych.generujOsoby(uczelnia, choice);
                        default -> System.out.println("hUH");
                    }
                }
                case 7 -> {
                    System.out.println("Generowanie nowych kursow");
                    System.out.println("Podaj liczbe kursow do wygenerowania: ");
                    choice = safeScanInt();
                    GeneratorDanych.generujKursy(uczelnia, choice);
                }
                case 8 -> {
                    System.out.println("Zapis do bazy danych");
                    Serializator.serializujUczelnie();
                    EventManager.getInstance().notify("databaseUpdate", null);
                }
                case 9 -> {
                    System.out.println("Wybierz ktora liste chcesz sortowac");
                    System.out.println("1. Lista osob");
                    System.out.println("2. Lista kursow");
                    choice = safeScanInt();
                    String choice3;
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Podaj kryterium: 'imie', 'nazwisko_i_imie', 'nazwisko_i_wiek'");
                            choice3 = safeScanString();
                            sortownik.sortujListeOsob(uczelnia.getListaOsob(), choice3);
                        }
                        case 2 -> {
                            System.out.println("Podaj kryterium: 'ects', 'prowadzacy_nazwisko'");
                            choice3 = safeScanString();
                            sortownik.sortujListeKursow(uczelnia.getListaKursow(), choice3);
                        }
                    }
                    System.out.println("Lista posortowana.");
                    scanner.nextLine();
                }
                case 10 -> {
                    System.out.println("Usuwanie wpisow z bazy danych");
                    System.out.println("1. Usun studenta");
                    System.out.println("2. Usun pracownika");
                    System.out.println("3. Usun kurs");
                    choice = safeScanInt();
                    String kryterium, wartosc;
                    int usunieci = 0;
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Usuwanie studenta");
                            System.out.println("Podaj dana po ktorej usuwasz i klucz usuniecia: ");
                            System.out.println("Mozliwe dane to: imie, nazwisko, index, rokStudiow");
                            kryterium = safeScanString();
                            wartosc = safeScanString();
                            usunieci = kasownik.usunStudenta(kryterium, wartosc);
                        }
                        case 2 -> {
                            System.out.println("Usuwanie pracownika");
                            System.out.println("Podaj dana po ktorej usuwasz i klucz usuniecia: ");
                            System.out.println("Mozliwe dane to: imie, nazwisko, stazPracy, stanowisko");
                            kryterium = safeScanString();
                            wartosc = safeScanString();
                            usunieci = kasownik.usunPracownika(kryterium, wartosc);
                        }
                        case 3 -> {
                            System.out.println("Usuwanie kursu");
                            System.out.println("Podaj dana po ktorej usuwasz i klucz usuniecia: ");
                            System.out.println("Mozliwe dane to: nazwa, prowadzacy (nazwisko), ects");
                            kryterium = safeScanString();
                            wartosc = safeScanString();
                            usunieci = kasownik.usunKurs(kryterium, wartosc);
                        }
                        default -> System.out.println("hUH");
                    }
                    System.out.println(usunieci);
                }
                case 11 -> {
                    System.out.println("Usuwanie calej listy z bazy danych (OSTROZNIE!)");
                    System.out.println("1. Usun liste studentow");
                    System.out.println("2. Usun liste pracownikow");
                    System.out.println("3. Usun liste kursow");
                    choice = safeScanInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Usun liste studentow");
                            uczelnia.getListaOsob().removeIf(osoba -> osoba instanceof Student);
                        }
                        case 2 -> {
                            System.out.println("Usun liste pracownikow");
                            uczelnia.getListaOsob().removeIf(osoba -> osoba instanceof PracownikUczelni);
                        }
                        case 3 -> {
                            System.out.println("Usun liste kursow");
                            uczelnia.getListaKursow().clear();
                        }
                        default -> System.out.println("hUH");
                    }
                }
                default -> System.out.println("hUH");
            }
        }
    }
}
