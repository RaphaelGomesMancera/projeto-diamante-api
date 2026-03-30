package br.com.fiap.projetodiamante.repository;

import br.com.fiap.projetodiamante.model.Dragon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DragonRepository extends JpaRepository<Dragon, Long> {
}
