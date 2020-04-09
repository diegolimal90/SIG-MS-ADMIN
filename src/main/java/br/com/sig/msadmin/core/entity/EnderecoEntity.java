package br.com.sig.msadmin.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {

	private Long id;
	
	private TipoLogradouroEntity tpLogradouro;
	private String nmLogradouro;
	private String dsNumero;
	
	private BairroEntity bairro;
	private String dsComplemento;
	private String nrCep;	
	
}