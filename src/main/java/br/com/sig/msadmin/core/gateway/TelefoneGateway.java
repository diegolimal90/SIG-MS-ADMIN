package br.com.sig.msadmin.core.gateway;

import br.com.sig.msadmin.core.entity.TelefoneEntity;

public interface TelefoneGateway {
    TelefoneEntity cadastrarTelefone(TelefoneEntity entity);
}