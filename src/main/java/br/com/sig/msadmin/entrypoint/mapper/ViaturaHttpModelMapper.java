package br.com.sig.msadmin.entrypoint.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.entrypoint.entity.ViaturaHttpModel;

public class ViaturaHttpModelMapper{
    public static ViaturaEntity to(ViaturaHttpModel httpModel){
        return Optional.ofNullable(httpModel).map(e -> ViaturaEntity.builder()
                .id_viatura(e.getId_viatura())
                .dt_cadastro_viatura(e.getDt_cadastro_viatura())
                .cd_identificacao_viatura(e.getCd_identificacao_viatura())
                .cd_placa_viatura(e.getCd_placa_viatura())
                .ano_viatura(e.getAno_viatura())
                .ds_fabricante(e.getDs_fabricante())
                .dt_km_inicial(e.getDt_km_inicial())
                .nr_km_inicial(e.getNr_km_inicial())
                .dt_km_final(e.getDt_km_final())
                .nr_km_final(e.getNr_km_final())
                .ds_viatura(e.getDs_viatura())
                .ds_observacao(e.getDs_observacao())
                                
              //  id_usuario_gravacao:varchar
          
                .dt_gravacao_viatura(e.getDt_gravacao_viatura())
                .dt_alt_viatura(e.getDt_alt_viatura())
                
              //  seg_id_usuario:number
            
                .build())
                .orElse(new ViaturaEntity());
    }

    public static ViaturaHttpModel from(ViaturaEntity entity){
        return Optional.ofNullable(entity).map(e -> ViaturaHttpModel.builder()
         
        		  .id_viatura(e.getId_viatura())
                  .dt_cadastro_viatura(e.getDt_cadastro_viatura())
                  .cd_identificacao_viatura(e.getCd_identificacao_viatura())
                  .cd_placa_viatura(e.getCd_placa_viatura())
                  .ano_viatura(e.getAno_viatura())
                  .ds_fabricante(e.getDs_fabricante())
                  .dt_km_inicial(e.getDt_km_inicial())
                  .nr_km_inicial(e.getNr_km_inicial())
                  .dt_km_final(e.getDt_km_final())
                  .nr_km_final(e.getNr_km_final())
                  .ds_viatura(e.getDs_viatura())
                  .ds_observacao(e.getDs_observacao())
        		
                  //  id_usuario_gravacao:varchar
                  
                  .dt_gravacao_viatura(e.getDt_gravacao_viatura())
                  .dt_alt_viatura(e.getDt_alt_viatura())
                  
                //  seg_id_usuario:number
                .build())
                .orElse(new ViaturaHttpModel());
    }
}