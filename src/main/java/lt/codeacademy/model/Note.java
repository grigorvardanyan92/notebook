package lt.codeacademy.model;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String text;
    private boolean completed;
    private boolean deleted;

    public Note() {
    }

    public Note(String category, String text) {
        this.category = category;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String toString() {
        String beginningOfText = text;
        if (beginningOfText.length() > 37) {
            beginningOfText = beginningOfText.substring(0, 37) + "...";
        }
        return String.format("%4d   %-40s   %s", id, beginningOfText);
    }
}
