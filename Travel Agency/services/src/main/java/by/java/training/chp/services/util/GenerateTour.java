package by.java.training.chp.services.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.java.training.chp.dataacess.dao.impl.ToursDaoImpl;
import by.java.training.chp.dataacess.model.Tours;

public class GenerateTour {

	public static void main(String[] args) {
		GenerateTour utilGenerateTour = new GenerateTour();
		utilGenerateTour.genSampleTours();

	}

	public void genSampleTours() {
		for (int i = 21235; i < 21400; i++) {

			Tours tour = new Tours();
			tour.setBoardBasisId(RandomVal.getRInt(6));
			tour.setTravelPurposeId(RandomVal.getRInt(4));
			tour.setTransportId(RandomVal.getRInt(4));
			tour.setPrice(RandomVal.getRInt(300, 1500));
			// Las vegas destination id
			tour.setDestination(3824);
			tour.setHotelId(i);
			Date curDate = new Date();
			// adds some days to generate departure/arrival date
			int daysNum = RandomVal.getRInt(10, 30);
			tour.setDateOfDeparture(genFutureDate(curDate, daysNum));
			tour.setDateOfArrival(genFutureDate(curDate, daysNum + RandomVal.getRInt(3, 10)));
			ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-db-context.xml");
			ToursDaoImpl gen = aContext.getBean(ToursDaoImpl.class);
			gen.insert(tour);
		}

	}

	/*
	 * genFutureDate adds days to current date
	 * 
	 */
	private Date genFutureDate(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();

	}

}
