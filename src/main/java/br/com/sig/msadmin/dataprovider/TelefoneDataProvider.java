package br.com.sig.msadmin.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.TelefoneEntity;
import br.com.sig.msadmin.core.gateway.TelefoneGateway;
import br.com.sig.msadmin.dataprovider.entity.TelefoneTable;
import br.com.sig.msadmin.dataprovider.mapper.TelefoneTableMapper;
import br.com.sig.msadmin.dataprovider.repository.TelefoneRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@Component
public class TelefoneDataProvider implements TelefoneGateway {

    @Autowired
	private TelefoneRepository telefoneRepository;

    @Override
	public TelefoneEntity cadastrarTelefone(TelefoneEntity entity) {
		try {

			TelefoneTable table = TelefoneTableMapper.to(entity);
			
            table = telefoneRepository.save(table);
			entity = TelefoneTableMapper.from(table);
		
			return entity;
		} catch (Exception e) {
			throw new DataBaseException("Falha na persistência do telefone");
		}						
			
	}
}