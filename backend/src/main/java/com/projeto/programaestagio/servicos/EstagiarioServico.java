package com.projeto.programaestagio.servicos;

import com.projeto.programaestagio.modelo.Estagiario;
import com.projeto.programaestagio.repositorio.EstagiarioRepositorio;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class EstagiarioServico {

    @Autowired
    EstagiarioRepositorio repoositorio;

    
    public Estagiario saveEstagiarioToDB(String nome, String email, String telefone, MultipartFile file, MultipartFile file2,
            List<String> areaInteresse, List<String> areaDominio) {
       
        
        Estagiario estagiario = new Estagiario();
       
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
        
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            estagiario.setFoto(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (fileName2.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            estagiario.setComprovanteMatricula(Base64.getEncoder().encodeToString(file2.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        estagiario.setNome(nome);
        estagiario.setEmail(email);
        estagiario.setTelefone(telefone);
        estagiario.setAreasInteresse(areaInteresse);
        estagiario.setAreasDominio(areaDominio);

       return repoositorio.save(estagiario);
    }
    
    
    public Estagiario editaEstagiarioToDB(Long id,String nome, String email, String telefone, MultipartFile file, MultipartFile file2,
            List<String> areaInteresse, List<String> areaDominio) {
       
        
         
        Estagiario estagiario = busca(id);
        
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
        
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            estagiario.setFoto(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (fileName2.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            estagiario.setComprovanteMatricula(Base64.getEncoder().encodeToString(file2.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
      
        estagiario.setNome(nome);
        estagiario.setEmail(email);
        estagiario.setTelefone(telefone);
        estagiario.setAreasInteresse(areaInteresse);
        estagiario.setAreasDominio(areaDominio);

       return repoositorio.save(estagiario);
        
        
       

    }
    
    
   
    public List<Estagiario> listagem() {

        return repoositorio.findAll();

    }
    
    
    public void excluir(Long id){
        
       repoositorio.deleteById(id);
        
    }
    
    
    public Estagiario busca(Long id){
        
         return repoositorio.findById(id).orElseThrow();
    }
   
    

}
