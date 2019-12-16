package br.com.sig.msadmin.dataprovider;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public PerfilEquipeEntity salvarPerfil(PerfilEquipeEntity entity) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataCadastro = new Date();
			
			entity.setDataCadastro(sdf.parse(sdf.format(dataCadastro)));
			
			PerfilEquipeTable table = PerfilEquipeMapper.from(entity);

			table = perfilRepository.save(table);
			entity = PerfilEquipeMapper.to(table);

			return entity;
		//TODO toda exceção que você nao sabe que pode ocorrer vc deve usar o Exception(exeção generica)
		} catch (Exception e) {
			//TODO utilizar lançamento de exceção DataBaseException que se encontra no pacote de exception
			throw new DataBaseException("Falha na persistencia do cadastrar perfil de equipe");
		}
	}

	@Override
	public List<PerfilEquipeEntity> pesquisarPerfil() {
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
