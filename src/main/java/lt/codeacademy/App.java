package lt.codeacademy;

import lt.codeacademy.model.note.Note;
import lt.codeacademy.model.note.PersonalNote;
import lt.codeacademy.model.note.StudiesNote;
import lt.codeacademy.model.notebook.Notebook;
import lt.codeacademy.model.notebook.NotebookImpl;
import lt.codeacademy.service.FileService;
import lt.codeacademy.service.FileServiceImpl;

import java.io.File;

public class App
{
    public static void main( String[] args )
    {
        File file = new File("notebook.bin");
        FileService fileService = new FileServiceImpl(file);
        Notebook notebook = new NotebookImpl();
        NotebookInterface notebookInterface = new NotebookInterface(notebook);

        Note note = new StudiesNote("some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla some another text bla bla bla ", notebook.giveId());
        notebook.addNote(note);

        System.out.println(notebookInterface.readNote(0));
    }
}
