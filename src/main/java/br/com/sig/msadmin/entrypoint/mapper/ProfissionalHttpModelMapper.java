package br.com.sig.msadmin.entrypoint.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.entrypoint.entity.ProfissionalHttpModel;

public class ProfissionalHttpModelMapper {

	public static ProfissionalHttpModel from(ProfissionalEntity entity) {
		return Optional.ofNullable(entity).map(e -> ProfissionalHttpModel.builder()
				.id(e.getId())
				.nmProfissional(e.getNmProfissional())
				.dsMatricula(e.getDsMatricula())
				.dtNasc(e.getDtNasc())
				.nrRg(e.getNrRg())
				.nrCpf(e.getNrCpf())
				.tpSanguineo(e.getTpSanguineo())
				.nrTelefone(e.getNrTelefone())
				.dsEmail(e.getDsEmail())
				.dsObs(e.getDsObs())
				.endereco(EnderecoHttpModelMapper.to(e.getEndereco()))
				.tpProfissional(TipoProfissionalHttpModelMapper.to(e.getTpProfissional()))
		        .build())
		        .orElse(new ProfissionalHttpModel());
	}
	
	public static ProfissionalEntity to(ProfissionalHttpModel httpModel) {
		return Optional.ofNullable(httpModel).map(e -> ProfissionalEntity.builder()
				.id(e.getId())
				.nmProfissional(e.getNmProfissional())
				.dsMatricula(e.getDsMatricula())
				.dtNasc(e.getDtNasc())
				.nrRg(e.getNrRg())
				.nrCpf(e.getNrCpf())
				.tpSanguineo(e.getTpSanguineo())
				.nrTelefone(e.getNrTelefone())
				.dsEmail(e.getDsEmail())
				.dsObs(e.getDsObs())
				.endereco(EnderecoHttpModelMapper.from(e.getEndereco()))
				.tpProfissional(TipoProfissionalHttpModelMapper.from(e.getTpProfissional()))
		        .build())
		        .orElse(new ProfissionalEntity());
	}
}