package br.com.sig.msadmin.entrypoint.mapper;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.entrypoint.entity.UnidadeHttpModel;

public class UnidadeHttpModelMapper {

	public static UnidadeEntity to(UnidadeHttpModel httpModel) {
		return UnidadeEntity.builder()
				.id(httpModel.getId())
				.build();
	}

	public static UnidadeHttpModel from(UnidadeEntity entity) {
		return UnidadeHttpModel.builder()
				.id(entity.getId())
				.build();
	}
}
