package br.com.sig.msadmin.dataprovider.entity;

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
	
	@Column(name="ic_tipo_unidade")
	private String tipo;
	
	@Column(name="nm_unidade")
	private String nome;
	
	@Column(name="cd_cep_unidade")
	private String cep;
	
	@Column(name="nm_tipo_logradouro_endereco")
	private String tipoLogradouro;
	
	@Column(name="nm_logradouro_unidade")
	private String logradouro;
	
	@Column(name="cd_numero_unidade")
	private Integer numero;
	
	@Column(name="ds_complemento_unidade")
	private String complemento;
	
	@Column(name="nm_regiao_unidade")
	private String regiao;
	
	@Column(name="nm_bairro_unidade")
	private String bairro;
	
	@Column(name="nm_cidade_unidade")
	private String cidade;
	
	@Column(name="sg_estado_unidade")
	private String estado;

	@Column(name="ds_referencia_unidade")
	private String referencia;
	
	@Column(name="nm_status_unidade")
	private String status;
}
