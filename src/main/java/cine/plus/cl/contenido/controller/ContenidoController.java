package cine.plus.cl.contenido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import cine.plus.cl.contenido.model.Contenido;
import cine.plus.cl.contenido.service.ContenidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;





@RestController
@RequestMapping("/api/Contenido")
@Tag(name = "Contenido", description = "Gestionar los Tipos de Contenidos.")

public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    @Operation(summary = "Obtiene los contenidos", description = "Obtiene una lista de Los Contenidos Disponibles.")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "202", description = "OK, Operacion exitosa."),
    @ApiResponse(responseCode = "404", description = "Contenido no encontrado")
    })
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
    @Operation(summary = "Obtener todas los Contenidos", description = "Obtiene una lista de todos los Contendidos Con ID.")
    @ApiResponse(responseCode = "202", description = "Contenido encontrado, Operación exitosa")
    @Parameter(description = "ID del contenido", required = true) 
    


    public ResponseEntity<Contenido> buscar(@PathVariable Long id) {
        
        Contenido contenido = contenidoService.fetchById(id);
        // estado 202 ok.
        return ResponseEntity.ok(contenido);
        
    }
    
    @PostMapping
    @Operation(summary = "Guarda el contenido", description ="Guarda un nuevo contenido en el sistema y devuelve el contenido creado con su ID")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Contenido a crear", required = true, content = @Content(schema = @Schema(implementation = Contenido.class)))


    
    public ResponseEntity<Contenido> guardar(@RequestBody Contenido contenido) { 
        Contenido contenidoNuevo = contenidoService.save(contenido);
        return ResponseEntity.status(HttpStatus.CREATED).body(contenidoNuevo);
        
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar el Contenido", description = "Actualiza un contenido existente basado en el ID proporcionado y devuelve el contenido actualizado")
    @Parameter(description = "ID del contenido", required = true) 
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Contenido a actualizar", required = true, content = @Content(schema = @Schema(implementation = Contenido.class)))
    
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
        @Operation(summary = "Eliminar Contenido", description = "Elimina un contenido existente del sistema utilizando su ID")
        @Parameter(description = "ID del contenido", required = true) 

        public ResponseEntity<?> eliminar(@PathVariable Long id){
            contenidoService.delete(id);

            return ResponseEntity.noContent().build();


    }

}
