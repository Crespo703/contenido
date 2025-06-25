package cine.plus.cl.contenido.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.*;

import cine.plus.cl.contenido.assemblers.ContenidoModelAssembler;
import cine.plus.cl.contenido.model.Contenido;
import cine.plus.cl.contenido.service.ContenidoService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/contenido")
public class ContenidoControllerV2 {

    @Autowired
    private ContenidoService contenidoService;

    @Autowired
    private ContenidoModelAssembler assembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Contenido>> getAllContenido() {
        List<EntityModel<Contenido>> contenidos = contenidoService.fetchAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(contenidos,
            linkTo(methodOn(ContenidoControllerV2.class).getAllContenido()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Contenido> getById(@PathVariable Long id) {
        Contenido contenido = contenidoService.fetchById(id);
        return assembler.toModel(contenido);
    }

    @GetMapping("/tipo/{tipo}")
    public CollectionModel<EntityModel<Contenido>> getByTipo(@PathVariable String tipo) {
        List<EntityModel<Contenido>> contenidos = contenidoService.findByTipo(tipo).stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(contenidos,
            linkTo(methodOn(ContenidoControllerV2.class).getByTipo(tipo)).withSelfRel());
    }

    @GetMapping("/estado/{estado}")
    public CollectionModel<EntityModel<Contenido>> getByEstado(@PathVariable boolean estado) {
        List<EntityModel<Contenido>> contenidos = contenidoService.findByEstado(estado).stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(contenidos,
            linkTo(methodOn(ContenidoControllerV2.class).getByEstado(estado)).withSelfRel());
    }

    @GetMapping("/idioma/{idioma}")
    public CollectionModel<EntityModel<Contenido>> getByIdioma(@PathVariable String idioma) {
        List<EntityModel<Contenido>> contenidos = contenidoService.findByIdioma(idioma).stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(contenidos,
            linkTo(methodOn(ContenidoControllerV2.class).getByIdioma(idioma)).withSelfRel());
    }

    @GetMapping("/categoria/{categoria}")
    public CollectionModel<EntityModel<Contenido>> getByCategoria(@PathVariable String categoria) {
        List<EntityModel<Contenido>> contenidos = contenidoService.findByCategoria(categoria).stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

        return CollectionModel.of(contenidos,
            linkTo(methodOn(ContenidoControllerV2.class).getByCategoria(categoria)).withSelfRel());

    }

    @GetMapping("/estado/{estado}/idioma/{idioma}")
    public CollectionModel<EntityModel<Contenido>> getByEstadoAndIdioma(@PathVariable boolean estado, @PathVariable String idioma) {
        List<EntityModel<Contenido>> contenidos = contenidoService.findByEstadoAndIdioma(estado, idioma).stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

        return CollectionModel.of(contenidos,
            linkTo(methodOn(ContenidoControllerV2.class).getByEstadoAndIdioma(estado, idioma)).withSelfRel());
    }

    
}
