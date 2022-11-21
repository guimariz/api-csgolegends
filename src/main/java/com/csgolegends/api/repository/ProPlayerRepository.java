package com.csgolegends.api.repository;


import com.csgolegends.api.model.ProPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProPlayerRepository extends JpaRepository<ProPlayer, Integer> {
}
