package lt.codeacademy.service;

import lt.codeacademy.model.note.Note;
import lt.codeacademy.model.notebook.Notebook;

import java.io.*;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public void writeNotebook(Notebook notebook, File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream ous = new ObjectOutputStream(fos);

            ous.writeObject(notebook);

            ous.close();
            fos.close();

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("error initializing stream");
        }
    }

    @Override
    public Notebook readNotebook(File file) {
        Notebook notebook = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            notebook = (Notebook) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return notebook;
    }
}
