package Cardgame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Cardgame extends JPanel {
        
        Card[] card=new Card[3];
        Cardgame(String[] full,int[] pos){
            card[0] = new Card(this,pos[0],full[0]);
            card[1] = new Card(this,pos[1],full[1]);
            card[2] = new Card(this,pos[2],full[2]);
         }
       private boolean kmove(int[] pos) {
           boolean[] boo=new boolean[3];
            boo[0]=card[0].move(pos[0]);
            boo[1]=card[1].move(pos[1]);
            boo[2]=card[2].move(pos[2]);
            return boo[0]||boo[1]||boo[2];
               }
     private void kgetpos(int[] pos) {
           
            pos[0]=card[0].getpos();
            pos[1]=card[1].getpos();
            pos[2]=card[2].getpos();
           
               }
        public void getcardname(String[] name)
        {
            for(int i=0;i<3;i++)
            {
                int pos=card[i].getpos();
                if(pos==20)name[0]=card[i].getname();
                if(pos==200)name[1]=card[i].getname();
                if(pos==380)name[2]=card[i].getname();
            }
               // return card[i].getpos();
          
        }
        
        public void swap(int id, int dest,int[] posarr)
        {
           int temp = posarr[id];
           posarr[id] = posarr[dest];
           posarr[dest] = temp; 
        
        }

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		card[0].paint(g2d);
                card[1].paint(g2d);
                card[2].paint(g2d);
	}

	public static void main(String[] args) throws InterruptedException {
       int choice;
       int[] a=new int[3];
       Random random=new Random();
       for(int i=0;i<3;i++)
        {
            a[i]=random.nextInt(52);
        }
        while(a[0]==a[1])
       {
           a[1]=random.nextInt(52);
       }
       while((a[0]==a[2])||(a[1]==a[2]))
       {
           a[2]=random.nextInt(52);
       }
        String[] full=new String[3];
        for(int i=0;i<3;i++)
        {
         choice=a[i]/13;
        switch(choice)
        {
            case 0:
                full[i]="Spade"+((a[i]%13)+1);
                break;
            case 1:
                full[i]="heart"+((a[i]%13)+1);
                break;
            case 2:
                full[i]="diamond"+((a[i]%13)+1);
                break;
            case 3:
                full[i]="club"+((a[i]%13)+1);
                break;
           
        }
        }
        System.out.println("cards in left to write order are");
        System.out.println();
        System.out.println("please note carefully");
        System.out.println();
        System.out.println(full[0]+" "+full[1]+" "+full[2]);
        
        System.out.println();
                int[] pos =new int[3];
                pos[0]=20;
                pos[1]=200;
                pos[2]=380;
                JFrame frame = new JFrame("Mini Cardgame");
		Cardgame game= new Cardgame(full,pos);
               
		frame.add(game);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int fi,sec,temp;
                int[] posarr=new int[3];
                int count;
                count=0;
                int correct=0;
                int incorrect=0;
                double score;
                double percent;
                
                //String player=in.nextLine();
                String[] name=new String[3];
                String[] realname=new String[3];
        Thread.sleep(4000);        
		while (true) {
			//game.kmove(pos,f);
                    if(count==10)
                    {
                        Scanner in=new Scanner(System.in);
                        count=0;
                        System.out.print("enter the Cards name left to right");
                        System.out.println();
                        System.out.print("PRESS enter after each name");
                        System.out.println();
                        for(int i=0;i<3;i++)
                        {
                        name[i]=in.nextLine();
                        }
                        game.getcardname(realname);
                        if((name[0].equals(realname[0]))&&(name[1].equals(realname[1]))&&(name[2].equals(realname[2])))
                            correct++;
                        else incorrect++;
                        score=(double)correct/((double)(correct)+(double)incorrect);
                        percent=score*100;
                         System.out.println("The correct answer is ");
                            System.out.println();
                          System.out.println(realname[0]+" "+realname[1]+" "+realname[2]);
                          System.out.println();
                        System.out.print("you current score is ");
                        System.out.print(percent+"percent");
                        System.out.println();
                        System.out.print("Do you wanna play again??type yes or no");
                        String decision=in.nextLine();
                        if(decision.equals("no")||decision.equals("No")||decision.equals("NO"))
                        {
                            System.out.println("GAME OVER");
                            System.out.println();
                            break;
                        }
                    }
                    fi=random.nextInt(3);
                    sec=random.nextInt(3);
                    while(fi==sec)
                    {
                      sec=random.nextInt(3);
                    }
                       game.kgetpos(posarr);
                       game.swap(fi, sec, posarr);
                       boolean c;
                       c=true;
                       while(c)
                       {
                        
                           c=game.kmove(posarr);
                        game.repaint();
			Thread.sleep(10);
                       }
                       count++;
		}
	}
}
