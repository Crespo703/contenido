package cine.plus.cl.contenido.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import cine.plus.cl.contenido.model.Contenido;
import cine.plus.cl.contenido.controller.ContenidoControllerV2;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ContenidoModelAssembler implements RepresentationModelAssembler<Contenido, EntityModel<Contenido>> {
    @Override
    public EntityModel<Contenido> toModel(Contenido contenido) {
        return EntityModel.of(contenido,
            linkTo(methodOn(ContenidoControllerV2.class).getById(Long.valueOf(contenido.getId()))).withSelfRel(),
            linkTo(methodOn(ContenidoControllerV2.class).getAllContenido()).withRel("todos-los-contenidos"));
    }
}
