package uczelnia;

import osoba.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GeneratorDanych {
//    private static Uczelnia uczelnia = Uczelnia.getInstance();
    public static String generujTekst(String dane) {
        String[] listaNazwiskMeskich = {
                "Nowak", "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk",
                "Kamiński", "Lewandowski", "Dąbrowski", "Zieliński", "Szymański",
                "Woźniak", "Kozłowski", "Jankowski", "Mazur", "Wojciechowski",
                "Kwiatkowski", "Krawczyk", "Kaczmarek", "Piotrowski", "Grabowski"
        };
        String[] listaNazwiskDamskich = {
                "Nowak", "Kowalska", "Wiśniewska", "Wójcik", "Kowalczyk",
                "Kamińska", "Lewandowska", "Dąbrowska", "Zielińska", "Szymańska",
                "Woźniak", "Kozłowska", "Jankowska", "Mazur", "Wojciechowska",
                "Kwiatkowska", "Krawczyk", "Kaczmarek", "Piotrowska", "Grabowska"
        };
        String[] listaNazwisk = new String[listaNazwiskDamskich.length + listaNazwiskMeskich.length];
        System.arraycopy(listaNazwiskDamskich, 0, listaNazwisk, 0, listaNazwiskDamskich.length);
        System.arraycopy(listaNazwiskMeskich, 0, listaNazwisk, listaNazwiskDamskich.length, listaNazwiskMeskich.length);

        String[] listaImionDamskich = {"Anna", "Maria", "Katarzyna", "Agnieszka", "Joanna",
                "Małgorzata", "Ewa", "Barbara", "Zofia", "Krystyna", "Janina", "Teresa",
                "Elżbieta", "Magdalena", "Ewelina", "Karolina", "Jadwiga", "Irena"};
        String[] listaImionMeskich = {"Jan", "Andrzej", "Piotr", "Krzysztof",
                "Tomasz", "Józef", "Marcin", "Marek", "Grzegorz",
                "Tadeusz", "Adam", "Zbigniew", "Ryszard", "Dariusz",
                "Henryk", "Mariusz", "Kazimierz", "Wojciech", "Robert", "Marian",
                "Jacek", "Janusz", "Maciej", "Kamil", "Jakub", "Edward", "Kamil", "Damian"};
        String[] listaImion = new String[listaImionDamskich.length + listaImionMeskich.length];
        System.arraycopy(listaImionDamskich, 0, listaImion, 0, listaImionDamskich.length);
        System.arraycopy(listaImionMeskich, 0, listaImion, listaImionDamskich.length, listaImionMeskich.length);

        String[] stanowiskaAdministracyjne = {"Dziekan", "Prodziekan", "Kierownik Katedry", "Dyrektor Biura"};
        String[] stanowiskaDydaktycznoBadawcze = {"Profesor", "Doktor", "Magister", "Asystent"};
        String[] nazwyKursow = {"Analiza matematyczna", "Algebra", "Programowanie", "Bazy danych",
                "Systemy operacyjne", "Sieci komputerowe", "Podstawy elektroniki", "Podstawy automatyki",
                "Kurs robienia masla", "Lezenie na plazy", "Kurs picia piwa", "Kurs robienia kursow",
                "Kurs robienia kursow robienia kursow", "Kurs robienia kursow robienia kursow robienia kursow",
                "Wu Ef", "Granie w gry", "Browarnictwo", "Tance fortnite", "Ubijanie mleka"};

        Random rand = new Random();
        switch (dane) {
            case "nazwisko":
                return listaNazwisk[rand.nextInt(listaNazwisk.length)];
            case "imie":
                return listaImion[rand.nextInt(listaImion.length)];
            case "imieDamskie":
                return listaImionDamskich[rand.nextInt(listaImionDamskich.length)];
            case "imieMeskie":
                return listaImionMeskich[rand.nextInt(listaImionMeskich.length)];
            case "nazwiskoDamskie":
                return listaNazwiskDamskich[rand.nextInt(listaNazwiskDamskich.length)];
            case "nazwiskoMeskie":
                return listaNazwiskMeskich[rand.nextInt(listaNazwiskMeskich.length)];
            case "pesel":
                return Long.toString(rand.nextLong(10000000000L, 99999999999L));
            case "stanowiskoAdministracyjne":
                return stanowiskaAdministracyjne[rand.nextInt(stanowiskaAdministracyjne.length)];
            case "stanowiskoDydaktycznoBadawcze":
                return stanowiskaDydaktycznoBadawcze[rand.nextInt(stanowiskaDydaktycznoBadawcze.length)];
            case "nazwaKursu":
                return nazwyKursow[rand.nextInt(nazwyKursow.length)];
            default:
                return "";
        }


    }

    public static Kurs generujKurs() {
        return new Kurs(generujTekst("nazwaKursu"), (PracownikBadawczoDydaktyczny) generujPracownik("dydaktycznoBadawczy"), (new Random()).nextInt(1, 5));
    }

    public static void generujKursy(Uczelnia uczelnia, int liczba) {
        Random rand = new Random();
        for (int i = 0; i < liczba; i++) {
            uczelnia.dodajKurs(generujKurs());
        }
    }

    public static void generujOsoby(Uczelnia uczelnia, int liczba) {
        Random rand = new Random();
        for (int i = 0; i < liczba; i++) {
            Osoba osoba_i;
            if (rand.nextBoolean() && rand.nextBoolean() && rand.nextBoolean()) {
                osoba_i = generujPracownik("administracyjny");
            }
            else if (rand.nextBoolean() && rand.nextBoolean()) {
                osoba_i = generujPracownik("dydaktycznoBadawczy");
            }
            else {
                osoba_i = generujStudent();
            }
            uczelnia.dodajOsobe(osoba_i);
        }
    }

    public static Student generujStudent() {
        char plec = new Random().nextBoolean() ? 'M' : 'K';
        String imie = plec=='M' ? generujTekst("imieMeskie") : generujTekst("imieDamskie");
        String nazwisko = plec=='M' ? generujTekst("nazwiskoMeskie") : generujTekst("nazwiskoDamskie");
        String pesel = generujTekst("pesel");
        int wiek = new Random().nextInt(18, 30);
        int nrIndeksu = new Random().nextInt(299900, 300000);
        int rokStudiow = new Random().nextInt(5);
        Student student = new Student(imie, nazwisko, pesel, wiek, plec, nrIndeksu, rokStudiow);
        return student;
    }

    public static void generujStudentow(Uczelnia uczelnia, int n) {
        for (int i = 0; i < n; i++) {
            uczelnia.dodajOsobe(generujStudent());
        }
    }

    public static void generujPracownikow(Uczelnia uczelnia, int n) {
        for (int i = 0; i < n; i++) {
            if (new Random().nextBoolean()) {
                uczelnia.dodajOsobe(generujPracownik("administracyjny"));
            } else {
                uczelnia.dodajOsobe(generujPracownik("dydaktycznoBadawczy"));
            }
        }
    }

    /**
     * Generuje pracownika uczelni
     * @param rodzaj "administracyjny" lub "dydaktyczno-badawczy"
     * @return obiekt klasy Pracownik
     */
    public static PracownikUczelni generujPracownik(String rodzaj) {
        char plec = new Random().nextBoolean() ? 'M' : 'K';
        String imie = plec=='M' ? generujTekst("imieMeskie") : generujTekst("imieDamskie");
        String nazwisko = plec=='M' ? generujTekst("nazwiskoMeskie") : generujTekst("nazwiskoDamskie");
        String pesel = generujTekst("pesel");
        int wiek = new Random().nextInt(18, 80);
        int stazPracy = new Random().nextInt(30, 100);
        int pensja = new Random().nextInt(5000, 10000);
        String stanowisko;
        PracownikUczelni pracownik;
        switch (rodzaj) {
            case "administracyjny":
                int liczbaNadgodzin = new Random().nextInt(0, 30);
                stanowisko = generujTekst("stanowiskoAdministracyjne");
                pracownik = new PracownikAdministracyjny(imie, nazwisko, pesel, wiek, plec, stanowisko, stazPracy, pensja, liczbaNadgodzin);
                break;
            case "dydaktycznoBadawczy":
                int liczbaPublikacji = new Random().nextInt(0, 25);
                stanowisko = generujTekst("stanowiskoDydaktycznoBadawcze");
                pracownik = new PracownikBadawczoDydaktyczny(imie, nazwisko, pesel, wiek, plec, stanowisko, stazPracy, pensja, liczbaPublikacji);
                break;
            default:
                System.out.println("FAtalny blad");
                pracownik = null;
        }

        return pracownik;
    }
}
