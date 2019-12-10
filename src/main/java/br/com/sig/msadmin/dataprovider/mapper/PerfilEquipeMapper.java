package br.com.sig.msadmin.dataprovider.mapper;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.dataprovider.entity.PerfilEquipeTable;

public class PerfilEquipeMapper {
	
	public static PerfilEquipeEntity to(PerfilEquipeTable table) {
		return PerfilEquipeEntity.builder()
				.id(table.getId())
				.nome(table.getNome())
				.sigla(table.getSigla())
				.qtProfissionais(table.getQtProfissionais())
				.descricaoEquipamentos(table.getDescricaoEquipamentos())
				.profissionaisId(table.getProfissionaisId())
				.veiculoId(table.getVeiculoId())
				.qtEquipamento(table.getQtEquipamento())
				.build();
	}
	
	public static PerfilEquipeTable from(PerfilEquipeEntity entity) {
		return PerfilEquipeTable.builder()
				.id(entity.getId())
				.nome(entity.getNome())
				.sigla(entity.getSigla())
				.qtProfissionais(entity.getQtProfissionais())
				.descricaoEquipamentos(entity.getDescricaoEquipamentos())
				.profissionaisId(entity.getProfissionaisId())
				.veiculoId(entity.getVeiculoId())
				.qtEquipamento(entity.getQtEquipamento())
				.build();
	}

}
