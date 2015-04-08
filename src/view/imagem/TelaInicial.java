package view.imagem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
/**
 * Classe que cria a interface para usuário. Nela apresenta um menu com três opções: Tirar foto, atualizar e subtrair as fotos.
 * 
 * @see GeraImagem
 * @see Cam
 * 
 * @author Bruno Clementino, Fábio Dias e Lucas Miranda
 *
 */
public class TelaInicial extends JFrame {

	
	private static final long serialVersionUID = -2090424541468295528L;
	private JPanel contentPane;
	JComboBox<String> comboBox_01 = new JComboBox<String>();
	JComboBox<String> comboBox_02 = new JComboBox<String>();
	JLabel label_projecao01 = new JLabel();
	JLabel label_projecao02 = new JLabel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicial() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 454);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFotos = new JMenu("Fotos");
		menuBar.add(mnFotos);

		JMenuItem mntmTirarFotos = new JMenuItem("Tirar fotos");
		mntmTirarFotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cam camera = new Cam();
				camera.tiraFoto();
				comboBox_01.repaint();
				comboBox_02.repaint();
			}
		});
		mntmTirarFotos.setIcon(new ImageIcon(TelaInicial.class
				.getResource("/lib/Camera_icon.jpg")));
		mnFotos.add(mntmTirarFotos);

		JMenuItem mntmAtualizar = new JMenuItem("Atualizar ");

		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validate();
				atualizaFotos();
			}
		});
		mntmAtualizar.setIcon(new ImageIcon(TelaInicial.class
				.getResource("/lib/atualizar.jpg")));
		mnFotos.add(mntmAtualizar);

		JMenuItem mntmSubtraoDeFotos = new JMenuItem(
				"Subtra\u00E7\u00E3o de fotos");
		mntmSubtraoDeFotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread thread = new Thread() {
					public void run() {

						GeraImagem gi = new GeraImagem();
						gi.gerar("fotos01\\foto1.jpg", "fotos02\\foto2.jpg");

					}
				};
				thread.start();
			}
		});
		mnFotos.add(mntmSubtraoDeFotos);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Panel que apresenta fotos;
		JPanel panel_foto01 = new JPanel();
		panel_foto01.setBounds(5, 5, 320, 370);
		contentPane.add(panel_foto01);

		comboBox_01.setLocation(10, 11);
		comboBox_01.setSize(300, 31);
		panel_foto01.setLayout(null);
		panel_foto01.add(comboBox_01);
		listaConteudo("fotos01", comboBox_01);

		label_projecao01.setBackground(Color.GRAY);
		label_projecao01.setBounds(10, 53, 300, 300);
		panel_foto01.add(label_projecao01);

		// Panel que apresenta as fotos;
		JPanel panel_foto02 = new JPanel();
		panel_foto02.setBounds(335, 5, 329, 370);
		contentPane.add(panel_foto02);
		panel_foto02.setLayout(null);

		comboBox_02.setBounds(10, 11, 300, 31);
		panel_foto02.add(comboBox_02);

		listaConteudo("fotos02", comboBox_02);

		label_projecao02.setBackground(Color.GRAY);
		label_projecao02.setBounds(10, 53, 300, 300);
		panel_foto02.add(label_projecao02);

		comboBox_01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaFotos();
				ImagemTela tela = new ImagemTela("fotos01\\foto1.jpg");
				label_projecao01.add(tela);
				label_projecao01.repaint();
			}
		});

		comboBox_02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaFotos();
				ImagemTela tela = new ImagemTela("fotos02\\foto2.jpg");
				label_projecao02.add(tela);
				label_projecao02.repaint();
			}
		});
	}

	public void atualizaFotos() {
		listaConteudo("fotos01/foto1", comboBox_01);
		listaConteudo("fotos02/foto2", comboBox_02);
		label_projecao01.repaint();
		label_projecao02.validate();
	}

	public void listaConteudo(String nomePasta, JComboBox<String> box) {

		File arquivo = new File(nomePasta);
		
		File[] file = arquivo.listFiles();

		if (file != null) {
			int length = file.length;
			for (int i = 0; i < length; ++i) {
				File f = file[i];
				if (f.isFile()) {
					box.addItem(f.getName());
				} else if (f.isDirectory()) {

				}
			}
		}
		box.repaint();
	}
}
