package br.com.sig.msadmin.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.gateway.ProfissionalGateway;
import br.com.sig.msadmin.dataprovider.entity.BairroTable;
import br.com.sig.msadmin.dataprovider.entity.CidadeTable;
import br.com.sig.msadmin.dataprovider.entity.EnderecoTable;
import br.com.sig.msadmin.dataprovider.entity.EspecialidadeProfissionalTable;
import br.com.sig.msadmin.dataprovider.entity.EstadoTable;
import br.com.sig.msadmin.dataprovider.entity.ProfissionalTable;
import br.com.sig.msadmin.dataprovider.entity.TipoLogradouroTable;
import br.com.sig.msadmin.dataprovider.entity.TipoProfissionalTable;
import br.com.sig.msadmin.dataprovider.mapper.ProfissionalTableMapper;
import br.com.sig.msadmin.dataprovider.repository.BairroRepository;
import br.com.sig.msadmin.dataprovider.repository.CidadeRepository;
import br.com.sig.msadmin.dataprovider.repository.EnderecoRepository;
import br.com.sig.msadmin.dataprovider.repository.EspecialidadeProfissionalRepository;
import br.com.sig.msadmin.dataprovider.repository.EstadoRepository;
import br.com.sig.msadmin.dataprovider.repository.ProfissionalRepository;
import br.com.sig.msadmin.dataprovider.repository.TipoLogradouroRepository;
import br.com.sig.msadmin.dataprovider.repository.TipoProfissionalRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@Component
public class ProfissionalDataProvider implements ProfissionalGateway{
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	@Autowired
	private TipoProfissionalRepository tipoProfissionalRepository;
	@Autowired
	private TipoLogradouroRepository tipoLogradouroRepository;
	@Autowired
	private EspecialidadeProfissionalRepository especialidadeProfissionalRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private BairroRepository bairroRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public ProfissionalEntity cadastrarProfissional(ProfissionalEntity entity) {
		try {
			ProfissionalTable profissional = ProfissionalTableMapper.from(entity);
			
			TipoProfissionalTable tipo = profissional.getTpProfissional();
			EspecialidadeProfissionalTable especialidade = tipo.getEspecialidade();
			EnderecoTable endereco = profissional.getEndereco();
			TipoLogradouroTable logradouro = endereco.getTpLogradouro();
			BairroTable bairro = endereco.getBairro();
			CidadeTable cidade = bairro.getCidade();
			EstadoTable estado = cidade.getEstado(); 
			

			estado = estadoRepository.save(estado);
			cidade = cidadeRepository.save(cidade);
			bairro = bairroRepository.save(bairro);
			logradouro = tipoLogradouroRepository.save(logradouro);
			endereco = enderecoRepository.save(endereco);
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
