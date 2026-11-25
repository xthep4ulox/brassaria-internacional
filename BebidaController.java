package br.com.brassaria.controller;
import br.com.brassaria.entity.Bebida;
import br.com.brassaria.service.BebidaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/bebidas")
public class BebidaController {
 private final BebidaService service;
 public BebidaController(BebidaService service){this.service=service;}
 @GetMapping public List<Bebida> listar(){return service.listar();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Bebida criar(@Valid @RequestBody Bebida b){return service.salvar(b);}
}