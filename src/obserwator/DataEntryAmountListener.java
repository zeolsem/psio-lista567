package obserwator;
import gui.GraphicsInputLoop;
import osoba.PracownikAdministracyjny;
import osoba.PracownikBadawczoDydaktyczny;
import osoba.Student;
import uczelnia.Uczelnia;
import wyszukiwanie.Wyszukiwarka;

import java.util.List;

public class DataEntryAmountListener implements Listener {
    private int listaStudentow;
    private int listaPracownikow;
    private int listaKursow;
    public void update(String eventType, List<String> data) {
        listaStudentow = Wyszukiwarka.wyszukajPoKlasie(Student.class, Uczelnia.getInstance().getListaOsob()).size();
        int listaPracownikowAdm = Wyszukiwarka.wyszukajPoKlasie(PracownikAdministracyjny.class, Uczelnia.getInstance().getListaOsob()).size();
        int listaPracownikowDyd = Wyszukiwarka.wyszukajPoKlasie(PracownikBadawczoDydaktyczny.class, Uczelnia.getInstance().getListaOsob()).size();;
        listaPracownikow = listaPracownikowAdm + listaPracownikowDyd;
        listaKursow = Uczelnia.getInstance().getListaKursow().size();
        GraphicsInputLoop.updateDataEntryAmount(listaStudentow, listaPracownikow, listaKursow);
    }

    public int getListaKursow() {
        return listaKursow;
    }

    public int getListaPracownikow() {
        return listaPracownikow;
    }

    public int getListaStudentow() {
        return listaStudentow;
    }
}
