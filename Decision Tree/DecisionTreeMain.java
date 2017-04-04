import java.util.List;

/**
 * DecisionTreeMain -- This class is the Driver class. Creates an object of
 * FileProcessor and reads the file. Creates an object of Entropy, calls
 * calEntropy and display the same. Creates an object of C45 and displays
 * Information Gain and Gain Ratio. Finally displays the best attribute of the
 * root of the Decision Tree.
 * 
 * @author: Yash Divecha
 * 
 */
public class DecisionTreeMain {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Invalid number of argument");
			System.out.println("Usage: java DecisionTreeMain <inputFileName> ");
			System.exit(1);
		} else {
			FileProcessor fp = new FileProcessor(args[0]);
			List<List<String>> attributesValues = fp.readFile();
			List<String> attributes = fp.getAttributes();
			double entropy;
			double best = 0.0;
			int i = 0, j = 0;

			Entropy enObj = new Entropy();
			entropy = enObj.calEntropy(attributesValues.get(attributesValues.size() - 1));
			System.out.println("Entropy E(S): " + entropy + "\n");

			C45 myc45 = new C45();
			for (i = 0; i < attributesValues.size() - 1; i++) {
				StoreData rs = myc45.calGainRatio(attributesValues.get(i),
						attributesValues.get(attributesValues.size() - 1), entropy);
				System.out.println("Information Gain G(S," + attributes.get(i) + ") : " + rs.getGain());
				System.out.println("Gain Ratio [" + attributes.get(i) + "] : " + rs.getGainRatio() + "\n");
				if (best < rs.getGainRatio()) {
					best = rs.getGainRatio();
					j = i;
				}
			}
			System.out.println("Best Attribute for the Root node is \"" + attributes.get(j) + "\"");
		}
	}
}
