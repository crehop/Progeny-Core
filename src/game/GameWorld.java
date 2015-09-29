package game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;

public class GameWorld {
	ArrayList<Chunk> worldChunk; 
	public int activeChunks;
	public int activeObjects;
	public int totalChunks;
	Random rand = new Random();
	Integer[][] worldChunks;
	
	public GameWorld(int chunksX, int chunksY, Texture types){
		 worldChunk = new ArrayList<Chunk>();
		 int xScroll = 0;
		 int yScroll = 0;
		 for(int currentX = 0; currentX < chunksX; currentX++){
			 for(int currentY = 0; currentY < chunksY; currentY++){
				 Chunk chunk = new Chunk(xScroll, yScroll, 0, rand.nextInt(11));
				 chunk.setID(totalChunks);
				 worldChunk.add(chunk);
				 xScroll += 100;
				 totalChunks ++;
			 }
			 yScroll += types.getWidth();
			 xScroll = 0;
		 }

	}

	public GameWorld(Integer[][] world) {
		 worldChunk = new ArrayList<Chunk>();
		 worldChunks = world;
		 int xScroll = 0;
		 int yScroll = 0;
		 for(int currentX = 0; currentX < world[0].length; currentX++){
			 for(int currentY = 0; currentY < world.length; currentY++){
				 Chunk chunk = new Chunk(xScroll, yScroll, 0, world[currentY][currentX]);
				 chunk.setID(totalChunks);
				 worldChunk.add(chunk);
				 xScroll += ChunkType.BASE.getWidth();
				 totalChunks ++;
				 System.out.println(world[currentY][currentX]);
			 }
			 yScroll += ChunkType.BASE.getWidth();
			 xScroll = 0;
		 }
	}
	public ArrayList<Chunk> getChunks(){
		return worldChunk;
	}
}
