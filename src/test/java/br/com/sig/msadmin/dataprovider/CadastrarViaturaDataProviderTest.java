package br.com.sig.msadmin.dataprovider;

import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.dataprovider.entity.ViaturaTable;
import br.com.sig.msadmin.dataprovider.repository.ViaturaRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarViaturaDataProviderTest {
    @InjectMocks
    private ViaturaDataProvider dataProvider;

    @Mock
    private ViaturaRepository viaturaRepository;

    private Date date = new Date();

    private ViaturaEntity viatura = ViaturaEntity.builder()
    									//	.id_viatura(1L)
    										.ano_viatura(2010)
    										.cd_placa_viatura("API-7777")
    										.ds_fabricante("Ford")
    										.nr_km_inicial(2000)
    										.nr_km_final(2000)
    										.dt_cadastro_viatura(date)
        	
    									//	.dataAlteracao(date)
    									//	.dataDesativacao(date)
        	
    									//	.idCadastro(2L)
    									//	.idAlteracao(3L)
    									//	.idDesativacao(4L)
                                       
                                                
                                                
                                                .build();

    @Test
    public void cadastrarViatura_success(){
        

        ViaturaTable table = ViaturaTable.builder().id(1L).build();

        Mockito.when(viaturaRepository.save(Mockito.any(ViaturaTable.class))).thenReturn(table);

        ViaturaEntity result = dataProvider.salvarViatura(viatura);

        Assert.assertThat(result, Matchers.any(ViaturaEntity.class));
    }

    @Test(expected = DataBaseException.class)
    public void cadastrarViatura_exception(){

        Mockito.doThrow(new DataBaseException("Falha na persistência")).when(viaturaRepository).save(Mockito.any(ViaturaTable.class));

        dataProvider.salvarViatura(viatura);
    }
}