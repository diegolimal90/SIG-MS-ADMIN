package br.com.sig.msadmin.dataprovider.mapper;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.dataprovider.entity.UnidadeTable;

public class UnidadeTableMapper {

	public static UnidadeEntity to(UnidadeTable table) {
		return UnidadeEntity.builder()
				.id(table.getId())
				.build();

	}
	
	public static UnidadeTable from(UnidadeEntity entity) {
		return UnidadeTable.builder()
				.id(entity.getId())
				.build();

	}
}
