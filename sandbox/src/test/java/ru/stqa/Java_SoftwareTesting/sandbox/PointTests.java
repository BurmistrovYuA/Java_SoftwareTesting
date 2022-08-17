package ru.stqa.Java_SoftwareTesting.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance1() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 2);

    Assert.assertEquals(p2.distance(p1), 2.0);
  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 3);

    Assert.assertEquals(p2.distance(p1), 2.0);
  }

}