package com.gpss.common;

import java.util.Map;

import com.gpss.common.utils.IMappingParameter;

/**
 * Hello world!
 *
 */
public class App implements IMappingParameter
{
    public static void main( String[] args )
    {
        System.out.println(fun());
    }
    
    public static Map<String,Object> fun() {
    	return new App().paramToMap(",",1);
    }
}
