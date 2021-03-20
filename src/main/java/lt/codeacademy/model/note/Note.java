package lt.codeacademy.model.note;

public interface Note {
    int getId();
    void setText(String text);
    String getText();
    void setCompleted(boolean completed);
    boolean isCompleted();
}
