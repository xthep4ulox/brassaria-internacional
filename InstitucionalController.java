package br.com.brassaria.controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/institucional")
public class InstitucionalController {
 @GetMapping public Map<String,String> conteudo(){return Map.of(
 "missao","Produzir bebidas com qualidade, responsabilidade e respeito às pessoas.",
 "visao","Ser reconhecida pela inovação, confiança e proximidade com os consumidores.",
 "valores","Qualidade, transparência, respeito, inovação e consumo responsável.");}
}