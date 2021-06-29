import java.awt.*;
import java.awt.Font.*;
import java.awt.event.*;
import javax.swing.*;
class TicTac implements ActionListener
{
   JFrame f;
   JPanel p1;
   char player='X';
   JButton b1;JButton b2;JButton b3;JButton b4;JButton b5;JButton b6;JButton b7;JButton b8;JButton b9;
   JMenuBar mb;
   JMenu menu,choose,score;
   JMenu submenu;
   JMenuItem newgame,quit,red,yellow,blue,playX,playO,scoreView;
   boolean hasWinner;

   int countX=0,countO=0,tie=0;

  TicTac()
  {
     f=new JFrame("TIC TAC TOE");
     mb=new JMenuBar();
     menu =new JMenu("File");
     newgame=new JMenuItem("New Game");
     newgame.addActionListener(this);
     quit=new JMenuItem("Quit");
     quit.addActionListener(this);
     submenu=new JMenu("Background Colours");
     red=new JMenuItem("Red");
     blue=new JMenuItem("Blue");
     yellow=new JMenuItem("Yellow");
     
     red.addActionListener(this);blue.addActionListener(this);yellow.addActionListener(this);
     

     choose=new JMenu("Player");
     playX=new JMenuItem("Player X");
     playO=new JMenuItem("Player O");
     playX.addActionListener(this);
     playO.addActionListener(this);

     score=new JMenu("Score board");
     scoreView=new JMenuItem("View score board");
     scoreView.addActionListener(this);
     score.add(scoreView);


    b1=new JButton("");b2=new JButton("");b3=new JButton("");b4=new JButton("");b5=new JButton("");b6=new JButton("");
    b7=new JButton("");b8=new JButton("");b9=new JButton("");
    p1=new JPanel();
    p1.setLayout(new GridLayout(3,3));
    p1.add(b1);p1.add(b2);p1.add(b3);p1.add(b4);p1.add(b5);p1.add(b6);p1.add(b7);p1.add(b8);p1.add(b9);
    menu.add(newgame);
    submenu.add(blue);submenu.add(red);submenu.add(yellow);
    menu.add(submenu);
    menu.add(quit);
    choose.add(playX);choose.add(playO);
    f.add(p1);
    f.setVisible(true);
    f.setSize(400,400);
    mb.add(menu);mb.add(choose);mb.add(score);
    f.setJMenuBar(mb);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    b1.addActionListener(this);b2.addActionListener(this);
    b3.addActionListener(this);b4.addActionListener(this);
    b5.addActionListener(this);b6.addActionListener(this);
    b7.addActionListener(this);b8.addActionListener(this);
    b9.addActionListener(this);

  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==playX){
      player='X';
    }
    if(e.getSource()==playO){
      player='O';
    }
    if(e.getSource()==scoreView){
      JOptionPane.showMessageDialog(f,"player X : "+countX+"\nplayer O : "+countO);
    }
    if(e.getSource()==b1)//to find which button was clicked
    {
      Font f1=new Font(Font.SANS_SERIF,Font.BOLD,100);
      b1.setFont(f1);
      b1.setText(Character.toString(player));
      check_win();
      if(hasWinner==false)
      {
       flip_player();
       b1.setEnabled(false);//so that the button cannot be clicked again
      }
      else
      {
        b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);
        b6.setEnabled(false);b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);
      }

    }
    if(e.getSource()==b2)
    {
      Font f1=new Font(Font.SANS_SERIF,Font.BOLD,100);
      b2.setFont(f1);
      b2.setText(Character.toString(player));
      check_win();
      if(hasWinner==false)
      {
      flip_player();
      b2.setEnabled(false);
     }
     else
     {
       b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);
       b6.setEnabled(false);b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);
     }

    }
    if(e.getSource()==b3)
    {
      Font f1=new Font(Font.SANS_SERIF,Font.BOLD,100);
      b3.setFont(f1);
      b3.setText(Character.toString(player));
      check_win();
      if(hasWinner==false)
      {
       flip_player();
       b3.setEnabled(false);
     }
     else
     {
       b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);
       b6.setEnabled(false);b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);
     }

    }
    if(e.getSource()==b4)
    {
      Font f1=new Font(Font.SANS_SERIF,Font.BOLD,100);
      b4.setFont(f1);
      b4.setText(Character.toString(player));
      check_win();
      if(hasWinner==false)
      {
       flip_player();
       b4.setEnabled(false);
     }
     else
     {
       b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);
       b6.setEnabled(false);b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);
     }

    }
    if(e.getSource()==b5)
    {
      Font f1=new Font(Font.SANS_SERIF,Font.BOLD,100);
      b5.setFont(f1);
      b5.setText(Character.toString(player));
      check_win();
      if(hasWinner==false)
      {
      flip_player();
      b5.setEnabled(false);
    }
    else
    {
      b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);
      b6.setEnabled(false);b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);
    }

    }
    if(e.getSource()==b6)
    {
      Font f1=new Font(Font.SANS_SERIF,Font.BOLD,100);
      b6.setFont(f1);
      b6.setText(Character.toString(player));
      check_win();
      if(hasWinner==false)
      {
      flip_player();
      b6.setEnabled(false);
    }
    else
    {
      b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);
      b6.setEnabled(false);b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);
    }
    }

    if(e.getSource()==b7)
    {
      Font f1=new Font(Font.SANS_SERIF,Font.BOLD,100);
      b7.setFont(f1);
      b7.setText(Character.toString(player));
      check_win();
      if(hasWinner==false)
      {
      flip_player();
      b7.setEnabled(false);
    }
    else
    {
      b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);
      b6.setEnabled(false);b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);
    }

    }
    if(e.getSource()==b8)
    {
      Font f1=new Font(Font.SANS_SERIF,Font.BOLD,100);
      b8.setFont(f1);
      b8.setText(Character.toString(player));
      check_win();
      if(hasWinner==false)
      {
      flip_player();
      b8.setEnabled(false);
    }
    else
    {
      b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);
      b6.setEnabled(false);b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);
    }

    }
    if(e.getSource()==b9)
    {
      Font f1=new Font(Font.SANS_SERIF,Font.BOLD,100);
      b9.setFont(f1);
      b9.setText(Character.toString(player));
      check_win();
      if(hasWinner==false)
      {
      flip_player();
      b9.setEnabled(false);
    }
    else
    {
      b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);
      b6.setEnabled(false);b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);
    }

    }
    if(e.getSource()==newgame)
    {
      hasWinner=false;
      b1.setEnabled(true);b2.setEnabled(true);b3.setEnabled(true);b4.setEnabled(true);b5.setEnabled(true);b6.setEnabled(true);
      b7.setEnabled(true);b8.setEnabled(true);b9.setEnabled(true);
      b1.setText("");b2.setText("");b3.setText("");b4.setText("");b5.setText("");b6.setText("");b7.setText("");b8.setText("");b9.setText("");

    }
    if(e.getSource()==quit)
    {
      System.exit(0);
    }

    JButton array[]={b1,b2,b3,b4,b5,b6,b7,b8,b9};

    if(e.getSource()==red)
    {
      for(JButton button:array){
        button.setBackground(Color.RED);
      }
    }
    if(e.getSource()==blue)
    {
      for(JButton button:array){
        button.setBackground(Color.blue);
      }
    }
    if(e.getSource()==yellow)
    {
      for(JButton button:array){
        button.setBackground(Color.yellow);
      }
    }
  }
  void flip_player()
  {
    if(player=='X')
     player='O';
    else if(player=='O')
      player='X';
  }
  void check_win()
  {
    check_rows();
    if(hasWinner==false)
    check_columns();
    if(hasWinner==false)
    check_diag();
    if(hasWinner==false)
    check_tie();
  }
  void check_rows()
  {
    if(b1.getText().equals("X")&&b2.getText().equals("X")&&b3.getText().equals("X")||b4.getText().equals("X")&&b5.getText().equals("X")&&b6.getText().equals("X")||
    b7.getText().equals("X")&&b8.getText().equals("X")&&b9.getText().equals("X"))
    {
      hasWinner=true;
      countX++;
      JOptionPane.showMessageDialog(f,"X wins");

    }
   else if(b1.getText().equals("O")&&b2.getText().equals("O")&&b3.getText().equals("O")||b4.getText().equals("O")&&b5.getText().equals("O")&&b6.getText().equals("O")||
   b7.getText().equals("O")&&b8.getText().equals("O")&&b9.getText().equals("O"))
   {
     hasWinner=true;
     countO++;
     JOptionPane.showMessageDialog(f,"O wins");

   }

  }
  void check_columns()
  {
    if(b1.getText().equals("X")&&b4.getText().equals("X")&&b7.getText().equals("X")||b2.getText().equals("X")&&b5.getText().equals("X")&&b8.getText().equals("X")||
    b3.getText().equals("X")&&b6.getText().equals("X")&&b9.getText().equals("X"))
    {
      hasWinner=true;
      countX++;
      JOptionPane.showMessageDialog(f,"X wins");

    }
   else if(b1.getText().equals("O")&&b4.getText().equals("O")&&b7.getText().equals("O")||b2.getText().equals("O")&&b5.getText().equals("O")&&b8.getText().equals("O")||
   b3.getText().equals("O")&&b6.getText().equals("O")&&b9.getText().equals("O"))
   {
     hasWinner=true;
     countO++;
     JOptionPane.showMessageDialog(f,"O wins");
    ;
   }

  }
  void check_diag()
  {
    if(b1.getText().equals("X")&&b5.getText().equals("X")&&b9.getText().equals("X")||b3.getText().equals("X")&&b5.getText().equals("X")&&b7.getText().equals("X"))
    {
      hasWinner=true;
      countX++;
      JOptionPane.showMessageDialog(f,"X wins");

    }
   else if(b1.getText().equals("O")&&b5.getText().equals("O")&&b9.getText().equals("O")||b3.getText().equals("O")&&b5.getText().equals("O")&&b7.getText().equals("O"))
   {
     hasWinner=true;
     countO++;
     JOptionPane.showMessageDialog(f,"O wins");

   }

  }
  void check_tie()
  {
    if((b1.getText().equals("X")||b1.getText().equals("O"))&&(b2.getText().equals("X")||b2.getText().equals("O"))&&(b3.getText().equals("X")||b3.getText().equals("O"))&&
    (b4.getText().equals("X")||b4.getText().equals("O"))&&(b5.getText().equals("X")||b5.getText().equals("O"))&&(b6.getText().equals("X")||b6.getText().equals("O"))&&
    (b7.getText().equals("X")||b7.getText().equals("O"))&&(b8.getText().equals("X")||b8.getText().equals("O"))&&(b9.getText().equals("X")||b9.getText().equals("O")))
    {
      hasWinner=true;
      tie++;
      JOptionPane.showMessageDialog(f,"Match Tied");
    }
  }
 public static void main(String args[])
  {
    new TicTac();

  }

}
