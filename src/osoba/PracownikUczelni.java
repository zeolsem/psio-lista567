package osoba;

public class PracownikUczelni extends Osoba {
    private String stanowisko;
    private int stazPracy;
    private double pensja;

    public PracownikUczelni(String imie, String nazwisko, String pesel, int wiek, char plec,
                            String stanowisko, int stazPracy, double pensja) {
        super(imie, nazwisko, pesel, wiek, plec);
        this.stanowisko = stanowisko;
        this.stazPracy = stazPracy;
        this.pensja = pensja;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public int getStazPracy() {
        return stazPracy;
    }

    public double getPensja() {
        return pensja;
    }

    @Override
    public String toString() {
        return super.toString() + ", Stanowisko: " + stanowisko + ", Staż pracy: " + stazPracy + " lat, Pensja: " + pensja;
    }
}