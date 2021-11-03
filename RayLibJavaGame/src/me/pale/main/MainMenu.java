package me.pale.main;

import static com.raylib.Raylib.BeginDrawing;
import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.DrawRectangleV;
import static com.raylib.Raylib.DrawTextureRec;
import static com.raylib.Raylib.EndDrawing;
import static com.raylib.Raylib.GetFrameTime;
import static com.raylib.Raylib.GetMousePosition;
import static com.raylib.Raylib.GetTime;
import static com.raylib.Raylib.IsSoundPlaying;
import static com.raylib.Raylib.LoadSound;
import static com.raylib.Raylib.LoadTexture;
import static com.raylib.Raylib.PlaySound;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import com.raylib.Jaylib;
import com.raylib.Jaylib.Color;
import com.raylib.Raylib;
import com.raylib.Raylib.Rectangle;
import com.raylib.Raylib.Sound;
import com.raylib.Raylib.Texture;
import com.raylib.Raylib.Vector2;

import me.pale.input.Button;
import me.pale.maths.Maths;

public class MainMenu {
	
	int d = 128;
	
	static Vector2 mp;
	
	static Sound rain = LoadSound("./resources/sounds/rainfall.wav");
	static Sound thunder = LoadSound("./resources/sounds/thunder4.wav");
	
	static Texture playerTexture = LoadTexture("./resources/images/CHARACTER/PLAYER_MENU_ANIM-Sheet.png");
	static Rectangle playerRectangle = new Rectangle();
	
	static Texture rainTexture = LoadTexture("./resources/images/rain.png");
	static Rectangle rainRectangle = new Rectangle();
	
static float px, py = 0;
	
	static float ay, vy, my, speed;
	
	static boolean isGravity = false;
	
	static float t = 0;
	static float o = 0.02f;
	
	static float rx = 0, ry = 0;
	
	static Vector2 playerPos = new Vector2();
	
	static Vector2 pos = new Vector2();
	
	static float w = 60;
	
	static float a = 480/3 - (w/2);
	
	static Button play = new Button("Play", null, 115, a, 200, w);
	static Button options = new Button("Options", null, 115, a+75, 200, w);
	static Button quit = new Button("Quit", null, 115, a+75+75, 200, w);
	
	static Button back = new Button("Back", null, 10, -100, 200, w);
	
	static Button credits = new Button("Credits", null, 10, -100, 200, w);
	
	static float timer = 0;
	static float timer2 = 0;
	
	static Random r = new Random();
	static int rn = (int) ((r.nextFloat() * 10) + 6);
	
	static Vector2 rainPos = new Vector2();
	
	static Color flashColor = new Color(255, 255, 255, 0);
	static Color fadeColor = new Color(0, 0, 0, 0);
	
	static int flashdelay;
	
	static int m = 10;
	
	
	static int BUTTONTRIG = 0;
	
	static int QUIT = 0;
	
	static float playF = 0;
	static float quitF = 0;
	
	static File creditsfile = new File("./resources/sounds/credits.txt");
	
	static String creditstext = "Made by Pale_Gray.";
	
	static float rectX = 10, rectY = -100;
	
	
	
	static Texture title = LoadTexture("./resources/images/TITLE/TITLE_SHEET.png");
	
	static Rectangle titleRect = new Rectangle();
	
	static Vector2 titlePos = new Vector2();
	
	static float playerF = 0;
	static float playerIndex = 0;
	
	static float staticF = 0;
	static float staticIndex = 0;
	
	
	public static void draw() {
		
		if (!IsSoundPlaying(rain)) {
    		
    		PlaySound(rain);
    		
    	}
    	
    	timer2 = (float) GetTime();
    	timer += (float) GetFrameTime();
    	
    	if (flashdelay == 1) {
    		
    		flashColor.a((byte) (Maths.Lerp(255, 0, timer/3)));
    		
    	}

    	if (timer > rn) {
    		
    		Raylib.SetSoundPitch(thunder, r.nextFloat() * 10 < 5 ? 1 : 0.9f);
    		PlaySound(thunder);
    		GetTime();
    		timer = 0;
    		rn = (int) ((r.nextFloat() * 10) + 6);
    		flashdelay = 1;
    		
    	}
    	
    	mp = new Vector2().x(GetMousePosition().x() / 640).y(GetMousePosition().y() / 480);
        
    	BeginDrawing();
    	
    		ClearBackground(new Jaylib.Color(255/m, 255/m, 255/m, 255));
    		
    		// System.out.println("X: " + mp.x() + ", Y: " + mp.y());
    		
    		int i = 15;
    		
    		pos.x(((640/3 * 2)-(250/4)) + Maths.Lerp(-i, i, mp.x()));
    		pos.y((240 - (250/2)) + Maths.Lerp(-i, i, mp.y()));
    		
    		DrawRectangleV(new Vector2().x(0).y(0), new Vector2().x(640).y(480), flashColor);
    		
    		// DrawRectangleV(pos, new Vector2().x(150).y(150), Jaylib.RAYWHITE);
    		playerF += GetFrameTime();
    		
    		if (playerF > 0.100f) {
    			
    			playerF = 0;
    			playerIndex += 1;
    			
    			if (playerIndex > 8) {
    				
    				playerIndex = 0;
    				
    			}
    			
    		}
    		
    		DrawTextureRec(playerTexture.width(250*8).height(250), playerRectangle.width(250).height(250).x(250*playerIndex).y(0), pos, Jaylib.WHITE);
    		
    		// DrawRectangleV(rainPos, new Vector2().x(640).y(480), Jaylib.WHITE);
    		
    		rx+=6;
    		if (rx > 640) {
    			rx=0;
    		}
    		ry+=6;
    		if (ry > 640) {
    			ry=0;
    		}
    		rainPos.x(-640+rx);
    		rainPos.y(-640+ry);
    		
    		DrawTextureRec(rainTexture.width((640*5)).height((640*5)), rainRectangle.width(640*3).height(640*3), rainPos, Jaylib.WHITE);
    		
    		float d = 3.25f;
    		
    		titlePos.x((0 + ((640 - (128*d))) / 2) + (Maths.Lerp(-2, 2, (com.raylib.Raylib.GetMousePosition().x()/640))));
    		titlePos.y((15) + (Maths.Lerp(-2, 2, (com.raylib.Raylib.GetMousePosition().y()/640)))); 
    		
    		// System.out.println(title.width());
    		
    		staticF += GetFrameTime();
    		
    		if (staticF > 0.100f) {
    			
    			staticF = 0;
    			staticIndex += 1;
    			
    		}
    		
    		if (staticIndex > 3) {
				
				staticIndex = 0;
				
			}
    		
    		DrawTextureRec(title.width((int) (128*d)).height((int) (24*d) * 4), titleRect.width(128*d).height(24*d).y(0 + (24*d) * staticIndex), titlePos, Jaylib.WHITE);
    		
    		// DrawTextureRec(staticTex.width((int) ((16*4)*d)).height((int) (16*d)), staticRect.width(16*d).height(16*d).x(0 + ((16 * d) * staticIndex) ), staticPos, new Color(255, 255, 255, 125));
    		
    		if (play.isClicked() || options.isClicked()) {
    			
    			if (options.isClicked()) {
    				
    				BUTTONTRIG = 3;
    				
    			} else {
    				
    				BUTTONTRIG = 1;
    				
    			}
    			playF = 0;
    			
    		}
    		
    		if (quit.isClicked()) {
    			
    			quitF = 0;
    			QUIT = 1;
    			
    		}
    		
    		if (QUIT == 1) {
    			
    			quitF += GetFrameTime();
    			
    			fadeColor.a((byte) Maths.Lerp(0, 255, quitF/1f));
    			
    			if (quitF > 1) {
    				
    				System.exit(0);
    				
    			}
    			
    		}
    		
    		if (BUTTONTRIG == 4) {
    			
    			playF += GetFrameTime();
    			
    			play.setY(Maths.CosLerp(650, a, playF / 1));
    			options.setY(Maths.CosLerp(650, a+75, playF / 1));
    			quit.setY(Maths.CosLerp(650, a+75+75, playF / 1));
    			
    			credits.setY(Maths.CosLerp(10+75, -100, playF / 1));
    			
    			rectY = Maths.CosLerp(10+75+75, -100, playF/1);
    			
    			back.setY(Maths.CosLerp(10, -100, playF/1));
    			
    		}
    		
    		if (BUTTONTRIG == 2) {
    			
    			playF += GetFrameTime();
    			
    			play.setY(Maths.CosLerp(650, a, playF / 1));
    			options.setY(Maths.CosLerp(650, a+75, playF / 1));
    			quit.setY(Maths.CosLerp(650, a+75+75, playF / 1));
    			
    			// credits.setY(Maths.CosLerp(10+75, -100, playF / 1));
    			
    			back.setY(Maths.CosLerp(10, -100, playF/1));
    			
    		}
    		
    		if (BUTTONTRIG == 3) {
    			
    			playF += GetFrameTime();
    			
    			play.setY(Maths.CosLerp(a, 650, playF / 1));
    			options.setY(Maths.CosLerp(a+75, 650, playF / 1));
    			quit.setY(Maths.CosLerp(a+75+75, 650, playF / 1));
    			
    			rectY = Maths.CosLerp(-100, 10+75+75, playF/1);
    			
    			back.setY(Maths.CosLerp(-100, 10, playF/1));
    			credits.setY(Maths.CosLerp(-100, 10+75, playF/1));
    			
    		}
    		
    		if (BUTTONTRIG == 1) {
    			
    			playF += GetFrameTime();
    			
    			play.setY(Maths.CosLerp(a, 650, playF / 1));
    			options.setY(Maths.CosLerp(a+75, 650, playF / 1));
    			quit.setY(Maths.CosLerp(a+75+75, 650, playF / 1));
    			
    			back.setY(Maths.CosLerp(-100, 10, playF/1));
    			// credits.setY(Maths.CosLerp(-100, 10+75, playF/1));
    			
    		}
    		
    		if (back.isClicked()&& BUTTONTRIG == 3) {
    				
    				playF = 0;
    				BUTTONTRIG = 4;
    			
    		}
    		
    		if (back.isClicked() && BUTTONTRIG == 1) {
    			
    			playF = 0;
				BUTTONTRIG = 2;
    			
    		}
    		
    		if (credits.isClicked()) {

    			System.out.println("INPROGRESS");
    			
    		}
    		
    		Raylib.DrawTextRec(com.raylib.Jaylib.GetFontDefault(), creditstext, new Rectangle().x(rectX+Maths.Lerp(-3, 3, (com.raylib.Raylib.GetMousePosition().x()/640))).y(rectY+Maths.Lerp(-3, 3, (com.raylib.Raylib.GetMousePosition().y()/480))).width(640).height(480), 28, 10, false, com.raylib.Jaylib.WHITE);
    		
    		credits.draw(Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().x()/640)), Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().y()/480)));
    		
    		back.draw(Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().x()/640)), Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().y()/480)));
    		play.draw(Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().x()/640)), Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().y()/480)));
    		options.draw(Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().x()/640)), Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().y()/480)));
    		quit.draw(Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().x()/640)), Maths.Lerp(-5, 5, (com.raylib.Raylib.GetMousePosition().y()/480)));
    		
    		// DrawTextureRec(playerTexture.width(d).height(d), playerRectangle.width(d).height(d), playerPos, com.raylib.Jaylib.WHITE);
    		DrawRectangleV(new Vector2().x(0).y(0), new Vector2().x(640).y(480), fadeColor);
    		
    	EndDrawing();
		
	}

}
