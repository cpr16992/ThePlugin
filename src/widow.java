import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class widow extends JFrame {

	private JPanel contentPane;
	private JTextField txtPleaseSelectThe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					widow frame = new widow();
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
	public widow() {
		setTitle("Please select a structure");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		aGEMtaglist aGEM = new aGEMtaglist();
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			aGEMtaglist aGEM = new aGEMtaglist();
			String[] values = aGEM.strToString();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		txtPleaseSelectThe = new JTextField();
		txtPleaseSelectThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtPleaseSelectThe.setText("Please select the structures you want to query about:");
		scrollPane.setColumnHeaderView(txtPleaseSelectThe);
		txtPleaseSelectThe.setColumns(10);
	}

}
