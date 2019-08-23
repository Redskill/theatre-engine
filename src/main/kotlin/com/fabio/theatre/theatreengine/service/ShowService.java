package com.fabio.theatre.theatreengine.service;
import com.fabio.theatre.theatreengine.database.entity.Show;
import com.fabio.theatre.theatreengine.database.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getAllshows() {
        List<Show> list =  showRepository.findAll();
        Show theLionKing = list.get(0);
        Show wicked = list.get(1);
        Show cirqueDuSoleil = list.get(2);
        Show lesMiserables = list.get(3);
        List<Show> newList = new ArrayList<>();
        newList.add(theLionKing);
        newList.add(wicked);
        newList.add(cirqueDuSoleil);
        newList.add(lesMiserables);
        return newList;

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

}
