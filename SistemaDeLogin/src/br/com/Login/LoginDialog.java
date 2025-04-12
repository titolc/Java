package br.com.Login;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textEmail;
	private JPasswordField textPassword;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private boolean fazerLogin(String email, String senha) {
	    String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
	    
	    try (Connection con = Conexao.conectar();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        
	        stmt.setString(1, email);
	        stmt.setString(2, senha);
	        
	        ResultSet rs = stmt.executeQuery();
	        return rs.next(); // Se tiver resultado, login válido
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setTitle("Login");
		setBounds(100, 100, 496, 394);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(53, 53, 53));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel jblTitulo = new JLabel("Login");
		jblTitulo.setForeground(new Color(255, 255, 255));
		jblTitulo.setBackground(new Color(255, 255, 255));
		jblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		jblTitulo.setBounds(58, 33, 93, 41);
		contentPanel.add(jblTitulo);
		
		textEmail = new JTextField();
		textEmail.setBounds(58, 133, 231, 31);
		contentPanel.add(textEmail);
		textEmail.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setColumns(10);
		textPassword.setBounds(58, 209, 231, 31);
		contentPanel.add(textPassword);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 15));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(32, 97, 93, 41);
		contentPanel.add(lblEmail);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Verdana", Font.BOLD, 15));
		lblSenha.setBackground(Color.WHITE);
		lblSenha.setBounds(32, 175, 93, 41);
		contentPanel.add(lblSenha);
		
		JButton btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String email = textEmail.getText();
						String senha = new String(textPassword.getPassword());

						if (fazerLogin(email, senha)) {
							JOptionPane.showMessageDialog(null, "Bem-vindo!");
							dispose(); // Fecha o login se quiser
						} else {
							JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.");
						}
					}
				});
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 10));
		btnLogin.setBounds(145, 284, 93, 31);
		contentPanel.add(btnLogin);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        CadastroDialog cadastro = new CadastroDialog();
		        cadastro.setModal(true); // Bloqueia interação com a tela de login enquanto cadastro está aberto
		        cadastro.setVisible(true); // Mostra o JDialog de cadastro
		    }
		});

		btnCadastrar.setFont(new Font("Verdana", Font.BOLD, 10));
		btnCadastrar.setBounds(248, 284, 93, 31);
		contentPanel.add(btnCadastrar);
	}
}
