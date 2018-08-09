package com.gpss.user.service;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( ((System.currentTimeMillis() >>> 16)^System.currentTimeMillis()) & 999/100 );
    }
}
