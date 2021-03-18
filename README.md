**Notebook**

Simple notebook program, which creates and saves notes. Notes come in different categories.
They can be viewed, edited, marked as completed and deleted. User can choose to view lists of all
uncompleted notes, lists of notes of desired category or list of all completed notes. All notes are
read from and saved into a file.

**Classes**

Note<br/>
&nbsp;&nbsp;&nbsp;&nbsp;int id<br/>
&nbsp;&nbsp;&nbsp;&nbsp;boolean completed<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String text<br/>
&nbsp;&nbsp;&nbsp;&nbsp;LocalDateTime dateTime<br/>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;int getId()<br/>
&nbsp;&nbsp;&nbsp;&nbsp;boolean isCompleted()<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String getText()<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String getDateTime()<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void setCompleted()<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void setText(String text)

Notebook<br/>
&nbsp;&nbsp;&nbsp;&nbsp;Map<Integer, Note> notes<br/>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void addNote(Note note)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void deleteNote(int id)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void editNote(int id)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;Note getNote(int id)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void markAsCompleted(int id)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;Map<Integer, Note> getAllNotes()<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void setAllNotes(Map<Integer, Note>)<br/>

NotebookService<br/>
&nbsp;&nbsp;&nbsp;&nbsp;Notebook notebook<br/>
&nbsp;&nbsp;&nbsp;&nbsp;File in<br/>
&nbsp;&nbsp;&nbsp;&nbsp;File out<br/>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void loadNotes()<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void writeNotes()<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void addNewNote(String text, int category)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String openNote(int id)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void deleteNote(int id)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void editNote(int id)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void markAsCompleted(int id)<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String getNotes(int category)<br/>

NotebookMenu<br/>
&nbsp;&nbsp;&nbsp;&nbsp;NotebookService notebook<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String mainMenuOptions<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String NoteOptions<br/>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;void run()