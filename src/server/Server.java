package server;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Server {
	private int configurableWorldSizeX;
	private int configurableWorldSizeY;
	private World world;
	public Server(){
		this.initialize();
	}
	private void initialize() {
		configurableWorldSizeX = 100;
		configurableWorldSizeY= 200;
		System.out.println("Initializing Server...." );
		 world = new World(configurableWorldSizeX,configurableWorldSizeY,new Texture("terrain/tiles.png"));
			System.out.println("World Created Successfully!" );
	}
	public ArrayList<Chunk> getWorld(){
		return this.world.worldChunk;
	}
}
