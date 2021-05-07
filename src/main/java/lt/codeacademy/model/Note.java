package lt.codeacademy.model;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int categoryId;
    private String text;
    private boolean completed;
    private boolean deleted;

    public Note() {
    }

    public Note(int categoryId, String text) {
        this.categoryId = categoryId;
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name = "cagegory_id")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
