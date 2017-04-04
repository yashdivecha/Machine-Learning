import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NaiveBayesAlgo - This class calculates the probability of all the attributes
 * depending on the class labels and classify the testing data into one of the
 * classes.
 * 
 * @author Yash Divecha
 */
public class NaiveBayesAlgo {

	Map<String, Double> attributes = new HashMap<String, Double>();
	Map<String, Double> valPositive = new HashMap<String, Double>();
	Map<String, Double> valNegative = new HashMap<String, Double>();
	Map<String, Double> valPositiveAll = new HashMap<String, Double>();
	Map<String, Double> valNegativeAll = new HashMap<String, Double>();

	// Method calculates Naive Bayes
	public void applyNaiveBayes(List<List<String>> values, List<String> classLabelValues) {
		// count the occurrences of play tennis attributes
		for (int i = 0; i < classLabelValues.size(); i++) {
			if (!attributes.containsKey(classLabelValues.get(i))) {
				attributes.put(classLabelValues.get(i), (double) 0);
			}
			attributes.put(classLabelValues.get(i), attributes.get(classLabelValues.get(i)) + 1);
		}
		// Display the probability of play game attributes
		for (String key : attributes.keySet()) {
			System.out.println("P(" + key + "): " + attributes.get(key) / classLabelValues.size());
		}
		System.out.println();
		// count the occurrences of each value
		for (int i = 0; i < values.size() - 1; i++) {
			valPositive.clear();
			valNegative.clear();
			// calculate the positive and negative occurrences for all
			// attributes
			for (int j = 0; j < values.get(i).size(); j++) {
				if (!valPositive.containsKey(values.get(i).get(j))) {
					valPositive.put(values.get(i).get(j), (double) 0);
				}
				if (!valNegative.containsKey(values.get(i).get(j))) {
					valNegative.put(values.get(i).get(j), (double) 0);
				}
				if (classLabelValues.get(j).equalsIgnoreCase("Yes")) {
					valPositive.put(values.get(i).get(j), valPositive.get(values.get(i).get(j)) + 1);
				} else if (classLabelValues.get(j).equalsIgnoreCase("No")) {
					valNegative.put(values.get(i).get(j), valNegative.get(values.get(i).get(j)) + 1);
				}
			}

			// Calculate the probability for attributes given on Yes and NO
			for (String key : valPositive.keySet()) {
				// System.out.println("P(" + key + "|Yes): " +
				// valPositive.get(key) / attributes.get("Yes"));
				valPositive.put(key, valPositive.get(key) / attributes.get("Yes"));
				System.out.println("P(" + key + "|Yes): " + valPositive.get(key));

				// System.out.println("P(" + key + "|No): " +
				// valNegative.get(key) / attributes.get("No"));
				valNegative.put(key, valNegative.get(key) / attributes.get("No"));
				System.out.println("P(" + key + "|No): " + valNegative.get(key));

			}
			System.out.println("");
			valPositiveAll.putAll(valPositive);
			valNegativeAll.putAll(valNegative);
		}
	}

	// Method to classify the testing data into one of the class labels
	// (PlayTennis = Yes OR PlayTennis = No)
	public void testingData(String attr1, String attr2, String attr3, String attr4) {
		double resultPositive = (attributes.get("Yes") / (attributes.get("Yes") + attributes.get("No")))
				* (valPositiveAll.get(attr1) * valPositiveAll.get(attr2) * valPositiveAll.get(attr3)
						* valPositiveAll.get(attr4));
		double resultNegative = (attributes.get("No") / (attributes.get("Yes") + attributes.get("No")))
				* (valNegativeAll.get(attr1) * valNegativeAll.get(attr2) * valNegativeAll.get(attr3)
						* valNegativeAll.get(attr4));

		// System.out.println(
		// (attributes.get("Yes") / (attributes.get("Yes") +
		// attributes.get("No"))) + " " + valPositiveAll.get(attr1)
		// + " " + valPositiveAll.get(attr2) + " " + valPositiveAll.get(attr3) +
		// " " +
		// valPositiveAll.get(attr4));
		// System.out.println(
		// (attributes.get("No") / (attributes.get("Yes") +
		// attributes.get("No"))) + " " + valNegativeAll.get(attr1)
		// + " " + valNegativeAll.get(attr2) + " " + valNegativeAll.get(attr3) +
		// " " +
		// valNegativeAll.get(attr4));
		System.out.println("Testing Data: [" + attr1 + ", " + attr2 + ", " + attr3 + ", " + attr4 + "]");

		if (resultPositive > resultNegative) {
			System.out.println("Play Tennis = Yes");
			System.out.println("P(Yes|X): " + resultPositive);

		} else {
			System.out.println("PlayTennis = No");
			System.out.println("P(No|X): " + resultNegative);
		}
	}
}
