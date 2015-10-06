package actors;

import com.badlogic.gdx.physics.box2d.PolygonShape;

import entities.IDGetter;
import entities.Lifeform;

public class Animal extends Lifeform{
	public Animal(){
		super.ID = IDGetter.getID();
	}
	@Override
	public int getID() {
		return super.getID();
	}

	@Override
	public void draw(float x, float y, float z) {
		PolygonShape segment = new PolygonShape();
		
	}
}
