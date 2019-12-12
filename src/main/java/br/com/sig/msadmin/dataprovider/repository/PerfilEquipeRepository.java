package br.com.sig.msadmin.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sig.msadmin.dataprovider.entity.PerfilEquipeTable;

//TODO na Declaração do JpaRepository<E, Type> vc deve colocar o mesmo tipo que foi dado ao campo que obtem o @Id
@Repository
public interface PerfilEquipeRepository extends JpaRepository<PerfilEquipeTable, Long>{

}
