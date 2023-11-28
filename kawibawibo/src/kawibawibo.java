import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class kawibawibo extends JFrame{
   
   ImageIcon[] imgIcons = {
         new ImageIcon("C:\\Users\\공현민\\Desktop\\가위.jpg"),
         new ImageIcon("C:\\Users\\공현민\\Desktop\\바위.jpg"),
         new ImageIcon("C:\\Users\\공현민\\Desktop\\보.jpg")
         
   };
   
   SelectPanel select = new SelectPanel();
   ResultDisplay result = new ResultDisplay();
   
   
   public kawibawibo() {
      super("가위 바위 보 게임");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      add(result,"Center");
      add(select, "South");
      
      
      setSize(500,500);
      setVisible(true);
      setBounds(600, 200, 500, 500);
   }
   
   
   class SelectPanel extends JPanel{
      JButton[] btnButtons = new JButton[3];
      
      public SelectPanel() {
         setBackground(Color.green);
         
         for(int i=0; i<imgIcons.length; i++) {
            btnButtons[i] = new JButton(imgIcons[i]);
            this.add(btnButtons[i]);
            
            btnButtons[i].addActionListener(new EventHandler());
         }
      }
   }
   
   class ResultDisplay extends JPanel{
      JLabel userJLabel = new JLabel("you");
      JLabel comJLabel = new JLabel("computer");
      JLabel resultJLabel = new JLabel("winner")
            ;
      
      public ResultDisplay() {
         setBackground(Color.yellow);
         add(userJLabel);
         add(resultJLabel);
         add(comJLabel);
      }
      
      public void output(Icon img,Icon comImage, String res ) {
         userJLabel.setIcon(img);
         userJLabel.setHorizontalTextPosition(JLabel.LEFT);
         comJLabel.setIcon(comImage);
         resultJLabel.setText(res);
         result.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
         
      }
   }
   
   class EventHandler implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         //getSource가 Object 타입임으로 타입변환을 해야한다.
         JButton btnSrc = (JButton)e.getSource();
         int selCom = (int)(Math.random()*3); // 0:가위  1:바위, 2:보
         
         String res = "";
         if(btnSrc.getIcon() == imgIcons[0] && selCom == 2 ||
            btnSrc.getIcon() == imgIcons[1] && selCom == 0 ||
            btnSrc.getIcon() == imgIcons[2] && selCom == 1 ) {
            res = "당신이 이겼습니다!";
            select imagePanel = new select();
            dispose();
         }
         else if(btnSrc.getIcon() == imgIcons[0] && selCom == 0 ||
                btnSrc.getIcon() == imgIcons[1] && selCom == 1 ||
                btnSrc.getIcon() == imgIcons[2] && selCom == 2 )
            res = "비겼습니다!!";
         else 
            res = "당신이 졌습니다...";
         
         result.output(btnSrc.getIcon(), imgIcons[selCom], res);
         
         
      }
      
   }

   
   
   
   public static void main(String[] args) {
      new kawibawibo();
   }
}