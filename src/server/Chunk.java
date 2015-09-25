package server;

import java.util.Random;

import progeny.Progeny;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import entities.GameObject;

public class Chunk {
	GameObject chunk;
	int type;
	int ID = 0;
	Location location;
	TextureRegion textureRegion;
	Random Rand = new Random();
	
	public Chunk(int x, int y, int z, int type){
		this.location = new Location(x,y,z);
		this.setTexutureRegion(ChunkType.getTexture(type));
		this.chunk = new GameObject(new Sprite(textureRegion),location);		
		this.chunk.setTextureRegion(ChunkType.getTexture(type));
		Progeny.gameObjects.add(chunk);
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

	public TextureRegion getTextureRegion() {
		return this.textureRegion;
	}
	public void setTexutureRegion(TextureRegion region){
		this.textureRegion = region;
	}
}
