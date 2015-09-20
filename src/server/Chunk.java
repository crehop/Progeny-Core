package server;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Chunk {
	int type;
	Sprite chunk;
	Location location;
	
	public Chunk(int x, int y, int z, int type){
		this.location.setX(x);
		this.location.setY(y);
		this.location.setZ(z);
		switch (type) {
		case ChunkType.AIR:
			
			break;
		case ChunkType.TOP_WATER_LAYER:
			
			break;
		case ChunkType.SHALLOW_WATER:
			
			break;
		case ChunkType.WATER:
			
			break;
		case ChunkType.DEEP_WATER:
			
			break;
		case ChunkType.FLOOR_WATER:
			
			break;
		case ChunkType.SAND:
			
			break;
		case ChunkType.DIRT:
			
			break;
		case ChunkType.ROCK:
			
			break;
		case ChunkType.OBSIDIAN:
			
			break;
		case ChunkType.LAVA:
			
			break;
		default:
			break;
		}
	}
}
