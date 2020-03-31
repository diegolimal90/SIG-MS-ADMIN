package br.com.sig.msadmin.entrypoint.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.BairroEntity;
import br.com.sig.msadmin.core.entity.CidadeEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.EstadoEntity;
import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.entity.TipoLogradouroEntity;
import br.com.sig.msadmin.entrypoint.entity.EnderecoHttpModel;
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
				.endereco(toEndereco(e))
		        .build())
		        .orElse(new ProfissionalHttpModel());
	}

	private static EnderecoHttpModel toEndereco(ProfissionalEntity entity) {
		return Optional.ofNullable(entity).map(e -> EnderecoHttpModel.builder()
				.tpLogradouro(e.getEndereco().getTpLogradouro().getNmTpLogradouro())
				.nmLogradouro(e.getEndereco().getNmLogradouro())
				.dsComplemento(e.getEndereco().getDsComplemento())
				.nrCep(e.getEndereco().getNrCep())
				.bairro(e.getEndereco().getBairro().getNmBairro())
				.cidade(e.getEndereco().getBairro().getCidade().getNmCidade())
				.estado(e.getEndereco().getBairro().getCidade().getEstado().getNmEstado())
				.build())
				.orElse(EnderecoHttpModel.builder().build());
	}
	
	private static EnderecoEntity fromEndereco(ProfissionalHttpModel httpModel) {
		return Optional.ofNullable(httpModel).map(e -> EnderecoEntity.builder()
				.tpLogradouro(TipoLogradouroEntity.builder()
						.nmTpLogradouro(e.getEndereco()
								.getTpLogradouro())
						.build())
				.nrCep(e.getEndereco().getNrCep())
				.dsComplemento(e.getEndereco().getDsComplemento())
				.nmLogradouro(e.getEndereco().getNmLogradouro())
				.dsNumero(e.getEndereco().getDsNumero())
				.bairro(BairroEntity.builder()
						.nmBairro(e.getEndereco()
								.getBairro())
						.cidade(CidadeEntity.builder()
								.nmCidade(e.getEndereco()
										.getCidade())
								.estado(EstadoEntity.builder()
										.nmEstado(e.getEndereco()
												.getEstado())
										.build())
								.build())
						.build())
				.build())
		        .orElse(EnderecoEntity.builder()
		        		.tpLogradouro(new TipoLogradouroEntity())
		        		.bairro(BairroEntity.builder()
		        				.cidade(CidadeEntity.builder()
										.estado(EstadoEntity.builder()
										.build())
								.build())
						.build())
        		.build());
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
				.endereco(fromEndereco(e))
		        .build())
		        .orElse(new ProfissionalEntity());
	}
}