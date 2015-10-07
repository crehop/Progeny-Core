package game;

import java.util.ArrayList;
import java.util.Random;

import packets.Packet2MoveMent;
import progeny.Progeny;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import entities.Chunk;
import entities.VCreature;

public class GameWorld {
	public static int PPM = 100;
	ArrayList<Chunk> worldChunk; 
	private int activeChunks;
	private int activeObjects;
	private boolean created = false;
	Random rand = new Random();
	Integer[][] worldChunks;
	int width;
	private float gravity = -1.1f;
	private int yStrech = 650;
	private World world = new World(new Vector2(0,gravity), false);
	private Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	
	//CREATURE 
	public GameWorld(Integer[][] worldArray, int width) {
		this.width = width;
		worldChunk = new ArrayList<Chunk>();
		worldChunks = worldArray;
		WorldUtils.GenerateWorldBorder(world, 0, 23000, 7220, 34500);
		WorldUtils.GenerateChunks(worldArray, worldChunk, yStrech);
		this.created = true;	 
		new VCreature(world);
	}
	public ArrayList<Chunk> getChunks(){
		return worldChunk;
	}
	public float getWidth() {
		return width;
	}

	public float getYStrech() {
		return this.yStrech;
	}
	

	public void update(float dt){
		this.world.step(dt, 6, 2);
		renderer.render(world, Progeny.getCam().combined);
	}
}
