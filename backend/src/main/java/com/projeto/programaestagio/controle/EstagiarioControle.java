package com.projeto.programaestagio.controle;

import com.projeto.programaestagio.modelo.Estagiario;
import com.projeto.programaestagio.repositorio.EstagiarioRepositorio;
import com.projeto.programaestagio.servicos.EstagiarioServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@Api(value = "Api Rest Estagiarios")
@CrossOrigin(origins = "*")
public class EstagiarioControle {


    @Autowired
    EstagiarioServico estagiarioServico;

  
    @PostMapping("/estagiario")
    @ApiOperation(value = "Este metodo salva um estagiario")
    public Estagiario salvarEstagiario(@Valid
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("telefone") String telefone,
            @RequestParam("file") MultipartFile file,
            @RequestParam("file2") MultipartFile file2,
            @RequestParam("interesse") List<String> interesse,
            @RequestParam("dominio") List<String> dominio) throws IOException {

        return estagiarioServico.saveEstagiarioToDB(nome, email, telefone, file, file2, interesse, dominio);

    }


    @GetMapping("/estagiarios")
    @ApiOperation(value = "Este metodo lista os estagiarios")
    public List<Estagiario> lista() {

        return estagiarioServico.listagem();

    }

    @PutMapping("/estagiario/{id}")
    @ApiOperation(value = "Este metodo edita um estagiario")
    public Estagiario atualizaEstagiario(@Valid
            @PathVariable("id") Long id,
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("telefone") String telefone,
            @RequestParam("file") MultipartFile file,
            @RequestParam("file2") MultipartFile file2,
            @RequestParam("interesse") List<String> interesse,
            @RequestParam("dominio") List<String> dominio) {

        return estagiarioServico.editaEstagiarioToDB(id,nome, email, telefone, file, file2, interesse, dominio);
    }

    
    
    
    @DeleteMapping("/estagiario/{id}")
    @ApiOperation(value = "Este metodo exclui um estagiario")
    public void deletarEstagiario(@PathVariable("id") Long id) {

        estagiarioServico.excluir(id);

    }

    
    @GetMapping("/estagiario/{id}")
    @ApiOperation(value = "Este metodo busca um estagiario")
     public Estagiario buscarEstagiario(@PathVariable("id") Long id) {

         return estagiarioServico.busca(id);

    }
    
}
