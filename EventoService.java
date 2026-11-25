package br.com.brassaria.service;
import br.com.brassaria.entity.Evento;
import br.com.brassaria.repository.EventoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EventoService {
 private final EventoRepository repo;
 public EventoService(EventoRepository repo){this.repo=repo;}
 public List<Evento> listar(){return repo.findAllByOrderByDataEventoDesc();}
 public List<Evento> recentes(){return repo.findTop3ByOrderByDataEventoDesc();}
 public Evento buscar(Long id){return repo.findById(id).orElseThrow(()->new IllegalArgumentException("Evento não encontrado"));}
 public Evento salvar(Evento e){return repo.save(e);}
 public Evento atualizar(Long id,Evento dados){Evento e=buscar(id);e.setTitulo(dados.getTitulo());e.setDescricao(dados.getDescricao());e.setDataEvento(dados.getDataEvento());e.setLocal(dados.getLocal());e.setImagemUrl(dados.getImagemUrl());return repo.save(e);}
 public void excluir(Long id){repo.delete(buscar(id));}
}