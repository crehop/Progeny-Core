package game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ChunkType {			
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
	
	public static TextureRegion getTexture(int type){
		switch (type) {
		case ChunkType.AIR:
			return ChunkType.AIR_TEXTURE;
		case ChunkType.TOP_WATER_LAYER:
			return ChunkType.TOP_WATER_LAYER_TEXTURE;
		case ChunkType.SHALLOW_WATER:
			return ChunkType.SHALLOW_WATER_TEXTURE;
		case ChunkType.WATER:
			return ChunkType.WATER_TEXTURE;
		case ChunkType.DEEP_WATER:
			return ChunkType.DEEP_WATER_TEXTURE;
		case ChunkType.FLOOR_WATER:
			return ChunkType.FLOOR_WATER_TEXTURE;
		case ChunkType.SAND:
			return ChunkType.SAND_TEXTURE;
		case ChunkType.DIRT:
			return ChunkType.DIRT_TEXTURE;
		case ChunkType.ROCK:
			return ChunkType.ROCK_TEXTURE;
		case ChunkType.OBSIDIAN:
			return ChunkType.OBSIDIAN_TEXTURE;
		case ChunkType.LAVA:
			return ChunkType.LAVA_TEXTURE;
		default:
			System.out.println("ERROR! LINE 58 CHUNK.JAVA");
			return ChunkType.AIR_TEXTURE;
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
