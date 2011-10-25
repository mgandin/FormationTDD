import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fit.ColumnFixture;

public class CalculDuMontantDUneCommande extends ColumnFixture {

	public Integer[] codesDesVolumesAchetes;

	public double montantTotal() {
		Bookshop bookshop = new Bookshop();
		List<Integer> booksToBuy = new ArrayList<Integer>();

		if (codesDesVolumesAchetes != null) {
			booksToBuy = new ArrayList<Integer>();
			booksToBuy.addAll(Arrays
					.asList(codesDesVolumesAchetes));
		}

		return bookshop.buy(booksToBuy);
	}
}
