package screens;

import progeny.Progeny;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import camera.CameraFPS;
import entities.IDGetter;

//import renderer.CameraRTS;
public class Player extends CameraFPS implements Screen{
	@SuppressWarnings("unused")
	private Game game;
	private boolean lockScreen;
	
	private int ID = IDGetter.getID();
	public Player(float x, float y, float z, Game game) {
		super(x, y, z);
		this.game = game;
		lockScreen = false;
	}
	
//@Override code=================================================================================	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(float delta) {
		Progeny.getCam().up.set(0, 1, 0);
		Progeny.getCam().position.set(this.location.getPosition());
		Progeny.getCam().direction.set(0,0,-1);
		this.updateLocation();
	}
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		viewport.apply();
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
	}
//=================================================================================	
	
	
	public boolean isCameraLocked() {
		return lockScreen;
	}
	public int ID(){
		return ID;
	}
	public void setScreenLocked(boolean lock){
		this.lockScreen = lock;
	}
}
