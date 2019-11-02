package br.com.sig.msadmin.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sig.msadmin.dataprovider.entity.ProfissionalTable;

@Repository
public interface ProfissionalRepository extends JpaRepository<ProfissionalTable, Long> {

}
