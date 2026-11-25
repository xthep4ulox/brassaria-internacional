package br.com.brassaria.service;
import br.com.brassaria.entity.Bebida;
import br.com.brassaria.repository.BebidaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BebidaService {
 private final BebidaRepository repo;
 public BebidaService(BebidaRepository repo){this.repo=repo;}
 public List<Bebida> listar(){return repo.findAll();}
 public Bebida salvar(Bebida b){return repo.save(b);}
}