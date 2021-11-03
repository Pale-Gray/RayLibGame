package me.pale.maths;

public class Maths {
	
	static float s = 0;
	
	public static float CosLerp(float p1, float p2, float f) {
		
		float f2 = (float) (1 - Math.cos(f*Math.PI))/2;
		
		if (f < 1) {
			
			return (p1 * (1-f2) + p2 * f2);
			
		} else if (f < 0){
			
			return p1;
			
		} else {
			
			return p2;
			
		}
		
	}

	public static float Lerp(float p1, float p2, float f) {
		
		if (f > 1) {
			
			return p2;
			
		} else
		if (f < 0) {
			
			return p1;
			
		} else {
			
			return (p1 + (p2 - p1) * f);
			
		}
		
	}
	
	private static void refresh() {
		
		s = 0;
		
	}
	
}
