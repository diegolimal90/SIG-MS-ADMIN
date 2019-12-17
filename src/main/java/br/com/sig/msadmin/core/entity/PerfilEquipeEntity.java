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
public class PerfilEquipeEntity {
	
	private Long id;
	private String nome;
	private String sigla; 
	private Long veiculoId;
	private Long profissionaisId;
	private Integer qtProfissionais;
	private String descricaoEquipamentos;
	private Integer qtEquipamento;
	private Date dataCadastro;
	private Long idCadastro;
}
