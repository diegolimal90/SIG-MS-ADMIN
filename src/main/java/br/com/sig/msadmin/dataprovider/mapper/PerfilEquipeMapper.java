package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.dataprovider.entity.PerfilEquipeTable;

public class PerfilEquipeMapper {
	
	public static PerfilEquipeEntity to(PerfilEquipeTable table) {
		return Optional.ofNullable(table).map(e -> PerfilEquipeEntity.builder()
				.id(e.getId())
				.nome(e.getNome())
				.sigla(e.getSigla())
				.qtProfissionais(e.getQtProfissionais())
				.descricaoEquipamentos(e.getDescricaoEquipamentos())
				.profissionaisId(e.getProfissionaisId())
				.veiculoId(e.getVeiculoId())
				.qtEquipamento(e.getQtEquipamento())
				.dataCadastro(e.getDataCadastro())
				//.dataAlteracao(e.getDataAlteracao())
				//.dataDesativacao(e.getDataDesativacao())
				.idCadastro(e.getIdCadastro())
				//.idAlteracao(e.getIdAlteracao())
				//.idDesativacao(e.getIdDesativacao())
		        .build())
		        .orElse(new PerfilEquipeEntity());
	}
	
	public static PerfilEquipeTable from(PerfilEquipeEntity entity) {
		return Optional.ofNullable(entity).map(e -> PerfilEquipeTable.builder()
				.id(e.getId())
				.nome(e.getNome())
				.sigla(e.getSigla())
				.qtProfissionais(e.getQtProfissionais())
				.descricaoEquipamentos(e.getDescricaoEquipamentos())
				.profissionaisId(e.getProfissionaisId())
				.veiculoId(e.getVeiculoId())
				.qtEquipamento(e.getQtEquipamento())
				.dataCadastro(e.getDataCadastro())
				//.dataAlteracao(e.getDataAlteracao())
				//.dataDesativacao(e.getDataDesativacao())
				.idCadastro(e.getIdCadastro())
				//.idAlteracao(e.getIdAlteracao())
				//.idDesativacao(e.getIdDesativacao())
				.build())
                .orElse(new PerfilEquipeTable());
	}

}
