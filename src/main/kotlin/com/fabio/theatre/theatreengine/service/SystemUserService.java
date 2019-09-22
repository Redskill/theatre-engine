package com.fabio.theatre.theatreengine.service;

import com.fabio.theatre.theatreengine.database.entity.SystemUser;
import com.fabio.theatre.theatreengine.database.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemUserService {

  @Autowired
  private SystemUserRepository repository;

  public boolean checkAuth(SystemUser systemUser) {
    Optional<SystemUser> user = repository.findById(systemUser.getEmail());
    return user.map(value -> value.getPassword().equals(systemUser.getPassword())).orElse(false);
  }
}
