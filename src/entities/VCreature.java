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

public class VCreature {
	PolygonShape shape = new PolygonShape();
	Body body;
	BodyDef def;
	Location location;
	FixtureDef fdef;

	public VCreature(World world){
		def = new BodyDef();
		def.position.set(300,8200 - Gdx.graphics.getHeight()/2);
		def.type = BodyType.DynamicBody;
		float[] creature = new float[8];
		creature[0] = 0f;
		creature[1] = 0;
		creature[2] = 0;
		creature[3] = 20;
		creature[4] = 20;
		creature[5] = 20;
		creature[6] = 20;
		creature[7] = 0;
		shape.set(creature);
		
		FixtureDef fdef = new FixtureDef();
		fdef.shape = shape;
		fdef.density = 1000;
		body = world.createBody(def);
		body.createFixture(fdef);
	}
}

	