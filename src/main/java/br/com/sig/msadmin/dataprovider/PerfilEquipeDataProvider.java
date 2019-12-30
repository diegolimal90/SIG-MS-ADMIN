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
import br.com.sig.msadmin.exception.DataBaseException;

@Component
public class PerfilEquipeDataProvider implements PerfilEquipeGateway {

	@Autowired
	private PerfilEquipeRepository perfilRepository;

	@Override
	public PerfilEquipeEntity cadastrarPerfilEquipe(PerfilEquipeEntity entity) {

		try {
			PerfilEquipeTable table = PerfilEquipeMapper.from(entity);

			table = perfilRepository.save(table);
			entity = PerfilEquipeMapper.to(table);

			return entity;
		} catch (Exception e) {
			throw new DataBaseException("Falha na persistencia do cadastrar perfil de equipe");
		}
	}

	@Override
	public List<PerfilEquipeEntity> pesquisarPerfilEquipe() {
		List<PerfilEquipeEntity> listEntity = new ArrayList<>();
		List<PerfilEquipeTable> listTable = new ArrayList<>();

		try {
			listTable = perfilRepository.findAll();

			for (PerfilEquipeTable table : listTable) {
				PerfilEquipeEntity entity = PerfilEquipeMapper.to(table);
				listEntity.add(entity);
			}

			return listEntity;

		} catch (Exception e) {
			throw new DataBaseException("Falha na persistencia do pesquisar perfil de equipe");
		}
	}

}
