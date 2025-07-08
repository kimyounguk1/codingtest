package cote.exam1;

	import java.util.*;
	import java.io.*;

	public class pr_phone {
		static String[] phone_book = {"12","123","1235","567","88"};
	    public static boolean solution(String[] phone_book) {
	        boolean result = true;
	        Arrays.sort(phone_book);
	        for(int i=0; i<phone_book.length; i++) {
	        	System.out.println(phone_book[i]);
	        }
	        
	        for(int i=0; i<phone_book.length; i++){
	            String a = phone_book[i];
	            for(int j=i+1; j<phone_book.length; j++){
	                boolean b = a.equals(phone_book[j].substring(0,a.length()));
	                System.out.println(b);
	                if(b){
	                    return  false;
	                }else{
	                    result =  true;
	                }
	            }
	        }
	        return result;
	    }
	    public static void main(String[] args) {
	    	solution(phone_book);
	    }
	}

