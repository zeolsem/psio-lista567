package osoba;

import java.util.ArrayList;

public class Student extends Osoba {
    private int nrIndeksu;
    private int rokStudiow;
    private ArrayList<Kurs> listaKursow;
    private boolean erasmusParticipant;
    private boolean stopienI;
    private boolean stopienII;
    private boolean studiaStacjonarne;
    private boolean studiaNiestacjonarne;
    public Student(String imie, String nazwisko, String pesel, int wiek, char plec,
                   int nrIndeksu, int rokStudiow) {
        super(imie, nazwisko, pesel, wiek, plec);
        this.nrIndeksu = nrIndeksu;
        this.rokStudiow = rokStudiow;
        this.listaKursow = new ArrayList<>();
        this.erasmusParticipant = false;
        this.stopienI = false;
        this.stopienII = false;
        this.studiaStacjonarne = false;
        this.studiaNiestacjonarne = false;
    }
    public int getNrIndeksu() {
        return nrIndeksu;
    }

    public int getRokStudiow() {
        return rokStudiow;
    }

    public ArrayList<Kurs> getListaKursow() {
        return listaKursow;
    }

    public void dodajKurs(Kurs kurs) {
        listaKursow.add(kurs);
    }

    public boolean isErasmusParticipant() {
        return erasmusParticipant;
    }

    public void setErasmusParticipant(boolean erasmusParticipant) {
        this.erasmusParticipant = erasmusParticipant;
    }

    public boolean isStopienI() {
        return stopienI;
    }

    public void setStopienI(boolean stopienI) {
        this.stopienI = stopienI;
    }

    public boolean isStopienII() {
        return stopienII;
    }

    public void setStopienII(boolean stopienII) {
        this.stopienII = stopienII;
    }

    public boolean isStudiaStacjonarne() {
        return studiaStacjonarne;
    }

    public void setStudiaStacjonarne(boolean studiaStacjonarne) {
        this.studiaStacjonarne = studiaStacjonarne;
    }

    public boolean isStudiaNiestacjonarne() {
        return studiaNiestacjonarne;
    }

    public void setStudiaNiestacjonarne(boolean studiaNiestacjonarne) {
        this.studiaNiestacjonarne = studiaNiestacjonarne;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nr indeksu: " + nrIndeksu + ", Rok studiów: " + rokStudiow +
                ", ERASMUS: " + erasmusParticipant + ", Stopień I: " + stopienI +
                ", Stopień II: " + stopienII + ", Studia stacjonarne: " + studiaStacjonarne +
                ", Studia niestacjonarne: " + studiaNiestacjonarne;
    }

    @Override
    public final int hashCode() {
        return getNrIndeksu();
    }

    @Override
    public final boolean equals(Object studentObject) {
        if (studentObject instanceof Student) {
            return (((Student) studentObject).getNrIndeksu()) == this.getNrIndeksu();
        }
        return false;
    }
}