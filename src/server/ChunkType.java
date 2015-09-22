package server;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ChunkType {
	public static final Texture BASE = new Texture("terrain/tiles.png");
	public static final TextureRegion AIR_TEXTURE = new TextureRegion(BASE,0,0,BASE.getWidth(),BASE.getWidth());
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
