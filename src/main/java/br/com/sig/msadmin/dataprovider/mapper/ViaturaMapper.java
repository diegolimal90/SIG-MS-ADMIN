package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Date;
import java.util.Optional;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.dataprovider.entity.ViaturaTable;

public class ViaturaMapper{

    public static ViaturaEntity to(ViaturaTable table){
        return Optional.ofNullable(table).map(e -> ViaturaEntity.builder()
                .id_viatura(e.getId())
                .dt_cadastro_viatura(e.getDataCadastro())
                .cd_identificacao_viatura(e.getIdentificacao())
                .cd_placa_viatura(e.getPlaca())
                .ano_viatura(e.getAno())
                .ds_fabricante(e.getFabricante())
                .dt_km_inicial(e.getDataQuilometragemInicial())
                .nr_km_inicial(e.getQuilometragemInicial())
                .dt_km_final(e.getDataQuilometragemFinal())
                .nr_km_final(e.getQuilometragemFinal())
                .ds_viatura(e.getDsViatura())
                .ds_observacao(e.getDsObservacao())
           //   .usuario_gravacao(e.getUsuarioGravacao())
                .dt_gravacao_viatura(e.getDataGravacao())
                .dt_alt_viatura(e.getDataAlteracao())
           // .seg_id_usuario(e.idUsuario())
            /*    .dataDesativacao(e.getDataDesativacao())
                .idCadastro(e.getIdCadastro())
                .idAlteracao(e.getIdAlteracao())
                .idDesativacao(e.getIdDesativacao())
              */                 
                         
                .build())
                .orElse(new ViaturaEntity());
    }

    public static ViaturaTable from(ViaturaEntity entity){
        return Optional.ofNullable(entity).map(e -> ViaturaTable.builder()
                .id(e.getId_viatura())
                .dataCadastro(e.getDt_cadastro_viatura())
                .identificacao(e.getCd_identificacao_viatura())
                .placa(e.getCd_placa_viatura())
                .ano(e.getAno_viatura())
                .fabricante(e.getDs_fabricante())
                .dataQuilometragemInicial(e.getDt_km_inicial())
                .quilometragemInicial(e.getNr_km_inicial())
                .dataQuilometragemFinal(e.getDt_km_final())
                .quilometragemFinal(e.getNr_km_final())
                .dsViatura(e.getDs_viatura())
                .dsObservacao(e.getDs_observacao())
             //   .usuarioGravacao(e.getId_usuario_gravacao())
                .dataGravacao(e.getDt_gravacao_viatura())
                .dataAlteracao(e.getDt_alt_viatura())
               // .idUsuario(e.se_id_usuario())
              /*  .dataDesativacao(e.getDataDesativacao())
                .idCadastro(e.getIdCadastro())
                .idAlteracao(e.getIdAlteracao())
                .idDesativacao(e.getIdDesativacao())
                     */                 		
                .build())
                .orElse(new ViaturaTable());
    }
}