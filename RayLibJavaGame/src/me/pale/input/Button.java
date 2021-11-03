package me.pale.input;

import static com.raylib.Raylib.LoadSound;

import com.raylib.Jaylib.Color;
import com.raylib.Jaylib.Rectangle;
import com.raylib.Raylib;
import com.raylib.Raylib.*;

import me.pale.maths.Maths;

public class Button {
	
	Rectangle rect;
	float x, y, w, h;
	
	float ox, oy;
	
	String text;
	
	Sound overrideClick = null;
	
	float nx, ny;
	
	Sound click = LoadSound("./resources/sounds/click.wav");
	
	com.raylib.Raylib.Color c;
	
	public Button(String text, String overrideClick, float x, float y, float w, float h) {
		
		this.rect = new Rectangle();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.text = text;
		
		this.overrideClick = LoadSound(overrideClick);
		
	}
	
	public void draw(float ox, float oy) {
		
		colche();
		
		this.ox = ox;
		this.oy = oy;
		
		// nx = x + Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().x()/640));
		// ny = y + Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().y()/480));
		
		nx = x + ox;
		ny = y + oy;
		
		rect.x(nx);
		rect.y(ny);
		rect.width(w);
		rect.height(h);
		com.raylib.Raylib.DrawRectangleRec(rect, c);
		
		if (com.raylib.Raylib.IsMouseButtonPressed(0) && com.raylib.Raylib.GetMousePosition().x() >= nx && com.raylib.Raylib.GetMousePosition().x() <= nx + w && com.raylib.Raylib.GetMousePosition().y() <= ny + h && com.raylib.Raylib.GetMousePosition().y() >= ny || com.raylib.Raylib.IsMouseButtonReleased(0) && com.raylib.Raylib.GetMousePosition().x() >= nx && com.raylib.Raylib.GetMousePosition().x() <= nx + w && com.raylib.Raylib.GetMousePosition().y() <= ny + h && com.raylib.Raylib.GetMousePosition().y() >= ny) {
			
			Raylib.PlaySound(click);
			
		}
		
		com.raylib.Raylib.DrawTextRec(com.raylib.Jaylib.GetFontDefault(), text, rect, 28, 10, false, com.raylib.Jaylib.BLACK);
		
	}
	
	public boolean isClicked() {
		
		if (com.raylib.Raylib.IsMouseButtonDown(0) && com.raylib.Raylib.GetMousePosition().x() >= nx && com.raylib.Raylib.GetMousePosition().x() <= nx + w && com.raylib.Raylib.GetMousePosition().y() <= ny + h && com.raylib.Raylib.GetMousePosition().y() >= ny) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public void colche() {
		
		// System.out.println("Y: " + ny + ", X: " + nx + ", MX: " + com.raylib.Raylib.GetMousePosition().x() + ", MY: " + com.raylib.Raylib.GetMousePosition().y() + ", BY: " + ny+w + ", BX: " + nx+w);
		
		if (com.raylib.Raylib.GetMousePosition().x() >= nx && com.raylib.Raylib.GetMousePosition().x() <= nx + w && com.raylib.Raylib.GetMousePosition().y() <= ny + h && com.raylib.Raylib.GetMousePosition().y() >= ny) {
			
			// System.out.println("COL");
			c = com.raylib.Jaylib.WHITE;
			
		} else {
			
			c = new Color(222, 222, 222, 255);
			
		}
		
	}
	
	public void setX(float p) {
		
		x = p;
		
	}
	
	public void setY(float p) {
		
		y = p;
		
	}
	
	public float getX() {
		
		return x;
		
	}
	
	public float getY() {
		
		return y;
		
	}

}
