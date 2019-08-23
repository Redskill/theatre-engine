package com.fabio.theatre.theatreengine.service;

import com.fabio.theatre.theatreengine.database.entity.Show;
import com.fabio.theatre.theatreengine.database.entity.Venue;
import com.fabio.theatre.theatreengine.database.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public List<Venue> getAllVenues() {
        List<Venue> list = venueRepository.findAll();
        Venue oden = list.get(0);
        Venue vue = list.get(1);
        Venue cinestar = list.get(2);
        List<Venue> newList = new ArrayList<>();
        newList.add(oden);
        newList.add(vue);
        newList.add(cinestar);
        return newList;


    }
    public Venue getVenueById(Integer id) {
        return venueRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    public void deleteVenueById(Integer id){
        Optional<Venue> venue = venueRepository.findById(id);
        if (venue.isPresent()){
            venueRepository.deleteById(id);
        }
    }
    public Venue updateShow(Venue venue){
        venueRepository.save(venue);
        return venue;
    }
    public Venue saveShow(Venue venue){
        venueRepository.save(venue);
        return venue;
    }
}
