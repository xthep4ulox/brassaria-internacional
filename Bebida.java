package br.com.brassaria.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity @Table(name="bebidas")
public class Bebida {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false) private String nome;
 @NotBlank @Column(nullable=false) private String categoria;
 @Column(length=500) private String descricao;
 @Column(length=500) private String imagemUrl;
 public Bebida() {}
 public Long getId(){return id;} public String getNome(){return nome;} public void setNome(String v){nome=v;}
 public String getCategoria(){return categoria;} public void setCategoria(String v){categoria=v;}
 public String getDescricao(){return descricao;} public void setDescricao(String v){descricao=v;}
 public String getImagemUrl(){return imagemUrl;} public void setImagemUrl(String v){imagemUrl=v;}
}