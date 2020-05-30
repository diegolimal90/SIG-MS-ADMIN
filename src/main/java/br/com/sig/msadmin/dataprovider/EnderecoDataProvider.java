package br.com.sig.msadmin.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.gateway.EnderecoGateway;
import br.com.sig.msadmin.dataprovider.entity.BairroTable;
import br.com.sig.msadmin.dataprovider.entity.CidadeTable;
import br.com.sig.msadmin.dataprovider.entity.EnderecoTable;
import br.com.sig.msadmin.dataprovider.entity.EstadoTable;
import br.com.sig.msadmin.dataprovider.entity.TipoLogradouroTable;
import br.com.sig.msadmin.dataprovider.mapper.EnderecoTableMapper;
import br.com.sig.msadmin.dataprovider.repository.BairroRepository;
import br.com.sig.msadmin.dataprovider.repository.CidadeRepository;
import br.com.sig.msadmin.dataprovider.repository.EnderecoRepository;
import br.com.sig.msadmin.dataprovider.repository.EstadoRepository;
import br.com.sig.msadmin.dataprovider.repository.TipoLogradouroRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@Component
public class EnderecoDataProvider implements EnderecoGateway{

	@Autowired
	private TipoLogradouroRepository tipoLogradouroRepository;
	@Autowired
	private BairroRepository bairroRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public EnderecoEntity cadastrarEndereco(EnderecoEntity entity) {
		try {
			EnderecoTable table = EnderecoTableMapper.to(entity);

			TipoLogradouroTable logradouro = table.getTpLogradouro();
			BairroTable bairro = table.getBairro();
			CidadeTable cidade = bairro.getCidade();
			EstadoTable estado = cidade.getEstado(); 
			
			estado = estadoRepository.save(estado);
			cidade = cidadeRepository.save(cidade);
			bairro = bairroRepository.save(bairro);
			logradouro = tipoLogradouroRepository.save(logradouro);
			table = enderecoRepository.save(table);
			
			entity = EnderecoTableMapper.from(table);
		
			return entity;
		} catch (Exception e) {
			throw new DataBaseException("Falha na persistência do endereço");
		}								
	}
	
	@Override
	public List<EnderecoEntity> buscarEndereco(String cep){
        try{
            List<EnderecoEntity> listaEntity = new ArrayList<>();
            List<EnderecoTable> listaTable = new ArrayList<>();

            listaTable = enderecoRepository.findByNrCep(cep);

            for(EnderecoTable endereco : listaTable){
                listaEntity.add(EnderecoTableMapper.from(endereco));
            }

            return listaEntity;
        }catch(Exception e){
            throw new DataBaseException("[E03] Falha ao buscar o endereço!");
        }
    }

}