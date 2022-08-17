package ru.stqa.Java_SoftwareTesting.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public Point p1;
  /*public Point p2;*/

  /*
  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
  }*/
  public double distance(Point p2){
    return Math.sqrt((this.x - p2.x) * (this.x - p2.x) + (this.y - p2.y) * (this.y - p2.y) );
  }


}



