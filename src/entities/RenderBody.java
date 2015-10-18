package entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public abstract class RenderBody {
	String type;
	public static enum ShapeDescription{LINE,CIRCLE, SQUARE, POLYGON}
	abstract public void render(ShapeRenderer sr, OrthographicCamera cam);
}
