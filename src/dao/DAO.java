package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;
import com.db4o.query.Query;

import modelo.Album;
import modelo.Artista;
import modelo.Genero;
import modelo.Musica;
import modelo.Produto;

public abstract class DAO<T> implements DAOInterface<T> {
	protected static ObjectContainer manager;

	public static void open(){	
		if(manager==null){		
			abrirBancoLocal();
			//abrirBancoServidor();
		}
	}
	public static void abrirBancoLocal(){		
		//Backup.criar("banco.db4o");		//criar uma copia do banco
		//new File("banco.db4o").delete();  //apagar o banco
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  // 0,1,2,3...
		config.common().objectClass(Artista.class).cascadeOnDelete(false);;
		config.common().objectClass(Artista.class).cascadeOnUpdate(true);;
		config.common().objectClass(Artista.class).cascadeOnActivate(true);  //sem cascata
		config.common().objectClass(Produto.class).cascadeOnDelete(false);;
		config.common().objectClass(Produto.class).cascadeOnUpdate(true);;
		config.common().objectClass(Produto.class).cascadeOnActivate(true);
		config.common().objectClass(Genero.class).cascadeOnDelete(false);;
		config.common().objectClass(Genero.class).cascadeOnUpdate(true);;
		config.common().objectClass(Genero.class).cascadeOnActivate(true);
		config.common().objectClass(Musica.class).cascadeOnDelete(false);;
		config.common().objectClass(Musica.class).cascadeOnUpdate(true);;
		config.common().objectClass(Musica.class).cascadeOnActivate(true);
		config.common().objectClass(Album.class).cascadeOnDelete(false);;
		config.common().objectClass(Album.class).cascadeOnUpdate(true);;
		config.common().objectClass(Album.class).cascadeOnActivate(true);
		
		//indexacao de atributos para agilizar a busca
		config.common().objectClass(Artista.class).objectField("nome").indexed(true);
		config.common().objectClass(Produto.class).objectField("nome").indexed(true);
		config.common().objectClass(Genero.class).objectField("nome").indexed(true);
		manager = 	Db4oEmbedded.openFile(config, "banco.db4o");
		IDControl.registrarManager(manager); 		// eventos para gerenciar autonumeração de id
	}
	
	public static void abrirBancoServidor() {
		ClientConfiguration config = Db4oClientServer.newClientConfiguration();
		config.common().messageLevel(0);
		config.common().objectClass(Artista.class).cascadeOnDelete(false);
		config.common().objectClass(Artista.class).cascadeOnUpdate(true);
		config.common().objectClass(Artista.class).cascadeOnActivate(true);
		config.common().objectClass(Produto.class).cascadeOnDelete(false);
		config.common().objectClass(Produto.class).cascadeOnUpdate(true);
		config.common().objectClass(Produto.class).cascadeOnActivate(true);
		config.common().objectClass(Genero.class).cascadeOnDelete(false);
		config.common().objectClass(Genero.class).cascadeOnUpdate(true);
		config.common().objectClass(Genero.class).cascadeOnActivate(true);
		config.common().objectClass(Musica.class).cascadeOnDelete(false);;
		config.common().objectClass(Musica.class).cascadeOnUpdate(true);;
		config.common().objectClass(Musica.class).cascadeOnActivate(true);
		config.common().objectClass(Album.class).cascadeOnDelete(false);;
		config.common().objectClass(Album.class).cascadeOnUpdate(true);;
		config.common().objectClass(Album.class).cascadeOnActivate(true);
		
		manager = Db4oClientServer.openClient(config,"10.0.4.158",34000,"usuario2","senha2");	
		//manager = Db4oClientServer.openClient(config,"localhost",34000,"usuario1","senha1");
		IDControl.registrarManager(manager); 		// eventos para gerenciar autonumeração de id
	}

	public static void close(){
		if(manager!=null) {
			manager.close();
			manager=null;
		}
	}

	//----------CRUD-----------------------

	public void create(T obj){
		manager.store( obj );
	}
	
	@SuppressWarnings("unchecked")
	public T read(int id){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = manager.query();
		q.constrain(type);
		q.descend("id").constrain(id);
		List<T> resultados = q.execute();
		if (resultados.size()>0)
			return (T) resultados.get(0);
		else
			return null;
	}

	public T update(T obj){
		manager.store(obj);
		return obj;
	}

	public void delete(T obj) {
		manager.delete(obj);
	}

	public void refresh(T obj){
		manager.ext().refresh(obj, Integer.MAX_VALUE);
	}

	@SuppressWarnings("unchecked")
	public List<T> readAll(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = manager.query();
		q.constrain(type);
		return (List<T>) q.execute();
	}
	
	//--------transação---------------
	public static void begin(){	}		// tem que ser vazio
	public static void commit(){
		manager.commit();
	}
	public static void rollback(){
		manager.rollback();
	}
	


}