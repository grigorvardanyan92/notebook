package lt.codeacademy.model;

import lt.codeacademy.exception.NoSuchIDException;
import lt.codeacademy.model.Note;
import lt.codeacademy.model.Notebook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* Represents set of notes
* */
public class NotebookImpl implements Notebook {
    private Map<Integer, Note> notes = new HashMap<>();
    private int idCounter = 0;

    @Override
    public void addNote(Note note) {
        notes.put(note.getId(), note);
    }

    @Override
    public Note getNote(int id) {
        return notes.get(id);
    }

    @Override
    public void deleteNote(int id) throws NoSuchIDException {
        if (notes.keySet().contains(id)) {
            notes.remove(id);
        } else {
            throw new NoSuchIDException();
        }
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
                .filter(n -> n.getCategory().equals("personal"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getStudiesNotes() {
        return notes.values().stream()
                .filter(n -> n.getCategory().equals("study"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getWorkNotes() {
        return notes.values().stream()
                .filter(n -> n.getCategory().equals("work"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getCompletedNotes() {
        return notes.values().stream()
                .filter(n -> n.isCompleted())
                .collect(Collectors.toList());
    }

    @Override
    public int giveId() {
        return idCounter++;
    }
}
