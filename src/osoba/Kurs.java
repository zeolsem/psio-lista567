package osoba;

import java.io.Serializable;

public class Kurs extends Dane implements Serializable {
    private String nazwa;
    private PracownikBadawczoDydaktyczny prowadzacy;
    private int punktyECTS;

    public Kurs(String nazwa, PracownikBadawczoDydaktyczny prowadzacy, int punktyECTS) {
        this.nazwa = nazwa;
        this.prowadzacy = prowadzacy;
        this.punktyECTS = punktyECTS;
    }

    // Getters and other methods specific to Kurs class


    public PracownikBadawczoDydaktyczny getProwadzacy() {
        return prowadzacy;
    }

    public void printProwadzacy() {
        System.out.println(prowadzacy.getImie() + " " + prowadzacy.getNazwisko());
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getPunktyECTS() {
        return punktyECTS;
    }

    @Override
    public String toString() {
        return "Nazwa kursu: " + nazwa + ", Prowadzący: " + prowadzacy.getImie() + " " + prowadzacy.getNazwisko() + ", Punkty ECTS: " + punktyECTS;
    }
}