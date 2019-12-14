package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.dataprovider.entity.ViaturaTable;

public class ViaturaMapper{

    public static ViaturaEntity to(ViaturaTable table){
        return Optional.ofNullable(table).map(e -> ViaturaEntity.builder()
                .id(table.getId())
                .ano(table.getAno())
                .placa(table.getPlaca())
                .fabricante(table.getFabricante())
                .quilometragem_atual(table.getQuilometragem_atual())
                .quilometragem_inicial(table.getQuilometragem_inicial())
                .build())
                .orElse(new ViaturaEntity());
    }

    public static ViaturaTable from(ViaturaEntity entity){
        return Optional.ofNullable(entity).map(e -> ViaturaTable.builder()
                .id(entity.getId())
                .ano(entity.getAno())
                .placa(entity.getPlaca())
                .fabricante(entity.getFabricante())
                .quilometragem_atual(entity.getQuilometragem_atual())
                .quilometragem_inicial(entity.getQuilometragem_inicial())
                .build())
                .orElse(new ViaturaTable());
    }
}