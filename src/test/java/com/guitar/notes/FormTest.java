package com.guitar.notes;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasProperty;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestTestClient
public class FormTest {

  private static final List<String> ALL_NOTES = WebController.allNotes();

  private static void testForm(MockMvc mvc, String postUri, FretAnswer fretAnswer, int maxFret, int correctFret)
      throws Exception {
    String allNotesString = String.valueOf(fretAnswer.getAllNotes());
    allNotesString = allNotesString.replaceAll(", ", ",");
    allNotesString = allNotesString.substring(1, allNotesString.length() - 1);

    for (int i = 0; i <= maxFret; i++) {
      boolean answer = false;
      if (i == correctFret) {
        answer = true;
      }
      mvc.perform(post(postUri)
          .contentType(MediaType.APPLICATION_FORM_URLENCODED)
          .param("fret", String.valueOf(i))
          .param("octave", fretAnswer.getOctave())
          .param("string", fretAnswer.getString())
          .param("allNotes", allNotesString)
          .param("note", fretAnswer.getNote().toString()))
          .andExpect(status().isOk())
          .andExpect(view().name("result"))
          .andExpect(model().attributeExists("randomOctave"))
          .andExpect(model().attributeExists("randomNote"))
          .andExpect(model().attributeExists("allNotes"))
          .andExpect(model().attributeExists("fretAnswer"))
          .andExpect(model().attribute("fretAnswer", hasProperty("isCorrectFret", is(answer))));

    }
  }

  @Test
  public void test6StringGuitarLowEString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "low E";
    final int maxFret = 23;
    FretAnswer answer = new FretAnswer("low", "E", string, ALL_NOTES);
    testForm(mvc, uri, answer, maxFret, 0);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 1);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 2);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 2);

    answer.setNoteString("G");
    testForm(mvc, uri, answer, maxFret, 3);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 4);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 4);

    answer.setNoteString("A");
    testForm(mvc, uri, answer, maxFret, 5);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 6);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 6);

    answer.setNoteString("B");
    testForm(mvc, uri, answer, maxFret, 7);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 8);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 9);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 9);

    answer.setNoteString("D");
    testForm(mvc, uri, answer, maxFret, 10);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("E");
    answer.setOctave("high");
    testForm(mvc, uri, answer, maxFret, 12);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 13);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 14);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 14);

    answer.setNoteString("G");
    testForm(mvc, uri, answer, maxFret, 15);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 16);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 16);

    answer.setNoteString("A");
    testForm(mvc, uri, answer, maxFret, 17);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 18);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 18);

    answer.setNoteString("B");
    testForm(mvc, uri, answer, maxFret, 19);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 20);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 21);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 21);

    answer.setNoteString("D");
    testForm(mvc, uri, answer, maxFret, 22);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 23);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 23);
  }

  @Test
  public void test6StringGuitarAString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "A";
    final int maxFret = 23;
    FretAnswer answer = new FretAnswer("low", "A", string, ALL_NOTES);
    testForm(mvc, uri, answer, maxFret, 0);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 1);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 1);

    answer.setNoteString("B");
    testForm(mvc, uri, answer, maxFret, 2);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 3);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 4);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 4);

    answer.setNoteString("D");
    testForm(mvc, uri, answer, maxFret, 5);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 6);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 6);

    answer.setNoteString("E");
    testForm(mvc, uri, answer, maxFret, 7);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 8);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 9);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 9);

    answer.setNoteString("G");
    testForm(mvc, uri, answer, maxFret, 10);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("A");
    answer.setOctave("high");
    testForm(mvc, uri, answer, maxFret, 12);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 13);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 13);

    answer.setNoteString("B");
    testForm(mvc, uri, answer, maxFret, 14);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 15);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 16);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 16);

    answer.setNoteString("D");
    testForm(mvc, uri, answer, maxFret, 17);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 18);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 18);

    answer.setNoteString("E");
    testForm(mvc, uri, answer, maxFret, 19);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 20);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 21);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 21);

    answer.setNoteString("G");
    testForm(mvc, uri, answer, maxFret, 22);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 23);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 23);
  }

  @Test
  public void test6StringGuitarDString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "D";
    final int maxFret = 23;
    FretAnswer answer = new FretAnswer("low", "D", string, ALL_NOTES);
    testForm(mvc, uri, answer, maxFret, 0);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 1);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 1);

    answer.setNoteString("E");
    testForm(mvc, uri, answer, maxFret, 2);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 3);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 4);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 4);

    answer.setNoteString("G");
    testForm(mvc, uri, answer, maxFret, 5);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 6);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 6);

    answer.setNoteString("A");
    testForm(mvc, uri, answer, maxFret, 7);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 8);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 8);

    answer.setNoteString("B");
    testForm(mvc, uri, answer, maxFret, 9);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 10);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("D");
    answer.setOctave("high");
    testForm(mvc, uri, answer, maxFret, 12);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 13);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 13);

    answer.setNoteString("E");
    testForm(mvc, uri, answer, maxFret, 14);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 15);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 16);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 16);

    answer.setNoteString("G");
    testForm(mvc, uri, answer, maxFret, 17);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 18);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 18);

    answer.setNoteString("A");
    testForm(mvc, uri, answer, maxFret, 19);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 20);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 20);

    answer.setNoteString("B");
    testForm(mvc, uri, answer, maxFret, 21);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 22);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 23);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 23);
  }

  @Test
  public void test6StringGuitarGString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "G";
    final int maxFret = 23;
    FretAnswer answer = new FretAnswer("low", "G", string, ALL_NOTES);
    testForm(mvc, uri, answer, maxFret, 0);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 1);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 1);

    answer.setNoteString("A");
    testForm(mvc, uri, answer, maxFret, 2);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 3);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 3);

    answer.setNoteString("B");
    testForm(mvc, uri, answer, maxFret, 4);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 5);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 6);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 6);

    answer.setNoteString("D");
    testForm(mvc, uri, answer, maxFret, 7);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 8);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 8);

    answer.setNoteString("E");
    testForm(mvc, uri, answer, maxFret, 9);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 10);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("G");
    answer.setOctave("high");
    testForm(mvc, uri, answer, maxFret, 12);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 13);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 13);

    answer.setNoteString("A");
    testForm(mvc, uri, answer, maxFret, 14);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 15);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 15);

    answer.setNoteString("B");
    testForm(mvc, uri, answer, maxFret, 16);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 17);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 18);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 18);

    answer.setNoteString("D");
    testForm(mvc, uri, answer, maxFret, 19);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 20);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 20);

    answer.setNoteString("E");
    testForm(mvc, uri, answer, maxFret, 21);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 22);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 23);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 23);
  }

  @Test
  public void test6StringGuitarBString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "B";
    final int maxFret = 23;
    FretAnswer answer = new FretAnswer("low", "B", string, ALL_NOTES);
    testForm(mvc, uri, answer, maxFret, 0);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 1);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 2);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 2);

    answer.setNoteString("D");
    testForm(mvc, uri, answer, maxFret, 3);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 4);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 4);

    answer.setNoteString("E");
    testForm(mvc, uri, answer, maxFret, 5);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 6);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 7);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 7);

    answer.setNoteString("G");
    testForm(mvc, uri, answer, maxFret, 8);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 9);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 9);

    answer.setNoteString("A");
    testForm(mvc, uri, answer, maxFret, 10);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("B");
    answer.setOctave("high");
    testForm(mvc, uri, answer, maxFret, 12);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 13);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 14);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 14);

    answer.setNoteString("D");
    testForm(mvc, uri, answer, maxFret, 15);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 16);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 16);

    answer.setNoteString("E");
    testForm(mvc, uri, answer, maxFret, 17);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 18);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 19);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 19);

    answer.setNoteString("G");
    testForm(mvc, uri, answer, maxFret, 20);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 21);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 21);

    answer.setNoteString("A");
    testForm(mvc, uri, answer, maxFret, 22);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 23);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 23);
  }

  @Test
  public void test6StringGuitarHighEString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "high E";
    final int maxFret = 23;
    FretAnswer answer = new FretAnswer("low", "E", string, ALL_NOTES);
    testForm(mvc, uri, answer, maxFret, 0);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 1);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 2);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 2);

    answer.setNoteString("G");
    testForm(mvc, uri, answer, maxFret, 3);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 4);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 4);

    answer.setNoteString("A");
    testForm(mvc, uri, answer, maxFret, 5);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 6);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 6);

    answer.setNoteString("B");
    testForm(mvc, uri, answer, maxFret, 7);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 8);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 9);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 9);

    answer.setNoteString("D");
    testForm(mvc, uri, answer, maxFret, 10);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 11);

    answer.setNoteString("E");
    answer.setOctave("high");
    testForm(mvc, uri, answer, maxFret, 12);

    answer.setNoteString("F");
    testForm(mvc, uri, answer, maxFret, 13);

    answer.setNoteString("F#");
    testForm(mvc, uri, answer, maxFret, 14);

    answer.setNoteString("Gb");
    testForm(mvc, uri, answer, maxFret, 14);

    answer.setNoteString("G");
    testForm(mvc, uri, answer, maxFret, 15);

    answer.setNoteString("G#");
    testForm(mvc, uri, answer, maxFret, 16);

    answer.setNoteString("Ab");
    testForm(mvc, uri, answer, maxFret, 16);

    answer.setNoteString("A");
    testForm(mvc, uri, answer, maxFret, 17);

    answer.setNoteString("A#");
    testForm(mvc, uri, answer, maxFret, 18);

    answer.setNoteString("Bb");
    testForm(mvc, uri, answer, maxFret, 18);

    answer.setNoteString("B");
    testForm(mvc, uri, answer, maxFret, 19);

    answer.setNoteString("C");
    testForm(mvc, uri, answer, maxFret, 20);

    answer.setNoteString("C#");
    testForm(mvc, uri, answer, maxFret, 21);

    answer.setNoteString("Db");
    testForm(mvc, uri, answer, maxFret, 21);

    answer.setNoteString("D");
    testForm(mvc, uri, answer, maxFret, 22);

    answer.setNoteString("D#");
    testForm(mvc, uri, answer, maxFret, 23);

    answer.setNoteString("Eb");
    testForm(mvc, uri, answer, maxFret, 23);
  }
}
