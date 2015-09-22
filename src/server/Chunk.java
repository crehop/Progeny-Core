package server;

import progeny.Progeny;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import entities.GameObject;

public class Chunk {
	GameObject chunk;
	int type;
	int ID = 0;
	Location location;
	Texture texture;
	
	public Chunk(int x, int y, int z, int type){
		System.out.println("Chunk created");
		this.location = new Location(x,y,z);
		this.texture = new Texture("terrain/tiles.png");
		this.chunk = new GameObject(new Sprite(texture),location.getX(), location.getY(), z);
		Progeny.gameObjects.add(chunk);
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
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	public int getID(){
		return ID;
	}

	public Texture getTexture() {
		return ChunkType.AIR_TEXTURE;
	}
}
