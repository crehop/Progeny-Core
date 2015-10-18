package entities;

import game.Location;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class Ball extends RenderBody{
	
	private Location location;
	private float radius;
	private int ID;
	private ShapeDescription shape =  ShapeDescription.CIRCLE;
	public Ball(Location location, float radius){
		this.radius = radius;
		this.location = location;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public void render(ShapeRenderer sr, OrthographicCamera cam) {
    	sr.begin(ShapeType.Filled);
    	sr.setProjectionMatrix(cam.combined);
		sr.circle(location.getX(), location.getY(), this.radius);
		sr.end();
	}
}
