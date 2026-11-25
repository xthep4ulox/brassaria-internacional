package br.com.brassaria.controller;
import br.com.brassaria.entity.Evento;
import br.com.brassaria.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/eventos")
public class EventoController {
 private final EventoService service;
 public EventoController(EventoService service){this.service=service;}
 @GetMapping public List<Evento> listar(){return service.listar();}
 @GetMapping("/recentes") public List<Evento> recentes(){return service.recentes();}
 @GetMapping("/{id}") public Evento buscar(@PathVariable Long id){return service.buscar(id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Evento criar(@Valid @RequestBody Evento e){return service.salvar(e);}
 @PutMapping("/{id}") public Evento atualizar(@PathVariable Long id,@Valid @RequestBody Evento e){return service.atualizar(id,e);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluir(@PathVariable Long id){service.excluir(id);}
}