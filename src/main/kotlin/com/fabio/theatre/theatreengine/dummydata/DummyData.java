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
  @PostConstruct
  private void init() {
    Venue vasquez = new Venue(99, "Vasquez", "Camden town");
    venueService.saveVenue(vasquez);


    Customer customer = customerService.getCustomerById(3);
    Seat seat4 = seatService.getSeatById(4);
    Seat seat7 = seatService.getSeatById(7);
    Show show9 = showService.getShowById(9);
    List<Seat> seatList = new ArrayList<>();
    seatList.add(seat4);
    seatList.add(seat7);

    Booking booking = new Booking(99, customer, show9, seatList);
    bookingService.createBooking(booking);

    log.info("Booking Saved ==============================");
  }
}
