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
		setTitle("���� ����");
		super.setLayout(new GridLayout(6,2));
		
		b1 = new JButton("����",new ImageIcon("C:\\\\Users\\\\������\\\\Desktop\\\\�����̸�Ƽ��.png"));
		b2 = new JButton("��Ʈ���� ����", new ImageIcon("C:\\\\Users\\\\������\\\\Desktop\\\\��Ʈ�����̸�Ƽ��.png"));
		b3 = new JButton("1 to 50����",new ImageIcon("C:\\Users\\������\\Desktop\\1to50�̸�Ƽ��.png"));
		b4 = new JButton("�δ��� ���",new ImageIcon("C:\\Users\\������\\Desktop\\�δ�������̸�Ƽ��.png"));
		b5 = new JButton("���� ����", new ImageIcon("C:\\Users\\������\\Desktop\\���������̸�Ƽ��.png"));
		b6 = new JButton("������ ����",new ImageIcon("C:\\Users\\������\\Desktop\\������ũ�����̸�Ƽ��.png"));
		
		setBounds(600, 200, 500, 500);
		b1.addActionListener(this);//�̺�Ʈ�޼ҵ�ȣ��
		b2.addActionListener(this);//�̺�Ʈ�޼ҵ�ȣ��
		b3.addActionListener(this);//�̺�Ʈ�޼ҵ�ȣ��
		b4.addActionListener(this);//�̺�Ʈ�޼ҵ�ȣ��
		b5.addActionListener(this);//�̺�Ʈ�޼ҵ�ȣ��
		b6.addActionListener(this);//�̺�Ʈ�޼ҵ�ȣ��
		
		
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
			snake imagePanel = new snake("������ũ ����");
			dispose();
		}
	}
	public static void main(String[] args) {
		new select();
	}
}

