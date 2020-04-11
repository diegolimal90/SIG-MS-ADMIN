package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.TelefoneEntity;
import br.com.sig.msadmin.dataprovider.entity.TelefoneTable;

public class TelefoneTableMapper {
    public static TelefoneTable to(TelefoneEntity entity) {
        return Optional.ofNullable(entity).map(telefoneEntity -> 
            TelefoneTable.builder()
                .telefone(telefoneEntity.getTelefone())
            .build())
            .orElse(TelefoneTable.builder().build());
    }

    public static TelefoneEntity from(TelefoneTable table) {
        return Optional.ofNullable(table).map(telefoneTable -> 
            TelefoneEntity.builder()
                .telefone(telefoneTable.getTelefone())
            .build())
            .orElse(TelefoneEntity.builder().build());
    }
}