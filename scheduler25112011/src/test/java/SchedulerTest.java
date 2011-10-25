import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sun.source.tree.AssertTree;

import junit.framework.Assert;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SchedulerTest {
	@Mock
	SchedulerDisplay schedulerDisplay;
	@Mock
	MailService mailService;
	
	
	@Test
	public void shouldAddFutureEventOnScheduler() {
		// G
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 9, 23);
		Date date = cal.getTime();
		Event event = new Event(date, 0);
		Scheduler scheduler = new Scheduler("");
		scheduler.setDisplay(schedulerDisplay);
		scheduler.setMailService(mailService);
		
		// W
		scheduler.addEvent(event);
		// T
		Assert.assertTrue(scheduler.getEvents().contains(event));
		verify(mailService).sendMail(anyString(), anyString(), anyString());
	}

	@Test
	public void shouldAddPastEventOnScheduler() {
		// G
		Calendar cal = Calendar.getInstance();
		cal.set(2010, 9, 23);
		Date date = cal.getTime();
		Event event = new Event(date, 0);
		Scheduler scheduler = new Scheduler("") {
			@Override
			protected void displayEvents(Event event) {
			}

			@Override
			protected void sendMail(Event event) {
			}
		};
		// W
		scheduler.addEvent(event);
		// T
		Assert.assertFalse(scheduler.getEvents().contains(event));
	}
	@Test
	public void shouldCallAppendToTextWhenCallUpdate() throws Exception
	{
		// G
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 9, 23);
		Date date = cal.getTime();
		Event event = new Meeting(date, 0, "");
		Scheduler scheduler = new Scheduler("");
		scheduler.setDisplay(schedulerDisplay);
		scheduler.setMailService(mailService);
		List events = new ArrayList();
		events.add(event);
		scheduler.setEvents(events);
		// W
		scheduler.update();
		// T
		Assert.assertNotNull(scheduler.getEvents().contains(event));
		verify(mailService).sendMail(anyString(), anyString(), anyString());
		
	}
	
	

}
