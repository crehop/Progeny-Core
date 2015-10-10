package entities;

import game.Location;
import screens.Console;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

public class GameObject extends Sprite{
	Location location;
	float roll = 0f;
	float pitch = 0f;
	float yaw = 0f;
	float scaleX = 1f;
	float scaleY = 1f;
	float scaleZ = 1f;
	boolean staticObject = false;
	String meta = "null";
    public final Vector3 center = new Vector3();
    public final Vector3 dimensions = new Vector3();
    public final float radius;
    private int ID = 0;
	private TextureRegion textureRegion;
	private boolean yVisible = false;

	public GameObject(Sprite sprite, float x, float y, float z) {
		super(sprite);
		radius = 0;
		this.location = new Location(x,y,z);
        progeny.Progeny.instances.add(this);
        Console.setLine4("Instance count:" + progeny.Progeny.instances.size);
	}

	public GameObject(Sprite sprite, Location location2) {
		super(sprite);
		radius = 0;
		this.location = new Location(location2);
        progeny.Progeny.instances.add(this);
        Console.setLine4("Instance count:" + progeny.Progeny.instances.size);	
    }

	public Location getLocation() {
		return this.location;
	}
	public float getYaw() {
		return yaw;
	}
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}
	public float getScaleX() {
		return scaleX;
	}
	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}
	public float getScaleY() {
		return scaleY;
	}
	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}
	public boolean isStaticObject() {
		return staticObject;
	}
	public void setStaticObject(boolean staticObject) {
		this.staticObject = staticObject;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void setLocation(float x, float y){
		this.location.setX(x);
		this.location.setY(y);
	}
	public void setStatic(boolean isStatic){
		this.staticObject = isStatic;
	}
	public boolean isStatic(){
		return this.staticObject;
	}
	public boolean hasMeta(){
		if(meta.equalsIgnoreCase("null")){
			return false;
		}
		return true;
	}
	public String getMeta(){
		return meta;
	}
	public void setMeta(String meta){
		this.meta = meta;
	}
	public void render() {
		this.setScale(scaleX, scaleY);
		this.setCenterX(location.getX());
		this.setCenterY(location.getY());
		this.setTexture(getTexture());
	}
	public int ID(){
		return ID;
	}
	public void setID(int ID){
		this.ID = ID;
	}

	public void setTextureRegion(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
		super.setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
	}
	public TextureRegion getTextureRegion(){
		return this.textureRegion;
	}

	public boolean hasTextureRegion() {
		if(this.textureRegion == null){
			return false;
		}
		return true;
	}
	public boolean isVisible(int x,int y){
		if(this.location.getX() < x  + Gdx.graphics.getWidth() && this.location.getX() > x  - this.getWidth() && this.location.getY() < y + Gdx.graphics.getHeight() && this.location.getY() > y - this.getHeight()){
			return true;
		}else if(this.yVisible){
			return true;
		}else{
			return false;
		}
	}
	public void setYVisible(boolean visible){
		this.yVisible = visible;
	}
}
