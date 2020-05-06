package br.com.sig.msadmin.core.usecase;

import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.core.usecase.CadastrarViaturaUseCase;
import br.com.sig.msadmin.dataprovider.ViaturaDataProvider;
import br.com.sig.msadmin.exception.DataBaseException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CadastrarViaturaUseCaseTest {

    @InjectMocks
    private CadastrarViaturaUseCase useCase;

    @Mock
    private ViaturaDataProvider dataProvider;
    
    private ViaturaEntity viatura = ViaturaEntity.builder()
    		                                     .ano_viatura(2010)
    		                                     .cd_placa_viatura("API-7777")
    		                                     .ds_fabricante("Ford")
    		                                     .nr_km_inicial(2000)
    		                                     .nr_km_final(2000)
    		                                        		                                
                                                 .build();

    private ViaturaEntity cloneViatura = ViaturaEntity.builder()
    												.ano_viatura(2010)
    												.cd_placa_viatura("API-7777")
    												.ds_fabricante("Ford")
    												.nr_km_inicial(2000)
    												.nr_km_final(2000)
                                                    .build();
    
    @Test
    public void CadastrarViaturaUseCase_success(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        cloneViatura.setDt_cadastro_viatura(timestamp);
        viatura.setDt_cadastro_viatura(timestamp);

        Mockito.when(dataProvider.salvarViatura(Mockito.any(ViaturaEntity.class))).thenReturn(cloneViatura);

        ViaturaEntity response = useCase.cadastrarViatura(viatura);        
        Assert.assertEquals(viatura, response);

    }
    
    @Test(expected = DataBaseException.class)
    public void CadastrarViaturaUseCase_exception(){
        ViaturaEntity vazio = ViaturaEntity.builder().build();

        Mockito.doThrow(new DataBaseException("Falha na persistencia do cadastro da viatura.")).when(dataProvider).salvarViatura(Mockito.any(ViaturaEntity.class));

        useCase.cadastrarViatura(vazio);
    }    
}