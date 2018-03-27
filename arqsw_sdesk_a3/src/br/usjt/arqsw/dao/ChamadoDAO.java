package br.usjt.arqsw.dao;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

@Repository
public class ChamadoDAO {
	@PersistenceContext
	EntityManager manager;
	public ChamadoDAO(EntityManager manager){
	this.manager = manager;
	}
	@SuppressWarnings("unchecked")
	public List<Chamado> listarChamado(Fila fila){
		List<Chamado> lista = new ArrayList<>();
		lista = (List<Chamado>) manager.createQuery("select c from Chamado c JOIN Fila l WHERE c.id_fila = f.id WHERE f.id = :fila").setParameter("fila", fila.getId());
		return lista;
	}
}
