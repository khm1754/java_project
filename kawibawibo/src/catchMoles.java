import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class catchMoles extends JFrame implements ActionListener,Runnable{
	JButton start = new JButton("Start"); //���� ��ư
	JButton set[] = new JButton[12]; //�δ��� ���� ��ư
	ImageIcon icon = new ImageIcon("C:\\Users\\������\\Desktop\\�δ���.png"); //��ư�� ��Ÿ�� �δ��� ����
	ImageIcon icon2 = new ImageIcon("null.png"); //null_ddu
	JLabel score = new JLabel("Score : 0");
	JLabel time = new JLabel("Time 0:30");
	Container c = getContentPane();
	JPanel PanelD = new JPanel(); //����� set[] ��ư ���� �г�
	JPanel PanelSc = new JPanel(); //�غκ� ���� �������̺� ���� �г�
	JPanel PanelSt = new JPanel(); //�غκ� �����ʿ� ���۹�ư ���� �г�
	int ran1 = 0;
	int ran2 = 0;
	int cnt = -1; //Score�� ��Ÿ�� ����
	int n = 30; //�ʸ� ��Ÿ���� ����
	
	catchMoles(){
		setTitle("�δ��� ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new BorderLayout(10,10));
		time.setFont(new Font("Arial",Font.BOLD,20));
		score.setFont(new Font("Arial",Font.BOLD,20));
		
		c.add(time,BorderLayout.NORTH);
		
		c.add(PanelD,BorderLayout.CENTER);
		PanelD.setLayout(new GridLayout(3,4));
		for(int i=0;i<set.length; i++) {
			set[i] = new JButton();
			PanelD.add(set[i],BorderLayout.CENTER);
			set[i].setIcon(icon2);
			set[i].setBorderPainted(false);
			set[i].setFocusPainted(false);
			set[i].setBackground(Color.DARK_GRAY);
		}
		c.add(PanelSc,BorderLayout.SOUTH);
		PanelSc.setLayout(new GridLayout(1,2));
		PanelSc.add(score);
		
		PanelSc.add(PanelSt);
		PanelSt.setLayout(new FlowLayout(FlowLayout.RIGHT));
		PanelSt.add(start);
		
		PanelD.setBackground(Color.DARK_GRAY);
		PanelSt.setBackground(Color.LIGHT_GRAY);
		PanelSc.setBackground(Color.LIGHT_GRAY);
		c.setBackground(Color.LIGHT_GRAY);

		Start();
		
		setSize(500,500);
		setVisible(true);
		setBounds(600, 200, 500, 500);
	}
	//���� ��ư ������ ����
	public void Start() {
		on();
		start.addActionListener(this);
		for(int i=0; i<set.length; i++)
			set[i].addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == start) {
			Thread th = new Thread(this);
			th.start();
			random(0);
		}
		for(int i=0; i<set.length; i++) {
			if(e.getSource() == set[i])
				random(i);
		}
	}
	
	private void random(int i) {
		if (i != ran1 && i != ran2) return; //�������� ���� �δ��� ��ư�� Ŭ���ߴ��� Ȯ��
		cnt ++;


		Timer tm = new Timer();
		TimerTask m_task = new TimerTask() {
			@Override
			public void run() {
				set[ran1].setIcon(icon2); //null
				ran1 = (int)(Math.random() * set.length);
				set[ran1].setIcon(icon);
			}
		};
		tm.schedule(m_task, 1500);
		
		set[ran2].setIcon(icon2); //null
		ran2 = (int)(Math.random() * set.length);
		set[ran2].setIcon(icon);
		
		score.setText("Score : "+cnt*10);
	}

	//Ÿ�̸�
	@Override
	public void run() {
		n = 30;
		while(true) {
			try{
				Thread.sleep(1000); //1��
			}catch(InterruptedException e) {};
			n--;
			if(n == 0) { //�ð� �ʰ� �� �δ��� �ȳ����� �ϰ� �ð��� �κ��� ���ӿ����� ���+��ư Ŭ�� ���ϰ� �ϱ�
				set[ran1].setIcon(icon2);	//null
				set[ran2].setIcon(icon2);	//null
				time.setText("Game Over !!");
				off();
				break;
			}
			time.setText("Time 0:"+n);
		}
	}
	
	public void off() {
		for(int i=0; i<set.length; i++)
			set[i].setEnabled(false);
	}
	public void on() {
		for(int i=0; i<set.length; i++)
			set[i].setEnabled(true);
	}
	
	public static void main(String[] args) {
		new catchMoles();
	}
}
