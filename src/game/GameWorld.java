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
	private int totalChunks;
	private boolean created = false;
	Random rand = new Random();
	Integer[][] worldChunks;
	int width;
	private float gravity = -1.1f;
	private int yStrech = 650;
	private World world = new World(new Vector2(0,gravity), false);
	private Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	
	//CREATURE 
	PolygonShape shape = new PolygonShape();
	Body body;
	BodyDef def;

	public GameWorld(Integer[][] worldArray, int width) {
		this.width = width;
		worldChunk = new ArrayList<Chunk>();
		worldChunks = worldArray;
		def = new BodyDef();
		def.position.set(0 - Gdx.graphics.getWidth()/2,0 - Gdx.graphics.getHeight()/2);
		def.type = BodyType.StaticBody;
		body = world.createBody(def);
		float[] worldBorder = new float[8];
		worldBorder[0] = 0f;
		worldBorder[1] = 7220;
		worldBorder[2] = 0;
		worldBorder[3] = 34500;
		worldBorder[4] = 23000;
		worldBorder[5] = 34500;
		worldBorder[6] = 23000;
		worldBorder[7] = 7220;
		shape.set(worldBorder);
		
		FixtureDef fdef = new FixtureDef();
		fdef.shape = shape;
		body.createFixture(fdef);
		int xScroll = 0;
		int yScroll = 0;
		for(int currentX = 0; currentX < worldArray.length; currentX++){
			for(int currentY = 0; currentY < worldArray[0].length; currentY++){
				Chunk chunk = new Chunk(xScroll, yScroll, 0, worldArray[currentX][currentY]);
				chunk.setID(totalChunks);
				worldChunk.add(chunk);
				yScroll += yStrech;
				totalChunks ++;
				System.out.println("CHUNK RECIEVED TYPE " + chunk.getType() + " Y=" + currentY++);
			}
			xScroll += ChunkType.BASE.getWidth();
			yScroll = 0;
		}
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
