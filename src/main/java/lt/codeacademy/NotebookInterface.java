package lt.codeacademy;

import lt.codeacademy.model.notebook.Notebook;
import lt.codeacademy.model.notebook.NotebookImpl;

import java.util.stream.Collectors;

/*
* Class that returns Notebook lists as strings for convenient reading
* */
public class NotebookInterface {
    private Notebook notebook;
    private final String LIST_HEADER = "  ID                   NOTE                          DATE\n";

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
}
