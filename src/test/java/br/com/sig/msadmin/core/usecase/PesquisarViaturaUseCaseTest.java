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

@RunWith(MockitoJUnitRunner.class)
public class PesquisarViaturaUseCaseTest {

	@InjectMocks 
    private PesquisarViaturaUseCase useCase;
    
	@Mock
    private ViaturaDataProvider dataProvider;
         
    @Test
    public void PesquisarViaturaUseCase_success(){
    	ViaturaEntity entity = new ViaturaEntity();
    	
    	entity.setId_viatura(1L);
    	entity.setAno_viatura(2010);
    	entity.setCd_placa_viatura("API-0007");
    	entity.setDs_fabricante("Jascker");
    	entity.setNr_km_inicial(12000);
    	entity.setNr_km_final(10000);
    	
    	List<ViaturaEntity> list = new ArrayList<>();
    	list.add(entity);
    	
        Mockito.when(dataProvider.pesquisarViatura()).thenReturn(list);
        
        List<ViaturaEntity> response = useCase.pesquisarViatura();

        Assert.assertEquals(list, response);

    }
    
}