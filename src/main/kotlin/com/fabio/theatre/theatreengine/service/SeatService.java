package com.fabio.theatre.theatreengine.service;

import com.fabio.theatre.theatreengine.database.entity.Booking;
import com.fabio.theatre.theatreengine.database.entity.Seat;
import com.fabio.theatre.theatreengine.database.entity.Show;
import com.fabio.theatre.theatreengine.database.entity.Venue;
import com.fabio.theatre.theatreengine.database.repository.BookingRepository;
import com.fabio.theatre.theatreengine.database.repository.SeatRepository;
import com.fabio.theatre.theatreengine.database.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.SearchControls;
import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowRepository showRepository;

    public List<Seat> getAllSeats() {
     return seatRepository.findAll();
    }


    public boolean checkSeatAvailability(Integer seatId, Integer showId, LocalDate date) {
        Seat seatRequested = seatRepository.findById(seatId).get();

//        return bookingRepository.findAll()
//                .stream()
//                .filter(booking -> booking.getShow().getId() == showId)
//                .filter(booking -> booking.getShow().getShow_date().equals(date))
//                .filter(booking -> booking.getSeat().contains(seatRequested))
//                .collect(Collectors.toList())
//                .isEmpty();

        List<Booking> bookingList = bookingRepository.findAll();
        List<Booking> filteredBooking = new ArrayList<>();

        bookingList.forEach(booking -> {
            if (booking.getShow().getId() == showId) {
                filteredBooking.add(booking);}
        });

        List<Booking> bookingWithShowAndSeat = new ArrayList<>();

        filteredBooking.forEach(booking -> {
            List<Seat> seatsForThisBooking = booking.getSeat();
            if (!seatsForThisBooking.contains(seatRequested)) {
                bookingWithShowAndSeat.add(booking);
            }
        });

        if (bookingWithShowAndSeat.isEmpty()) {
            return true;
        }
        List<Booking> finalList = new ArrayList<>();
        Show myShow = showRepository.findById(showId).get();

        bookingWithShowAndSeat.forEach(booking -> {
            if (!booking.getShow().getShow_date().equals(date)) {
                finalList.add(booking);
            }
        });

        return finalList.isEmpty();
    }
    public Seat getSeatById(Integer id) {
        return seatRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void deleteById(Integer id) {
        Optional<Seat> seat = seatRepository.findById(id);
        if (seat.isPresent()) {
            seatRepository.deleteById(id);
        }
    }
    public Seat updateSeat (Seat seat) {
        seatRepository.save(seat);
        return seat;
    }
    public Seat saveSeat (Seat seat) {
        seatRepository.save(seat);
        return seat;
    }

}
