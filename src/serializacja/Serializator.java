package serializacja;

import osoba.Dane;
import uczelnia.Uczelnia;
import osoba.Osoba;
import osoba.Kurs;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Serializator {
    private static final Uczelnia uczelnia = Uczelnia.getInstance();

    public static void serializujUczelnie() {
        try {
            FileOutputStream fileOutOsoba = new FileOutputStream("lista_osob.txt");
            FileOutputStream fileOutKurs = new FileOutputStream("lista_kursow.txt");
            ObjectOutputStream outOsoba = new ObjectOutputStream(fileOutOsoba);
            ObjectOutputStream outKurs = new ObjectOutputStream(fileOutKurs);
            outOsoba.writeObject(uczelnia.getListaOsob());
            outKurs.writeObject(uczelnia.getListaKursow());
            outOsoba.flush();
            outKurs.flush();
            outOsoba.close();
            outKurs.close();
            fileOutOsoba.close();
            fileOutKurs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Serialized data is saved in lista_osob.txt an lista_kursow.txt");
    }

    public static void deserializujListeDanych(String nazwa_pliku) {
        ArrayList<Dane> listaDanych;
        try {
            FileInputStream fileInListaDanych = new FileInputStream(nazwa_pliku);
            ObjectInputStream inListaDanych = new ObjectInputStream(fileInListaDanych);
            listaDanych = (ArrayList<Dane>) inListaDanych.readObject();
            inListaDanych.close();
            switch (nazwa_pliku) {
                case "lista_osob.txt":
                    uczelnia.setListaOsob(listaDanych);
                    break;
                case "lista_kursow.txt":
                    uczelnia.setListaKursow(listaDanych);
                    break;
                default:
                    System.out.println("Pozadane nazwy plikow dla listy osob i kursow to lista_osob.txt oraz lista_kursow.txt");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}