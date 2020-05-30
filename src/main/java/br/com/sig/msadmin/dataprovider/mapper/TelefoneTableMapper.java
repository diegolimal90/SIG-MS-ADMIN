package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.entity.TelefoneEntity;
import br.com.sig.msadmin.dataprovider.entity.ClienteTable;
import br.com.sig.msadmin.dataprovider.entity.TelefoneTable;

public class TelefoneTableMapper {
    public static TelefoneTable to(TelefoneEntity entity) {
        return Optional.ofNullable(entity).map(telefoneEntity -> 
            TelefoneTable.builder()
                .telefone(telefoneEntity.getTelefone())
                // .cliente(ClienteTable.builder()
                //         .id(telefoneEntity.getCliente().getId())
                //     .build())
            .build())
            .orElse(TelefoneTable.builder().build());
    }

    public static TelefoneEntity from(TelefoneTable table) {
        return Optional.ofNullable(table).map(telefoneTable -> 
            TelefoneEntity.builder()
                .telefone(telefoneTable.getTelefone())
                // .cliente(ClienteEntity.builder()
                //         .id(telefoneTable.getCliente().getId())
                //     .build())
            .build())
            .orElse(TelefoneEntity.builder().build());
    }
}