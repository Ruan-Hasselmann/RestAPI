package com.ruan.RestApi.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruan.RestApi.Models.Zemo;

@Repository
public interface ZemoRepository extends JpaRepository<Zemo, Long>
{
	List<Zemo> findByTipo(String tipo);
}
