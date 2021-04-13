package com.ruan.RestApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruan.RestApi.Models.Votos;

@Repository
public interface VotosRepository extends JpaRepository<Votos, Long> {

}
