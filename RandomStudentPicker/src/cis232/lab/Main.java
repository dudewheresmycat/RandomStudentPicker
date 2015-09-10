package cis232.lab;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		File originalFile = new File("students.csv");
		Scanner input = new Scanner(originalFile);

		ArrayList<Student> students = new ArrayList<>();
		Random random = new Random();

		

		while (input.hasNextLine()) {
			StringTokenizer tokens = new StringTokenizer(input.nextLine(), ",");
			if (tokens.countTokens() >= 2) {
				Student s = new Student(tokens.nextToken(), tokens.nextToken());
				students.add(s);
			} 
		}
		
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Pick a student? (y/n)");
			String userIn = keyboard.nextLine();
			while(userIn.equalsIgnoreCase("y")) {
				int randomNumber = random.nextInt(students.size());
				String name = students.get(randomNumber).getName();
				System.out.println(name);
				System.out.println("Did they get the question right?(y/n)");
				boolean correct = keyboard.nextLine().equalsIgnoreCase("y");
				if(correct){
					students.get(randomNumber).addPoint();
					System.out.println("Correct!");
					System.out.println(students.get(randomNumber).getName() + " has " +students.get(randomNumber).getPoints()+ " points.");
				}else{
					System.out.println("Incorrect.");
					System.out.println(students.get(randomNumber).getName() + " has " +students.get(randomNumber).getPoints()+ " points.");
				}
				System.out.println("Pick another student?(y/n)");
				userIn = keyboard.nextLine();
			}
			
			String filename = "students.csv";
			FileWriter writefile = new FileWriter(filename);
			PrintWriter output = new PrintWriter(writefile);
			for(int i = 0; i < students.size(); i++){
	        	
	        	output.print(students.get(i).getName()+",");
	        	
	        	output.print(students.get(i).getPoints());
				output.println();
			}
			// For testing purposes, output all the lines

			
			
		input.close();
		output.close();
		

	}

}
