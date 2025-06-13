package cine.plus.cl.contenido.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        List<EntityModel<Contenido>> contenidos = contenidoService.fetchAll().stream().map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(contenidos, linkTo(methodOn(ContenidoControllerV2.class).getAllContenido()).withSelfRel());
    }
}
