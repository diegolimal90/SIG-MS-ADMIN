package br.com.sig.msadmin.dataprovider;

import javax.naming.ServiceUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.gateway.ProfissionalGateway;
import br.com.sig.msadmin.dataprovider.entity.ProfissionalTable;
import br.com.sig.msadmin.dataprovider.mapper.ProfissionalTableMapper;
import br.com.sig.msadmin.dataprovider.repository.ProfissionalRepository;

@Component
public class CadastrarProfissionalDataProvider implements ProfissionalGateway{
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Override
	public ProfissionalEntity cadastrarProfissional(ProfissionalEntity entity) throws ServiceUnavailableException {		
		try {
			ProfissionalTable table = ProfissionalTableMapper.to(entity);
			
			table = profissionalRepository.save(table);
			
			return ProfissionalTableMapper.from(table);
		} catch (Exception e) {
			throw new ServiceUnavailableException("Falha na persistencia do profissional");
		}
	}
}
