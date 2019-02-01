package com.lyyzoo.gpss.api;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import com.lyyzoo.gpss.api.vo.PurchaseOrder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	Set<String> set = new LinkedHashSet<>();
    	set.add("z");
    	set.add("b");
    	set.add("c");
    	System.out.println(new PurchaseOrder());
    }

}
