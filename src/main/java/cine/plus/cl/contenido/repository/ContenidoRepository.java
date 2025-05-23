package cine.plus.cl.contenido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cine.plus.cl.contenido.model.Contenido;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {

}
