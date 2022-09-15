package ru.stqa.Java_SoftwareTesting.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTestes {
  @Test
  public void testPrime(){
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
} @Test
  public void testPrimeFast(){
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }
  @Test(enabled = false)
  public void testPrimeLong(){
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }
  @Test(enabled = false)
  public void testNonPrime(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
  }


}
