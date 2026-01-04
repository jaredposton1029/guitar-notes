package com.guitar.notes;

import java.util.List;

public class FretAnswer {
  private int fret;
  private String octave;
  private String noteString;
  private String string;
  private List<String> allNotes;
  private boolean isCorrectFret;

  private Note note;

  public FretAnswer(String octave, String note, String string, List<String> allNotes)
      throws InvalidNoteException {
    this.octave = octave;
    this.noteString = note;
    this.string = string;
    this.allNotes = allNotes;
    this.note = new Note(note);
    this.isCorrectFret = false;
  }

  public int getFret() {
    return fret;
  }

  public void setFret(int fret) {
    this.fret = fret;

    this.isCorrectFret = checkFret(fret);
  }

  private boolean checkFret(int fret) {
    int correctFret = 0;
    String currentNoteString = String.valueOf(this.string.charAt(this.string.length() - 1));
    if (currentNoteString.equals("#") || currentNoteString.equals("b")) {
      currentNoteString = this.string.substring(this.string.length() - 2);
    }

    Note currentNote = null;
    try {
      currentNote = new Note(currentNoteString);
    } catch (InvalidNoteException e) {
      return false;
    }

    while (!currentNote.equals(this.note)) {
      // go up a fret
      correctFret++;
      currentNote.increment();
    }

    if (this.octave.equals("high")) {
      correctFret += 12;
    }

    return fret == correctFret;
  }

  public String getOctave() {
    return octave;
  }

  public void setOctave(String octave) {
    this.octave = octave;

    this.isCorrectFret = checkFret(this.fret);
  }

  public String getNoteString() {
    return noteString;
  }

  public void setNoteString(String noteString) throws InvalidNoteException {
    this.noteString = noteString;
    this.note = new Note(noteString);
    this.isCorrectFret = checkFret(this.fret);
  }

  public Note getNote() {
    return note;
  }

  public void setNote(Note note) {
    this.note = note;
    this.isCorrectFret = checkFret(this.fret);
  }

  public String getString() {
    return string;
  }

  public List<String> getAllNotes() {
    return allNotes;
  }

  public boolean getIsCorrectFret() {
    return isCorrectFret;
  }
}
