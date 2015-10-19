package packets;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class Packet2Body extends Packet{
	private BodyDef def;
	private float radius;
	private int UID;
	public Vector2 location;
	private float angle;
	private Vector2[] vertices;
	private boolean polygon;
	public int getUID(){
		return UID;
	}
	
	public Packet2Body(){
	}
	public BodyDef getBodyDef(){
		return def;
	}
	public void setBodyDef(BodyDef def){
		this.def = def;
	}
	public void setUID(int UID){
		this.UID = UID;
	}
	public void setLocation(float x,float y, float angle){
		this.location = new Vector2(x,y);
		this.angle = angle;
	}
	public float getAngle(){
		return this.angle;
	}
	public void setRadius(float radius) {
		this.radius = radius;
		setPolygon(false);
	}
	public float getRaidus(){
		return this.radius;
	}
	public Vector2[] getVertices(){
		return this.vertices;
	}

	public void packVertices(Vector2[] vertices) {
		this.vertices = vertices;
		if(this.vertices != null){
			this.setPolygon(true);
		}
	}

	public boolean isPolygon() {
		return polygon;
	}

	public void setPolygon(boolean polygon) {
		this.polygon = polygon;
	}
}