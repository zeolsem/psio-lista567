package wyszukiwanie;

import osoba.Dane;

import java.util.ArrayList;

public interface IWyszukiwarka {
    abstract public ArrayList<Dane> wyszukaj(ArrayList<Dane> listaDanych, String dana, String klucz);
}
