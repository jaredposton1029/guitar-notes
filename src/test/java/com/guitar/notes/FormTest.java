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

  private static void testForm(MockMvc mvc, String postUri, FretAnswer fretAnswer, int userSubmittedFret)
      throws Exception {
    String allNotesString = String.valueOf(fretAnswer.getAllNotes());
    allNotesString = allNotesString.replaceAll(", ", ",");
    allNotesString = allNotesString.substring(1, allNotesString.length() - 1);

    mvc.perform(post(postUri)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("fret", String.valueOf(userSubmittedFret))
        .param("octave", fretAnswer.getOctave())
        .param("string", fretAnswer.getString())
        .param("allNotes", allNotesString)
        .param("note", fretAnswer.getNote()))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attributeExists("randomOctave"))
        .andExpect(model().attributeExists("randomNote"))
        .andExpect(model().attributeExists("allNotes"))
        .andExpect(model().attributeExists("fretAnswer"))
        .andExpect(model().attribute("fretAnswer", hasProperty("isCorrectFret", is(true))));
  }

  @Test
  public void test6StringGuitarLowEString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "low E";
    FretAnswer answer = new FretAnswer("low", "E", string, ALL_NOTES);
    testForm(mvc, uri, answer, 0);

    answer.setNote("F");
    testForm(mvc, uri, answer, 1);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 2);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 2);

    answer.setNote("G");
    testForm(mvc, uri, answer, 3);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 4);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 4);

    answer.setNote("A");
    testForm(mvc, uri, answer, 5);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 6);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 6);

    answer.setNote("B");
    testForm(mvc, uri, answer, 7);

    answer.setNote("C");
    testForm(mvc, uri, answer, 8);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 9);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 9);

    answer.setNote("D");
    testForm(mvc, uri, answer, 10);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 11);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 11);

    answer.setNote("E");
    answer.setOctave("high");
    testForm(mvc, uri, answer, 12);

    answer.setNote("F");
    testForm(mvc, uri, answer, 13);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 14);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 14);

    answer.setNote("G");
    testForm(mvc, uri, answer, 15);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 16);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 16);

    answer.setNote("A");
    testForm(mvc, uri, answer, 17);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 18);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 18);

    answer.setNote("B");
    testForm(mvc, uri, answer, 19);

    answer.setNote("C");
    testForm(mvc, uri, answer, 20);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 21);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 21);

    answer.setNote("D");
    testForm(mvc, uri, answer, 22);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 23);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 23);
  }

  @Test
  public void test6StringGuitarAString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "A";
    FretAnswer answer = new FretAnswer("low", "A", string, ALL_NOTES);
    testForm(mvc, uri, answer, 0);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 1);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 1);

    answer.setNote("B");
    testForm(mvc, uri, answer, 2);

    answer.setNote("C");
    testForm(mvc, uri, answer, 3);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 4);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 4);

    answer.setNote("D");
    testForm(mvc, uri, answer, 5);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 6);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 6);

    answer.setNote("E");
    testForm(mvc, uri, answer, 7);

    answer.setNote("F");
    testForm(mvc, uri, answer, 8);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 9);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 9);

    answer.setNote("G");
    testForm(mvc, uri, answer, 10);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 11);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 11);

    answer.setNote("A");
    answer.setOctave("high");
    testForm(mvc, uri, answer, 12);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 13);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 13);

    answer.setNote("B");
    testForm(mvc, uri, answer, 14);

    answer.setNote("C");
    testForm(mvc, uri, answer, 15);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 16);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 16);

    answer.setNote("D");
    testForm(mvc, uri, answer, 17);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 18);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 18);

    answer.setNote("E");
    testForm(mvc, uri, answer, 19);

    answer.setNote("F");
    testForm(mvc, uri, answer, 20);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 21);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 21);

    answer.setNote("G");
    testForm(mvc, uri, answer, 22);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 23);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 23);
  }

  @Test
  public void test6StringGuitarDString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "D";
    FretAnswer answer = new FretAnswer("low", "D", string, ALL_NOTES);
    testForm(mvc, uri, answer, 0);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 1);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 1);

    answer.setNote("E");
    testForm(mvc, uri, answer, 2);

    answer.setNote("F");
    testForm(mvc, uri, answer, 3);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 4);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 4);

    answer.setNote("G");
    testForm(mvc, uri, answer, 5);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 6);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 6);

    answer.setNote("A");
    testForm(mvc, uri, answer, 7);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 8);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 8);

    answer.setNote("B");
    testForm(mvc, uri, answer, 9);

    answer.setNote("C");
    testForm(mvc, uri, answer, 10);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 11);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 11);

    answer.setNote("D");
    answer.setOctave("high");
    testForm(mvc, uri, answer, 12);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 13);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 13);

    answer.setNote("E");
    testForm(mvc, uri, answer, 14);

    answer.setNote("F");
    testForm(mvc, uri, answer, 15);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 16);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 16);

    answer.setNote("G");
    testForm(mvc, uri, answer, 17);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 18);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 18);

    answer.setNote("A");
    testForm(mvc, uri, answer, 19);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 20);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 20);

    answer.setNote("B");
    testForm(mvc, uri, answer, 21);

    answer.setNote("C");
    testForm(mvc, uri, answer, 22);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 23);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 23);
  }

  @Test
  public void test6StringGuitarGString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "G";
    FretAnswer answer = new FretAnswer("low", "G", string, ALL_NOTES);
    testForm(mvc, uri, answer, 0);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 1);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 1);

    answer.setNote("A");
    testForm(mvc, uri, answer, 2);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 3);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 3);

    answer.setNote("B");
    testForm(mvc, uri, answer, 4);

    answer.setNote("C");
    testForm(mvc, uri, answer, 5);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 6);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 6);

    answer.setNote("D");
    testForm(mvc, uri, answer, 7);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 8);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 8);

    answer.setNote("E");
    testForm(mvc, uri, answer, 9);

    answer.setNote("F");
    testForm(mvc, uri, answer, 10);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 11);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 11);

    answer.setNote("G");
    answer.setOctave("high");
    testForm(mvc, uri, answer, 12);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 13);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 13);

    answer.setNote("A");
    testForm(mvc, uri, answer, 14);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 15);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 15);

    answer.setNote("B");
    testForm(mvc, uri, answer, 16);

    answer.setNote("C");
    testForm(mvc, uri, answer, 17);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 18);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 18);

    answer.setNote("D");
    testForm(mvc, uri, answer, 19);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 20);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 20);

    answer.setNote("E");
    testForm(mvc, uri, answer, 21);

    answer.setNote("F");
    testForm(mvc, uri, answer, 22);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 23);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 23);
  }

  @Test
  public void test6StringGuitarBString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "B";
    FretAnswer answer = new FretAnswer("low", "B", string, ALL_NOTES);
    testForm(mvc, uri, answer, 0);

    answer.setNote("C");
    testForm(mvc, uri, answer, 1);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 2);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 2);

    answer.setNote("D");
    testForm(mvc, uri, answer, 3);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 4);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 4);

    answer.setNote("E");
    testForm(mvc, uri, answer, 5);

    answer.setNote("F");
    testForm(mvc, uri, answer, 6);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 7);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 7);

    answer.setNote("G");
    testForm(mvc, uri, answer, 8);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 9);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 9);

    answer.setNote("A");
    testForm(mvc, uri, answer, 10);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 11);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 11);

    answer.setNote("B");
    answer.setOctave("high");
    testForm(mvc, uri, answer, 12);

    answer.setNote("C");
    testForm(mvc, uri, answer, 13);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 14);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 14);

    answer.setNote("D");
    testForm(mvc, uri, answer, 15);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 16);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 16);

    answer.setNote("E");
    testForm(mvc, uri, answer, 17);

    answer.setNote("F");
    testForm(mvc, uri, answer, 18);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 19);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 19);

    answer.setNote("G");
    testForm(mvc, uri, answer, 20);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 21);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 21);

    answer.setNote("A");
    testForm(mvc, uri, answer, 22);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 23);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 23);
  }

  @Test
  public void test6StringGuitarHighEString(@Autowired MockMvc mvc) throws Exception {
    final String uri = "/6-string-guitar";
    final String string = "high E";
    FretAnswer answer = new FretAnswer("low", "E", string, ALL_NOTES);
    testForm(mvc, uri, answer, 0);

    answer.setNote("F");
    testForm(mvc, uri, answer, 1);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 2);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 2);

    answer.setNote("G");
    testForm(mvc, uri, answer, 3);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 4);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 4);

    answer.setNote("A");
    testForm(mvc, uri, answer, 5);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 6);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 6);

    answer.setNote("B");
    testForm(mvc, uri, answer, 7);

    answer.setNote("C");
    testForm(mvc, uri, answer, 8);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 9);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 9);

    answer.setNote("D");
    testForm(mvc, uri, answer, 10);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 11);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 11);

    answer.setNote("E");
    answer.setOctave("high");
    testForm(mvc, uri, answer, 12);

    answer.setNote("F");
    testForm(mvc, uri, answer, 13);

    answer.setNote("F#");
    testForm(mvc, uri, answer, 14);

    answer.setNote("Gb");
    testForm(mvc, uri, answer, 14);

    answer.setNote("G");
    testForm(mvc, uri, answer, 15);

    answer.setNote("G#");
    testForm(mvc, uri, answer, 16);

    answer.setNote("Ab");
    testForm(mvc, uri, answer, 16);

    answer.setNote("A");
    testForm(mvc, uri, answer, 17);

    answer.setNote("A#");
    testForm(mvc, uri, answer, 18);

    answer.setNote("Bb");
    testForm(mvc, uri, answer, 18);

    answer.setNote("B");
    testForm(mvc, uri, answer, 19);

    answer.setNote("C");
    testForm(mvc, uri, answer, 20);

    answer.setNote("C#");
    testForm(mvc, uri, answer, 21);

    answer.setNote("Db");
    testForm(mvc, uri, answer, 21);

    answer.setNote("D");
    testForm(mvc, uri, answer, 22);

    answer.setNote("D#");
    testForm(mvc, uri, answer, 23);

    answer.setNote("Eb");
    testForm(mvc, uri, answer, 23);
  }
}
