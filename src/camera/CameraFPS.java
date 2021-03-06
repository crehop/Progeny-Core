package camera;

import game.Location;
import progeny.Progeny;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class CameraFPS {
	protected Vector3 position = null;
	protected float lastYaw = 0.0f;
	protected float lastPitch = 0.0f;
	protected float lastCalc = 0.0f;
	protected float yaw = 0.0f;
	protected float pitch = 0.0f;
	protected Location location;
	protected Viewport viewport;
	protected float far = 1000;
	protected float near = 0.1f;

	public CameraFPS(float x, float y, float z){
		position = new Vector3(x,y,z);
		this.location = new Location(x,y,z);
		Progeny.setCam(new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
		Progeny.getCam().near = near;
		Progeny.getCam().far = far;
		Progeny.setB2DCam(new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
		Progeny.getB2DCam().near = near;
		Progeny.getB2DCam().far = far;
		viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Progeny.getCam());
	}
	
	public void yaw(float amount){
		setYaw(amount);
	}
	public void pitch(float amount){
		setPitch(amount);
	}
	public void walkBackward(float distance){
		this.position.y -= distance;
		updateLocation();
		
	}
	public void walkForward(float distance){
		this.position.y += distance;
		updateLocation();
	}
	protected float getYaw() {
		return this.yaw;
	}

	public void strafeRight(float distance){
		//moves camera forward relative to its current rotation;
		this.position.x += distance;
		updateLocation();
	}
	public void strafeLeft(float distance){
		//moves camera forward relative to its current rotation;
		this.position.x -= distance;
		updateLocation();
	}
	protected float getYawD() {
		this.lastCalc = this.lastYaw;
		this.lastYaw = 0.0f;
		return this.lastCalc;
	}
	protected float getPitchD() {
		this.lastCalc = this.lastPitch;
		this.lastPitch = 0.0f;
		return this.lastCalc;
	}

	public void moveDown(float distance){
		this.position.y -= distance;
		this.location.update(position);
	}
	public void moveUp(float distance){
		this.position.y += distance;
		updateLocation();
	}
	
	public void setLocation(Location location){
		this.position.x = (location.getX());
		this.position.y = (location.getY());
		this.position.z = (location.getZ());
		this.location.update(position);
	}
	public Location getLocation(){
		return location;
	}
	protected void updateLocation(){
		this.location.update(position);

	}
	public void setYaw(float yaw) {
		if(yaw + this.yaw > 360){
			this.yaw = ((this.yaw + yaw) - 360);
		}
		else if(yaw + this.yaw < 0){
			this.yaw = ((this.yaw + yaw) + 360);
		}
		else{
			this.yaw += yaw;
			lastYaw += yaw;
		}
	}
	public float getPitch(){
		return pitch;
	}
	public void setPitch(float pitch) {
		if(pitch + this.pitch < -85){
			this.pitch = -85;
		}
		else if(pitch + this.pitch > 85){
			this.pitch = 85;
		}
		else{
			this.pitch += pitch;
			lastPitch += pitch;
		}
	}
	public float getLastYaw(){
		return lastYaw;
	}
	public void setLastYaw(float last){
		lastYaw = last;
	}
}
