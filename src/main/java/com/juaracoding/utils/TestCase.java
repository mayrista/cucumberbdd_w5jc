package com.juaracoding.utils;

public enum TestCase {
    T1 ("Admin Login Valid"),
    T2("Admin Login null Username and Password"),
    T3("Add to cart"),
    T4("Checkout Negatif null Data Information"),
    T5("Checkout success and logout");


 private String testCaseName;
 TestCase(String value){
     testCaseName = value;
 }
 public String getTestCaseName(){
     return testCaseName;
 }
}
