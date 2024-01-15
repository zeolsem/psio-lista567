package osoba;

public class PracownikBadawczoDydaktyczny extends PracownikUczelni {
    private int liczbaPublikacji;

    public PracownikBadawczoDydaktyczny(String imie, String nazwisko, String pesel, int wiek, char plec,
                                        String stanowisko, int stazPracy, double pensja,
                                        int liczbaPublikacji) {
        super(imie, nazwisko, pesel, wiek, plec, stanowisko, stazPracy, pensja);
        this.liczbaPublikacji = liczbaPublikacji;
    }

    public int getLiczbaPublikacji() {
        return liczbaPublikacji;
    }

    @Override
    public String toString() {
        return super.toString() + ", Liczba publikacji: " + liczbaPublikacji;
    }
}