package uczelnia;

import osoba.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GeneratorDanych {
    private Uczelnia uczelnia;
    public String generujTekst(String dane) {
        String[] listaNazwisk = {
                "Nowak", "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk",
                "Kamiński", "Lewandowski", "Dąbrowski", "Zieliński", "Szymański",
                "Woźniak", "Kozłowski", "Jankowski", "Mazur", "Wojciechowski",
                "Kwiatkowski", "Krawczyk", "Kaczmarek", "Piotrowski", "Grabowski"
        };
        // lista imion meskich i damskich
        String[] listaImion = {"Anna", "Maria", "Katarzyna", "Agnieszka", "Joanna",
                "Małgorzata", "Ewa", "Barbara", "Zofia", "Krystyna"};
        String[] stanowiskaAdministracyjne = {"Dziekan", "Prodziekan", "Kierownik Katedry", "Dyrektor Biura"};
        String[] stanowiskaDydaktycznoBadawcze = {"Profesor", "Doktor", "Magister", "Asystent"};

        Random rand = new Random();
        switch (dane) {
            case "nazwisko":
                return listaNazwisk[rand.nextInt(listaNazwisk.length)];
            case "imie":
                return listaImion[rand.nextInt(listaImion.length)];
            case "pesel":
                return Long.toString(rand.nextLong(10000000000L, 99999999999L));
            case "stanowiskoAdministracyjne":
                return stanowiskaAdministracyjne[rand.nextInt(stanowiskaAdministracyjne.length)];
            case "stanowiskoDydaktycznoBadawcze":
                return stanowiskaDydaktycznoBadawcze[rand.nextInt(stanowiskaDydaktycznoBadawcze.length)];
            default:
                return "";
        }


    }

    public Student generujStudent() {
        String imie = generujTekst("imie");
        String nazwisko = generujTekst("nazwisko");
        String pesel = generujTekst("pesel");
        int wiek = new Random().nextInt(18, 30);
        char plec = new Random().nextBoolean() ? 'M' : 'K';
        int nrIndeksu = new Random().nextInt(200000, 300000);
        int rokStudiow = new Random().nextInt(5);
        Student student = new Student(imie, nazwisko, pesel, wiek, plec, nrIndeksu, rokStudiow);
        return student;
    }

    /**
     * Generuje pracownika uczelni
     * @param rodzaj "administracyjny" lub "dydaktyczno-badawczy"
     * @return obiekt klasy Pracownik
     */
    public PracownikUczelni generujPracownik(String rodzaj) {
        switch (rodzaj) {
            case "administracyjny":
                //
            case "dydaktyczno-badawczy":
                //
        }
        return null;
    }

//    public ArrayList<Osoba>generujListeOsob(int n) {
//        Random rand = new Random();
//        for (int i = 0; i < n; i++) {
//            Osoba osoba_i;
//            char plec = rand.nextBoolean() ? 'M' : 'K';
//            }
//        return
//    }
}
