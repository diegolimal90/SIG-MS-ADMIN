package br.com.sig.msadmin.core.entity;

import java.util.Date;

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
    
    private Date dataCadastro;
	private Date dataAlteracao;
	private Date dataDesativacao;
	private Long idCadastro;
	private Long idAlteracao;
	private Long idDesativacao;
     
}