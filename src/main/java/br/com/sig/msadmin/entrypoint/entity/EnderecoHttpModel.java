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
	
	private String tpLogradouro;
	private String nmLogradouro;
	private String dsComplemento;
	private String nrCep;	
	private String dsNumero;
	private String bairro;
	private String cidade;
	private String estado;
	
}
