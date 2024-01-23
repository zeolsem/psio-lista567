package gui;

import java.util.ArrayList;

import obserwator.EventManager;
import osoba.*;
import sortowanie.Kasownik;
import sortowanie.Sortownik;
import uczelnia.GeneratorDanych;
import uczelnia.Uczelnia;
import wyszukiwanie.Wyszukiwarka;
import serializacja.Serializator;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

import static uczelnia.GeneratorDanych.*;

public class GraphicsInputLoop {
    static Uczelnia uczelnia = Uczelnia.getInstance();
    static JFrame frame;
    static GraphicsInputLoop instance;
    static JPanel dataPanel;

    private GraphicsInputLoop() {
    }

    public static GraphicsInputLoop getInstance() {
        if (instance == null) {
            instance = new GraphicsInputLoop();
        }
        return instance;
    }

    public static void createAndShowGUI() {
        frame = new JFrame("Projekt Uczelnia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Option[] options = {
                new SearchForAll("Wyszukaj wszystkich studentow/pracownikow/kursy", () -> {

                }),
                new SearchForDataInTable("Wyszukaj studentow/pracownikow/kursy po danych", () -> {

                }),
                new GenerateNewData("Generuj nowe dane", () -> {

                }),
                new OptionImpl("Zapisz dane", Serializator::serializujUczelnie),
                new SortData("Sortuj dane", () -> {

                }),
                new DeleteEntry("Usun wpis", () -> {

                }),
                new DeleteTable("Usun wszystko", () -> {

                }),

                // ... other options
        };

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Witaj w projekcie uczelnia!");


        dataPanel = new JPanel(new GridLayout(1, 3));
        EventManager.getInstance().notify("databaseUpdate", null);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);

        mainPanel.add(dataPanel);

        mainPanel.add(titlePanel);

        for (Option option : options) {
            JPanel optionPanel = createOptionPanel(option);
            mainPanel.add(optionPanel);
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        frame.getContentPane().add(scrollPane);

        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void updateDataPanel(int studenci, int pracownicy, int kursy) {
        for (Component component : dataPanel.getComponents()) {
            dataPanel.remove(component);
        }

        JPanel leftPanel = new JPanel();
        leftPanel.add(OptionImpl.myLabel(String.format("Liczba studentow: %d", studenci)));

        JPanel centerPanel = new JPanel();
        centerPanel.add(OptionImpl.myLabel(String.format("Liczba pracownikow: %d", pracownicy)));

        JPanel rightPanel = new JPanel();
        rightPanel.add(OptionImpl.myLabel(String.format("Liczba kursow: %d", kursy)));

        dataPanel.add(leftPanel);
        dataPanel.add(centerPanel);
        dataPanel.add(rightPanel);

    }

    private static JPanel createOptionPanel(Option option) {
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BorderLayout());
        optionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JButton optionButton = new JButton(option.getText());
        optionButton.setFont(new Font("Arial", Font.BOLD, 24));
        optionButton.addActionListener(e -> {
            option.performAction();
            option.showDialog(optionButton);
        });

        optionPanel.add(optionButton, BorderLayout.CENTER);
        return optionPanel;
    }

    public static void updateDataEntryAmount(int listaStudentow, int listaPracownikow, int listaKursow) {
        updateDataPanel(listaStudentow, listaPracownikow, listaKursow);
        frame.revalidate();
        frame.repaint();
    }

    interface Option {
        String getText();

        void performAction();

        void showDialog(Component parent);

        // Additional method for different behaviors
        Component createSpecificComponent();
    }

    static class OptionImpl implements Option {
        private final String text;
        private final Runnable action;

        public OptionImpl(String text, Runnable action) {
            this.text = text;
            this.action = action;
        }

        @Override
        public String getText() {
            return text;
        }

        @Override
        public void performAction() {
            action.run();
        }

        @Override
        public void showDialog(Component parent) {
            showDialog(parent, "Dialog for " + getText(), "OK");
        }

        @Override
        public Component createSpecificComponent() {
            // Default behavior, can be overridden by subclasses
            return new JLabel("Default Component for " + getText());
        }

        public static JLabel myLabel(String message) {
            JLabel label = new JLabel(message);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            return label;
        }
        private static void showDialog(Component parent, String title, String message) {
            JOptionPane.showMessageDialog(parent, myLabel(message), title, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static class SortData extends OptionImpl {
        public SortData(String text, Runnable action) {
            super(text, action);
        }

        @Override
        public void showDialog(Component parent) {
            String[] searchOptions = {"Osoby", "Kursy"};
            Sortownik sortownik = new Sortownik();
            // Show the option dialog
            int choice = JOptionPane.showOptionDialog(
                    parent,
                    myLabel("Wybierz co chcesz sortowac:"),
                    "Wybor klas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    searchOptions,
                    searchOptions[0]);

            // Perform action based on the user's choice
            int choice2;
            switch (choice) {
                case 0:

                    String[] opcje = new String[]{"imie", "nazwisko_i_imie", "nazwisko_i_wiek"};
                    choice2 = JOptionPane.showOptionDialog(
                            parent,
                            "Wybierz typ sortowania:",
                            "Wybor sortowania",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcje,
                            "imie");
                    sortownik.sortujListeOsob(uczelnia.getListaOsob(), opcje[choice2]);
                    break;
                case 1:
                    opcje = new String[]{"ects", "prowadzacy_nazwisko"};
                    choice2 = JOptionPane.showOptionDialog(
                            parent,
                            "Wybierz typ sortowania:",
                            "Wybor sortowania",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcje,
                            "imie");
                    sortownik.sortujListeOsob(uczelnia.getListaOsob(), opcje[choice2]);
                    break;
            }
        }
    }

    static class DeleteTable extends OptionImpl {
        public DeleteTable(String text, Runnable action) {
            super(text, action);
        }

        @Override
        public void showDialog(Component parent) {
            String[] searchOptions = {"Studenci", "Pracownicy", "Kursy"};
            Kasownik kasownik = new Kasownik();
            // Show the option dialog
            int choice = JOptionPane.showOptionDialog(
                    parent,
                    myLabel("Wybierz co chcesz usunac:"),
                    "Wybor klas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    searchOptions,
                    searchOptions[0]);

            switch (choice) {
                case 0:
                    System.out.println("Usun liste studentow");
                    uczelnia.getListaOsob().removeIf(osoba -> osoba instanceof Student);
                    break;
                case 1:
                    System.out.println("Usun liste pracownikow");
                    uczelnia.getListaOsob().removeIf(osoba -> osoba instanceof PracownikUczelni);
                    break;
                case 2:
                    System.out.println("Usun liste kursow");
                    uczelnia.getListaKursow().clear();
                    break;
                default:
                    System.out.println("hUH");
            }
            EventManager.getInstance().notify("databaseUpdate", null);
        }
    }

    static class DeleteEntry extends OptionImpl {
        public DeleteEntry(String text, Runnable action) {
            super(text, action);
        }

        @Override
        public void showDialog(Component parent) {
            String[] searchOptions = {"Studenci", "Pracownicy", "Kursy"};
            Kasownik kasownik = new Kasownik();
            // Show the option dialog
            int choice = JOptionPane.showOptionDialog(
                    parent,
                    "Wybierz co chcesz usunac:",
                    "Wybor klas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    searchOptions,
                    searchOptions[0]);

            // Perform action based on the user's choice
            int choice2;
            int usunieci = 0;
            switch (choice) {
                case 0:
                    String[] opcje = new String[]{"imie", "nazwisko", "index", "rokStudiow"};
                    choice2 = JOptionPane.showOptionDialog(
                            parent,
                            myLabel("Wybierz typ danej:"),
                            "Wybor danej",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcje,
                            "imie");

                    switch (choice2) {
                        case 0:
                            String imie = JOptionPane.showInputDialog(parent, "Podaj imie:");
                            usunieci = kasownik.usunStudenta("imie", imie);
                            break;
                        case 1:
                            String nazwisko = JOptionPane.showInputDialog(parent, "Podaj nazwisko:");
                            usunieci = kasownik.usunStudenta("nazwisko", nazwisko);
                            break;
                        case 2:
                            String index = JOptionPane.showInputDialog(parent, "Podaj index:");
                            usunieci = kasownik.usunStudenta("index", index);
                            break;
                        case 3:
                            String rok = JOptionPane.showInputDialog(parent, "Podaj rok:");
                            usunieci = kasownik.usunStudenta("rokStudiow", rok);
                            break;
                        default:
                    }
                    break;
                case 1:
                    // Search for employees
                    opcje = new String[]{"imie", "nazwisko", "stazPracy", "stanowisko"};
                    choice2 = JOptionPane.showOptionDialog(
                    parent,
                    "Wybierz typ danej:",
                    "Wybor danej",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcje,
                    "imie");
                    switch (choice2) {
                        case 0:
                            String imie = JOptionPane.showInputDialog(parent, "Podaj imie:");
                            usunieci = kasownik.usunPracownika("imie", imie);
                            break;
                        case 1:
                            String nazwisko = JOptionPane.showInputDialog(parent, "Podaj nazwisko:");
                            usunieci = kasownik.usunPracownika("nazwisko", nazwisko);
                            break;
                        case 2:
                            String stazPracy = JOptionPane.showInputDialog(parent, "Podaj staz pracy:");
                            usunieci = kasownik.usunPracownika("stazPracy", stazPracy);
                            break;
                        case 3:
                            String stanowisko = JOptionPane.showInputDialog(parent, "Podaj stanowisko:");
                            usunieci = kasownik.usunPracownika("stanowisko", stanowisko);
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    opcje = new String[]{"nazwa", "ects", "prowadzacy"};
                    choice2 = JOptionPane.showOptionDialog(
                            parent,
                            "Wybierz typ danej:",
                            "Wybor danej",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcje,
                            "imie");
                    switch (choice2) {
                        case 0:
                            String nazwa = JOptionPane.showInputDialog(parent, "Podaj nazwe kursu:");
                            usunieci = kasownik.usunKurs("nazwa", nazwa);
                            break;
                        case 1:
                            String ects = JOptionPane.showInputDialog(parent, "Podaj ects:");
                            usunieci = kasownik.usunKurs("ects", ects);
                            break;
                        case 2:
                            String prowadzacy = JOptionPane.showInputDialog(parent, "Podaj prowadzacego:");
                            usunieci = kasownik.usunKurs("prowadzacy", prowadzacy);
                            break;
                        default:
                    }
                    break;
            }
            EventManager.getInstance().notify("databaseUpdate", null);
            JOptionPane.showMessageDialog(null, String.format("usunieto %d wpisow", usunieci), "liczba usunietyvh", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static class GenerateNewData extends OptionImpl {
       public GenerateNewData(String text, Runnable action) {
           super(text, action);
       }

       @Override
         public void showDialog(Component parent) {
           String[] searchOptions = {"Studenci", "Pracownicy", "Kursy"};

           // Show the option dialog
           int choice = JOptionPane.showOptionDialog(
                   parent,
                   myLabel("Wybierz co chcesz generowac:"),
                   "Wybor generacji",
                   JOptionPane.DEFAULT_OPTION,
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   searchOptions,
                   searchOptions[0]);

           switch (choice) {
               case 0:
                   int liczbaStudentow = Integer.parseInt(JOptionPane.showInputDialog(parent, "Podaj liczbe studentow:"));
                   for (int i = 0; i < liczbaStudentow; i++) {
                       uczelnia.dodajOsobe(GeneratorDanych.generujStudent());
                   }
                   break;
               case 1:
                   int liczbaPracownikow = Integer.parseInt(JOptionPane.showInputDialog(parent, "Podaj liczbe pracownikow administracyjnych:"));
                   for (int i = 0; i < liczbaPracownikow; i++) {
                       if (new Random().nextBoolean()) {
                           uczelnia.dodajOsobe(generujPracownik("administracyjny"));
                       } else {
                           uczelnia.dodajOsobe(generujPracownik("dydaktycznoBadawczy"));
                       }
                   }
                   break;
               case 2:
                   int liczbaKursow = Integer.parseInt(JOptionPane.showInputDialog(parent, "Podaj liczbe kursow:"));
                   for (int i = 0; i < liczbaKursow; i++) {
                       uczelnia.dodajKurs(generujKurs());
                   }
                   break;
               default:
                   // User canceled or closed the dialog
                   System.out.println("Search canceled.");
           }
           EventManager.getInstance().notify("databaseUpdate", null);
       }
    }
    static class SearchForDataInTable extends OptionImpl {
        public SearchForDataInTable(String text, Runnable action) {
            super(text, action);
        }

        @Override
        public void showDialog(Component parent) {
            String[] searchOptions = {"Studenci", "Pracownicy", "Kursy"};

            // Show the option dialog
            int choice = JOptionPane.showOptionDialog(
                    parent,
                    myLabel("Wyszukaj po klasach:"),
                    "Wybor klas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    searchOptions,
                    searchOptions[0]);

            // Perform action based on the user's choice
            int choice2;
            ArrayList<Dane> wyniki;
            switch (choice) {
                case 0:
                    ArrayList<Dane> studenci = Wyszukiwarka.wyszukajPoKlasie(Student.class, uczelnia.getListaOsob());
                    choice2 = JOptionPane.showOptionDialog(
                            parent,
                           "Wybierz typ danej:",
                            "Wybor danej",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new String[]{"imie", "nazwisko", "nazwaKursu", "index", "rok"},
                            "imie");
                    switch (choice2) {
                        case 0:
                            String imie = JOptionPane.showInputDialog(parent, "Podaj imie:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(Student.class, studenci, "imie", imie);
                            showListDialog(wyniki, parent);
                            break;
                        case 1:
                            String nazwisko = JOptionPane.showInputDialog(parent, "Podaj nazwisko:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(Student.class, studenci, "nazwisko", nazwisko);
                            showListDialog(wyniki, parent);
                            break;
                        case 2:
                            String nazwaKursu = JOptionPane.showInputDialog(parent, "Podaj nazwe kursu:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(Student.class, studenci, "nazwaKursu", nazwaKursu);
                            showListDialog(wyniki, parent);
                            break;
                        case 3:
                            String index = JOptionPane.showInputDialog(parent, "Podaj index:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(Student.class, studenci, "index", index);
                            showListDialog(wyniki, parent);
                            break;
                        case 4:
                            String rok = JOptionPane.showInputDialog(parent, "Podaj rok:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(Student.class, studenci, "rok", rok);
                            showListDialog(wyniki, parent);
                            break;
                        default:
                            // User canceled or closed the dialog
                            System.out.println("Search canceled.");
                    }
                    break;
                case 1:
                    // Search for employees
                    choice2 = JOptionPane.showOptionDialog(
                            parent,
                            "Wybierz typ danej:",
                            "Wybor klas",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new String[]{"imie", "nazwisko", "staz_pracy", "stanowisko", "pensja", "liczba_nadgodzin"},
                            "Pracownicy administracyjni");
                    switch (choice2) {
                        case 0:
                            String imie = JOptionPane.showInputDialog(parent, "Podaj imie:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "imie", imie);
                            showListDialog(wyniki, parent);
                            break;
                        case 1:
                            String nazwisko = JOptionPane.showInputDialog(parent, "Podaj nazwisko:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "nazwisko", nazwisko);
                            showListDialog(wyniki, parent);
                            break;
                        case 2:
                            String stazPracy = JOptionPane.showInputDialog(parent, "Podaj staz pracy:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "staz_pracy", stazPracy);
                            showListDialog(wyniki, parent);
                            break;
                        case 3:
                            String stanowisko = JOptionPane.showInputDialog(parent, "Podaj stanowisko:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "stanowisko", stanowisko);
                            showListDialog(wyniki, parent);
                            break;
                        case 4:
                            String pensja = JOptionPane.showInputDialog(parent, "Podaj pensje:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "pensja", pensja);
                            showListDialog(wyniki, parent);
                            break;
                        case 5:
                            String liczbaNadgodzin = JOptionPane.showInputDialog(parent, "Podaj liczbe nadgodzin:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(PracownikUczelni.class, uczelnia.getListaOsob(), "liczba_nadgodzin", liczbaNadgodzin);
                            showListDialog(wyniki, parent);
                        default:
                            // User canceled or closed the dialog
                            System.out.println("Search canceled.");
                    }
                    break;
                case 2:
                    // Search for courses
                    choice2 = JOptionPane.showOptionDialog(
                            parent,
                            "Wybierz typ danej:",
                            "Wybor klas",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new String[]{"Nazwa Kursu", "ects", "prowadzacy"},
                            "nazwa");
                    switch (choice2) {
                        case 0:
                            String nazwa = JOptionPane.showInputDialog(parent, "Podaj nazwe kursu:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(Kurs.class, uczelnia.getListaKursow(), "nazwa", nazwa);
                            showListDialog(wyniki, parent);
                            break;
                        case 1:
                            String ects = JOptionPane.showInputDialog(parent, "Podaj ects:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(Kurs.class, uczelnia.getListaKursow(), "ects", ects);
                            showListDialog(wyniki, parent);
                            break;
                        case 2:
                            String prowadzacy = JOptionPane.showInputDialog(parent, "Podaj prowadzacego:");
                            wyniki = Wyszukiwarka.wyszukajPoDanych(Kurs.class, uczelnia.getListaKursow(), "prowadzacy", prowadzacy);
                            showListDialog(wyniki, parent);
                            break;
                        default:
                            // User canceled or closed the dialog
                            System.out.println("Search canceled.");
                    }
                    break;
                default:
                    // User canceled or closed the dialog
                    System.out.println("Search canceled.");
            }
        }
    }
    static class SearchForAll extends OptionImpl {
        public SearchForAll(String text, Runnable action) {
            super(text, action);
        }

        @Override
        public void showDialog(Component parent) {
            String[] searchOptions = {"Studenci", "Pracownicy", "Kursy"};

            // Show the option dialog
            int choice = JOptionPane.showOptionDialog(
                    parent,
                    myLabel("Wybor klas:"),
                    "Wybor klas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    searchOptions,
                    searchOptions[0]);

            // Perform action based on the user's choice
            switch (choice) {
                case 0:
                    ArrayList<Dane> studenci = Wyszukiwarka.wyszukajPoKlasie(Student.class, uczelnia.getListaOsob());
                    showListDialog(studenci, parent);
                    break;
                case 1:
                    // Search for employees
                    int choice2 = JOptionPane.showOptionDialog(
                            parent,
                            "Wybierz typ pracownika:",
                            "Wybor klas",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new String[]{"Pracownicy administracyjni", "Pracownicy dydaktyczno-badawczy"},
                            "Pracownicy administracyjni");
                    switch (choice2) {
                        case 0:
                            ArrayList<Dane> pracownicyAdministracyjni = Wyszukiwarka.wyszukajPoKlasie(PracownikAdministracyjny.class, uczelnia.getListaOsob());
                            showListDialog(pracownicyAdministracyjni, parent);
                            break;
                        case 1:
                            ArrayList<Dane> pracownicyDydaktycznoBadawczy = Wyszukiwarka.wyszukajPoKlasie(PracownikBadawczoDydaktyczny.class, uczelnia.getListaOsob());
                            showListDialog(pracownicyDydaktycznoBadawczy, parent);
                            break;
                        default:
                            System.out.println("Search canceled.");
                    }
                    break;
                case 2:
                    ArrayList<Dane> kursy = Wyszukiwarka.wyszukajPoKlasie(Kurs.class, uczelnia.getListaKursow());
                    showListDialog(kursy, parent);
                    break;
                default:
                    System.out.println("Search canceled.");
            }
        }
    }

    private static void showListDialog(ArrayList<Dane> lista, Component parent) {

        JList dane = new JList<>(lista.toArray());

        JScrollPane scrollPane = new JScrollPane(dane);

        scrollPane.setPreferredSize(new Dimension(1300, 500));
        JOptionPane.showMessageDialog(
                parent,
                scrollPane,
                "Dane",
                JOptionPane.PLAIN_MESSAGE
        );
    }

}