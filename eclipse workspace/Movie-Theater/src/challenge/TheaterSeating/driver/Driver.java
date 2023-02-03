package challenge.TheaterSeating.driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import challenge.TheaterSeating.service.MovieTheater;
import challenge.TheaterSeating.test.TestTheaterSeating;
import challenge.TheaterSeating.util.FileProcessor;

public class Driver {
	public static void main(String[] args) {
		
		if (args.length > 0) {			
			MovieTheater movieTheater = new MovieTheater();
			
			try {
				File file = new File(args[0]);
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				/* Read and process the file */
				String newEntry = bufferedReader.readLine();

				while (newEntry != null) {
					int output = movieTheater.bookSeat(newEntry);
					if (output == 1) 
						System.out.println(newEntry + " Invalid number of Seats");
					
					if (output == -1) 
						System.out.println(newEntry + " Sorry, cannot process request due to Insufficient seats");
					
					newEntry = bufferedReader.readLine();
				}
				/* Writing to File */
				FileProcessor fileProcessor = new FileProcessor();
				fileProcessor.writeToFile(movieTheater.getResults());

				/* Print Layout of the theater */
				movieTheater.printLayout();

				/* Calling the Test method */
				TestTheaterSeating test = new TestTheaterSeating();
				MovieTheater testObject = new MovieTheater();
				test.testMe(testObject);

			} catch (FileNotFoundException ex) {
				System.err.println("Input file not Found.");
				ex.printStackTrace();
				System.exit(1);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
