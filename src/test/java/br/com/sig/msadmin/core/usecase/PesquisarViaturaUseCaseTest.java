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

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.dataprovider.ViaturaDataProvider;
import br.com.sig.msadmin.exception.DataBaseException;

@RunWith(MockitoJUnitRunner.class)
public class PesquisarViaturaUseCaseTest {

	@InjectMocks 
    private PesquisarViaturaUseCase useCase;
    
	@Mock
    private ViaturaDataProvider dataProvider;
         
    @Test
    public void PesquisarViaturaUseCase_success(){
    	ViaturaEntity entity = new ViaturaEntity();
    	
    	entity.setId(1L);
    	entity.setAno(2010);
    	entity.setPlaca("API-0007");
    	entity.setFabricante("Jascker");
    	entity.setQuilometragem_atual(12000);
    	entity.setQuilometragem_inicial(10000);
    	
    	List<ViaturaEntity> list = new ArrayList<>();
    	list.add(entity);
    	
        Mockito.when(dataProvider.pesquisarViatura()).thenReturn(list);
        
        List<ViaturaEntity> response = useCase.pesquisarViatura();

        Assert.assertEquals(list, response);

    }

    @Test(expected = DataBaseException.class)
    public void PesquisarViaturaUseCase_exception(){

        Mockito.doThrow(new DataBaseException("Falha na consulta de dados")).when(dataProvider).pesquisarViatura();

        useCase.pesquisarViatura();
    }
}