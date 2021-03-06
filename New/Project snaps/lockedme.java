package Project_FSD;

import java.io.IOException;

import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class LockedMe {
		
	public static void main(String args[]) throws IOException
	{
	
	System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	System.out.println(":::::::::::::::::::::::::: LOCKED ME.COM  ::::::::::::::::::::::");
	System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	System.out.println("Developer: Robin K M ");
	System.out.println();
	do {
	process();
	
	}
		
	while(true);
	}
	
//FileNotFound Exception 	
//==================================================================================================

	public static void FileNotFoundException() {
	
		System.out.println("File does not exist");}
		
	public static void userInput() throws IOException {
		char c;
		Scanner in = new Scanner(System.in);
		System.out.println("Do you want to start again(Y/N) : ");
		c = in.next().charAt(0);
		if(c=='y' || c == 'Y') {
			process();
		}
		else if(c=='N' || c == 'n') {
			System.out.println("Good bye");
			System.exit(0);
		}
		else if(c!='y' || c !='Y'|| c !='N' || c != 'n') {
			System.out.println("Oops! you have entered invalid input \nPlease enter a valid option\n\n");
			   process();
		}
	}
//View files	
//==================================================================================================
	public void userInput_Reg() {
		try {
		File file = new File("C:\\Users\\Rmath\\Desktop\\New folder");	
	
		if(file.isDirectory())
		{
			List<String> listFile = Arrays.asList(file.list());
			for(String s: listFile) {
				System.out.println(s);
				System.out.println();
			}
		}
	
			else
		{
			System.out.println(file.getAbsolutePath() + " is not a directory");
		}
		}
	
catch(ArithmeticException e) {
	System.out.println("There is an arithmetic exception ");
}
	
}
//core function
//==================================================================================================
	static void process() throws IOException {
		int num =0;
		int opt=0;
		String h=null;
		char c;
		
		Scanner input = new Scanner(System.in);
		File file = new File("C:\\Users\\Rmath\\Desktop\\New folder");

		LockedMe obj = new LockedMe();
		try {
		System.out.println(" 1. View files");
		System.out.println(" 2. File mainpulation options");
		System.out.println(" 3. Exit");
		System.out.println();

		System.out.print(" Enter Your Choice: ");

	   num =  input.nextInt();
		}
		catch(Exception d) {
			if(opt != 1 || opt != 2 || opt != 3) {
				   System.out.println("Oops! you have entered invalid input \nPlease enter a valid option\n\n");
				   process();
		}
		}
		   switch(num){  
//Manipulation options		   
//==================================================================================================		 
		   case 1: System.out.println("Displaying the files  \n"); 
		           obj.userInput_Reg(); 
		           userInput();
		           break ;  
		   case 2:  
			   try {
		    System.out.println("Please select from the available options");
		    System.out.println("Options:\n"); 	   
		    System.out.println(" 1. Create a new file");
			System.out.println(" 2. Delete a file");
			System.out.println(" 3. Search for a file");
			System.out.println(" 4. Return to Main context");
			System.out.println();
			
		   opt = input.nextInt();
			   }
			   catch(Exception e)
			   {
		   if(opt != 1 || opt != 2 || opt != 3 || opt != 4 ) {
			   System.out.println("Oops! you have entered invalid input \nPlease enter a valid option\n\n");
			   process();
			   }
			   }  
			   		   
//File creation---------------------------------------------------------------------------------------
	switch(opt)
	{
			case 1: System.out.println("\n Create a file");
			System.out.println("Enter the name of the file to be created : ");
			h = input.next();
			File newfile = new File("C:\\Users\\Rmath\\Desktop\\New folder\\"+h + ".txt");
			if(newfile.createNewFile()) {
				System.out.println("File created "+ newfile.getName());
				userInput();
			}
			else
				System.out.println("File already exists");
			userInput();
			break;
//File Deletion
//==================================================================================================
		   case 2: System.out.println("Please enter the complete file name to delete");
		
			try {
			h=input.next();
			File filedel = new File("C:\\Users\\Rmath\\Desktop\\New folder\\"+h + ".txt");
			if(filedel.delete())
			{
			
					System.out.println("File "+ filedel.getName() + "  has been deleted");
					userInput();
		           }
			
			else
			 FileNotFoundException();
			}
			finally
			{
				System.out.println();
			}
//==================================================================================================	
		   case 3: System.out.println("Please enter the name or part of the File/Directory : ");
			search();
			break;
//==================================================================================================	
		   case 4: System.out.println("Welcome back\n");
			main(null);
			break;
		   default: System.out.println("Wrong input!\nPlease select from the available options");
			 process();
	}	
//==================================================================================================
			
	
		   case 3: System.out.println("Good bye ");
			System.exit(0);
			break;
		   default: System.out.println("Wrong input!\nPlease select from the available options");
			 process();	 		   
		   }
	}
//search function	
//--------------------------------------------------------------------------------------------------
	private static void search() throws IOException {
		Scanner input = new Scanner(System.in);
	
		String h = input.next();
		boolean flag=false;
		File[] loc = new File("C:\\\\Users\\\\Rmath\\\\Desktop\\\\New folder").listFiles();
				for(int i=0;i<loc.length-1;i++) {
					if(loc[i].getName().contains(h)) {
							flag=true;
							if(loc[i].isFile()) {
								System.out.println("The keyword has retured the below files");
								System.out.println(loc[i].getName());
												}
							else if(loc[i].isDirectory()) {
								System.out.println("The keyword has retured the below directories");
								System.out.println(loc[i].getName());}
																			
													}
											}
				if(flag==false)
				{
						System.out.println("No file or directory found with the keyword : "+ h);
						
				}
					System.out.println();
				userInput();
				}
 			}
	