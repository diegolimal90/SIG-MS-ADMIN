package br.com.sig.msadmin.entrypoint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoHttpModel {

	private Long id;
	
	private TipoLogradouroHttpModel tpLogradouro;
	private String nmLogradouro;
	private String dsNumero;
	
	private BairroHttpModel bairro;
	private String dsComplemento;
	private String nrCep;	
	
}
