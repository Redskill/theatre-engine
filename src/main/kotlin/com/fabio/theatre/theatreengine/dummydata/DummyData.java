package com.fabio.theatre.theatreengine.dummydata;

import com.fabio.theatre.theatreengine.database.entity.*;
import com.fabio.theatre.theatreengine.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Dummy data class to populate the database. Delete after some tests
 */
@Component
public class DummyData {

  private static Logger log = LoggerFactory.getLogger(DummyData.class);

  @Autowired
  private BookingService bookingService;

  @Autowired
  private CustomerService customerService;

  @Autowired
  private SeatService seatService;

  @Autowired
  private ShowService showService;

  @Autowired
  private VenueService venueService;

  /**
   * After the first run, comment out the annotation @PostConstruct to avoid Hibernate errors
   */
//  @PostConstruct
  private void init() {

    Venue venue = venueService.getAllVenues().stream().findFirst().get();

//    List<String> dates = new ArrayList<>();
//    dates.add("2020-2-02");
//    dates.add("2020-12-30");
//    dates.add("2020-4-6");
//    dates.add("2020-9-18");
//
//    Show lionking =
//        new Show(99, "Harry Potter", venue, "The story follows Harry Potter, who has been tasked by Dumbledore with finding and destroying Lord Voldemort's secret to immortality – the Horcruxes.", "Fantasy", 146, dates, "http://10.0.2.2:8080/harrypotter.jpg");
//
//    showService.saveShow(lionking);

    Customer customer = customerService.getAllCustomers().stream().findFirst().get();
    Show show = showService.getAllshows().stream().filter(e -> e.getId() == 10).findFirst().get();


    List<Seat> seatList = seatService.getAllSeats().stream().filter(e -> e.getId() < 6).collect(Collectors.toList());

    Booking booking = new Booking(99, customer, show, seatList, "2020-9-18");
    bookingService.createBooking(booking);

  }
}
