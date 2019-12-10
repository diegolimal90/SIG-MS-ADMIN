package br.com.sig.msadmin.entrypoint.entity;

import br.com.sig.msadmin.entrypoint.entity.UnidadeHttpModel.UnidadeHttpModelBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
