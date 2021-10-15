package it.unical.demacs.IngSw;

import org.joda.time.DateTime;

import com.sun.tools.javac.util.StringUtils;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DateTime joda=new DateTime();
        System.out.println(joda.toString());
        System.out.println(StringUtils.toUpperCase("Hello world"));
        System.out.println(StringUtils.toUpperCase("Hello world 2"));
    }
}
