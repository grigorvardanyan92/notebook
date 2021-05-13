package lt.codeacademy;

import com.fasterxml.jackson.core.JsonProcessingException;
import lt.codeacademy.exception.NoSuchCategoryExcepiton;
import lt.codeacademy.util.NoteFactory;
import lt.codeacademy.model.Category;
import lt.codeacademy.model.Note;
import lt.codeacademy.service.NoteService;
import lt.codeacademy.util.HibernateConfig;

public class App
{
    public static void main( String[] args ) throws JsonProcessingException {

        HibernateConfig.buildSessionFactory();

        NoteService noteService = new NoteService();

        Category category = null;
        try {
            category = NoteFactory.getCategory("home");
            Note note = new Note("tekst", category);

            noteService.save(note);

        } catch (NoSuchCategoryExcepiton noSuchCategoryExcepiton) {
            noSuchCategoryExcepiton.printStackTrace();
        }

        HibernateConfig.closeSessionFactory();

        // simple notebook with array of notes
//        Notebook notebook = new NotebookImpl();
//        Notebook notebook = fileService.readNotebook();
//        NotebookInterface notebookInterface = new NotebookInterface(notebook);

        // adding notes
//        Note note1 = new StudiesNote("Study Java", notebook.giveId());
//        Note note2 = new PersonalNote("Buy flowers", notebook.giveId());
//        notebook.addNote(note1);
//        notebook.addNote(note2);

        // deleting note
//        notebookInterface.deleteNote(0);

        // print list
//        System.out.println(notebookInterface.uncompletedNotes());
//        System.out.println(notebookInterface.personalNotes());
//        System.out.println(notebookInterface.studiesNotes());

    }
}
