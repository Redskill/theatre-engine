package com.fabio.theatre.theatreengine.service;

import com.fabio.theatre.theatreengine.database.entity.Show;
import com.fabio.theatre.theatreengine.database.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getAllshows() {
        return showRepository.findAll();
    }
    public Show getShowById(Integer id) {
        return showRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    public void deleteShowById(Integer id){
        Optional<Show> show = showRepository.findById(id);
        if (show.isPresent()){
            showRepository.deleteById(id);
        }
    }
    public Show updateShow(Show show){
        showRepository.save(show);
        return show;
    }
    public Show saveShow(Show show){
        showRepository.save(show);
        return show;
    }

    public List<Show> findShowByVenueId(Integer id) {
        return showRepository.findByVenueId(id);
    }

    public List<Show> findShowByVenueIdAndGenre(Integer id, String genre) {
        return showRepository.findByVenueIdAndGenre(id, genre);
    }

    public void deleteShow(Integer id) {
        showRepository.deleteById(id);
    }

}
