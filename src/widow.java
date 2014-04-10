import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Box;

import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.UIManager;

public class widow extends JFrame {

	//private JFrame frmSelectAnAnatomical;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					widow window = new widow();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public widow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frmSelectAnAnatomical = new JFrame();
		setTitle("Select an anatomical structure");
		this.setAlwaysOnTop(true);
		this.getContentPane().setEnabled(false);

		JList list = new JList();
		JScrollPane scrollPane = new JScrollPane(list);
		list.setBorder(UIManager.getBorder("ScrollPane.border"));
		list.setValueIsAdjusting(true);
		list.setModel(new AbstractListModel() {
			aGEMtaglist aGEMdata = new aGEMtaglist();
			String[] values = aGEMdata.strToString();

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("");

		JLabel lblNewLabel = new JLabel(
				"Please select the anatomical structure(s) you want to query about:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JButton btnContinue = new JButton("Continue");

		JButton btnCancel = new JButton("Cancel");
		GroupLayout groupLayout = new GroupLayout(
				this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(113)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(list, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
									.addGap(385))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(408)
							.addComponent(btnCancel)
							.addGap(18)
							.addComponent(btnContinue)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnContinue))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		this.getContentPane().setLayout(groupLayout);
		this.setBounds(100, 100, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
