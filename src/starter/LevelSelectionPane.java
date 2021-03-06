package starter;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
//level select
public class LevelSelectionPane extends GraphicsPane {
	private MainApplication program;
	private static final String IMAGES[]= {"example_back.jpg","portMapMain.png", "menu_back_arrow.png","highlight.png", "forestMap.jpg", "maps/BeachMap/beachMapMain.png"};
	private GImage arena1,arena2,arena3, arena4, backArrow,highlight;
	private GButton fight;
	private Background back_Ground;
	private int choice=1;
	private Level LEVEL_DANIEL;
	private Level LEVEL_MIGUEL;
	private Level LEVEL_MIGUEL1;
	private Level LEVEL_MIGUEL2;
	public LevelSelectionPane(MainApplication app )
	{
		this.program=app;
		arena1=new GImage(IMAGES[0],100,100);
		arena1.setSize(300, 200);
		arena2=new GImage(IMAGES[1],700,100);
		arena2.setSize(300, 200);
		arena3=new GImage(IMAGES[4],100,320);
		arena3.setSize(300, 200);
		arena4 = new GImage(IMAGES[5], 700, 320);
		arena4.setSize(300, 200);
		backArrow=new GImage(IMAGES[2],0,0);
		backArrow.setSize(80,80);
		fight=new GButton("Fight",435,265,200,100);
		fight.setFillColor(Color.RED);
		highlight=new GImage(IMAGES[3],80,80);
		highlight.setSize(340 ,240);
		choice=1;
		back_Ground=program.background;	
		LEVEL_DANIEL=new Level(1,arena1);
		LEVEL_MIGUEL=new Level(2,arena2);
		LEVEL_MIGUEL1=new Level(3,arena3);
		LEVEL_MIGUEL2 = new Level(4,arena4);
	}
	
	public void resetArena()
	{
		arena1.setLocation(100,100);
		arena1.setSize(300, 200);
		arena2.setLocation(700, 100);
		arena2.setSize(300, 200);
		arena3.setLocation(100, 320);
		arena3.setSize(300, 200);
		arena4.setSize(300, 200);
		arena4.setLocation(700,320);
	}
	@Override
	public void showContents() {
		resetArena();
		program.add(back_Ground.getImage());
		program.add(arena1);
		program.add(arena2);
		program.add(arena3);
		program.add(arena4);
		program.add(backArrow);
		program.add(fight);
		program.add(highlight);
	}

	@Override
	public void hideContents() {
		program.remove(back_Ground.getImage());
		program.remove(arena1);
		program.remove(arena2);
		program.remove(arena3);
		program.remove(arena4);
		program.remove(backArrow);
		program.remove(fight);
		program.remove(highlight);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == backArrow) {
			choice=0;
			program.remove(highlight);
			program.switchToMenu();
		}
		if(obj==arena1)
		{
			choice=1;
			System.out.println(choice);
			program.remove(back_Ground.getImage());
			program.remove(highlight);
			highlight=new GImage(IMAGES[3],80,80);
			highlight.setSize(340 ,240);
			program.add(highlight);
			back_Ground=program.background;
			program.add(back_Ground.getImage());
			showContents();
		}
		if(obj==arena2)
		{
			choice=2;
			System.out.println(choice);
			program.remove(back_Ground.getImage());
			program.remove(highlight);
		
			highlight=new GImage(IMAGES[3],680,80);
			highlight.setSize(340 ,240);
			program.add(highlight);
			back_Ground=program.backgroundPort;
			program.add(back_Ground.getImage());
			showContents();
		}
		if(obj==arena3)
		{
			choice=3;
			System.out.println(choice);
			program.remove(back_Ground.getImage());
			program.remove(highlight);
		
			highlight=new GImage(IMAGES[3],80,300);
			highlight.setSize(340 ,240);
			program.add(highlight);
			back_Ground=program.backgroundForest;
			program.add(back_Ground.getImage());
			showContents();
		}
		
		if(obj==arena4)
		{
			choice=4;
			System.out.println(choice);
			program.remove(back_Ground.getImage());
			program.remove(highlight);
		
			highlight=new GImage(IMAGES[3],680,300);
			highlight.setSize(340 ,240);
			program.add(highlight);
			back_Ground=program.backgroundBeach;
			program.add(back_Ground.getImage());
			showContents();
		}
		if(obj==fight)
		{	
			checkChoice();
		}
	}
	public void checkChoice()
	{
		switch(choice)
		{
		case 1:
			program.getGamePane().set_Choice(LEVEL_DANIEL);
			program.switchToCharacterPane();
			break;
		case 2:
			program.getGamePane().set_Choice(LEVEL_MIGUEL);
			program.switchToCharacterPane();
			break;
		case 3:
			program.getGamePane().set_Choice(LEVEL_MIGUEL1);
			program.switchToCharacterPane();
			break;
		case 4:
			program.getGamePane().set_Choice(LEVEL_MIGUEL2);
			program.switchToCharacterPane();
			break;
		}
	}
}
