package Calculadora;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField Valor1_1;
	private JTextField Valor2_1;
	private JTextField Resultado1;
	private String operador = "";
	private boolean digitandoSegundoNumero = false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Tela dialog = new Tela();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Tela() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel Calculadora = new JLabel("Calculadora");
		Calculadora.setBounds(172, 11, 78, 14);
		contentPanel.add(Calculadora);
		
		JLabel Valor1 = new JLabel("Valor #1");
		Valor1.setBounds(10, 24, 60, 14);
		contentPanel.add(Valor1);
		
		Valor1_1 = new JTextField();
		Valor1_1.setBounds(10, 49, 86, 20);
		contentPanel.add(Valor1_1);
		Valor1_1.setColumns(10);
		
		JLabel Valor2 = new JLabel("Valor #2");
		Valor2.setBounds(10, 80, 46, 14);
		contentPanel.add(Valor2);
		
		Valor2_1 = new JTextField();
		Valor2_1.setColumns(10);
		Valor2_1.setBounds(10, 105, 86, 20);
		contentPanel.add(Valor2_1);
		
		JLabel Resultado = new JLabel("Resultado");
		Resultado.setBounds(10, 157, 71, 14);
		contentPanel.add(Resultado);
		
		Resultado1 = new JTextField();
		Resultado1.setColumns(10);
		Resultado1.setBounds(10, 182, 86, 20);
		contentPanel.add(Resultado1);
		
		JButton Numb1 = new JButton("1");
		Numb1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!digitandoSegundoNumero) {
		            Valor1_1.setText(Valor1_1.getText() + "1");
		        } else {
		            Valor2_1.setText(Valor2_1.getText() + "1");
		        }
		    }
		});
		Numb1.setBounds(146, 48, 50, 30);
		contentPanel.add(Numb1);
		
		JButton Numb4 = new JButton("4");
		Numb4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!digitandoSegundoNumero) {
		            Valor1_1.setText(Valor1_1.getText() + "4");
		        } else {
		            Valor2_1.setText(Valor2_1.getText() + "4");
		        }
		    }
		});
		Numb4.setBounds(146, 89, 50, 30);
		contentPanel.add(Numb4);
		
		JButton Numb7 = new JButton("7");
		Numb7.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!digitandoSegundoNumero) {
		            Valor1_1.setText(Valor1_1.getText() + "7");
		        } else {
		            Valor2_1.setText(Valor2_1.getText() + "7");
		        }
		    }
		});
		Numb7.setBounds(146, 130, 50, 30);
		contentPanel.add(Numb7);
		
		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Valor1_1.setText("");
		        Valor2_1.setText("");
		        Resultado1.setText("");
		        operador = "";
		        digitandoSegundoNumero = false;
			}
		});
		btnCe.setBounds(146, 171, 50, 30);
		contentPanel.add(btnCe);
		
		JButton Numb2 = new JButton("2");
		Numb2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!digitandoSegundoNumero) {
		            Valor1_1.setText(Valor1_1.getText() + "2");
		        } else {
		            Valor2_1.setText(Valor2_1.getText() + "2");
		        }
		    }
		});
		Numb2.setBounds(206, 49, 50, 30);
		contentPanel.add(Numb2);
		
		JButton Numb5 = new JButton("5");
		Numb5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!digitandoSegundoNumero) {
		            Valor1_1.setText(Valor1_1.getText() + "5");
		        } else {
		            Valor2_1.setText(Valor2_1.getText() + "5");
		        }
		    }
		});
		Numb5.setBounds(206, 90, 50, 30);
		contentPanel.add(Numb5);
		
		JButton Numb8 = new JButton("8");
		Numb8.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!digitandoSegundoNumero) {
		            Valor1_1.setText(Valor1_1.getText() + "8");
		        } else {
		            Valor2_1.setText(Valor2_1.getText() + "8");
		        }
		    }
		});
		Numb8.setBounds(206, 131, 50, 30);
		contentPanel.add(Numb8);
		
		JButton Numb0 = new JButton("0");
		Numb0.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!digitandoSegundoNumero) {
		            Valor1_1.setText(Valor1_1.getText() + "0");
		        } else {
		            Valor2_1.setText(Valor2_1.getText() + "0");
		        }
		    }
		});
		Numb0.setBounds(206, 172, 50, 30);
		contentPanel.add(Numb0);
		
		JButton Numb3 = new JButton("3");
		Numb3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!digitandoSegundoNumero) {
		            Valor1_1.setText(Valor1_1.getText() + "3");
		        } else {
		            Valor2_1.setText(Valor2_1.getText() + "3");
		        }
		    }
		});
		Numb3.setBounds(266, 49, 50, 30);
		contentPanel.add(Numb3);
		
		JButton Numb6 = new JButton("6");
		Numb6.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!digitandoSegundoNumero) {
		            Valor1_1.setText(Valor1_1.getText() + "6");
		        } else {
		            Valor2_1.setText(Valor2_1.getText() + "6");
		        }
		    }
		});
		Numb6.setBounds(266, 90, 50, 30);
		contentPanel.add(Numb6);
		
		JButton Numb9 = new JButton("9");
		Numb9.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!digitandoSegundoNumero) {
		            Valor1_1.setText(Valor1_1.getText() + "9");
		        } else {
		            Valor2_1.setText(Valor2_1.getText() + "9");
		        }
		    }
		});
		Numb9.setBounds(266, 131, 50, 30);
		contentPanel.add(Numb9);
		
		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            double num1 = Double.parseDouble(Valor1_1.getText());
		            double num2 = Double.parseDouble(Valor2_1.getText());
		            double resultado = 0;

		            switch (operador) {
		                case "+":
		                    resultado = num1 + num2;
		                    break;
		                case "-":
		                    resultado = num1 - num2;
		                    break;
		                case "*":
		                    resultado = num1 * num2;
		                    break;
		                case "/":
		                    if (num2 != 0) {
		                        resultado = num1 / num2;
		                    } else {
		                        Resultado1.setText("Erro");
		                        return;
		                    }
		                    break;
		            }

		            Resultado1.setText(String.valueOf(resultado));
		        } catch (NumberFormatException ex) {
		            Resultado1.setText("Erro");
		        }
		    }
		});

		btnIgual.setBounds(266, 172, 50, 30);
		contentPanel.add(btnIgual);
		
		JButton btnDivisao = new JButton("/");
		btnDivisao.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        operador = "/";
		        digitandoSegundoNumero = true;
		    }
		});
		btnDivisao.setBounds(326, 49, 50, 30);
		contentPanel.add(btnDivisao);
		
		JButton btnMultiplicacao = new JButton("*");
		btnMultiplicacao.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        operador = "*";
		        digitandoSegundoNumero = true;
		    }
		});
		btnMultiplicacao.setBounds(326, 90, 50, 30);
		contentPanel.add(btnMultiplicacao);
		
		JButton btnSubtracao = new JButton("-");
		btnSubtracao.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        operador = "-";
		        digitandoSegundoNumero = true;
		    }
		});
		btnSubtracao.setBounds(326, 131, 50, 30);
		contentPanel.add(btnSubtracao);
		
		JButton btnSoma = new JButton("+");
		btnSoma.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        operador = "+";
		        digitandoSegundoNumero = true;
		    }
		});

		btnSoma.setBounds(326, 172, 50, 30);
		contentPanel.add(btnSoma);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        try {
				            double num1 = Double.parseDouble(Valor1_1.getText());
				            double num2 = Double.parseDouble(Valor2_1.getText());
				            double resultado = 0;

				            switch (operador) {
				                case "+":
				                    resultado = num1 + num2;
				                    break;
				                case "-":
				                    resultado = num1 - num2;
				                    break;
				                case "*":
				                    resultado = num1 * num2;
				                    break;
				                case "/":
				                    if (num2 != 0) {
				                        resultado = num1 / num2;
				                    } else {
				                        Resultado1.setText("Erro");
				                        return;
				                    }
				                    break;
				            }

				            Resultado1.setText(String.valueOf(resultado));
				        } catch (NumberFormatException ex) {
				            Resultado1.setText("Erro");
				        }
				    }
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        Valor1_1.setText("");
				        Valor2_1.setText("");
				        Resultado1.setText("");
				        operador = "";
				        digitandoSegundoNumero = false;
				    }
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
