package fr.seremptos.cleaner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	public static Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)" + String.valueOf('§') + "[0-9A-FK-OR]");
	public static String stripColor(final String input) {
        if (input == null) {
            return null;
        }
        return STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
    }
		
		public static void main(String[] args) throws IOException {
			
			System.out.print("Fichier à nettoyer : ");
	        Scanner sfile = new Scanner(System.in);
	        String inputString = sfile.nextLine();
	        sfile.close();
	        File file = Paths.get(System.getProperty("user.home")+"/AppData/Roaming/.minecraft/logs/"+inputString).toFile();
			System.out.println(file);
	        

	        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file+" - Cleaned"), Charset.defaultCharset());
	        PrintWriter pw = new PrintWriter(outputStreamWriter);
	        BufferedReader br1 = new BufferedReader(new InputStreamReader(new 	FileInputStream(file), Charset.forName("Cp1252"))); 
	        String line1 = br1.readLine();
	          
	        while(line1 != null && !line1.equals("")) 
	        { 
	            pw.println(stripColor(line1)); 
	            line1 = br1.readLine(); 
	              
	        } 
	        pw.flush(); 
	        br1.close(); 
	        pw.close(); 
	          
	        System.out.println("File operation performed successfully"); 
	    
		}
	
}