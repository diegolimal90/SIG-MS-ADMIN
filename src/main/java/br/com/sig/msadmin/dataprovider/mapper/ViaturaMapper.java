package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.dataprovider.entity.ViaturaTable;

public class ViaturaMapper{

    public static ViaturaEntity to(ViaturaTable table){
        return Optional.ofNullable(table).map(e -> ViaturaEntity.builder()
                .id(e.getId())
                .ano(e.getAno())
                .placa(e.getPlaca())
                .fabricante(e.getFabricante())
                .quilometragem_atual(e.getQuilometragem_atual())
                .quilometragem_inicial(e.getQuilometragem_inicial())
                .dataCadastro(e.getDataCadastro())
                .dataAlteracao(e.getDataAlteracao())
                .dataDesativacao(e.getDataDesativacao())
                .idCadastro(e.getIdCadastro())
                .idAlteracao(e.getIdAlteracao())
                .idDesativacao(e.getIdDesativacao())
                .build())
                .orElse(new ViaturaEntity());
    }

    public static ViaturaTable from(ViaturaEntity entity){
        return Optional.ofNullable(entity).map(e -> ViaturaTable.builder()
                .id(e.getId())
                .ano(e.getAno())
                .placa(e.getPlaca())
                .fabricante(e.getFabricante())
                .quilometragem_atual(e.getQuilometragem_atual())
                .quilometragem_inicial(e.getQuilometragem_inicial())
                .dataCadastro(e.getDataCadastro())
                .dataAlteracao(e.getDataAlteracao())
                .dataDesativacao(e.getDataDesativacao())
                .idCadastro(e.getIdCadastro())
                .idAlteracao(e.getIdAlteracao())
                .idDesativacao(e.getIdDesativacao())
                .build())
                .orElse(new ViaturaTable());
    }
}