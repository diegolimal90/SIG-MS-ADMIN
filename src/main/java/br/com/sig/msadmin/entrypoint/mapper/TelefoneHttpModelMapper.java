package br.com.sig.msadmin.entrypoint.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.TelefoneEntity;
import br.com.sig.msadmin.entrypoint.entity.TelefoneHttpModel;

public class TelefoneHttpModelMapper {
    public static TelefoneHttpModel to(TelefoneEntity entity) {
        return Optional.ofNullable(entity).map(telefoneEntity -> 
        TelefoneHttpModel.builder()
            .telefone(telefoneEntity.getTelefone())
        .build())
        .orElse(TelefoneHttpModel.builder().build());
    }

    public static TelefoneEntity from(TelefoneHttpModel httpModel) {
        return Optional.ofNullable(httpModel).map(telefoneHttpModel -> 
        TelefoneEntity.builder()
            .telefone(telefoneHttpModel.getTelefone())
        .build())
        .orElse(TelefoneEntity.builder().build());
    }
}