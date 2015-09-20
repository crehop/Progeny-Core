package server;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class World {
	ArrayList<Chunk> worldChunk; 
	public int activeChunks;
	public int totalChunks;
	
	public World(int chunkTotal, Texture texture){
		 worldChunk = new ArrayList<Chunk>();
		 
		
	}
}
