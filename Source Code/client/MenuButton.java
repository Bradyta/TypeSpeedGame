package client;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class MenuButton
{
	private Image button = null;
	private Image litButton = null;
	private Font buttonFont;
	private TrueTypeFont buttonText;
	private String text;
	private boolean entered = false, clicked = false;
	private int x, y, textWidth;
	
	public MenuButton(String str, int y) throws SlickException
	{
		this.text = str;
		this.y = y;
		button = new Image("res/button.png");
		litButton = new Image("res/button_lit.png");
		textWidth = 290;
		x = (GameClient.WIDTH - button.getWidth()) / 2;
		this.buttonFont = new Font("Calibri", Font.BOLD, 32);
		this.buttonText = new TrueTypeFont(buttonFont, true);
	}
	
	public boolean getEntered(){return entered;}
	public boolean getClicked(){return clicked;}
	public void setEntered(boolean entered){this.entered = entered;}
	public void setClicked(boolean clicked){this.clicked = clicked;}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		Input input = gc.getInput();
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		
		if((mouseX > x && mouseX < x + button.getWidth()) && (mouseY > y && mouseY < y + button.getHeight()))
			entered = true;
		else
			entered = false;
		
		if(entered && input.isMouseButtonDown(0))
			clicked = true;
		else
			clicked = false;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		if(entered)
			button.draw(x, y);
		else 
			litButton.draw(x, y);
		buttonText.drawString(x + (textWidth - button.getWidth()), y + 30, text, Color.gray);
	}
}
