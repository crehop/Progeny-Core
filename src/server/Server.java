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
		configurableWorldSizeX = 3;
		configurableWorldSizeY= 3;
		System.out.println("Initializing Server...." );
		 world = new World(configurableWorldSizeX,configurableWorldSizeY,new Texture("terrain/tiles.png"));
	}
	public ArrayList<Chunk> getWorld(){
		return this.world.worldChunk;
	}
}
