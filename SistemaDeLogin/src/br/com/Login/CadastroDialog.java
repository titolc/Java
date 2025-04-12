package br.com.Login;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class CadastroDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textEmail;
	private JPasswordField textPassword;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JButton btnCancelar;
	private JTextField textNome;
	private JLabel lblNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroDialog dialog = new CadastroDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroDialog() {
		setTitle("Cadastro");
		setBounds(100, 100, 532, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(53, 53, 53));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastre-se");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBackground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTitulo.setBounds(192, 11, 144, 41);
		contentPanel.add(lblTitulo);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Verdana", Font.BOLD, 12));
		textEmail.setBounds(58, 156, 231, 31);
		contentPanel.add(textEmail);
		textEmail.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Verdana", Font.BOLD, 12));
		textPassword.setColumns(10);
		textPassword.setBounds(58, 221, 231, 31);
		contentPanel.add(textPassword);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 15));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(32, 120, 93, 41);
		contentPanel.add(lblEmail);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Verdana", Font.BOLD, 15));
		lblSenha.setBackground(Color.WHITE);
		lblSenha.setBounds(32, 187, 93, 41);
		contentPanel.add(lblSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textNome.getText().trim();
				String email = textEmail.getText().trim();
				String senha = new String(textPassword.getPassword()).trim();

				// Verificação de campos vazios
				if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}
				// Conexão com banco de dados e inserção
				try {
					Connection conn = Conexao.conectar(); // usa a classe certa
					String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1, nome);
					stmt.setString(2, email);
					stmt.setString(3, senha);
					stmt.executeUpdate();
					stmt.close();
					conn.close();

					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					dispose(); // Fecha a janela de cadastro

				} catch (Exception e) {
				    if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("for key 'email'")) {
				        JOptionPane.showMessageDialog(null, "Este email já está cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
				    } else {
				        JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				    }
				    e.printStackTrace();
				}
			}
		});

		btnSalvar.setFont(new Font("Verdana", Font.BOLD, 10));
		btnSalvar.setBounds(169, 296, 93, 31);
		contentPanel.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Fecha a janela
			}
		});
		btnCancelar.setFont(new Font("Verdana", Font.BOLD, 10));
		btnCancelar.setBounds(272, 296, 93, 31);
		contentPanel.add(btnCancelar);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Verdana", Font.BOLD, 12));
		textNome.setColumns(10);
		textNome.setBounds(58, 87, 231, 31);
		contentPanel.add(textNome);
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNome.setBackground(Color.WHITE);
		lblNome.setBounds(32, 51, 93, 41);
		contentPanel.add(lblNome);
	}

}
