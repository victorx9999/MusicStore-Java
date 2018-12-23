package aplicacaoswing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCadastrarArtista = new JMenuItem("Cadastrar Artista");
		mntmCadastrarArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarArtista t = new TelaCadastrarArtista();
				t.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarArtista);
		
		JMenuItem mntmCadastrarlbum = new JMenuItem("Cadastrar \u00C1lbum");
		mntmCadastrarlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarAlbum t = new TelaCadastrarAlbum();
				t.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarlbum);
		
		JMenuItem mntmCadastrarMsica = new JMenuItem("Cadastrar M\u00FAsica");
		mntmCadastrarMsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarMusica t = new TelaCadastrarMusica();
				t.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarMsica);
		
		JMenuItem mntmCadastrarGnero = new JMenuItem("Cadastrar G\u00EAnero");
		mntmCadastrarGnero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarGenero t = new TelaCadastrarGenero();
				t.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarGnero);
		
		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		
		JMenuItem mntmListarArtistas = new JMenuItem("Listar Artistas");
		mntmListarArtistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarArtistas t = new TelaListarArtistas();
				t.setVisible(true);
			}
		});
		mnListar.add(mntmListarArtistas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listar \u00C1lbuns");
		mnListar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar M\u00FAsicas");
		mnListar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listar G\u00EAneros");
		mnListar.add(mntmNewMenuItem_2);
		
		JMenu mnAtualizar = new JMenu("Atualizar");
		menuBar.add(mnAtualizar);
		
		JMenuItem mntmAtualizarArtista = new JMenuItem("Atualizar Artista");
		mnAtualizar.add(mntmAtualizarArtista);
		
		JMenuItem mntmAtualizarlbum = new JMenuItem("Atualizar \u00C1lbum");
		mnAtualizar.add(mntmAtualizarlbum);
		
		JMenuItem mntmAtualizarMsica = new JMenuItem("Atualizar M\u00FAsica");
		mnAtualizar.add(mntmAtualizarMsica);
		
		JMenuItem mntmAtualizarGnero = new JMenuItem("Atualizar G\u00EAnero");
		mnAtualizar.add(mntmAtualizarGnero);
		
		JMenu mnExcluir = new JMenu("Excluir");
		menuBar.add(mnExcluir);
		
		JMenuItem mntmExcluirArtista = new JMenuItem("Excluir Artista");
		mntmExcluirArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverArtista t = new TelaRemoverArtista();
				t.setVisible(true);
			}
		});
		mnExcluir.add(mntmExcluirArtista);
		
		JMenuItem mntmExcluirlbum = new JMenuItem("Excluir \u00C1lbum");
		mntmExcluirlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverAlbum t = new TelaRemoverAlbum();
				t.setVisible(true);
			}
		});
		mnExcluir.add(mntmExcluirlbum);
		
		JMenuItem mntmExcluirMsica = new JMenuItem("Excluir M\u00FAsica");
		mntmExcluirMsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverMusica t = new TelaRemoverMusica();
				t.setVisible(true);
			}
		});
		mnExcluir.add(mntmExcluirMsica);
		
		JMenuItem mntmExcluirGnero = new JMenuItem("Excluir G\u00EAnero");
		mntmExcluirGnero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverGenero t = new TelaRemoverGenero();
				t.setVisible(true);
			}
		});
		mnExcluir.add(mntmExcluirGnero);
	}
}
