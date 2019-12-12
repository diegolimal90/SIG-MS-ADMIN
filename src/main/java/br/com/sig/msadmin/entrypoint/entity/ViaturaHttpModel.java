package br.com.sig.msadmin.entrypoint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaturaHttpModel{
    
    private long id;

    private int ano;
    
    private String placa;
    private String fabricante;
    
    private int quilometragem_atual;
    private int quilometragem_inicial;
}