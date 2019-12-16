package br.com.sig.msadmin.entrypoint.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.entrypoint.entity.PerfilEquipeHttpModel;

public class PerfilEquipeHttpModelMapper {
	
	public static PerfilEquipeEntity to(PerfilEquipeHttpModel httpModel) {
		
		return Optional.ofNullable(httpModel).map(e -> PerfilEquipeEntity.builder()
				.id(httpModel.getId())
				.nome(httpModel.getNome())
				.sigla(httpModel.getSigla())
				.qtProfissionais(httpModel.getQtProfissionais())
				.descricaoEquipamentos(httpModel.getDescricaoEquipamentos())
				.profissionaisId(httpModel.getProfissionaisId())
				.veiculoId(httpModel.getVeiculoId())
				.qtEquipamento(httpModel.getQtProfissionais())
				.dataCadastro(httpModel.getDataCadastro())
				.dataAlteracao(httpModel.getDataAlteracao())
				.dataDesativacao(httpModel.getDataDesativacao())
				.idCadastro(httpModel.getIdCadastro())
				.idAlteracao(httpModel.getIdAlteracao())
				.idDesativacao(httpModel.getIdDesativacao())
				.build())
				.orElse(new PerfilEquipeEntity());
	}
	
	public static PerfilEquipeHttpModel from(PerfilEquipeEntity entity) {
		return Optional.ofNullable(entity).map(e -> PerfilEquipeHttpModel.builder()
				.id(entity.getId())
				.nome(entity.getNome())
				.sigla(entity.getSigla())
				.qtProfissionais(entity.getQtProfissionais())
				.descricaoEquipamentos(entity.getDescricaoEquipamentos())
				.profissionaisId(entity.getProfissionaisId())
				.veiculoId(entity.getVeiculoId())
				.qtEquipamento(entity.getQtProfissionais())
				.dataCadastro(entity.getDataCadastro())
				.dataAlteracao(entity.getDataAlteracao())
				.dataDesativacao(entity.getDataDesativacao())
				.idCadastro(entity.getIdCadastro())
				.idAlteracao(entity.getIdAlteracao())
				.idDesativacao(entity.getIdDesativacao())
				.build())
				.orElse(new PerfilEquipeHttpModel());
	}

}
