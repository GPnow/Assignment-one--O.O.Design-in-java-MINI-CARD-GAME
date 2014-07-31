package Cardgame;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 *
 * @author ral
 */
public class Card {
        private int x = 20;
	int y = 200;
	int xa = 3;
	private String name;
	private Cardgame game;

public Card(Cardgame game,int pos,String n)
{
    this.game=game;
    x=pos;
    name=n;
}
public String getname()
{       
 return name;   
}
boolean move(int newpos) {
	
if(x==newpos)
    return false;
if(x>newpos)
{   if(x>newpos+xa)
    {
        x=x-xa;
    }
    else x=newpos;
}
else
{
    if(x+xa<newpos)
    {
        x=x+xa;
        
    }
    else x=newpos;
}
return true;
}
public int getpos()
{
return x;   
}

public void paint(Graphics2D g) {
                g.setColor(Color.BLUE );
		g.fillRect(x, y, 60, 70);
                
	}
}
