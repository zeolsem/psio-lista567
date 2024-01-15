package osoba;

public class PracownikAdministracyjny extends PracownikUczelni {
    private int nadgodziny;

    public PracownikAdministracyjny(String imie, String nazwisko, String pesel, int wiek, char plec,
                                    String stanowisko, int stazPracy, double pensja, int nadgodziny) {
        super(imie, nazwisko, pesel, wiek, plec, stanowisko, stazPracy, pensja);
        this.nadgodziny = nadgodziny;
    }

    public int getNadgodziny() {
        return nadgodziny;
    }

    @Override
    public String toString() {
        return super.toString() + ", Liczba nadgodzin: " + nadgodziny;
    }
}