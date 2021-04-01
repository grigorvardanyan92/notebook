# Notebook

A simple program for creating, reading, editing and deleting notes, which can
be saved to and loaded from a file. There are 3 categories of notes: work,
studies and personal, and each of them can be marked as completed/uncompleted.

## Usage

To be able to save and load notebook from and to a file, include these 2 lines
which create a file object and pass it to a class that does the work with file:  
`File file = new File("notebook.bin");`  
`FileService fileService = new FileServiceImpl(file);`

When launching for the first time, create new notebook  
`Notebook notebook = new NotebookImpl();`

To load from a file, use this instead:  
`Notebook notebook = fileService.readNotebook();`

To add a new note, first create it choosing either PersonalNote, StudiesNote
or WorkNote and then add it to notebook:  
`Note note = new StudiesNote("Your text here", notebook.giveId());`  
`notebook.addNote(note);`

Deleting note:  
`notebook.deleteNote(0);    // need note id`

Updating note text:  
`notebook.getNote(0).setText("new text");   // need note id`

Setting note as completed/uncompleted:  
`notebook.getNote(0).setCompleted(true);    // or false`

To get an appealing list of notes, call and print either uncompletedNotes,
personalNotes, studiesNotes, workNotes or completedNotes:  
`System.out.println(notebookInterface.uncompletedNotes());`

Or read the text of a single note:  
`System.out.println(notebookInterface.readNote(0));`

Finally, to save the changes to notebook to a file, use:  
`fileService.writeNotebook(notebook);`