import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class Coder {
	/**
	* @param args
	*/
	public static void main(String[] args) {
		if (args.length < 4) {
		System.out.println("ERROR: Запустите программу с аргументами: имя_входного_файла кодировка имя_выходного_файла кодировка\n");
		return;
		}
		File file_in = new File(args[0]);
		System.out.println("Input file is: " + args[0]);
		System.out.println("Input encoding is: " + args[1]);
		System.out.println("Output file is: " + args[2]);
		System.out.println("Output encoding is: " + args[3]);
		File file_out = new File(args[2]);
		try {
			Scanner scanner = new Scanner(new InputStreamReader(new FileInputStream(file_in), args[1]));
			OutputStream os = new FileOutputStream(file_out);
			try {
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(os), args[3]));
				try {
					while (scanner.hasNextLine())
						writer.println(scanner.nextLine());
				} finally {
					writer.close();
				}
			} finally {
				os.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
