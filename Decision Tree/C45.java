import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * C45 - This class calculates Information Gain and Gain Ratio.
 * 
 * @author Yash Divecha
 */
public class C45 {
	/**
	 * This function calculates Information Gain and Gain Ratio.
	 * 
	 * @param values
	 *            - Attributes values
	 * @param selectParameter
	 *            - Attributes
	 * @param entropy
	 * @return an Object which stores Information Gain and Gain Ratio
	 */
	public StoreData calGainRatio(List<String> values, List<String> selectParameter, double entropy) {
		
		Map<String, Integer> mapPositive = new HashMap<String, Integer>();
		Map<String, Integer> mapNegative = new HashMap<String, Integer>();

		for (int i = 0; i < selectParameter.size(); i++) {
			if (!mapPositive.containsKey(values.get(i))) {
				mapPositive.put(values.get(i), 0);
			}
			if (!mapNegative.containsKey(values.get(i))) {
				mapNegative.put(values.get(i), 0);
			}
			if (selectParameter.get(i).equalsIgnoreCase("Yes")) {
				mapPositive.put(values.get(i), mapPositive.get(values.get(i)) + 1);
			} else if (selectParameter.get(i).equalsIgnoreCase("No")) {
				mapNegative.put(values.get(i), mapNegative.get(values.get(i)) + 1);
			}
		}

		Double result = 0.0;
		Double gain = entropy;
		double splitInfo = 0.0;
		for (String sequence : mapPositive.keySet()) {
			double p = (double) mapPositive.get(sequence).doubleValue();
			double n = (double) mapNegative.get(sequence).doubleValue();

			if (p != 0) {
				double frequency = p / (p + n);
				result = -frequency * (Math.log(frequency) / Math.log(2));
			}

			if (n != 0) {
				double frequency = n / (p + n);
				result += (-frequency * (Math.log(frequency) / Math.log(2)));
			}

			if (p == 0 && n == 0) {
				gain -= 0;
			} else {
				gain -= (result * ((p + n) / values.size()));
				double frequency = (p + n) / values.size();
				splitInfo += -frequency * (Math.log(frequency) / Math.log(2));
			}
		}
		splitInfo = gain / splitInfo;

		return new StoreData(gain, splitInfo);
	}
}
