import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bookshop {

	private static final Double UNIT_PRICE = 8.;
	private List<Double> promotionPolicy = new ArrayList<Double>();

	public Bookshop() {
		promotionPolicy.add(0.);
		promotionPolicy.add(1.);
		promotionPolicy.add(0.95);
		promotionPolicy.add(0.9);
		promotionPolicy.add(0.80);
		promotionPolicy.add(0.75);
	}
	private double promote(List<Integer> booksToBuy) {

		Set<Integer> set = new HashSet<Integer>();
		set.addAll(booksToBuy);
		return promotionPolicy.get(set.size());
	}

	public double buy(List<Integer> booksToBuy) {

		double basicPrice = UNIT_PRICE;

		Set<Integer> set = new HashSet<Integer>();

		double price = 0.0;
		while (!booksToBuy.isEmpty()) {
			
			set.clear();
			set.addAll(booksToBuy);
			price = calculatePartialPromotionPrice(booksToBuy, basicPrice, set,
					price);
		}
		return price;

	}
	private double calculatePartialPromotionPrice(List<Integer> booksToBuy,
			double basicPrice, Set<Integer> set, double price) {
		int bouquinsAvecPromotion = set.size();
		
		double promotionFactor = bouquinsAvecPromotion * promote(booksToBuy);
		price += basicPrice * promotionFactor;
		for (Integer integer : set) {
			booksToBuy.remove(integer);
		}
		return price;
	}


}
