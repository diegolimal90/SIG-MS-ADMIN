package br.com.sig.msadmin.entrypoint.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.EspecialidadeProfissionalEntity;
import br.com.sig.msadmin.core.entity.TipoProfissionalEntity;
import br.com.sig.msadmin.entrypoint.entity.TipoProfissionalHttpModel;

public class TipoProfissionalHttpModelMapper {

	public static TipoProfissionalHttpModel to(TipoProfissionalEntity entity) {
		return Optional.ofNullable(entity).map(profissional -> TipoProfissionalHttpModel.builder()
				.nmProfissao(profissional.getNmProfissao())
				.nrDocumento(profissional.getNrDocumento())
				.dtValidadeDocumento(profissional.getDtValidadeDocumento())
				.dsCategoriaCnh(profissional.getDsCategoriaCnh())
				.dsCursoObrigatorio(profissional.getDsCursoObrigatorio())
				.dtValidadeCurso(profissional.getDtValidadeCurso())
				.dsEspecialidade(profissional.getDsEspecialidade().getNomeEspecialidade())
				.build())
				.orElse(TipoProfissionalHttpModel.builder().build());
	}
	
	public static TipoProfissionalEntity from(TipoProfissionalHttpModel httpModel) {
		return Optional.ofNullable(httpModel).map(profissional -> TipoProfissionalEntity.builder()
				.nmProfissao(profissional.getNmProfissao())
				.nrDocumento(profissional.getNrDocumento())
				.dtValidadeDocumento(profissional.getDtValidadeDocumento())
				.dsCategoriaCnh(profissional.getDsCategoriaCnh())
				.dsCursoObrigatorio(profissional.getDsCursoObrigatorio())
				.dtValidadeCurso(profissional.getDtValidadeCurso())
				.dsEspecialidade(EspecialidadeProfissionalEntity.builder()
						.nomeEspecialidade(profissional.getDsEspecialidade())
						.build())
				.build())
				.orElse(TipoProfissionalEntity.builder().build());
	}
}
