package daojpa;

import java.lang.reflect.ParameterizedType;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Artista;

public class DAOArtista extends DAO<Artista> {
	  
	public Artista buscaPorNome(String nome) {
		try {
			Query q = manager.createQuery("select a from Artista a where a.nome='" + nome + "'");
			return (Artista) q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	/*
	public Artista buscaPorNome(String nome) {
		Query q = manager.query();
		q.constrain(Artista.class);
		q.descend("nome").constrain(nome);
		List<Artista> resultados = q.execute();
		if(resultados.size()>0)
			return resultados.get(0);
		return null;
	}
	

	public List<Artista> listaArtistasPorGenero(String genero){
		Query q = manager.query();
		q.constrain(Artista.class);
		q.descend("produtos").descend("generos").descend("nome").constrain(genero);
		List<Artista> resultados = q.execute();
		if(resultados.size()>0)
			return resultados;
		return null;
	}
}



class Filtro implements Evaluation{
	private int n;
	@Override
	public void evaluate(Candidate arg0) {
		// TODO Auto-generated method stub
		
	} */


}
