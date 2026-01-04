package com.guitar.notes;

import java.util.Objects;

public class Note {

  private static final int MAX_KEYBOARD_VALUE = 12;

  private NoteLetter noteLetter;
  private NoteQuality noteQuality;
  private int keyboardValue;

  public Note(String note) throws InvalidNoteException {
    if (note == null || note.length() == 0 || note.length() > 3) {
      throw new InvalidNoteException(String.format("Value %s is an invalid note.", note));
    }

    if (note.length() == 1) {
      this.noteQuality = NoteQuality.Natural;
      switch (note) {
        case "A":
          this.noteLetter = NoteLetter.A;
          break;
        case "B":
          this.noteLetter = NoteLetter.B;
          break;
        case "C":
          this.noteLetter = NoteLetter.C;
          break;
        case "D":
          this.noteLetter = NoteLetter.D;
          break;
        case "E":
          this.noteLetter = NoteLetter.E;
          break;
        case "F":
          this.noteLetter = NoteLetter.F;
          break;
        case "G":
          this.noteLetter = NoteLetter.G;
          break;
        default:
          throw new InvalidNoteException(String.format("Value %s is an invalid note name.", note));
      }
    } else { // note.length() == 2 || note.length() == 3
      char noteLetter = note.charAt(0);
      String noteQuality = note.substring(1);

      switch (noteLetter) {
        case 'A':
          this.noteLetter = NoteLetter.A;
          break;
        case 'B':
          this.noteLetter = NoteLetter.B;
          break;
        case 'C':
          this.noteLetter = NoteLetter.C;
          break;
        case 'D':
          this.noteLetter = NoteLetter.D;
          break;
        case 'E':
          this.noteLetter = NoteLetter.E;
          break;
        case 'F':
          this.noteLetter = NoteLetter.F;
          break;
        case 'G':
          this.noteLetter = NoteLetter.G;
          break;
        default:
          throw new InvalidNoteException(String.format("Value %c is an invalid note name.", noteLetter));
      }

      switch (noteQuality) {
        case "bb":
          this.noteQuality = NoteQuality.DoubleFlat;
          break;
        case "b":
          this.noteQuality = NoteQuality.Flat;
          break;
        case "#":
          this.noteQuality = NoteQuality.Sharp;
          break;
        case "x":
          this.noteQuality = NoteQuality.DoubleSharp;
          break;
        default:
          throw new InvalidNoteException(String.format("Value %s is an invalid note quality.", noteQuality));
      }
    }

    this.keyboardValue = calculateKeyboardValue();
  }

  private int calculateKeyboardValue() {
    int keyboardValue = 0;

    switch (this.noteLetter) {
      case NoteLetter.A:
        keyboardValue = 9;
        break;
      case NoteLetter.B:
        keyboardValue = 11;
        break;
      case NoteLetter.C:
        keyboardValue = 0;
        break;
      case NoteLetter.D:
        keyboardValue = 2;
        break;
      case NoteLetter.E:
        keyboardValue = 4;
        break;
      case NoteLetter.F:
        keyboardValue = 5;
        break;
      case NoteLetter.G:
        keyboardValue = 7;
        break;
    }

    switch (this.noteQuality) {
      case NoteQuality.DoubleFlat:
        keyboardValue = (keyboardValue - 2 + Note.MAX_KEYBOARD_VALUE) % Note.MAX_KEYBOARD_VALUE;
        break;
      case NoteQuality.Flat:
        keyboardValue = (keyboardValue - 1 + Note.MAX_KEYBOARD_VALUE) % Note.MAX_KEYBOARD_VALUE;
        break;
      case NoteQuality.Natural:
        break;
      case NoteQuality.Sharp:
        keyboardValue = (keyboardValue + 1) % Note.MAX_KEYBOARD_VALUE;
        break;
      case NoteQuality.DoubleSharp:
        keyboardValue = (keyboardValue + 2) % Note.MAX_KEYBOARD_VALUE;
        break;
    }

    return keyboardValue;
  }

  private static Note calculateNote(int keyboardValue) throws InvalidNoteException {
    switch (keyboardValue) {
      case 0:
        return new Note("C");
      case 1:
        return new Note("C#");
      case 2:
        return new Note("D");
      case 3:
        return new Note("Eb");
      case 4:
        return new Note("E");
      case 5:
        return new Note("F");
      case 6:
        return new Note("F#");
      case 7:
        return new Note("G");
      case 8:
        return new Note("Ab");
      case 9:
        return new Note("A");
      case 10:
        return new Note("Bb");
      case 11:
        return new Note("B");
      default:
        throw new InvalidNoteException(String.format("Unable to create note for keyboard value %d", keyboardValue));
    }
  }

  public boolean isEnharmonicTo(Note note) {
    return this.keyboardValue == note.keyboardValue;
  }

  public void increment() {
    int incrementedKeyboardValue = (this.keyboardValue + 1) % Note.MAX_KEYBOARD_VALUE;
    Note incrementedNote;
    try {
      incrementedNote = calculateNote(incrementedKeyboardValue);
    } catch (InvalidNoteException e) {
      // shouldn't happen
      System.out.println(String.format("Somehow, unable to increment note: %s", e.getMessage()));
      return;
    }

    this.noteLetter = incrementedNote.noteLetter;
    this.noteQuality = incrementedNote.noteQuality;
    this.keyboardValue = incrementedKeyboardValue;
  }

  public void decrement() {
    int decrementedKeyboardValue = (this.keyboardValue - 1 + Note.MAX_KEYBOARD_VALUE) % Note.MAX_KEYBOARD_VALUE;
    Note decrementedNote;
    try {
      decrementedNote = calculateNote(decrementedKeyboardValue);
    } catch (InvalidNoteException e) {
      // shouldn't happen
      System.out.println(String.format("Somehow, unable to decrement note: %s", e.getMessage()));
      return;
    }

    this.noteLetter = decrementedNote.noteLetter;
    this.noteQuality = decrementedNote.noteQuality;
    this.keyboardValue = decrementedKeyboardValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || !(o instanceof Note)) {
      return false;
    }

    Note note = (Note) o;
    return noteLetter == note.noteLetter && noteQuality == note.noteQuality || this.isEnharmonicTo(note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(noteLetter, noteQuality, keyboardValue);
  }

  @Override
  public String toString() {
    char noteLetter = 'A';
    String noteQuality = "";

    switch (this.noteLetter) {
      case NoteLetter.A:
        noteLetter = 'A';
        break;
      case NoteLetter.B:
        noteLetter = 'B';
        break;
      case NoteLetter.C:
        noteLetter = 'C';
        break;
      case NoteLetter.D:
        noteLetter = 'D';
        break;
      case NoteLetter.E:
        noteLetter = 'E';
        break;
      case NoteLetter.F:
        noteLetter = 'F';
        break;
      case NoteLetter.G:
        noteLetter = 'G';
        break;
    }

    switch (this.noteQuality) {
      case NoteQuality.DoubleFlat:
        noteQuality = "bb";
        break;
      case NoteQuality.Flat:
        noteQuality = "b";
        break;
      case NoteQuality.Natural:
        noteQuality = "";
        break;
      case NoteQuality.Sharp:
        noteQuality = "#";
        break;
      case NoteQuality.DoubleSharp:
        noteQuality = "x";
        break;
    }

    return noteLetter + noteQuality;
  }

  public NoteLetter getNoteLetter() {
    return noteLetter;
  }

  public NoteQuality getNoteQuality() {
    return noteQuality;
  }

  public int getKeyboardValue() {
    return keyboardValue;
  }

}
