package com.has.app;
import java.util.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	public void testFound() {
      ArrayList<String> test = new ArrayList<String>(Arrays.asList("deneme","asd","bfge"));
      assertTrue(new App().search(test, "e" , "a"));
    }
	public void testFound2() {
      ArrayList<String> test = new ArrayList<String>(Arrays.asList("cagdas","evren","gerede"));
      assertTrue(new App().search(test, "e" , "a"));
    }
    public void testNotFound() {
      ArrayList<String> test = new ArrayList<String>(Arrays.asList("fatih","furkan","has"));
      assertFalse(new App().search(test, "a" , "a"));
    }
	public void testNotFound2() {
      ArrayList<String> test = new ArrayList<String>(Arrays.asList("bil","481","yazilim","muhendisligi"));
      assertFalse(new App().search(test, "4" , "4"));
    }
    public void testNull() {
      assertFalse(new App().search(null, "a" , "b"));
    }

}
