package phase1.project;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LockedMePrototype {
    
	private static String root = null;
	
	public static void main(String[] args) {
		
		while(true)
		{
			
		// User Interface
		System.out.println("\n*********************************************************");
		System.out.println("*********************[LockedMe.com]**********************");
		System.out.println("*********************************************************");
		System.out.println();
		
		System.out.println("Please enter your choice from the list below");
		
	    // First Option
		System.out.println("1. List of Current files in the directory");
		
		// Second Option
		System.out.println("2. Add / Delete or Search a file");
		
		// Third Option
        System.out.println("3. Close the application");
        
        // Taking the user input
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        
        switch(input) {
	        case 1: fileList();
	                break;
	        
	        case 2: detailOptions();
	                break;
	                
	        case 3: System.out.println("Thank you for using LockedMe.com. \nClosing...");
	                System.exit(0);
	        
	        default: System.out.println("Please enter number from 1 - 3 only.");
	     
	        }
        
        
		}
        
        
	}
	
	
	public static void setDirectory() {
			Scanner sc = new Scanner(System.in);
			
	    	System.out.println("Please enter the path for root directory");
	    	//return Files.isDirectory(Paths.get(root_dir));
	    	
	    	root = sc.nextLine();
	    	while(!Files.isDirectory(Paths.get(root)))
	    	{
	    		System.out.println("Invalid direcotry path. Please enter valid direcotry path");
	    		root = sc.nextLine();
	    	}
	    	System.out.println("Root director set to : "+root);
	}
	
	// Main menu option 1 method
	public static void fileList() {
		if(root==null) 
		setDirectory();
		
		try {
			File file = new File(root);
			String[] files = file.list();
			
			if(files.length ==0)
			{
				System.out.println("No file found. Directory is empty.");
				return;
			}
			
			TreeSet<String> fileList = new TreeSet<>();
		
		    for(String s:files)
		    	fileList.add(s);
			
			
			int count = 1;
			Iterator<String> itr = fileList.iterator();
			
			System.out.println("Files currently present in the root directory in ascending order are:");
			while(itr.hasNext()) {
				System.out.println((count++)+": "+itr.next());
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	
	
	// Main menu option 2 method
	public static void detailOptions(){
		
		if(root==null) 
		setDirectory();
		
		while(true)
		{
		System.out.println("\n*********************************************************");
		System.out.println("*********************[LockedMe.com]**********************");
		System.out.println("*********************************************************");
		System.out.println();
		System.out.println("------------Developed by - Vikash Kumar -----------------");
		System.out.println();
		
        System.out.println("Please enter your choice from the list below");
		
	    // First Option
		System.out.println("1. Add a file to the existing directory list");
		
		// Second Option
		System.out.println("2. Delete a file from the existing directory list");
		
		// Third Option
        System.out.println("3. Search a file");
        
        // Fourth Option
        System.out.println("4. Navigate back to the main menu");
        
        // Taking the user input
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        
        switch(input) {
	        case 1: addFile();
	                break;
	        
	        case 2: deleteFile();
	                break;
	        
	        case 3: searchFile();
	                break;
	                
	        case 4: return;
	        
	        default: System.out.println("Please enter number from 1 - 4 only.");
	     
	        }
		}
        
	}
	
	
	// Add File
	public static void addFile() {

	    // need to put try block
    	Scanner sc = new Scanner(System.in);
 
    	System.out.println("Please enter the name of the file to be created");
    	String fileName = sc.nextLine();
    	
		
		
		try   
		{  
			File file = new File(root+"\\"+fileName); 
			
		 	
			if(file.createNewFile())      
			{  
			System.out.println("File created at: "+file.getCanonicalPath()); //returns the path string  
			}  
			else  
			{  
			System.out.println("File already exist at location: "+file.getCanonicalPath());  
			}  
		}   
		catch (Exception e)   
		{  
		    System.out.println(e.getStackTrace());    
		}     
	    
	}
	
	// Delete File
	public static void deleteFile() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Plese enter the name of the file to be deleted");
		String fileName = sc.nextLine();
		
		try {
			File file = new File(root+"\\"+fileName);

			if(file.delete()) {
				System.out.println("File deleted successfully");
			}
			else {
				System.out.println("File not deleted");
			}
		}
		catch (Exception e) {
			System.out.println("File not found");
		}
		
	}
	
	// Search File 
	public static void searchFile() {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Plese enter the name of the file to be searched");
		String fileName = sc.nextLine();
		
		try {
		File file = new File(root);
        
		String[] files = file.list();
		
		
	
	    for(String s:files)
	    {   
	    	//System.out.print(s+" ");
	    	if(s.equals(fileName))
	    		{  
	    		   System.out.println("File found at "+root+"\\"+s);
	    		   return;
	    		}
	    }	
	     System.out.println("File not found");
		}catch(Exception e) {
			System.out.println(e.getStackTrace());    
		}
		
	}

}
