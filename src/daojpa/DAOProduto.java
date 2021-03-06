package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Musica;
import modelo.Produto;

public class DAOProduto extends DAO<Produto> {
	
	public Produto listarPorNome(String nome) {
		try {
			Query q = manager.createQuery("select p from Produto p where p.nome='" + nome + "'");
			return (Produto) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<Musica> buscarMusicas(String genero){
		try {
			Query q = manager.createQuery("select m from Musica m join m.album al join al.generos g where g.nome ='" + genero + "'");
			@SuppressWarnings("unchecked")
			List<Musica> resultados = q.getResultList();
			if(resultados.size()>0)
				return resultados;
		}catch(NoResultException e) {
			
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public int contarMusicas() {
		try {
			Query q = manager.createQuery("select count(m) from Musica m");
			System.out.println(q);
			int resultados = q.getFirstResult();
			if(resultados > 0)
				return resultados;
		}catch(NoResultException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
} 
