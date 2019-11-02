package br.com.sig.msadmin.dataprovider.mapper;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.dataprovider.entity.ProfissionalTable;

public class ProfissionalTableMapper {

	public static ProfissionalTable to(ProfissionalEntity entity) {
		return ProfissionalTable.builder()
				.id(entity.getId())
				.build();
	}

	public static ProfissionalEntity from(ProfissionalTable entity) {
		return ProfissionalEntity.builder()
				.id(entity.getId())
				.build();
	}
}
