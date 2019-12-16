package br.com.sig.msadmin.entrypoint.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeHttpModel {
	
	private Long id;
	
	private String tipo;
	private String nome;
	private String cep;
	
	@JsonProperty("tipo_logradouro")
	private String tipoLogradouro;
	
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String regiao;
	private String bairro;
	private String cidade;
	private String estado;
	private String referencia;
	private Integer status;
	
	@JsonProperty("data_cadastro")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataCadastro;
	
	@JsonProperty("usuario_cadastro")
	private Long idCadastro;
	
}
