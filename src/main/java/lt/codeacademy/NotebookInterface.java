package lt.codeacademy;

import lt.codeacademy.exception.NoSuchIDException;
import lt.codeacademy.model.Note;

import java.util.stream.Collectors;

/*
* Class that returns Notebook values in more readable String format
* */
public class NotebookInterface {
    private Notebook notebook;
    private final String LIST_HEADER = "  ID   NOTE                                       DATE\n";

    // constructor
    public NotebookInterface(Notebook notebook) {
        this.notebook = notebook;
    }

    public void deleteNote(int id) {
        try {
            notebook.deleteNote(id);
        } catch (NoSuchIDException e) {
            System.out.println("no such id");
        }
    }

    public String uncompletedNotes() {
        return LIST_HEADER + notebook.getUncompletedNotes().stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    public String personalNotes() {
        return LIST_HEADER + notebook.getPersonalNotes().stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    public String studiesNotes() {
        return LIST_HEADER + notebook.getStudiesNotes().stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    public String workNotes() {
        return LIST_HEADER + notebook.getWorkNotes().stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    public String completedNotes() {
        return LIST_HEADER + notebook.getCompletedNotes().stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    /**
     * Returns text of a note in a pleasant format for reading,
     * breaking lines after each 50th char.
     *
     * @param note whose text needs to be returned
     * @return string with new lines
     */
    public static String readNote(Note note) {
        String result = note.getText();
        // replaces multiple spaces with one
        result = result.replaceAll(" +", " ");
        // breaks into lines at spaces after 50th char on each line
        int charCounter = 0;
        for (int i = 0; i < result.length(); i++) {
            charCounter++;
            if (charCounter > 50 && result.charAt(i) == ' ') {
                charCounter = 0;
                result = result.substring(0, i) + '\n' + result.substring(i + 1);
            }
        }
        return result;
    }
}
