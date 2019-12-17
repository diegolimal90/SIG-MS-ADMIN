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
				.idCadastro(httpModel.getIdCadastro())
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
				.idCadastro(entity.getIdCadastro())
				.build())
				.orElse(new PerfilEquipeHttpModel());
	}

}
