package br.com.sig.msadmin.entrypoint.mapper;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.entrypoint.entity.ViaturaHttpModel;

public class ViaturaHttpModelMapper{
    public static ViaturaEntity to(ViaturaHttpModel httpModel){
        return ViaturaEntity.builder()
                .id(httpModel.getId())
                .ano(httpModel.getAno())
                .placa(httpModel.getPlaca())
                .fabricante(httpModel.getFabricante())
                .quilometragem_atual(httpModel.getQuilometragem_atual())
                .quilometragem_inicial(httpModel.getQuilometragem_inicial())
                .build();
    }

    public static ViaturaHttpModel from(ViaturaEntity entity){
        return ViaturaHttpModel.builder()
                .id(entity.getId())
                .ano(entity.getAno())
                .placa(entity.getPlaca())
                .fabricante(entity.getFabricante())
                .quilometragem_atual(entity.getQuilometragem_atual())
                .quilometragem_inicial(entity.getQuilometragem_inicial())
                .build();
    }
}