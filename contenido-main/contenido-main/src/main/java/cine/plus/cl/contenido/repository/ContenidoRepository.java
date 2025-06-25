package cine.plus.cl.contenido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cine.plus.cl.contenido.model.Contenido;
import java.util.List;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
    List<Contenido> findByTipo(String tipo);
    List<Contenido> findByEstado(boolean estado);
    List<Contenido> findByIdioma(String idioma);
    List<Contenido> findByCategoria(String categoria);
    List<Contenido> findByEstadoAndIdioma(boolean estado, String idioma);


}

