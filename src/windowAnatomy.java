import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class windowAnatomy extends JFrame implements ActionListener {

	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private JList list;
	private JScrollPane scrollPane;
	private JLabel lblPleaseSelectThe;
	protected MDAToSTR MDA = new MDAToSTR();
	protected ArrayList<String> selection = new ArrayList<String>();
	public boolean wasperformed = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowAnatomy frame = new windowAnatomy();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public windowAnatomy() {
		setTitle("Please select a structure");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblPleaseSelectThe = new JLabel("Please select the structure(s) you want to query about:");
		lblPleaseSelectThe.setHorizontalAlignment(SwingConstants.CENTER);
		
		scrollPane = new JScrollPane();		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setActionCommand("enable");
		btnProceed.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(307)
							.addComponent(btnProceed, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPleaseSelectThe, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblPleaseSelectThe, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnProceed)
					.addGap(27))
		);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = MDA.strToString();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
				
			}
			
		});
		scrollPane.setViewportView(list);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 // Get the index of all the selected items
	    int[] selectedIx = list.getSelectedIndices();
	    // Get all the selected items using the indices
	    for (int i = 0; i < selectedIx.length; i++) {
	    	String item = (String) list.getModel().getElementAt(selectedIx[i]);
	    	selection.add(item);
	    }
	    wasperformed = true;
	    // Get the index of the first selected item
		
	}
	
	public ArrayList<String> getResults(){
		return this.selection;
	}
	
	
}
