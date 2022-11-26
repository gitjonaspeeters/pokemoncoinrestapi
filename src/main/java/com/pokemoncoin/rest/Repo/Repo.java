package com.pokemoncoin.rest.Repo;

import com.pokemoncoin.rest.Model.pokemoncoin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<pokemoncoin, Long> {

}

