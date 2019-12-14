package br.com.sig.msadmin.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaturaEntity{

    private Long id;

    private Integer ano;
    
    private String placa;
    private String fabricante;
    
    private Integer quilometragem_atual;
    private Integer quilometragem_inicial;

    //TODO Adicionar dt_criacao, dt_alteracao, nm_de_alteracao
     
}