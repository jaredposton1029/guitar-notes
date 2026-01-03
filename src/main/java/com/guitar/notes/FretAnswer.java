package com.guitar.notes;

import java.util.List;

public class FretAnswer {
  private int fret;
  private String octave;
  private String note;
  private String string;
  private List<String> allNotes;
  private boolean isCorrectFret;

  public FretAnswer(String octave, String note, String string, List<String> allNotes) {
    this.octave = octave;
    this.note = note;
    this.string = string;
    this.allNotes = allNotes;
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
    boolean noteIsFlat = this.note.endsWith("b");
    boolean noteIsSharp = this.note.endsWith("#");
    String currentNote = String.valueOf(this.string.charAt(this.string.length() - 1));
    if (currentNote.equals("#") || currentNote.equals("b")) {
      currentNote = this.string.substring(this.string.length() - 2);
    }
    int currentNoteIndex = this.allNotes.indexOf(currentNote);

    System.out.println(String.format("noteIsFlat: %b", noteIsFlat));
    System.out.println(String.format("currentNote: %s", currentNote));
    System.out.println(String.format("this.note: %s", this.note));

    while (!currentNote.equals(this.note)) {
      // go up a fret
      correctFret++;
      currentNoteIndex = (currentNoteIndex + 1) % this.allNotes.size();
      currentNote = this.allNotes.get(currentNoteIndex);
      if (noteIsFlat) {
        if (currentNote.endsWith("#")) {
          currentNoteIndex = (currentNoteIndex + 1) % this.allNotes.size();
          currentNote = this.allNotes.get(currentNoteIndex);
        }
      } else if (noteIsSharp) {
        if (currentNote.endsWith("b")) {
          currentNoteIndex = (currentNoteIndex + 1) % this.allNotes.size();
          currentNote = this.allNotes.get(currentNoteIndex);
        }
      } else {
        if (currentNote.endsWith("#")) {
          currentNoteIndex = (currentNoteIndex + 1) % this.allNotes.size();
          currentNote = this.allNotes.get(currentNoteIndex);
        }
      }
    }

    if (this.octave.equals("high")) {
      correctFret += 12;
    }

    System.out.println(String.format("correctFret: %d", correctFret));

    return fret == correctFret;
  }

  public String getOctave() {
    return octave;
  }

  public String getNote() {
    return note;
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
