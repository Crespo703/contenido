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
    }

    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


}
