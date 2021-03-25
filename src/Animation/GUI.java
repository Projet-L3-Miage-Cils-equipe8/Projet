import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	
	JLabel label = new JLabel("Options"); 
	JFrame frame; 
	JPanel panel; 
	JButton play_music;
	JButton stop_music;
	JButton exit;
	JButton jouer;
	GroupLayout g;
	boolean son = false;
	Music m = new Music();
	
	MouvementKeyListener ml;
	
	
	ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Ressources/Images/Marish Bros.gif"));
	public GUI() {
		ml = new MouvementKeyListener();
		JLabel bg = new JLabel(image);
		play_music = new JButton("Activer la musique");
		stop_music = new JButton("Arrêter la musique");
		jouer = new JButton("Lancer le jeu");
		exit = new JButton("Quitter");
		jouer.addActionListener(this);
		jouer.setActionCommand("jouer");
		play_music.addActionListener(this);
		play_music.setActionCommand("activer");
		stop_music.addActionListener(this);
		stop_music.setActionCommand("arrêter");
		exit.addActionListener(this);
		exit.setActionCommand("quitter");
		panel = new JPanel();
		g = new GroupLayout(panel);
		panel.setLayout(g);
		g.setAutoCreateContainerGaps(true);
		g.setAutoCreateGaps(true);
		g.setHorizontalGroup(g.createSequentialGroup()
				.addComponent(bg)
				.addGroup(g.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jouer)
				.addComponent(play_music)
				.addComponent(stop_music)
				.addComponent(exit))
				.addComponent(label)
				);
		g.setVerticalGroup(g.createSequentialGroup()
				.addGroup(g.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(bg))
						.addComponent(jouer)
						.addComponent(play_music)
						.addComponent(stop_music)
						.addComponent(exit)
						.addComponent(label)
				);
		
		
		
		
		
		
		
		
		
		
		
		frame = new JFrame();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Marish Bros");
		frame.pack();
		frame.setVisible(true);

		
	
		
	}
	public boolean getSon() {
		return son;
	}
	
	

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		play_music.setEnabled(true); stop_music.setEnabled(false);
		
		if("activer".equals(e.getActionCommand())) {
			son = true;
			m.play1();
		}
		if("arrêter".equals(e.getActionCommand())) {
			son = false;
			m.stop1();
		}
		if("quitter".equals(e.getActionCommand())) {
			System.out.println("Au revoir et à bientôt !");
			System.exit(0);
		}
		if("jouer".equals(e.getActionCommand())) {
			m.ready();
			ml.show();
			panel.setVisible(false);
			if(son) {
				m.stop1();
				m.lvl1();
				
			}
		}
		
		if (son) play_music.setEnabled(false);
		else play_music.setEnabled(true);
		if(play_music.isEnabled()) stop_music.setEnabled(false);
		else stop_music.setEnabled(true);
		
	}

	
}
