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
public class PerfilEquipeTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nm_perfil_equipe", length = 65)
	private String nome;
	
	@Column(name="sg_perfil_equipe", length = 2)
	private String sigla;
	
	@Column(name="cd_profissionais")
	private Long profissionaisId;
	
	@Column(name="qt_profissionais")
	private Integer qtProfissionais;
	
	@Column(name="cd_veiculo")
	private Long veiculoId;
	
	@Column(name="ds_equipamentos", length = 100)
	private String descricaoEquipamentos;
		
	@Column(name="qt_equipamentos")
	private Integer qtEquipamento;
	
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
