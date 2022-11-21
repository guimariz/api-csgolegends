package com.csgolegends.api.repository;

import com.csgolegends.api.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PerfilsRepository extends JpaRepository<Perfil, Integer> {
}
