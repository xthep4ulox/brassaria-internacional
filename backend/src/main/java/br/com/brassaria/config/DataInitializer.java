package br.com.brassaria.config;
import br.com.brassaria.entity.*;
import br.com.brassaria.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import java.time.LocalDate;
@Configuration
public class DataInitializer {
 @Bean CommandLineRunner seed(BebidaRepository bebidas,EventoRepository eventos){return args->{
 if(bebidas.count()==0){Bebida a=new Bebida();a.setNome("Brassaria Pilsen");a.setCategoria("Cerveja");a.setDescricao("Leve, refrescante e equilibrada.");bebidas.save(a);
 Bebida b=new Bebida();b.setNome("Brassaria IPA");b.setCategoria("Cerveja");b.setDescricao("Aroma cítrico e amargor marcante.");bebidas.save(b);
 Bebida c=new Bebida();c.setNome("Brassaria Zero");c.setCategoria("Sem álcool");c.setDescricao("Opção sem álcool para diferentes ocasiões.");bebidas.save(c);}
 if(eventos.count()==0){for(int i=0;i<3;i++){Evento e=new Evento();e.setTitulo(new String[]{"Encontro Brassaria","Festival de Sabores","Brassaria de Portas Abertas"}[i]);e.setDescricao("Evento institucional de demonstração e relacionamento com convidados.");e.setDataEvento(LocalDate.now().minusDays(18-8*i));e.setLocal("São Paulo - SP");eventos.save(e);}}
 };}
}