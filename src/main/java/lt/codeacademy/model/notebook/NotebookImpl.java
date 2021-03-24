package lt.codeacademy.model.notebook;

import lt.codeacademy.model.note.Note;
import lt.codeacademy.model.note.PersonalNote;
import lt.codeacademy.model.note.StudiesNote;
import lt.codeacademy.model.note.WorkNote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NotebookImpl implements Notebook {

    private Map<Integer, Note> notes = new HashMap<>();

    @Override
    public void addNote(Note note) {
        notes.put(note.getId(), note);
    }

    @Override
    public Note getNote(int id) {
        return notes.get(id);
    }

    @Override
    public void deleteNote(int id) {
        notes.remove(id);
    }

    @Override
    public List<Note> getUncompletedNotes() {
        return notes.values().stream()
                .filter(n -> !n.isCompleted())
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getPersonalNotes() {
        return notes.values().stream()
                .filter(n -> n instanceof PersonalNote)
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getStudiesNotes() {
        return notes.values().stream()
                .filter(n -> n instanceof StudiesNote)
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getWorkNotes() {
        return notes.values().stream()
                .filter(n -> n instanceof WorkNote)
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getCompletedNotes() {
        return notes.values().stream()
                .filter(n -> n.isCompleted())
                .collect(Collectors.toList());
    }
}
