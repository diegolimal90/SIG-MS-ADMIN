package br.com.sig.msadmin.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.core.gateway.UnidadeGateway;
import br.com.sig.msadmin.dataprovider.entity.UnidadeTable;
import br.com.sig.msadmin.dataprovider.mapper.UnidadeTableMapper;
import br.com.sig.msadmin.dataprovider.repository.UnidadeRepository;

@Component
public class CadastrarUnidadeDataProvider implements UnidadeGateway{
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Override
	public UnidadeEntity salvarUnidade(UnidadeEntity entity) throws RuntimeException{		
		try {
			UnidadeTable table = UnidadeTableMapper.from(entity);
			
			table = unidadeRepository.save(table);
			entity = UnidadeTableMapper.to(table);
			
			return entity;
		} catch (RuntimeException e) {
			throw new RuntimeException("Falha na persistencia do profissional");
		}
	}
}
