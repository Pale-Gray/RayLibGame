package me.pale.main;

import static com.raylib.Raylib.*;

public class Main {
	
	static float FRAMETIME = 0;

	public static void main(String[] args) {

		InitWindow(640, 480, "Demo");
		
		InitAudioDevice();
		
        SetTargetFPS(60);

        while (!WindowShouldClose()) {
        	
        	FRAMETIME += GetFrameTime();
        	
        	if (FRAMETIME < 5) {
        		
        		LogoAnim.draw();
        		
        	}
        	if (FRAMETIME > 5) {
        		
        		MainMenu.draw();
        		
        	}
        	
        }
        
        CloseAudioDevice();
        
        UnloadSound(MainMenu.rain);
        UnloadSound(MainMenu.thunder);
        UnloadTexture(MainMenu.rainTexture);
        UnloadTexture(MainMenu.playerTexture);
        
        CloseWindow();

	}

}
