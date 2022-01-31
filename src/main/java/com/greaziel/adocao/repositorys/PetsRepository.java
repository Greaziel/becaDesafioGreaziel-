package com.greaziel.adocao.repositorys;

import com.greaziel.adocao.domains.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends JpaRepository<Pets, Integer> {
}
