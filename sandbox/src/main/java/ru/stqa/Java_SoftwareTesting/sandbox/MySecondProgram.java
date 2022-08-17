package ru.stqa.Java_SoftwareTesting.sandbox;

public class MySecondProgram {

  public static void main(String[] args) {
    Point p1 = new Point(0,0);
    Point p2 = new Point(1,1);
    //System.out.println("Расстояние между точкой p1=(" + p1.x +","+p1.y+ ") и p2=("+ p2.x +","+p2.y+ ") ="+ Point.distance(p1,p2));
    System.out.println("Расстояние между точкой p1=(" + p1.x +","+p1.y+ ") и p2=("+ p2.x +","+p2.y+ ") ="+ p1.distance(p2));
  }

}