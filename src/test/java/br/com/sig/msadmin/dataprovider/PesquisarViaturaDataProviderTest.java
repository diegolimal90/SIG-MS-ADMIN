package br.com.sig.msadmin.dataprovider;

import java.util.ArrayList;
import java.util.List;

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
public class PesquisarViaturaDataProviderTest {
    @InjectMocks
    private ViaturaDataProvider dataProvider;
    
    @Mock
    private ViaturaRepository repository;

    @Test
    public void pesquisarViatura_success(){
        List<ViaturaTable> listViatura = new ArrayList<>();

        Mockito.when(repository.findAll()).thenReturn(listViatura);

        List<ViaturaEntity> result = dataProvider.pesquisarViatura();

        Assert.assertThat(result, Matchers.any(List.class));
    }

    @Test(expected = DataBaseException.class)
    public void pesquisarViatura_exception(){
        Mockito.when(repository.findAll()).thenThrow(new DataBaseException("Falha na persistência"));

        Assertions.assertThrows(DataBaseException.class, ()-> dataProvider.pesquisarViatura());
    }
}