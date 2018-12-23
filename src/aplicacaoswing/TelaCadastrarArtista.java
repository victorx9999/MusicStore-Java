package aplicacaoswing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Artista;

import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaCadastrarArtista extends JFrame {

	private JFrame frame;
	private JTextField textField_artista;
	private JTextField textField_nac;
	private JLabel lbl_numintegrantes;
	private JTextField textField_num;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarArtista window = new TelaCadastrarArtista();
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
	public TelaCadastrarArtista() {
		setTitle("Cadastro de Artista");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField_artista = new JTextField();
		textField_artista.setBounds(126, 45, 171, 20);
		getContentPane().add(textField_artista);
		textField_artista.setColumns(10);
		
		JLabel lblNomeDoArtista = new JLabel("Nome do Artista");
		lblNomeDoArtista.setBounds(10, 48, 106, 14);
		getContentPane().add(lblNomeDoArtista);
		
		JLabel lblNewLabel = new JLabel("Nacionalidade");
		lblNewLabel.setBounds(10, 79, 85, 14);
		getContentPane().add(lblNewLabel);
		
		textField_nac = new JTextField();
		textField_nac.setBounds(126, 76, 171, 20);
		getContentPane().add(textField_nac);
		textField_nac.setColumns(10);
		
		lbl_numintegrantes = new JLabel("N\u00FAmero de Integrantes");
		lbl_numintegrantes.setBounds(10, 110, 131, 14);
		getContentPane().add(lbl_numintegrantes);
		
		textField_num = new JTextField();
		textField_num.setBounds(126, 107, 43, 20);
		getContentPane().add(textField_num);
		textField_num.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField_artista.getText().equalsIgnoreCase("") || textField_nac.getText().equalsIgnoreCase("") || textField_num.getText().equalsIgnoreCase(""))
						throw new Exception("Campos em branco, tente novamente!!");
					String nomeArtista = textField_artista.getText();
					String nacionalidade = textField_nac.getText();
					int numero = Integer.parseInt(textField_num.getText());
					Artista ar = Fachada.cadastrarArtista(nomeArtista, nacionalidade, numero);
					status.setText("Artista "+ ar.getNome() + " criado com sucesso");
				}catch(Exception err) {
					status.setText(err.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(167, 168, 106, 23);
		getContentPane().add(btnCadastrar);
		
		status = new JLabel("");
		status.setBounds(10, 237, 414, 14);
		getContentPane().add(status);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
