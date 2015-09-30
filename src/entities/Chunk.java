package entities;

import java.util.ArrayList;
import java.util.Random;

import progeny.Progeny;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import game.ChunkType;
import game.Location;

public class Chunk {
	private GameObject chunk;
	int type;
	int ID = 0;
	Location location;
	Random Rand = new Random();
	TextureRegion region;
	
	public Chunk(int x, int y, int z, int type){
		this.location = new Location(x,y,z);
		this.type = type;
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

	public GameObject getChunk() {
		if(chunk == null){
			this.region = ChunkType.getTexture(type);
			chunk = new GameObject(new Sprite(ChunkType.BASE),location);
			chunk.setTextureRegion(this.region);
			chunk.setRegionHeight(650);
			chunk.setYVisible(true);
		}
		return chunk;
	}

	public void setChunk(GameObject chunk) {
		this.chunk = chunk;
	}
}
