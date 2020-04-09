package br.com.sig.msadmin.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sig.msadmin.dataprovider.entity.EnderecoTable;

public interface EnderecoRepository extends JpaRepository<EnderecoTable, Long> {

}
