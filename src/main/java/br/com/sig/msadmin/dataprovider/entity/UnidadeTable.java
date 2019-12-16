package br.com.sig.msadmin.dataprovider.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UnidadeTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ic_tipo_unidade", length = 30)
	private String tipo;
	
	@Column(name="nm_unidade", length = 65)
	private String nome;
	
	@Column(name="cd_cep_unidade", length = 8)
	private String cep;
	
	@Column(name="nm_tipo_logradouro_endereco", length = 12)
	private String tipoLogradouro;
	
	@Column(name="nm_logradouro_unidade", length = 50)
	private String logradouro;
	
	@Column(name="cd_numero_unidade", length = 10)
	private Integer numero;
	
	@Column(name="ds_complemento_unidade", length = 50)
	private String complemento;
	
	@Column(name="nm_regiao_unidade", length = 30)
	private String regiao;
	
	@Column(name="nm_bairro_unidade", length = 30)
	private String bairro;
	
	@Column(name="nm_cidade_unidade", length = 50)
	private String cidade;
	
	@Column(name="sg_estado_unidade", length = 2)
	private String estado;

	@Column(name="ds_referencia_unidade", length = 200)
	private String referencia;
	
	@Column(name="cd_status_unidade", length = 1)
	private Integer status;
	
	@Column(name="dt_cadastro_unidade")
	private Date dataCadastro;
	
	@Column(name="dt_alteracao_unidade")
	private Date dataAlteracao;
	
	@Column(name="dt_desativacao_unidade")
	private Date dataDesativacao;
	
	@Column(name="cd_usuario_cadastro_unidade")
	private Long idCadastro;
	
	@Column(name="cd_usuario_alteracao_unidade")
	private Long idAlteracao;
	
	@Column(name="cd_usuario_desativacao_unidade")
	private Long idDesativacao;
}