package br.com.sig.msadmin.entrypoint.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.entrypoint.entity.ProfissionalHttpModel;

public class ProfissionalHttpModelMapper {

	public static ProfissionalEntity to(ProfissionalHttpModel httpModel) {
		return Optional.ofNullable(httpModel).map(e -> ProfissionalEntity.builder()
				.id(e.getId())
				.nmProfissional(e.getNmProfissional())
				.tpLogradouro(e.getTpLogradouro())
				.dsEndereço(e.getDsEndereço())
				.dsNumero(e.getDsNumero())
				.dsComplemento(e.getDsComplemento())
				.nrCep(e.getNrCep())
				.nmBairro(e.getNmBairro())
				.nmEstado(e.getNmEstado())
				.nmCidade(e.getNmCidade())
				.nmPais(e.getNmPais())
				.dtNasc(e.getDtNasc())
				.nrRg(e.getNrRg())
				.nrCpf(e.getNrCpf())
				.tpSanguineo(e.getTpSanguineo())
				.nrTelefone(e.getNrTelefone())
				.dsEmail(e.getDsEmail())
				.dsObs(e.getDsObs())
		        .build())
		        .orElse(new ProfissionalEntity());
	}

	public static ProfissionalHttpModel from(ProfissionalEntity entity) {
		return Optional.ofNullable(entity).map(e -> ProfissionalHttpModel.builder()
				.id(e.getId())
				.nmProfissional(e.getNmProfissional())
				.tpLogradouro(e.getTpLogradouro())
				.dsEndereço(e.getDsEndereço())
				.dsNumero(e.getDsNumero())
				.dsComplemento(e.getDsComplemento())
				.nrCep(e.getNrCep())
				.nmBairro(e.getNmBairro())
				.nmEstado(e.getNmEstado())
				.nmCidade(e.getNmCidade())
				.nmPais(e.getNmPais())
				.dtNasc(e.getDtNasc())
				.nrRg(e.getNrRg())
				.nrCpf(e.getNrCpf())
				.tpSanguineo(e.getTpSanguineo())
				.nrTelefone(e.getNrTelefone())
				.dsEmail(e.getDsEmail())
				.dsObs(e.getDsObs())
		        .build())
		        .orElse(new ProfissionalHttpModel());
	}

}
