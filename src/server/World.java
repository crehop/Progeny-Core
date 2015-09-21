package server;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class World {
	ArrayList<Chunk> worldChunk; 
	public int activeChunks;
	public int totalChunks;
	
	public World(int chunksX, int chunksY, Texture Guide){
		 worldChunk = new ArrayList<Chunk>();
		 int xScroll = 0;
		 int yScroll = 0;
		 
		 for(int currentY = 0; currentY < chunksY; currentY++){
			 for(int currentX = 0; currentX < chunksX; currentX++){
				 Chunk chunk = new Chunk(xScroll, yScroll, 0, ChunkType.SHALLOW_WATER);
				 chunk.setID(totalChunks);
				 xScroll += Guide.getWidth();
				 totalChunks ++;
				 System.out.println("ADDING CHUNK " + totalChunks);
			 }
		 yScroll += Guide.getHeight()/12;
		 }

	}
}
