package br.com.sig.msadmin.entrypoint.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@JsonProperty("tipo_logradouro")
	private String tpLogradouro;
	@JsonProperty("nome_logradouro")
	private String nmLogradouro;
	@JsonProperty("complemento")
	private String dsComplemento;
	@JsonProperty("cep")
	private Integer nrCep;
	@JsonProperty("numero")
	private String dsNumero;
	private String bairro;
	private String cidade;
	private String estado;
	
}
