import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Tic extends JFrame implements ActionListener{
	JFrame f;
	JButton b[]=new JButton[9];
	String bt[]=new String[9];
	JLabel l=new JLabel("l");
	int count=0;
	JOptionPane pop=new JOptionPane();
	JPanel p1,p2;
	JLabel lab1,lab2;
	JButton comp,play,re;
	int player=0,computer=0;

	Tic(){
		f=new JFrame();
		p1=new JPanel();
		p2=new JPanel();
		lab1=new JLabel("choose opponent:");
		comp=new JButton("computer");
		play=new JButton("2 players");
		comp.addActionListener(this);
		play.addActionListener(this);
		re=new JButton("RESTART");
		re.addActionListener(this);
		re.setBounds(0,100,300,50);
		p1.add(lab1);p1.add(comp);p1.add(play);
		for(int i=0;i<9;i++){
			b[i]=new JButton("");
			b[i].addActionListener(this);
			b[i].setBackground(Color.DARK_GRAY);
			//b[i].setground(Color.DARK_GRAY);
			b[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
			p2.add(b[i]);
		}
		p1.setLayout(new GridLayout(3,1));;
		p2.setLayout(new GridLayout(3,3));
		f.add(p1);//f.add(p2);
		
		f.setLayout(new GridLayout(1,1));
		f.setSize(300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);	
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==play){
			f.add(p2);
			p2.setVisible(true);
			lab1.setText("2 player mode");
			comp.setVisible(false);
			play.setVisible(false);
			re.setVisible(true);
			p1.remove(comp);
			p1.remove(play);
			p1.add(re);
			f.setSize(300,600);
			f.setLayout(new GridLayout(2,1));
			player++;
			return;
		}
		if(e.getSource()==re){
			lab1.setText("choose opponent:");
			p2.setVisible(false);
			f.remove(p2);
			re.setVisible(false);
			comp.setVisible(true);
			play.setVisible(true);
			p1.remove(re);
			p1.add(comp);
			p1.add(play);
			return;
		}
		if(e.getSource()==comp){
			f.add(p2);
			p2.setVisible(true);
			lab1.setText("computer is your opponent");
			comp.setVisible(false);
			play.setVisible(false);
			re.setVisible(true);
			p1.remove(comp);
			p1.remove(play);
			p1.add(re);
			f.setSize(300,600);
			f.setLayout(new GridLayout(2,1));
			computer++;
			return;
		}
		if(player>0){
			if(count%2==0){
				for(int i=0;i<9;i++){
					if(e.getSource()==b[i]){
						b[i].setText("X");
						b[i].setForeground(new Color(255,255,0));
						bt[i]="X";
					}
				}
			}
			if(count%2!=0){
				for(int i=0;i<9;i++){
					if(e.getSource()==b[i]){
						b[i].setText("O");
						b[i].setForeground(new Color(51,204,255));
						bt[i]="O";
					}
				}
			}
			count++;
			Ai a=new Ai();
			a.minimax();
		}

		if(computer>0){

		}

		if(hasXWon()){
			JOptionPane.showMessageDialog(f, "X has won");
			return;
		}
		else if(hasOWon()){
			JOptionPane.showMessageDialog(f, "O has won");
			return;
		}
		if(count==9){
			JOptionPane.showMessageDialog(f, "its a draw!");
			return;
		}

		

	}

	public boolean hasXWon() {
        if ((bt[0] == bt[4] && bt[0] == bt[8] && bt[0] == "X") || (bt[2] == bt[4] && bt[2] == bt[6] && bt[2] == "X")
        			||(bt[0] == bt[1] && bt[0] == bt[2] && bt[0] == "X")||(bt[0] == bt[3] && bt[0] == bt[6] && bt[0] == "X")
        				||(bt[1] == bt[4] && bt[1] == bt[7] && bt[1] == "X")||(bt[2] == bt[5] && bt[2] == bt[8] && bt[2] == "X")
        					||(bt[3] == bt[4] && bt[3] == bt[5] && bt[3] == "X")||(bt[6] == bt[7] && bt[6] == bt[8] && bt[6] == "X")) {
            //System.out.println("X Diagonal Win");
            return true;
        }
        
        return false;
    }

    public boolean hasOWon() {
        if ((bt[0] == bt[4] && bt[0] == bt[8] && bt[0] == "O") || (bt[2] == bt[4] && bt[2] == bt[6] && bt[2] == "O")
        			||(bt[0] == bt[1] && bt[0] == bt[2] && bt[0] == "O")||(bt[0] == bt[3] && bt[0] == bt[6] && bt[0] == "O")
        				||(bt[1] == bt[4] && bt[1] == bt[7] && bt[1] == "O")||(bt[2] == bt[5] && bt[2] == bt[8] && bt[2] == "O")
        					||(bt[3] == bt[4] && bt[3] == bt[5] && bt[3] == "O")||(bt[6] == bt[7] && bt[6] == bt[8] && bt[6] == "O")) {
            //System.out.println("X Diagonal Win");
            return true;
        }
        return false;
    }


	public static void main(String args[]){
		new Tic();
	}
} 

class Ai{
	String but[][]=new String[3][3];
	Tic tac=new Tic();
	ArrayList<Integer> score=new ArrayList<Integer>();
	public int minimax(){
		int i=0;
			for(int j=0;j<3;j++){
				for(int k=0;k<3;k++){
					but[j][k]=tac.bt[i];
					i++;
					System.out.println(but[j][k]);
				}
			}			
		
		return 0;
	}
}





