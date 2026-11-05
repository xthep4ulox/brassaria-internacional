package br.com.brassaria.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
@Entity @Table(name="eventos")
public class Evento {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false,length=120) private String titulo;
 @NotBlank @Column(nullable=false,columnDefinition="TEXT") private String descricao;
 @NotNull @Column(nullable=false) private LocalDate dataEvento;
 private String local;
 @Column(length=500) private String imagemUrl;
 public Evento() {}
 public Long getId(){return id;} public String getTitulo(){return titulo;} public void setTitulo(String v){titulo=v;}
 public String getDescricao(){return descricao;} public void setDescricao(String v){descricao=v;}
 public LocalDate getDataEvento(){return dataEvento;} public void setDataEvento(LocalDate v){dataEvento=v;}
 public String getLocal(){return local;} public void setLocal(String v){local=v;}
 public String getImagemUrl(){return imagemUrl;} public void setImagemUrl(String v){imagemUrl=v;}
}