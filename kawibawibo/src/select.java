import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;




public class select extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4,b5,b6;
	
	public select() {
		setTitle("게임 선택");
		super.setLayout(new GridLayout(6,2));
		
		b1 = new JButton("버섯",new ImageIcon("C:\\\\Users\\\\공현민\\\\Desktop\\\\버섯이모티콘.png"));
		b2 = new JButton("테트리스 게임", new ImageIcon("C:\\\\Users\\\\공현민\\\\Desktop\\\\테트리스이모티콘.png"));
		b3 = new JButton("1 to 50게임",new ImageIcon("C:\\Users\\공현민\\Desktop\\1to50이모티콘.png"));
		b4 = new JButton("두더지 잡기",new ImageIcon("C:\\Users\\공현민\\Desktop\\두더지잡기이모티콘.png"));
		b5 = new JButton("벽돌 깨기", new ImageIcon("C:\\Users\\공현민\\Desktop\\벽돌깨기이모티콘.png"));
		b6 = new JButton("지렁이 게임",new ImageIcon("C:\\Users\\공현민\\Desktop\\스네이크게임이모티콘.png"));
		
		setBounds(600, 200, 500, 500);
		b1.addActionListener(this);//이벤트메소드호출
		b2.addActionListener(this);//이벤트메소드호출
		b3.addActionListener(this);//이벤트메소드호출
		b4.addActionListener(this);//이벤트메소드호출
		b5.addActionListener(this);//이벤트메소드호출
		b6.addActionListener(this);//이벤트메소드호출
		
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);

		setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			gun imagePanel = new gun();
			dispose();
		}
		else if(e.getSource()==b2) {
			ImagePanel imagePanel = new ImagePanel();
			dispose();
		}
		else if(e.getSource()==b3) {
			MainFrame JPanel = new MainFrame();
			dispose();
		}
		else if(e.getSource()==b4) {
			catchMoles imagePanel = new catchMoles();
			dispose();
		}
		else if(e.getSource()==b5) {
			blockgame imagePanel = new blockgame("Block Game");
			dispose();
		}
		else if(e.getSource()==b6) {
			snake imagePanel = new snake("스네이크 게임");
			dispose();
		}
	}
	public static void main(String[] args) {
		new select();
	}
}

