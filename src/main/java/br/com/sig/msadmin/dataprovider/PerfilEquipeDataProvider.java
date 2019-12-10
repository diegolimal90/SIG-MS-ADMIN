package br.com.sig.msadmin.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.core.gateway.PerfilEquipeGateway;
import br.com.sig.msadmin.dataprovider.entity.PerfilEquipeTable;
import br.com.sig.msadmin.dataprovider.mapper.PerfilEquipeMapper;
import br.com.sig.msadmin.dataprovider.repository.PerfilEquipeRepository;
import br.com.sig.msadmin.exception.PerfilEquipeException;

@Component
public class PerfilEquipeDataProvider implements PerfilEquipeGateway{
	
	@Autowired
	private PerfilEquipeRepository perfilRepository;
	
	@Override
	public PerfilEquipeEntity salvarPerfil(PerfilEquipeEntity entity) throws RuntimeException{
			
		try {
			PerfilEquipeTable table = PerfilEquipeMapper.from(entity);
			
			table = perfilRepository.save(table);
			entity = PerfilEquipeMapper.to(table);
			
			return entity;
			
			}catch(RuntimeException e) {
				throw new RuntimeException("Falha na persistencia do pesquisar perfil de equipe");
			}
	}
	
	@Override
	public List<PerfilEquipeEntity> pesquisarPerfil(){
		List<PerfilEquipeEntity> listEntity = new ArrayList<>();
		List<PerfilEquipeTable> listTable = new ArrayList<>();
		
		try {
			listTable = perfilRepository.findAll();
			
			for(PerfilEquipeTable table: listTable) {
				PerfilEquipeEntity entity = PerfilEquipeMapper.to(table);
				listEntity.add(entity);
			}
			
			return listEntity;
			
		}catch(RuntimeException e) {
			throw new RuntimeException("Falha na persistencia do pesquisar perfil de equipe");
		}
	}

}
