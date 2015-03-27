package view;

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

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String JComboBox = null;
	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox_01 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox comboBox_02 = new JComboBox();

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 1300, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Panel que apresenta fotos;
		JPanel panel_foto01 = new JPanel();
		panel_foto01.setBounds(10, 5, 376, 478);
		contentPane.add(panel_foto01);
		
		comboBox_01.setLocation(10, 11);
		comboBox_01.setSize(350, 31);
		panel_foto01.setLayout(null);
		panel_foto01.add(comboBox_01);
		listaConteudo("fotos01", comboBox_01);
		
		JLabel panel_projecao01 = new JLabel();
		
		panel_projecao01.setBackground(Color.GRAY);
		panel_projecao01.setBounds(10, 54, 350, 400);
		panel_foto01.add(panel_projecao01);
		
		// Panel que apresenta as fotos;
		JPanel panel_foto02 = new JPanel();
		panel_foto02.setBounds(396, 5, 376, 478);
		contentPane.add(panel_foto02);
		panel_foto02.setLayout(null);

		comboBox_02.setBounds(10, 11, 350, 31);
		panel_foto02.add(comboBox_02);
		
		listaConteudo("fotos02", comboBox_02);
		
		JLabel panel_projecao02 = new JLabel();
		panel_projecao02.setBackground(Color.GRAY);
		panel_projecao02.setBounds(10, 54, 350, 400);
		panel_foto02.add(panel_projecao02);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(782, 5, 426, 478);
		contentPane.add(panel);
		
		JLabel panel_1 = new JLabel();
		panel_1.setBounds(10, 54, 350, 400);
		panel.add(panel_1);

		comboBox_01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagemTela tela = new ImagemTela("fotos01\\foto1.jpg");
				panel_projecao01.add(tela);
				panel_projecao01.repaint();
			}
		});
		
		comboBox_02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagemTela tela = new ImagemTela("fotos02\\foto2.jpg");
				panel_projecao02.add(tela);
				panel_projecao02.repaint();
			}
		});
	}

	public void listaConteudo(String nomePasta, JComboBox box) {

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
