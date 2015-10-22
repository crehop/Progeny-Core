package game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;

public class Effects {
	static ImmediateModeRenderer20 lineRenderer = new ImmediateModeRenderer20(false, true, 0);
	static int spacingH = 10;
	static int spacingW = 10;
	public static void line(float x1, float y1, float z1,
	                        float x2, float y2, float z2,
	                        float r, float g, float b, float a) {
	    lineRenderer.color(r, g, b, a);
	    lineRenderer.vertex(x1, y1, z1);
	    lineRenderer.color(r, g, b, a);
	    lineRenderer.vertex(x2, y2, z2);
	}
}
