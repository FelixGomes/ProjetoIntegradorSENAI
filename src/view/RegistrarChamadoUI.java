package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarChamadoUI extends JInternalFrame {
	private JTextField txtDataChamado;
	private JTextField txtEndereco;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarChamadoUI frame = new RegistrarChamadoUI();
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
	public RegistrarChamadoUI() {
		setClosable(true);
		setTitle("Registrar Chamado");
		setBounds(100, 100, 495, 277);
		
		JComboBox cbColaborador = new JComboBox();
		
		JLabel jlColaborador = new JLabel("Colaborador:");
		
		JLabel jlVeiculo = new JLabel("Veiculo:");
		
		JComboBox cbVeiculo = new JComboBox();
		
		JLabel jlDataChamado = new JLabel("Data Chamado:");
		
		txtDataChamado = new JTextField();
		txtDataChamado.setColumns(10);
		
		JLabel jlEndereco = new JLabel("Endereco:");
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		
		JLabel jlDistancia = new JLabel("Distancia:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel jlStatus = new JLabel("Status:");
		
		JComboBox cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"EM ABERTO", "EM ANDAMENTO", "CONCLUICDDO"}));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel jlEmissaoCarbono = new JLabel("Total CO2 emitido:");
		
		JLabel jlTotalEmissaoCarbono = new JLabel("");
		jlTotalEmissaoCarbono.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jlDataChamado)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDataChamado, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(jlStatus)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbStatus, 0, 183, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(jlColaborador)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(jlVeiculo)
										.addGap(23)))
								.addComponent(jlEndereco)
								.addComponent(jlDistancia))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
												.addComponent(jlEmissaoCarbono)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(jlTotalEmissaoCarbono)
												.addGap(41))
											.addComponent(txtEndereco, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
										.addComponent(cbVeiculo, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(cbColaborador, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))))
					.addGap(48))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlDataChamado)
						.addComponent(jlStatus)
						.addComponent(cbStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataChamado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlColaborador)
						.addComponent(cbColaborador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlVeiculo)
						.addComponent(cbVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlEndereco)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlDistancia)
						.addComponent(jlEmissaoCarbono)
						.addComponent(jlTotalEmissaoCarbono)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}

}