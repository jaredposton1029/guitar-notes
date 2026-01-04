package com.guitar.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

  @GetMapping("/greeting")
  public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
      Model model) {
    model.addAttribute("name", name);
    return "greeting";
  }

  @GetMapping("/6-string-guitar")
  public String guitar(Model model) {
    List<String> strings = Arrays.asList("low E", "A", "D", "G", "B", "high E");
    int stringIndex = ThreadLocalRandom.current().nextInt(0, strings.size());
    String randomString = strings.get(stringIndex);
    model.addAttribute("randomString", randomString);

    String octave = (String) model.getAttribute("randomOctave");
    String note = (String) model.getAttribute("randomNote");

    Object allNotesObj = model.getAttribute("allNotes");
    List<String> allNotes = new ArrayList<String>();
    if (allNotesObj instanceof List) {
      List<?> rawList = (List<?>) allNotesObj;
      for (Object item : rawList) {
        if (item instanceof String) {
          allNotes.add((String) item);
        } else {
          System.err.println(String.format("Found non-String element: %s", item.getClass().getName()));
        }
      }
    }

    FretAnswer fretAnswer = null;
    try {
      fretAnswer = new FretAnswer(octave, note, randomString, allNotes);
    } catch (InvalidNoteException e) {
      System.err.println(String.format("Error trying to create fret answer: %s", e.getMessage()));
    }
    model.addAttribute("fretAnswer", fretAnswer);

    return "6-string-guitar";
  }

  @PostMapping("/6-string-guitar")
  public String fretSubmit(@ModelAttribute FretAnswer fretAnswer, Model model) {
    model.addAttribute("fretAnswer", fretAnswer);
    return "result";
  }

  @ModelAttribute("randomOctave")
  public String randomOctave() {
    int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
    return randomNum == 0 ? "low" : "high";
  }

  @ModelAttribute("randomNote")
  public String randomNote() {
    List<String> notes = allNotes();
    int randomIndex = ThreadLocalRandom.current().nextInt(0, notes.size());
    return notes.get(randomIndex);
  }

  @ModelAttribute("allNotes")
  public static List<String> allNotes() {
    return Arrays.asList("Ab", "A", "A#", "Bb", "B", "C", "C#", "Db", "D", "D#", "Eb", "E", "F", "F#", "Gb", "G", "G#");
  }
}
