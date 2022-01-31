package com.greaziel.adocao.repositorys;

import com.greaziel.adocao.domains.Donatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonatarioRepository extends JpaRepository<Donatario, Integer> {
}
