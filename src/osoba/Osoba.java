package osoba;


import java.io.Serializable;

public abstract class Osoba extends Dane implements Serializable {
    private String imie;
    private String nazwisko;
    private String pesel;
    private int wiek;
    private char plec;

    public Osoba(String imie, String nazwisko, String pesel, int wiek, char plec) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.wiek = wiek;
        this.plec = plec;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public int getWiek() {
        return wiek;
    }

    public char getPlec() {
        return plec;
    }

    @Override
    public String toString() {
        return "Imię: " + imie + ", Nazwisko: " + nazwisko + ", PESEL: " + pesel + ", Wiek: " + getWiek() + ", Płeć: " + plec;
    }
}