package VIEW;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmNovoProjeto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNovoProjeto frame = new FrmNovoProjeto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmNovoProjeto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		tableModel = new DefaultTableModel(
				new Object[][] {
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
				},
				new String[] {
						"New column", "New column", "New column", "New column", "New column"
				}
		);
		table.setModel(tableModel);
		table.setBounds(10, 72, 694, 96);
		contentPane.add(table);

		JButton btnNewButton = new JButton("Add Project");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProject();
			}
		});
		btnNewButton.setBounds(90, 318, 165, 23);
		contentPane.add(btnNewButton);
	}

	private void addProject() {
		Object[] rowData = {"Project Name", "Start Date", "End Date", "Status", "Description"};
		tableModel.addRow(rowData);
	}
}
