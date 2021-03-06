package control;

import java.util.Random;

import progeny.Progeny;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

import game.Location;

public class Controls extends InputAdapter implements InputProcessor {
	private boolean exitKey;
	private boolean forward;
	private boolean back;
	private boolean strafeLeft;
	private boolean strafeRight;
    private boolean jump;
	private boolean crouch;
	private boolean speedUpCam;
	private boolean speedDownCam;
	private boolean menu;
	@SuppressWarnings("unused")
	private boolean testForward;
	@SuppressWarnings("unused")
	private boolean testBack;
	@SuppressWarnings("unused")
	private boolean testLeft;
	@SuppressWarnings("unused")
	private boolean testRight;
	@SuppressWarnings("unused")
	private boolean testUp;
	private boolean testDown;
	@SuppressWarnings("unused")
	private Location current;
	private Progeny game;
	//Mouse sensitivity
	private float mouseSensitivity = 0.04141519f;
	private final float defaultMovementSpeed = 0.50f;
	public float movementSpeed = defaultMovementSpeed;
	private int mouseX = 0;
	private int mouseY = 0;
	private int magY = 0;
	private int magX = 0;
	private int resX = 0;
	private int resY = 0;
	int count = 0;
	int result;
	float distance;
	float dist2;
	//3d OBJECT MANIPULATION
	Random rand = new Random();
	//========================
	public Controls(Progeny game){
		this.game = game;
		this.resX = Gdx.graphics.getWidth();
		this.resY = Gdx.graphics.getHeight();
	}

	public  void checkInput() {
		if(exitKey){
			
		}
		if(menu){
		}
		if(testDown){
		}
		if(forward){
			if(Gdx.input.isCursorCatched()){
				Progeny.player.walkForward((float)(movementSpeed));
			}
		}
		if(back){
			if(Gdx.input.isCursorCatched()){
				Progeny.player.walkBackward((float)(movementSpeed));
			}
		}
		if(strafeLeft){
			if(Gdx.input.isCursorCatched()){
				Progeny.player.strafeLeft((float)(movementSpeed));
			}
		}
		if(strafeRight){	
			if(Gdx.input.isCursorCatched()){
				Progeny.player.strafeRight((float)(movementSpeed));
			}
		}
		if(jump){
			if(Gdx.input.isCursorCatched()){
				Progeny.player.moveUp((float)(movementSpeed));
			}
		}
		if(crouch){
			if(Gdx.input.isCursorCatched()){
				Progeny.player.moveDown((float)(movementSpeed));
			}
		}
		if(speedUpCam){
			if(Gdx.input.isCursorCatched()){
				movementSpeed = defaultMovementSpeed * 15;
			}
		}
		else if(speedDownCam){
			if(Gdx.input.isCursorCatched()){
				movementSpeed = defaultMovementSpeed / 100;
			}
		}
		else{
			movementSpeed = defaultMovementSpeed;
		}
	}
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode){
			case Input.Keys.A:
				if(Gdx.input.isCursorCatched()){
					strafeLeft = true;
				}
				return false;
			case Input.Keys.S:
				if(Gdx.input.isCursorCatched()){
					back = true;
				}
				return false;
			case Input.Keys.D:
				if(Gdx.input.isCursorCatched()){
					strafeRight = true;
				}
				return false;
			case Input.Keys.W:
				if(Gdx.input.isCursorCatched()){
					forward = true;
				}
				return false;
			case Input.Keys.TAB:
				if(Gdx.input.isCursorCatched()){
					speedUpCam = true;
				}
				return false;
			case Input.Keys.CONTROL_LEFT:
				if(Gdx.input.isCursorCatched()){
					speedDownCam = true;
				}
				return false;
			case Input.Keys.SHIFT_LEFT:
				if(Gdx.input.isCursorCatched()){
					crouch = true;
				}
				return false;
			case Input.Keys.SPACE:
				if(Gdx.input.isCursorCatched()){
					jump = true;
				}
				return false;
			case Input.Keys.ESCAPE:
				game.dispose();
				return true;
			case Input.Keys.UP:
				if(Gdx.input.isCursorCatched()){
					testForward = true;
				}
				return false;
			case Input.Keys.DOWN:
				if(Gdx.input.isCursorCatched()){
					testBack = true;
				}
				return false;
			case Input.Keys.E:
				this.testDown = true;
				return false;
			case Input.Keys.LEFT:
				if(Gdx.input.isCursorCatched()){
					testLeft = true;
				}
				return false;
			case Input.Keys.RIGHT:
				if(Gdx.input.isCursorCatched()){
					testRight = true;
				}
				return false;
			case Input.Keys.CONTROL_RIGHT:
				if(Gdx.input.isCursorCatched()){
					testDown = true;
				}
				return false;
			case Input.Keys.SHIFT_RIGHT:
				if(Gdx.input.isCursorCatched()){
					testUp = true;
				}
				return false;
			case Input.Keys.T:
				if(Gdx.input.isCursorCatched()){
					menu = true;
				}
				return false;
			default:
				return true;
		}
	}
	@Override
	public boolean keyUp(int keycode) {
		switch(keycode){
			case Input.Keys.A:
				strafeLeft = false;
				return false;
			case Input.Keys.S:
				back = false;
				return false;
			case Input.Keys.D:
				strafeRight = false;
				return false;
			case Input.Keys.ENTER:
				return false;
			case Input.Keys.E:
				this.testDown = false;
				return false;
			case Input.Keys.W:
				forward = false;
				return false;
			case Input.Keys.TAB:
				speedUpCam = false;
				return false;
			case Input.Keys.CONTROL_LEFT:
				speedDownCam = false;
				return false;
			case Input.Keys.SHIFT_LEFT:
				crouch = false;
				return false;
			case Input.Keys.SPACE:
				jump = false;
				return false;
			case Input.Keys.ESCAPE:
				game.dispose();
				return true;
			case Input.Keys.UP:
				testForward = false;
				return false;
			case Input.Keys.DOWN:
				testBack = false;
				return false;
			case Input.Keys.LEFT:
				testLeft = false;
				return false;
			case Input.Keys.RIGHT:
				testRight = false;
				return false;
			case Input.Keys.CONTROL_RIGHT:
				testDown = false;
				return false;
			case Input.Keys.SHIFT_RIGHT:
				testUp = false;
				return false;
			case Input.Keys.T:
				menu = false;
				count++;
				if(count>13) {
					count = 0;
				}
				return false;
		}
		return false;
		}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method 
		return false;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
	    if(Gdx.input.isCursorCatched()){
	    	magX = Math.abs(mouseX - screenX);
	    	magY = Math.abs(mouseY - screenY);
	    	if (mouseX > screenX) {
	    		resX += magX;
	    	}
	    	
	    	if (mouseX < screenX) {
	    		resX -= magX;
	    	}
	    	
	    	if (mouseY < screenY) {
	    		resY -= magY;
	    	}
	    	
	    	if (mouseY > screenY) {
	    		resY += magY;
	    	}
	    
	    	//CAMERA PITCH YAW CODE =====================
	    	Progeny.player.pitch((float)((float)resY * (float)mouseSensitivity));
	    	Progeny.player.yaw((float)((float)resX * (float)mouseSensitivity));
	    	resX = 0;
			resY = 0;
			mouseX = screenX;
			mouseY = screenY;
			//===========================================
	    }

		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		Progeny.getCam().zoom += amount;
		return false;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(button == Input.Buttons.RIGHT){
			return true;
		}
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	    
	}
	public int getObject (int screenX, int screenY) {
	   return 0;
	}
	public Progeny getGame(){
		return game;
	}
}
