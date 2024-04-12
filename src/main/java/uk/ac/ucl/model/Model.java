package uk.ac.ucl.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Model
{
  int state = 0;
  private File file;

  private List<String> notes = new ArrayList<>(); //
  private List<String> contents = new ArrayList<>();
  private File contentfile;

  public List<String> getPatientNames()
  {
    return List.of("Name1", "Name2", "Name3"); // This is just dummy data
  }

  public void readFile(File file) throws IOException {
    // Read a data file and store the data in your data structure.
    this.file = file;
    BufferedReader in = new BufferedReader(new FileReader(file));
    while (in.ready()) {
      String s = in.readLine();
      notes.add(s);
    }
  }
  public void readContentFile(File file) throws IOException {
    // Read a data file and store the data in your data structure.
    this.contentfile = file;
    BufferedReader in = new BufferedReader(new FileReader(file));
    while (in.ready()) {
      String s = in.readLine();
      contents.add(s);
    }
  }

  // This also returns dummy data. The real version should use the keyword parameter to search
  // the data and return a list of matching items.
  public List<String> searchFor(String keyword)
  {
    List<String> copy = new ArrayList<>();
    for(int i = 0; i < notes.size(); i++){
      if (notes.get(i).contains(keyword))
        copy.add(notes.get(i));
    }
    return copy;
  }

  public List<String> addnote(String note, String content) throws IOException {
    notes.add(note);
    contents.add(content);
    updateDB();
    return notes;
  }

  private void updateDB() throws IOException {
    FileWriter fw = new FileWriter(file.getAbsolutePath(), false);
    for (String n:notes) {
      fw.write(n+"\n");
    }
    fw.close();
    FileWriter fp = new FileWriter(contentfile.getAbsolutePath(), false);
    for (String n:contents) {
      fp.write(n+"\n");
    }
    fp.close();
  }

  public List<String> deleteNote(int index) throws IOException {
    notes.remove(index);
    updateDB();
    return notes;
  }
  public String getNote(int index){
    return notes.get(index);

  }
  public String getContent(int index){
    return contents.get(index);

  }

  public List<String> replaceNote(int index, String newNote, String newContent) throws IOException {
    notes.remove(index);
    notes.add(index, newNote);
    contents.remove(index);
    contents.add(index, newContent);
    updateDB();
    return notes;
  }

  public List<String> sortnote() {
    state = (state + 1) % 3;
    if(state == 0){
      return notes;}
    else if (state == 1){
      List sorted = notes.stream().sorted().collect(Collectors.toList());
      return sorted;}
    else{
      List sorted = notes.stream().sorted().collect(Collectors.toList());
      Collections.reverse(sorted);
      return sorted;

    }
  }
}
