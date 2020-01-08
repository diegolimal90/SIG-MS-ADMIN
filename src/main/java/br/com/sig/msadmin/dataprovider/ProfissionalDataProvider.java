package br.com.sig.msadmin.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.gateway.ProfissionalGateway;
import br.com.sig.msadmin.dataprovider.entity.ProfissionalTable;
import br.com.sig.msadmin.dataprovider.mapper.ProfissionalTableMapper;
import br.com.sig.msadmin.dataprovider.repository.ProfissionalRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@Component
public class ProfissionalDataProvider implements ProfissionalGateway{
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public ProfissionalEntity cadastrarProfissional(ProfissionalEntity entity) {
		try {
			ProfissionalTable table = ProfissionalTableMapper.from(entity);

			table = profissionalRepository.save(table);
			entity = ProfissionalTableMapper.to(table);

			return entity;
		} catch (Exception e) {
			throw new DataBaseException("Falha na persistência do cadastro profissional");
		}
	}

}
