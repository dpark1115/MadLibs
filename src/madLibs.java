import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class madLibs {
	private Scanner in = new Scanner(System.in);
	public static final String TITLE = "Welcome to the game of Mad Libs.\nYou will help create a story by providing words and phrases.";

	public void run() {
		System.out.println(TITLE);
		while (true) {
			String command = getString("(C)reate, (V)iew, or (Q)uit: ")
					.toLowerCase();

			if (command.equals("c")) {
				create();
			} else if (command.equals("v")) {
				view();
			} else if (command.equals("q")) {
				break;
			} else {
				System.out.println("Invalid command");
			}
		}

		System.out.println("Goodbye :(");
	}

	public void create() {
		String fileName = getString("Enter a File Name:").toLowerCase();
		if (fileName.equals("simple")) {

			Scanner filereader = getFile("input/simple");
			PrintWriter writer = getWriter("output/simple");
			readWrite(filereader, writer);

		}

		else if (fileName.equals("dance")) {
			Scanner filereader = getFile("input/dance");
			PrintWriter writer = getWriter("output/dance");
			readWrite(filereader, writer);

		}

		else if (fileName.equals("clothes")) {
			Scanner filereader = getFile("input/clothes");
			PrintWriter writer = getWriter("output/clothes");
			readWrite(filereader, writer);

		}

		else if (fileName.equals("tarzan")) {
			Scanner filereader = getFile("input/tarzan");
			PrintWriter writer = getWriter("output/tarzan");
			readWrite(filereader, writer);

		} else
			System.out.println("Not a valid file name, Please try again");
	}

	public Scanner getFile(String files) {

		File file = new File(files);

		try {
			return new Scanner(file);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		return null;

	}

	public PrintWriter getWriter(String files) {

		try {
			// second parameter as true will open file for appending
			FileOutputStream file = new FileOutputStream(files, true);
			return new PrintWriter(file);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}

		return null;
	}

	public void readWrite(Scanner filereader, PrintWriter writer) {

		while (filereader.hasNextLine()) {
			String line = filereader.nextLine();
			System.out.println("i hit this2");

			while (true) {
				int startindex = line.indexOf("<");
				System.out.println(startindex);
				if (startindex == -1)
					break;
				
				int endindex = line.indexOf(">");
				String data = line.substring(startindex + 1, endindex);
				System.out.println(data);
				String word = getString("Please type a " + data + " :");
				String begIndex = line.substring(startindex, (endindex + 1));

				line = line.replace(begIndex, word);
				

			}
				writer.println(line);
		}
		System.out.println("Mad Lib has been created");
		writer.close();

	}

	public void view() {

		String outFiles = getString("Enter a File Name:").toLowerCase();

		if (outFiles.equals("simple")) {

			Scanner filereader = getFile("output/simple");
			while (filereader.hasNextLine()) {
				String line = filereader.nextLine();
				System.out.println(line);
			}

			filereader.close();
		}

		else if (outFiles.equals("clothes")) {
			Scanner filereader = getFile("output/clothes");
			while (filereader.hasNextLine()) {
				String line = filereader.nextLine();
				System.out.println(line);
			}

			filereader.close();
		}

		else if (outFiles.equals("tarzan")) {
			Scanner filereader = getFile("output/tarzan");
			while (filereader.hasNextLine()) {
				String line = filereader.nextLine();
				System.out.println(line);
			}

			filereader.close();
		}

		else if (outFiles.equals("dance")) {
			Scanner filereader = getFile("output/dance");
			while (filereader.hasNextLine()) {
				String line = filereader.nextLine();
				System.out.println(line);
			}

			filereader.close();
		}

		else {
			System.out.println("sorry incorrect file");
		}
	}

	public String getString(String question) {
		System.out.print(question);
		return in.nextLine();
	}

	public static void main(String[] args) {

		madLibs MadLibs = new madLibs();
		MadLibs.run();

	}

}
