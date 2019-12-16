package br.com.sig.msadmin.dataprovider;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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

    //TODO Corrigir teste
    @Test
    public void cadastrarViatura_success(){
        ViaturaEntity viatura = ViaturaEntity.builder()
                                             .id(1L)
                                             .ano(2010)
                                             .build();

        ViaturaTable table = ViaturaTable.builder().build();

        Mockito.when(viaturaRepository.save(Mockito.any(ViaturaTable.class))).thenReturn(table);

        ViaturaEntity result = dataProvider.salvarViatura(viatura);

        Assert.assertThat(result, Matchers.any(ViaturaEntity.class));
    }

    @Test(expected = DataBaseException.class)
    public void cadastrarViatura_exception(){
        ViaturaEntity viatura = ViaturaEntity.builder().build();

        Mockito.when(viaturaRepository.save(Mockito.any(ViaturaTable.class))).thenThrow(new DataBaseException("Falha na persistência"));

        Assertions.assertThrows(DataBaseException.class, ()-> dataProvider.salvarViatura(viatura));
    }
}