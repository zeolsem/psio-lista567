package inputhandling;

import osoba.*;
import uczelnia.Uczelnia;
import wyszukiwanie.Wyszukiwarka;

import java.util.Scanner;

public class InputLoop {
    Scanner scanner;
    Wyszukiwarka wyszukiwarka;
    Uczelnia uczelnia;
    boolean running;
    public InputLoop() {
        System.out.println("Witaj w programie do zarzadzania uczelnia\nCo chcesz zrobic?");
        scanner = new Scanner(System.in);
        wyszukiwarka = Wyszukiwarka.getInstance();
        uczelnia = Uczelnia.getInstance();
        running = true;
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
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Wyszukiwanie wszystkich studentow/pracownikow/kursy");
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
                    running = false;
                    break;
                default:
                    System.out.println("hUH");
            }
        }
    }
}
