import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class windowInformation extends JFrame {

	private JPanel contentPane;
	private static ArrayList<Gene> information = new ArrayList<Gene>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowInformation frame = new windowInformation(information);
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
	public windowInformation(ArrayList<Gene> information) {
		setTitle("Genetic information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 328);
		JTextPane txtpn = new JTextPane();
		txtpn.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtpn);
		scrollPane.setBounds(1, 1, 400, 285);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		//contentPane.setLayout(null);
		
		
		String result = "List of genes expressed in the queried area: \nName: ";
		for (Gene k: information){
			result = result + k.getName();
			result = result + "\nWhere: ";
			result = result + k.getStructureName();
			result = result + "\nStrength: ";
			result = result + k.getStrength();
			result = result + "\n\n\nName: ";
		}
		
	
		
		txtpn.setText(result);
		
		
		
		
		
		
		//

		
	}
}
