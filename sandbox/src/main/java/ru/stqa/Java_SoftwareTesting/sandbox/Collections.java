package ru.stqa.Java_SoftwareTesting.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main (String[] args) {
    /*String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Python";
    langs[3] = "PHP";*/
    String[] langs = {"Java", "C#", "Python", "PHP"};

    for(int i = 0; i < langs.length; i++){
      System.out.println("Я хочу выучить " + langs[i]);
    }
    System.out.println("");
    for (String l : langs) {
      System.out.println("Я хочу выучить " + l);
    }

   /* List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");
    System.out.println("");
    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }*/
    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

    System.out.println("");
    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
    System.out.println("");
    for(int i = 0; i < languages.size(); i++){
      System.out.println("Я хочу выучить " + languages.get(i));
    }

    System.out.println("");
    for(String l : languages){
      System.out.println("Я хочу выучить " + l);
    }
  }
}
