package game;

import java.util.ArrayList;
import java.util.Random;

import progeny.Progeny;
import screens.Console;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import entities.Chunk;

public class GameWorld {
	private long lastNanoTime = -1;
	public static int PPM = 100;
	ArrayList<Chunk> worldChunk; 
	private int sleepWaveCount = 0;
	private int sleepWaveCountMax = 60;
	private int duration = 0;
	private int cullCount = 10;
	private int random;
	private int bodyHibernation;
	Random rand = new Random();
	Integer[][] worldChunks;
	int width;
	private float gravity = -9.8f;
	private int yStrech = 200;
	private World world = new World(new Vector2(0,gravity), false);
	private Array<Body> bodies = new Array<Body>();
	private Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	//CREATURE 
	public GameWorld(Integer[][] worldArray, int width) {
		Progeny.world = this;
		this.width = width;
		worldChunk = new ArrayList<Chunk>();
		worldChunks = worldArray;
		WorldUtils.GenerateWorldBorder(getWorld(), 0, 23000, 7142, 34500);
		WorldUtils.GenerateChunks();	 
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
		
		if(this.lastNanoTime == -1){
			this.lastNanoTime = System.nanoTime();
		}
		if(((System.nanoTime()/1000000000) - (this.lastNanoTime/1000000000)) > 2){
			Progeny.server.updateBodies();
			this.lastNanoTime = System.nanoTime();
		}
		Console.setLine3("LAG DURATION:" + duration);
		bodyHibernation = 0;;
		sleepWaveCount++;
		if(this.sleepWaveCount > this.sleepWaveCountMax){
			this.sleepWaveCount = 1;
		}
		Console.setLine8("DELTA * 60:" + dt * 60);
		if(dt * 60 > 1.0){
			duration++;
			if(world.getBodyCount() > 0){
				while(bodyHibernation < cullCount){
					bodyHibernation++;
					world.getBodies(bodies);
					if(bodies.size > 0){
						random = rand.nextInt(bodies.size);
						if(bodies.get(random).isSleepingAllowed()){
							world.destroyBody(bodies.get(random));
						}
					}		
				}									
			}
		}else{
			if(duration > 0){
				this.duration--;
			}
		}
		this.getWorld().step(dt, 6, 2);
		renderer.render(getWorld(), Progeny.getCam().combined);
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
}
