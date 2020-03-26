package br.com.sig.msadmin.entrypoint.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.BairroEntity;
import br.com.sig.msadmin.core.entity.CidadeEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.EstadoEntity;
import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.entity.TipoLogradouroEntity;
import br.com.sig.msadmin.entrypoint.entity.BairroHttpModel;
import br.com.sig.msadmin.entrypoint.entity.CidadeHttpModel;
import br.com.sig.msadmin.entrypoint.entity.EnderecoHttpModel;
import br.com.sig.msadmin.entrypoint.entity.EstadoHttpModel;
import br.com.sig.msadmin.entrypoint.entity.ProfissionalHttpModel;
import br.com.sig.msadmin.entrypoint.entity.TipoLogradouroHttpModel;

public class ProfissionalHttpModelMapper {

	public static ProfissionalHttpModel from(ProfissionalEntity entity) {
		return Optional.ofNullable(entity).map(e -> ProfissionalHttpModel.builder()
				.id(e.getId())
				.nmProfissional(e.getNmProfissional())
				.dsMatricula(e.getDsMatricula())
				.endereco(fromEndereco(e))
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

	private static EnderecoHttpModel fromEndereco(ProfissionalEntity entity) {
		return Optional.ofNullable(entity).map(e -> EnderecoHttpModel.builder()
				.tpLogradouro(TipoLogradouroHttpModel.builder()
						.nmTpLogradouro(e.getEndereco()
								.getTpLogradouro()
								.getNmTpLogradouro())
						.build())
				.nrCep(e.getEndereco().getNrCep())
				.dsComplemento(e.getEndereco().getDsComplemento())
				.nmLogradouro(e.getEndereco().getNmLogradouro())
				.dsNumero(e.getEndereco().getDsNumero())
				.bairro(BairroHttpModel.builder()
						.nmBairro(e.getEndereco()
								.getBairro()
								.getNmBairro())
						.cidade(CidadeHttpModel.builder()
								.nmCidade(e.getEndereco()
										.getBairro()
										.getCidade()
										.getNmCidade())
								.estado(EstadoHttpModel.builder()
										.nmEstado(e.getEndereco()
												.getBairro()
												.getCidade()
												.getEstado()
												.getNmEstado())
										.build())
								.build())
						.build())
				.build())
		        .orElse(EnderecoHttpModel.builder()
		        		.tpLogradouro(new TipoLogradouroHttpModel())
		        		.bairro(BairroHttpModel.builder()
		        				.cidade(CidadeHttpModel.builder()
										.estado(new EstadoHttpModel())
										.build())
								.build())
		        		.build());
	}
	
	private static EnderecoEntity fromEndereco(ProfissionalHttpModel httpModel) {
		return Optional.ofNullable(httpModel).map(e -> EnderecoEntity.builder()
				.tpLogradouro(TipoLogradouroEntity.builder()
						.nmTpLogradouro(e.getEndereco()
								.getTpLogradouro()
								.getNmTpLogradouro())
						.build())
				.nrCep(e.getEndereco().getNrCep())
				.dsComplemento(e.getEndereco().getDsComplemento())
				.nmLogradouro(e.getEndereco().getNmLogradouro())
				.dsNumero(e.getEndereco().getDsNumero())
				.bairro(BairroEntity.builder()
						.nmBairro(e.getEndereco()
								.getBairro()
								.getNmBairro())
						.cidade(CidadeEntity.builder()
								.nmCidade(e.getEndereco()
										.getBairro()
										.getCidade()
										.getNmCidade())
								.estado(EstadoEntity.builder()
										.nmEstado(e.getEndereco()
												.getBairro()
												.getCidade()
												.getEstado()
												.getNmEstado())
										.build())
								.build())
						.build())
				.build())
		        .orElse(EnderecoEntity.builder()
		        		.tpLogradouro(new TipoLogradouroEntity())
		        		.bairro(BairroEntity.builder()
		        				.cidade(CidadeEntity.builder()
										.estado(new EstadoEntity())
										.build())
								.build())
		        		.build());
	}
	
	public static ProfissionalEntity to(ProfissionalHttpModel httpModel) {
		return Optional.ofNullable(httpModel).map(e -> ProfissionalEntity.builder()
				.id(e.getId())
				.nmProfissional(e.getNmProfissional())
				.dsMatricula(e.getDsMatricula())
				.endereco(fromEndereco(e))
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
}