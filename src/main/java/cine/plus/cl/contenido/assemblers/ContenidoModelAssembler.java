package cine.plus.cl.contenido.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cine.plus.cl.contenido.model.Contenido;

@Component
public class ContenidoModelAssembler implements RepresentationModelAssembler<Contenido, EntityModel<Contenido>> {
    @Override
    public EntityModel<Contenido> toModel(Contenido contenido) {
        return EntityModel.of(contenido);
    }
}
