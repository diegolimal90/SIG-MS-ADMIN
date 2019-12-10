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
public class PerfilEquipeTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nm_perfil_equipe")
	private String nome;
	
	@Column(name="sg_perfil_equipe")
	private String sigla;
	
	@Column(name="cd_profissionais")
	private Long profissionaisId;
	
	@Column(name="qt_profissionais")
	private Integer qtProfissionais;
	
	@Column(name="cd_veiculo")
	private Long veiculoId;
	
	@Column(name="ds_equipamentos")
	private String descricaoEquipamentos;
		
	@Column(name="qt_equipamentos")
	private Integer qtEquipamento;

}
