import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class BookshopTest {

	private Bookshop bookshop;
	private List<Integer> booksToBuy;

	@Before
	public void setup() {
		// Given
		bookshop = new Bookshop();
		booksToBuy = new ArrayList<Integer>();
	}

	private void verifyBooksPrice(Double expected) {
		// When
		double price = bookshop.buy(booksToBuy);
		// Then
		Assert.assertEquals(expected, price);
	}

	@Test
	public void shouldReturn0WhenNoBook() {
		// When
		double price = bookshop.buy(booksToBuy);
		Double expected = 0.;
		// Then
		Assert.assertEquals(expected, price);
	}

	@Test
	public void shouldReturn8whenBuyOneBook() {
		// Given
		booksToBuy.add(0);
		Double expected = 8.;
		verifyBooksPrice(expected);
	}

	@Test
	public void shouldReturn16whenBuyTwoSameBooks() {
		// Given
		booksToBuy.add(0);
		booksToBuy.add(0);
		Double expected = 16.;
		verifyBooksPrice(expected);

	}

	@Test
	public void shouldReturn152whenBuyTwoDifferentBooks() {
		// Given
		booksToBuy.add(0);
		booksToBuy.add(1);
		Double expected = 15.2;
		verifyBooksPrice(expected);

	}

	@Test
	public void shouldReturnPromotedPriceWhenBuy2DifferentBooks() {
		// Given
		booksToBuy.add(1);
		booksToBuy.add(2);
		Double expected = 15.2;
		verifyBooksPrice(expected);
	}

	@Test
	public void shouldReturnPromotedPriceWhenBuy3DifferentBooks() {
		// Given
		booksToBuy.add(0);
		booksToBuy.add(1);
		booksToBuy.add(2);
		Double expected = 21.6;
		verifyBooksPrice(expected);
	}

	@Test
	public void shouldReturnPromotedPriceWhenBuy4DifferentBooks() {
		// Given
		booksToBuy.add(0);
		booksToBuy.add(1);
		booksToBuy.add(2);
		booksToBuy.add(3);
		Double expected = 25.6;
		verifyBooksPrice(expected);
	}

	@Test
	public void shouldReturnPromotedPriceWhenBuy5DifferentBooks() {
		// Given
		booksToBuy.add(0);
		booksToBuy.add(1);
		booksToBuy.add(2);
		booksToBuy.add(3);
		booksToBuy.add(4);
		Double expected = 30.;
		verifyBooksPrice(expected);
	}

	@Test
	public void shouldReturnPromotedPriceWhenBuy2DifferentBooksAnd1BookDuplicated() {
		// Given
		booksToBuy.add(0);
		booksToBuy.add(0);
		booksToBuy.add(1);
		Double expected = 23.2;
		verifyBooksPrice(expected);
	}
	
	@Test
	public void shouldReturnAPromotedPriceWhen2BookSets()
	{
		// Given
		booksToBuy.add(0);
		booksToBuy.add(0);
		booksToBuy.add(1);
		booksToBuy.add(1);
		Double expected = 30.4;
		verifyBooksPrice(expected);
	}
	
}
