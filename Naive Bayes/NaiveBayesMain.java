import java.util.List;
/**
 * NaiveBayes - This class is the Driver class. Creates an object of
 * FileProcessor and reads the file. Creates an object of Naive Bayes Algo class
 * and calculates the probability of all the attributes. Finally classifies the
 * testing data into one of the classes depending upon the highest probability.
 * 
 * @author Yash Divecha
 */
public class NaiveBayesMain {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Invalid number of argument");
			System.out.println("Usage: java NaiveBayesMain <inputFileName> ");
			System.exit(1);
		} else {
			FileProcessor fp = new FileProcessor(args[0]);
			List<List<String>> attributesValues = fp.readFile();

			NaiveBayesAlgo naiveBayes = new NaiveBayesAlgo();
			naiveBayes.applyNaiveBayes(attributesValues, attributesValues.get(attributesValues.size() - 1));
			naiveBayes.testingData("Rain", "Cool", "High", "Strong");
		}
	}
}
