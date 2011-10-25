

import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;


public class EventTest {

	@Test
	public void shouldSuccedsOnEmptyEventCreation()
	{
		//Given
		//When
		Event evt = new Event(null, 0);
		//Then
		Assert.assertNotNull(evt);
	}
	
	@Test
	public void shouldSuccedsOnTodayEventCreation()
	{
		//Given
		//When
		Event evt = new Event(new Date(), 0);
		//Then
		Assert.assertNotNull(evt);
	}
	
	@Test
	public void shouldSuccedsOnYesterdayEventCreation()
	{
		//Given
		Calendar cal = Calendar.getInstance();
		cal.set(2011, 9, 23);
		Date date = cal.getTime();
		//When
		Event evt = new Event(date, 0);
		//Then
		Assert.assertNotNull(evt);
	}
	
	@Test
	public void shouldReturnTrueOnFutureEvent(){
		// G
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 9, 23);
		Date date = cal.getTime();
		Event evt = new Event(date, 0);
		// W
		boolean isFutureEvent = evt.isFutureEvent();
		// T
		Assert.assertTrue(isFutureEvent);
	}
	
	@Test
	public void shouldReturnFalseOnPastEvent(){
		// G
		Calendar cal = Calendar.getInstance();
		cal.set(2010, 9, 23);
		Date date = cal.getTime();
		Event evt = new Event(date, 0);
		// W
		boolean isFutureEvent = evt.isFutureEvent();
		// T
		Assert.assertFalse(isFutureEvent);
	}
}
