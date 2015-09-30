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
	int width;
	public int yStrech = 650;
	
	public GameWorld(int chunksX, int chunksY, Texture types){
		 worldChunk = new ArrayList<Chunk>();
		 int xScroll = 0;
		 int yScroll = 0;
		 for(int currentX = 0; currentX < chunksX; currentX++){
			 for(int currentY = 0; currentY < chunksY; currentY++){
				 Chunk chunk = new Chunk(xScroll, yScroll, 0, rand.nextInt(11));
				 chunk.setID(totalChunks);
				 worldChunk.add(chunk);
				 yScroll += 650;
				 totalChunks ++;
			 }
			 xScroll = 0;
		 }

	}

	public GameWorld(Integer[][] world, int width) {
		this.width = width;
		worldChunk = new ArrayList<Chunk>();
		worldChunks = world;
		int xScroll = 0;
		int yScroll = 0;
		for(int currentX = 0; currentX < world.length; currentX++){
			for(int currentY = 0; currentY < world[0].length; currentY++){
				Chunk chunk = new Chunk(xScroll, yScroll, 0, world[currentX][currentY]);
				chunk.setID(totalChunks);
				worldChunk.add(chunk);
				yScroll += yStrech;
				totalChunks ++;
				System.out.println("CHUNK RECIEVED TYPE " + chunk.getType() + " Y=" + currentY++);
			}
			xScroll += ChunkType.BASE.getWidth();
			yScroll = 0;
		}
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
}
