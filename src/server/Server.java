package server;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Server {
	private World world;
	public Server(){
		this.initialize();
	}
	private void initialize() {
		System.out.println("Initializing Server...." );
		 world = new World(10,10,new Texture("terrain/tiles.png"));
	}
	public ArrayList<Chunk> getWorld(){
		return this.world.worldChunk;
	}
}
