package br.com.brassaria.repository;
import br.com.brassaria.entity.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BebidaRepository extends JpaRepository<Bebida,Long> {}