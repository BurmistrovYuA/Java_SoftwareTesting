package ru.stqa.Java_SoftwareTesting.sandbox;

public class Equality {

  public static void main(String[] avrs){
    String s1 = "firefox";
  //  String s2 = new String(s1);
    String s2 = "firefox";
    System.out.println( s1 == s2);
    System.out.println(s1.equals(s2));
  }
}
