package com.projeto.programaestagio.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Estagiario implements Serializable {

   
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do usuario e obrigatorio")
    private String nome;

    @Email
    @Size(max = 60)
    private String email;

    @NotBlank(message = "O numero do telefone e obrigatorio")
    @Size(max = 20)
    private String telefone;

    @Lob
    @Column(name="FOTO",length=Integer.MAX_VALUE,nullable= true)
    private String foto;

    @Lob
    @Column(name = "Comprovante",length=Integer.MAX_VALUE,nullable= true)
    private String comprovanteMatricula;

   
    
    @Fetch(FetchMode.SUBSELECT)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="INTERESSE")
    @Column(name = "area_interesse")
    private List<String> areasInteresse = new ArrayList<>();

    
    
    @Fetch(FetchMode.SUBSELECT)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="DOMINIO")
    @Column(name = "area_dominio")
    private List<String> areasDominio = new ArrayList<>();

    
    
    
    public Estagiario(Long id, String nome, String email, String telefone, String foto, String comprovanteMatricula) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.foto = foto;
        this.comprovanteMatricula = comprovanteMatricula;
    }

    
    

    public Estagiario() {
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getComprovanteMatricula() {
        return comprovanteMatricula;
    }

    public void setComprovanteMatricula(String comprovanteMatricula) {
        this.comprovanteMatricula = comprovanteMatricula;
    }

    public List<String> getAreasInteresse() {
        return areasInteresse;
    }

    public void setAreasInteresse(List<String> areasInteresse) {
        this.areasInteresse = areasInteresse;
    }

    public List<String> getAreasDominio() {
        return areasDominio;
    }

    public void setAreasDominio(List<String> areasDominio) {
        this.areasDominio = areasDominio;
    }

       

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estagiario other = (Estagiario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
