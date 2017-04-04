import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * FileProcessor - This class reads the input file and stores it in List<List
 * <String>>
 * 
 * @author Yash Divecha
 *
 */
public class FileProcessor {

	private String fileName;
	private List<List<String>> attributesValues = new ArrayList<List<String>>();
	private String[][] tempString = new String[50][50];
	private List<String> attributes = new ArrayList<String>();
	int i = 0, j = 0, flag = 0;

	/**
	 * Constructor of the class.
	 * 
	 * @param fileNameIn
	 *            Name of the file which needs to be read.
	 */
	public FileProcessor(String fileNameIn) {
		this.fileName = fileNameIn;
	}

	/**
	 * Getter method of the attributes
	 * 
	 * @return List<String> get the attributes
	 */
	public List<String> getAttributes() {
		return this.attributes;
	}

	/**
	 * Reads the input File.
	 * 
	 * @return List<List<String>> attributes values
	 */
	public List<List<String>> readFile() {
		try {
			// Read the file
			FileReader fileReader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fileReader);
			String line = null;
			// Logic to store data in two dimensional list
			while ((line = br.readLine()) != null) {
				if (flag == 0) {
					for (String part : line.split("\\s+")) {
						attributes.add(part);
					}
					flag = 1;
				} else {
					j = 0;
					for (String part : line.split("\\s+")) {
						tempString[i][j++] = part;
					}
					i++;
				}
			}
			br.close();

			// Logic to store data column wise
			List<String> str;
			for (int k = 0; k < j; k++) {
				str = new ArrayList<String>();
				for (int l = 0; l < i; l++) {
					str.add(tempString[l][k]);
				}
				attributesValues.add(str);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
			System.exit(1);
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			System.exit(1);
		}
		return attributesValues;
	}
}
