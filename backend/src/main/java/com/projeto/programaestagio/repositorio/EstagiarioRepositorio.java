
package com.projeto.programaestagio.repositorio;

import com.projeto.programaestagio.modelo.Estagiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstagiarioRepositorio extends JpaRepository<Estagiario,Long> {
    
}
