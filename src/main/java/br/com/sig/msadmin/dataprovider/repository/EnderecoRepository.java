package br.com.sig.msadmin.dataprovider.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sig.msadmin.dataprovider.entity.EnderecoTable;

public interface EnderecoRepository extends JpaRepository<EnderecoTable, Long> {
    List<EnderecoTable> findByNrCep(String cep);
}
