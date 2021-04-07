package lt.codeacademy.service;

import lt.codeacademy.model.notebook.Notebook;

import java.io.*;

public class FileServiceImpl implements FileService {
    File file;

    public FileServiceImpl(File file) {
        this.file = file;
    }

    @Override
    public void writeNotebook(Notebook notebook) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream ous = new ObjectOutputStream(fos)) {
            ous.writeObject(notebook);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("error initializing stream");
        }
    }

    @Override
    public Notebook readNotebook() {
        Notebook notebook = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            notebook = (Notebook) ois.readObject();
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
