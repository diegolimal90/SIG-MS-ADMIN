package br.com.sig.msadmin.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.gateway.ClienteGateway;
import br.com.sig.msadmin.dataprovider.entity.ClienteTable;
import br.com.sig.msadmin.dataprovider.mapper.ClienteTableMapper;
import br.com.sig.msadmin.dataprovider.repository.ClienteRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@Component
public class ClienteDataProvider implements ClienteGateway{
	
	@Autowired
	private ClienteRepository ClienteRepository;
    
    @Override
	public ClienteEntity cadastrarCliente(ClienteEntity entity) {
		try {
			ClienteTable table = ClienteTableMapper.from(entity);

			table = ClienteRepository.save(table);
			entity = ClienteTableMapper.to(table);

			return entity;
		} catch (Exception e) {
			throw new DataBaseException("Falha na persistência do cadastro do cliente");
		}
	}

}