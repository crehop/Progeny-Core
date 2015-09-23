package server;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ChunkType {
	static Random rand = new Random();				
	public static final Texture BASE = new Texture("terrain/tiles.png");
	public static final TextureRegion AIR_TEXTURE = new TextureRegion(BASE,0,0,BASE.getWidth(),BASE.getWidth());
	public static final TextureRegion TOP_WATER_LAYER_TEXTURE = new TextureRegion(BASE,0,BASE.getWidth(),BASE.getWidth(),BASE.getWidth());
	public static final TextureRegion SHALLOW_WATER_TEXTURE = new TextureRegion(BASE,0,BASE.getWidth()*2,BASE.getWidth(),BASE.getWidth());
	public static final TextureRegion WATER_TEXTURE = new TextureRegion(BASE,0,BASE.getWidth()*3,BASE.getWidth(),BASE.getWidth());
	public static final TextureRegion DEEP_WATER_TEXTURE = new TextureRegion(BASE,0,BASE.getWidth()*4,BASE.getWidth(),BASE.getWidth());
	public static final TextureRegion FLOOR_WATER_TEXTURE = new TextureRegion(BASE,0,BASE.getWidth()*5,BASE.getWidth(),BASE.getWidth());
	public static final TextureRegion SAND_TEXTURE = new TextureRegion(BASE,0,BASE.getWidth()*6,BASE.getWidth(),BASE.getWidth());
	public static final TextureRegion DIRT_TEXTURE = new TextureRegion(BASE,0,BASE.getWidth()*7,BASE.getWidth(),BASE.getWidth());
	public static final TextureRegion ROCK_TEXTURE = new TextureRegion(BASE,0,BASE.getWidth()*8,BASE.getWidth(),BASE.getWidth());
	public static final TextureRegion OBSIDIAN_TEXTURE = new TextureRegion(BASE,0,BASE.getWidth()*9,BASE.getWidth(),BASE.getWidth());
	public static final TextureRegion LAVA_TEXTURE = new TextureRegion(BASE,0,BASE.getWidth()*10,BASE.getWidth(),BASE.getWidth());
	
	public static TextureRegion random(){
		switch(rand.nextInt(11)){
			case 0: return ChunkType.AIR_TEXTURE;
			case 1: return ChunkType.TOP_WATER_LAYER_TEXTURE;
			case 2: return ChunkType.SHALLOW_WATER_TEXTURE;
			case 3: return ChunkType.WATER_TEXTURE;
			case 4: return ChunkType.DEEP_WATER_TEXTURE;
			case 5: return ChunkType.FLOOR_WATER_TEXTURE;
			case 6: return ChunkType.SAND_TEXTURE;
			case 7: return ChunkType.DIRT_TEXTURE;
			case 8: return ChunkType.ROCK_TEXTURE;
			case 9: return ChunkType.OBSIDIAN_TEXTURE;
			case 10: return ChunkType.LAVA_TEXTURE;
			default: return ChunkType.LAVA_TEXTURE;
		}
	}

	public static final int AIR = 0;
	public static final int TOP_WATER_LAYER = 1;
	public static final int SHALLOW_WATER = 2;
	public static final int WATER = 3;
	public static final int DEEP_WATER = 4;
	public static final int FLOOR_WATER = 5;
	public static final int SAND = 6;
	public static final int DIRT = 7;
	public static final int ROCK = 8;
	public static final int OBSIDIAN = 9;
	public static final int LAVA = 10;
}
