package cine.plus.cl.contenido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import cine.plus.cl.contenido.model.Contenido;
import cine.plus.cl.contenido.service.ContenidoService;





@RestController
@RequestMapping("/api/Contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public ResponseEntity<List<Contenido>> listar() {
        List<Contenido> contenido = contenidoService.fetchAll();

        if (contenido.isEmpty()) {
            // error 404 no encontrado.
            return ResponseEntity.notFound().build();

        }
        // estado 202 ok.
        return ResponseEntity.ok(contenido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> buscar(@PathVariable Long id) {
        
        Contenido contenido = contenidoService.fetchById(id);
        // estado 202 ok.
        return ResponseEntity.ok(contenido);
        
    }
    
    @PostMapping
    public ResponseEntity<Contenido> guardar(@RequestBody Contenido contenido) { 
        Contenido contenidoNuevo = contenidoService.save(contenido);
        return ResponseEntity.status(HttpStatus.CREATED).body(contenidoNuevo);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contenido> actualizar(
        @PathVariable Long id,
        @RequestBody Contenido contenido
    ) {
        // obtener el contenido x el id
        Contenido cont = contenidoService.fetchById(id);

        //modificamos los campos del objeto.
        // en base a lo entregado por el parametro body.
        cont.setId(id.intValue());
        cont.setTitulo(contenido.getTitulo());
        cont.setTipo(contenido.getTipo());
        cont.setCategoria(contenido.getCategoria());
        cont.setEstado(contenido.isEstado());
        cont.setIdioma(contenido.getIdioma());
        cont.setUrlstreaming(contenido.getUrlstreaming());

        // guardamos los cambios del objeto de la base de datos.
        contenidoService.save(cont);

        // resputas http ok con el objeto modificado.
        return ResponseEntity.ok(cont);
    }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> eliminar(@PathVariable Long id){
            contenidoService.delete(id);

            return ResponseEntity.noContent().build();


    }

}
