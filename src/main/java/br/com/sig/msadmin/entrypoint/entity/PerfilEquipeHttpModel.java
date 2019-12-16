package br.com.sig.msadmin.entrypoint.entity;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilEquipeHttpModel {
	

	private Long id;
	private String nome;
	private String sigla; 
	private Long veiculoId;
	private Long profissionaisId;
	private Integer qtProfissionais;
	private String descricaoEquipamentos;
	private Integer qtEquipamento;

	@JsonProperty("data_cadastro")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataCadastro;

	@JsonProperty("data_alteracao")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataAlteracao;

	@JsonProperty("data_desativacao")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataDesativacao;

	@JsonProperty("usuario_cadastro")
	private Long idCadastro;

	@JsonProperty("usuario_alteracao")
	private Long idAlteracao;

	@JsonProperty("usuario_desativacao")
	private Long idDesativacao;

}
