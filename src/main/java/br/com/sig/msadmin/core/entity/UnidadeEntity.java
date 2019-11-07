package br.com.sig.msadmin.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeEntity {

	private Integer id;
	
	private Integer tipo;
	private String nome;
	private String cep;
	private String tipoLogradouro;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String regiao;
	private String bairro;
	private String cidade;
	private String estado;
	
}