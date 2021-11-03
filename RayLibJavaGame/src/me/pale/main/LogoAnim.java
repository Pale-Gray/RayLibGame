package me.pale.main;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import com.raylib.Raylib.*;

import me.pale.maths.Maths;

public class LogoAnim {
	
	static Vector2 pos = new Vector2();
	static Rectangle rect = new Rectangle();
	static Texture logo = com.raylib.Raylib.LoadTexture("./resources/images/palegraylogo.png");
	
	static Sound logosound = Raylib.LoadSound("./resources/sounds/logosound.wav");
	
	static float TIME = 0;
	static int SOUND = 0;
	static int START = 1;
	static int TEXT = 0;
	
	public static void draw() {
		
		TIME += Raylib.GetFrameTime();
		
		Raylib.BeginDrawing();
		
		Raylib.ClearBackground(new Jaylib.Color(150, 150, 150, 255));
		
		pos.x((640/2)-(150/2));
		pos.y(Maths.CosLerp(500, ((480/2)-25)-(150/2), TIME/1));
		
		if (START == 1) {
			
			if (TIME >= 2) {
				
				SOUND = 1;
				
			}
			
			if (SOUND == 1) {
				
				Raylib.PlaySound(logosound);
				
				TEXT = 1;
				
				START = 0;
				
			}
			
		}
		
		if (TEXT == 1) {
			
			Raylib.DrawText("Pale_Gray", (int) ((640/2) - 78), 240+100, 30, Jaylib.BLACK);
			
		}
		
		Raylib.DrawTextureRec(logo.width(150).height(150), rect.width(150).height(150), pos, Jaylib.WHITE);
		
		Raylib.EndDrawing();
		
	}

}
