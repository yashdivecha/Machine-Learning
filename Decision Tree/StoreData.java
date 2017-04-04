/**
 * StoreData - This class stores the information gain and gain ratio of a single
 * attribute
 * 
 * @author Yash Divecha
 *
 */
final class StoreData {
	private double gain;
	private double gainRatio;

	public StoreData(double gainIn, double gainRatioIn) {
		this.gain = gainIn;
		this.gainRatio = gainRatioIn;
	}

	public double getGain() {
		return gain;
	}

	public double getGainRatio() {
		return gainRatio;
	}
}
