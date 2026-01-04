package com.guitar.notes;

public class InvalidNoteException extends Exception {
  public InvalidNoteException(String message) {
    super(message);
  }

  public InvalidNoteException(String message, Throwable cause) {
    super(message, cause);
  }
}
