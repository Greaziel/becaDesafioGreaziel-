package com.greaziel.adocao.repositorys;

import com.greaziel.adocao.domains.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdocaoRepository extends JpaRepository<Adocao, Integer> {
}
