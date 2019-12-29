package br.com.sig.msadmin.core.usecase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.dataprovider.UnidadeDataProvider;
import br.com.sig.msadmin.exception.DataBaseException;

@RunWith(MockitoJUnitRunner.class)
public class PesquisarUnidadeUseCaseTest {

	@InjectMocks 
    private PesquisarUnidadeUseCase useCase;
    
	@Mock
    private UnidadeDataProvider data;
         
    @Test
    public void PesquisarUnidadeUseCase_success(){
    	UnidadeEntity entity = new UnidadeEntity();
    	
    	entity.setId(1L);
    	entity.setTipo("unidade");
    	entity.setNome("Teste unidade");
    	entity.setCep("11700190");
    	entity.setTipoLogradouro("Rua");
    	entity.setLogradouro("Espírito Santo");
    	entity.setNumero(391);
    	entity.setComplemento("apto 122");
    	entity.setRegiao("Baixada");
    	entity.setBairro("Canto do Forte");
    	entity.setCidade("Praia Grande");
    	entity.setEstado("SP");
    	entity.setReferencia("proximo a um mercado");
    	entity.setIdCadastro(1L);
    	
    	List<UnidadeEntity> list = new ArrayList<>();
    	list.add(entity);
    	
        Mockito.when(data.pesquisarUnidades()).thenReturn(list);
        
        List<UnidadeEntity> response = useCase.pesquisarUnidades();

        Assert.assertEquals(list, response);

    }

    @Test(expected = DataBaseException.class)
    public void PesquisarUnidadeUseCase_exception(){

        Mockito.doThrow(new DataBaseException("Falha na consulta de dados")).when(data).pesquisarUnidades();

        useCase.pesquisarUnidades();
    }
}