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
public class UnidadeEntity {

	private Long id;
	
	private String tipo;
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
	private String referencia;
	private Integer status;
	
	private Date dataCadastro;
	private Date dataAlteracao;
	private Date dataDesativacao;
	private Long idCadastro;
	private Long idAlteracao;
	private Long idDesativacao;
}