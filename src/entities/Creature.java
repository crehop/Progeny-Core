package entities;

import game.Location;

import java.util.ArrayList;

import progeny.Progeny;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

public class Creature {
	PolygonShape shape = new PolygonShape();
	Body body;
	BodyDef def;
	Location location;
	FixtureDef fdef;

	public Creature(World world, Location position){
		this.location = position;
		def = new BodyDef();
		def.position.set(location.getX(), location.getY());
		def.type = BodyType.DynamicBody;
		def.angle = 200;
		float[] creature = new float[8];
		creature[0] = 14f;
		creature[1] = 0;
		creature[2] = 4;
		creature[3] = 88;
		creature[4] = 80;
		creature[5] = 26;
		creature[6] = 86;
		creature[7] = 0;
		shape.set(creature);
		
		FixtureDef fdef = new FixtureDef();
		fdef.shape = shape;
		fdef.density = 1000;
		body = world.createBody(def);
		body.createFixture(fdef);
	}
}

	