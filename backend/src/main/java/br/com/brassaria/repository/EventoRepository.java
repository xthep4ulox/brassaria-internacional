package br.com.brassaria.repository;
import br.com.brassaria.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EventoRepository extends JpaRepository<Evento,Long> {
 List<Evento> findTop3ByOrderByDataEventoDesc();
 List<Evento> findAllByOrderByDataEventoDesc();
}