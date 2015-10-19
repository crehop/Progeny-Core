package entities;

import game.Location;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class Poly extends RenderBody{
	float[] vertices;
	Location location;
	
	public Poly(Vector2[] vertices, Location location){
		this.location = location;
		this.vertices = new float[vertices.length * 2];
		int count = 0;
		for(int i = 1; i<vertices.length;i++){
			this.vertices[count] = vertices[i].x;
			count++;
			this.vertices[count] = vertices[i].y;
			count++;
		}
	}
	
	@Override
	public void render(ShapeRenderer sr, OrthographicCamera cam) {
		sr.begin(ShapeType.Line);
		sr.polygon(vertices);
		sr.end();
	}

	public void setLocation(Location location2) {
		this.location = location2;
	}

	public void setVertices(Vector2[] vertices) {
		this.vertices = new float[vertices.length * 2];
		int count = 0;
		for(int i = 1; i<vertices.length;i++){
			this.vertices[count] = vertices[i].x;
			count++;
			this.vertices[count] = vertices[i].y;
			count++;
		}		
	}
}
