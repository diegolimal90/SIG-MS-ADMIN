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

    private long id;

    private int ano;
    
    private String placa;
    private String fabricante;
    
    private int quilometragem_atual;
    private int quilometragem_inicial;
     
}