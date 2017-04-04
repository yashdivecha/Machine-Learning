import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Entropy - This class calculates the Entropy.
 * 
 * @author Yash
 */
public class Entropy {

	/**
	 * This function calculates Entropy
	 * 
	 * @param values
	 *            Attributes values
	 * @return entropy value
	 */
	public double calEntropy(List<String> values) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		// count the occurrences of each value
		for (String sequence : values) {
			if (!map.containsKey(sequence)) {
				map.put(sequence, 0);
			}
			map.put(sequence, map.get(sequence) + 1);
		}

		// calculate the entropy
		Double entropy = 0.0;
		for (String strSeq : map.keySet()) {
			Double frequency = (double) map.get(strSeq) / values.size();
			entropy -= frequency * (Math.log(frequency) / Math.log(2));
		}

		return entropy;
	}
}
