package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.dataprovider.entity.ProfissionalTable;

public class ProfissionalTableMapper {

	public static ProfissionalTable from(ProfissionalEntity entity) {
		return Optional.ofNullable(entity).map(profissional -> ProfissionalTable.builder()
				.id(profissional.getId())
				.nmProfissional(profissional.getNmProfissional())
				.dsMatricula(profissional.getDsMatricula())
				.endereco(EnderecoTableMapper.to(profissional.getEndereco()))
				.tpProfissional(TipoProfissionalTableMapper.to(profissional.getTpProfissional()))
				.dtNasc(profissional.getDtNasc())
				.nrRg(profissional.getNrRg())
				.nrCpf(profissional.getNrCpf())
				.tpSanguineo(profissional.getTpSanguineo())
				.nrTelefone(profissional.getNrTelefone())
				.dsEmail(profissional.getDsEmail())
				.dsObs(profissional.getDsObs())
		        .build())
		        .orElse(new ProfissionalTable());
	}

	
	public static ProfissionalEntity to(ProfissionalTable table) {
		return Optional.ofNullable(table).map(profissional -> ProfissionalEntity.builder()
				.id(profissional.getId())
				.nmProfissional(profissional.getNmProfissional())
				.dsMatricula(profissional.getDsMatricula())
				.endereco(EnderecoTableMapper.from(profissional.getEndereco()))
				.tpProfissional(TipoProfissionalTableMapper.from(profissional.getTpProfissional()))
				.dtNasc(profissional.getDtNasc())
				.nrRg(profissional.getNrRg())
				.nrCpf(profissional.getNrCpf())
				.tpSanguineo(profissional.getTpSanguineo())
				.nrTelefone(profissional.getNrTelefone())
				.dsEmail(profissional.getDsEmail())
				.dsObs(profissional.getDsObs())
		        .build())
		        .orElse(new ProfissionalEntity());
	}
	
}