package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.awt.Color;

import javax.swing.ImageIcon;

public class TelaInicial extends JFrame {

	private static final String JComboBox = null;
	private JPanel contentPane;
	JComboBox comboBox_01 = new JComboBox();
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
		setBounds(100, 100, 1007, 454);
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
		
		JLabel panel_projecao01 = new JLabel();
		
		panel_projecao01.setBackground(Color.GRAY);
		panel_projecao01.setBounds(10, 53, 300, 300);
		panel_foto01.add(panel_projecao01);
		
		// Panel que apresenta as fotos;
		JPanel panel_foto02 = new JPanel();
		panel_foto02.setBounds(335, 5, 329, 370);
		contentPane.add(panel_foto02);
		panel_foto02.setLayout(null);

		comboBox_02.setBounds(10, 11, 300, 31);
		panel_foto02.add(comboBox_02);
		
		listaConteudo("fotos02", comboBox_02);
		
		JLabel panel_projecao02 = new JLabel();
		panel_projecao02.setBackground(Color.GRAY);
		panel_projecao02.setBounds(10, 53, 300, 300);
		panel_foto02.add(panel_projecao02);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(674, 5, 329, 370);
		contentPane.add(panel);
		
		JLabel panel_1 = new JLabel();
		panel_1.setBounds(10, 53, 300, 300);
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
