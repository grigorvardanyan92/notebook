package lt.codeacademy;

import lt.codeacademy.model.notebook.Notebook;
import lt.codeacademy.model.notebook.NotebookImpl;

import java.util.stream.Collectors;

/*
* Class that returns Notebook values in more readable String format
* */
public class NotebookInterface {
    private Notebook notebook;
    private final String LIST_HEADER = "  ID   NOTE                                       DATE\n";

    public NotebookInterface(Notebook notebook) {
        this.notebook = notebook;
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

    public String readNote(int id) {
        String original = notebook.getNote(id).getText();
        String result = original;

        // breaks into lines at spaces after 50th char on each line
        int charCounter = 0;
        for (int i = 0; i < original.length(); i++) {
            charCounter++;
            if (charCounter > 50 && original.charAt(i) == ' ') {
                charCounter = 0;
                result = result.substring(0, i) + result.substring(i + 1);
            }
        }
    }
}
