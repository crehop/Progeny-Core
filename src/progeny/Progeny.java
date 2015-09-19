package progeny;

import interfaces.UI;

import java.util.ArrayList;

import screens.Console;
import screens.Player;
import screens.SplashScreen;
import server.Time;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import control.Controls;
import control.MenuControls;
import entities.AssetHandler;
import entities.GameObject;

public class Progeny extends Game implements ApplicationListener {
	public static final String TITLE = "Progeny";
	public static final int V_HEIGHT = 600;
	public static final int V_WIDTH = 800;
	public static final float SCALE = 2.0f;
	public static final String VERSION = "0.01 Pre-Alpha";
	public static String LOG = "";
	
	private static SpriteBatch sb;
	private static OrthographicCamera cam;

	public static SplashScreen splash;
	public static Player player;
	public static UI ui;
	
	public static Environment env;
	private static Progeny game;
	public static AssetHandler assets;
	public static ModelBuilder modelBuilder;
	public static InputMultiplexer multiplexer;
	
	public static Controls controls;
	public static MenuControls controlsMenu;
	
	private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	
	float progress;
	
	public static Vector3 xAxis = new Vector3(1,0,0);
	public static Vector3 yAxis = new Vector3(0,1,0);
	public static Vector3 zAxis = new Vector3(0,0,1);
	
	private Vector3 position = new Vector3();
	
	
	//WORLD CLASSES
	
    public static Array<GameObject> instances = new Array<GameObject>();	
    
	@Override
	public void create() {
		@SuppressWarnings("unused")
		Thread thread = new Thread(){
			Time time = new Time();
		};
		assets = new AssetHandler();
		ui = new UI();
		Progeny.game = this;
		controls = new Controls(this);
		controlsMenu = new MenuControls(this);
		sb = new SpriteBatch();
		player = new Player(0,0,10,this);
		splash = new SplashScreen(this);
		assets.getAssetManager().finishLoading();
		
		
		//ABSOLUTE 0,0 BOX=========================================
		//===========================================================
		Gdx.graphics.setContinuousRendering(true);
		Gdx.graphics.setVSync(true);
		Gdx.input.setCursorCatched(false );
		setScreen(splash);
		multiplexer = new InputMultiplexer(ui.getStage(),controlsMenu);
		Gdx.input.setInputProcessor(multiplexer);
	}

	@Override
	public void render() {	
		Console.setLine1("FPS:" + Gdx.graphics.getFramesPerSecond());
		//MAIN MENU LOOP============================================================================================================
		if(assets.getAssetManager().update() && this.screen.equals(splash)) {
			ui.render(Gdx.graphics.getDeltaTime());
		}
		
		//GAME LOOP=================================================================================================================
		else if(assets.getAssetManager().update() && this.screen.equals(player)) {
			controls.checkInput();
			super.render();
	  	    Console.setLine9("POSITION: X:" + (double) Math.round(player.getLocation().getX() * 100) / 100
	  	    		+ " Y:" + (double) Math.round(player.getLocation().getY() * 100) / 100
	  	    		+ " Z:" + (double) Math.round(player.getLocation().getZ() * 100) / 100);
	  	    Console.setLine10("TIME: " + (double) Math.round(Time.getTime() * 100) / 100);
	  	    
	  	    //Ooze===================================
	  	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
			sb.begin();
	        sb.end();
			Gdx.gl.glClear(GL20.GL_DEPTH_BUFFER_BIT);
	  	    //=========================================
			
			//Animals=====================================
			sb.begin();
			for(GameObject object:gameObjects){
				sb.draw(object.getTexture(), object.getLocation().getX(), object.getLocation().getY());
			}
	        sb.end();
			//=========================================
			Console.render();
			//Effects and movement==================================
			sb.begin();
			Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
			Gdx.gl.glEnable(GL20.GL_BLEND);
			Gdx.gl.glBlendFunc(GL20.GL_ONE_MINUS_SRC_ALPHA, GL20.GL_ALPHA);
	        sb.end();
			Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);
			Gdx.gl.glDisable(GL20.GL_BLEND);
	  	    //=========================================
			
		//LOADING LOOP =========================================================================================================
	      }else{
	       progress = assets.getAssetManager().getProgress();
	  	 }
	}
	
	@Override
	public void dispose() {
		super.dispose();
		sb.dispose();
		assets.assets.dispose();
        ui.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		ui.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	public static Progeny getGame() {
		return game;
	}
	public AssetManager getAssets(){
		return assets.getAssetManager();
	}
	
	public static void newSprite(Sprite sprite, float x, float y, float z) {
		GameObject nGO = new GameObject(sprite, x,y,z);
		gameObjects.add(nGO); 
	}
	
	protected boolean isVisible(final GameObject instance) {
	    position.add(instance.center);
	    return cam.frustum.sphereInFrustum(position, instance.radius);
	}
	
	public static OrthographicCamera getCam() {
		return cam;
	}

	public static void setCam(OrthographicCamera cam) {
		Progeny.cam = cam;
	}

}
