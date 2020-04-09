package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.EspecialidadeProfissionalEntity;
import br.com.sig.msadmin.core.entity.TipoProfissionalEntity;
import br.com.sig.msadmin.dataprovider.entity.EspecialidadeProfissionalTable;
import br.com.sig.msadmin.dataprovider.entity.TipoProfissionalTable;

public class TipoProfissionalTableMapper {

	public static TipoProfissionalTable to(TipoProfissionalEntity entity) {
		return Optional.ofNullable(entity).map(profissional -> TipoProfissionalTable.builder()
				.id(profissional.getId())
				.nmProfissao(profissional.getNmProfissao())
				.nrDocumento(profissional.getNrDocumento())
				.dtValidadeDocumento(profissional.getDtValidadeDocumento())
				.dsCategoriaCnh(profissional.getDsCategoriaCnh())
				.dsCursoObrigatorio(profissional.getDsCursoObrigatorio())
				.dtValidadeCurso(profissional.getDtValidadeCurso())
				.especialidade(EspecialidadeProfissionalTable.builder()
						.nomeEspecialidade(profissional.getDsEspecialidade()
								.getNomeEspecialidade())
						.build())
				.build())
				.orElse(TipoProfissionalTable.builder()
						.especialidade(EspecialidadeProfissionalTable.builder()
						.build())
				.build());
	}
	
	public static TipoProfissionalEntity from(TipoProfissionalTable table) {
		return Optional.ofNullable(table).map(profissional -> TipoProfissionalEntity.builder()
				.id(profissional.getId())
				.nmProfissao(profissional.getNmProfissao())
				.nrDocumento(profissional.getNrDocumento())
				.dtValidadeDocumento(profissional.getDtValidadeDocumento())
				.dsCategoriaCnh(profissional.getDsCategoriaCnh())
				.dsCursoObrigatorio(profissional.getDsCursoObrigatorio())
				.dtValidadeCurso(profissional.getDtValidadeCurso())
				.dsEspecialidade(EspecialidadeProfissionalEntity.builder()
						.nomeEspecialidade(profissional.getEspecialidade()
								.getNomeEspecialidade())
						.build())
				.build())
				.orElse(TipoProfissionalEntity.builder().build());
	}
}
