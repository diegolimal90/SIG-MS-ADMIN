package br.com.sig.msadmin.entrypoint.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.entrypoint.entity.ViaturaHttpModel;

public class ViaturaHttpModelMapper{
    public static ViaturaEntity to(ViaturaHttpModel httpModel){
        return Optional.ofNullable(httpModel).map(e -> ViaturaEntity.builder()
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

    public static ViaturaHttpModel from(ViaturaEntity entity){
        return Optional.ofNullable(entity).map(e -> ViaturaHttpModel.builder()
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
                .orElse(new ViaturaHttpModel());
    }
}