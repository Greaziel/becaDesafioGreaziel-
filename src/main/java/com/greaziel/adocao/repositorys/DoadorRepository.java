package com.greaziel.adocao.repositorys;

import com.greaziel.adocao.domains.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Integer> {
}
