package br.com.sig.msadmin.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sig.msadmin.dataprovider.entity.PerfilEquipeTable;

@Repository
public interface PerfilEquipeRepository extends JpaRepository<PerfilEquipeTable, Integer>{

}
