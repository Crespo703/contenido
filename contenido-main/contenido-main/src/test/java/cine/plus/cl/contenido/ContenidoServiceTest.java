package cine.plus.cl.contenido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import cine.plus.cl.contenido.model.Contenido;
import cine.plus.cl.contenido.repository.ContenidoRepository;
import cine.plus.cl.contenido.service.ContenidoService;


public class ContenidoServiceTest {
    
    @Autowired
    private ContenidoService contenenidoService;
    // se debe crear un mock del repositorio de contenido para simular su campo
    @MockBean
    private ContenidoRepository contenidoRepository;

    @Test
    public void testFindAll() {
        // se define el comportamiento del mock : cuando se llama a findall(), devuelve una lista con peliculas de ficcion
        when(contenidoRepository.findAll()).thenReturn(List.of(new Contenido(null, "1","ficcion", null, false, null, null)));
        
        // llama al metodo findAll() del servicio
        List<Contenido> contenido = contenenidoService.fetchAll();

        // verifica que la lista devuelta no sea nula y contenga exactamente un tipo de  pelicula.
        assertNotNull(contenido);
        assertEquals(contenido, contenido.size());
    
    }

}


