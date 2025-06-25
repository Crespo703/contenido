package cine.plus.cl.contenido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cine.plus.cl.contenido.model.Contenido;
import cine.plus.cl.contenido.repository.ContenidoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class ContenidoService {
    
    @Autowired
    private ContenidoRepository contenidoRepository;

    // fetchall es que traera todos los datos.
    public List<Contenido> fetchAll() {

        return contenidoRepository.findAll();
    };

    public Contenido fetchById(Long id) {
        
        return contenidoRepository.findById(id).get();

    };

    public Contenido save(Contenido contenido) {
        
        return contenidoRepository.save(contenido);
    };

    public void delete(Long id) {
       contenidoRepository.deleteById(id);
    };

    public List<Contenido> findByTipo(String tipo) {
        return contenidoRepository.findByTipo(tipo);
    };

    public List<Contenido> findByEstado(boolean estado) {
        return contenidoRepository.findByEstado(estado);
    };

    public List<Contenido> findByIdioma(String idioma) {
        return contenidoRepository.findByIdioma(idioma);
    };

    public List<Contenido> findByCategoria(String categoria) {
        return contenidoRepository.findByCategoria(categoria);
    };

    public List<Contenido> findByEstadoAndIdioma(boolean estado, String idioma) {
        return contenidoRepository.findByEstadoAndIdioma(estado, idioma);
    
    }

}
