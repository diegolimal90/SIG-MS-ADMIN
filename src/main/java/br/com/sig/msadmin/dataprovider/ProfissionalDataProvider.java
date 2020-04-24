package br.com.sig.msadmin.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.gateway.ProfissionalGateway;
import br.com.sig.msadmin.dataprovider.entity.EspecialidadeProfissionalTable;
import br.com.sig.msadmin.dataprovider.entity.ProfissionalTable;
import br.com.sig.msadmin.dataprovider.entity.TipoProfissionalTable;
import br.com.sig.msadmin.dataprovider.mapper.ProfissionalTableMapper;
import br.com.sig.msadmin.dataprovider.repository.EspecialidadeProfissionalRepository;
import br.com.sig.msadmin.dataprovider.repository.ProfissionalRepository;
import br.com.sig.msadmin.dataprovider.repository.TipoProfissionalRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@Component
public class ProfissionalDataProvider implements ProfissionalGateway{
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	@Autowired
	private TipoProfissionalRepository tipoProfissionalRepository;
	@Autowired
	private EspecialidadeProfissionalRepository especialidadeProfissionalRepository;
	
	public ProfissionalEntity cadastrarProfissional(ProfissionalEntity entity) {
		try {
			ProfissionalTable profissional = ProfissionalTableMapper.from(entity);
			
			TipoProfissionalTable tipo = profissional.getTpProfissional();
			EspecialidadeProfissionalTable especialidade = tipo.getEspecialidade();
	
			especialidade = especialidadeProfissionalRepository.save(especialidade);
			tipo = tipoProfissionalRepository.save(tipo);
			profissional = profissionalRepository.save(profissional);
			
			entity = ProfissionalTableMapper.to(profissional);

			return entity;
		} catch (Exception e) {
			throw new DataBaseException("Falha na persistência do cadastro profissional");
		}
	}

}
