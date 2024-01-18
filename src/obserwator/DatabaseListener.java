package obserwator;

import java.io.*;
import java.util.List;

public final class DatabaseListener implements Listener {
    private int newDatabaseAlterations;
    private int oldDatabaseAlterations;
    public void update(String eventType, List<String> data) {
        if (eventType.equals("databaseUpdate")) {
            newDatabaseAlterations++;
        }
    }

    public int getNewDatabaseAlterations() {
        return newDatabaseAlterations;
    }

    public int getOldDatabaseAlterations() {
        return oldDatabaseAlterations;
    }

    public void loadDatabaseAlterations() {
        try {
            FileInputStream inFile = new FileInputStream("databaseAlterations.txt");
            ObjectInputStream inData = new ObjectInputStream(inFile);
            oldDatabaseAlterations = (Integer) inData.readObject();
            inData.close();
            inFile.close();
        } catch (IOException e) {
            System.out.println("IO exception");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }
    }
    public void saveDatabaseAlterations() {
       try {
           FileOutputStream outFile = new FileOutputStream("databaseAlterations.txt");
           ObjectOutputStream outData = new ObjectOutputStream(outFile);
           outData.writeObject(oldDatabaseAlterations + newDatabaseAlterations);
           outData.flush();
           outData.close();
           outFile.close();
       } catch (IOException e) {
           System.out.println("IO exception");
       }
    }
}
