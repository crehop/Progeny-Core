package server;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class World {
	ArrayList<Chunk> worldChunk; 
	public int activeChunks;
	public int totalChunks;
	
	public World(int chunksX, int chunksY, Texture types){
		 worldChunk = new ArrayList<Chunk>();
		 int xScroll = 0;
		 int yScroll = 0;
		 
		 for(int currentX = 0; currentX < chunksX; currentX++){
			 for(int currentY = 0; currentY < chunksY; currentY++){
				 Chunk chunk = new Chunk(xScroll, yScroll, 0, ChunkType.SHALLOW_WATER);
				 chunk.setID(totalChunks);
				 worldChunk.add(chunk);
				 xScroll += types.getWidth();
				 totalChunks ++;
				 System.out.println("ADDING CHUNK " + totalChunks);
			 }
			 yScroll += types.getWidth();
			 xScroll = 0;
		 }

	}
}
