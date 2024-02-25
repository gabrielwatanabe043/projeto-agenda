package com.desafio.agenda.repositories;

import com.desafio.agenda.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContatoRepository extends JpaRepository<Contato, UUID> {
}
