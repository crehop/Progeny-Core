package game;

import interfaces.Dialogs;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import packets.Packet;
import packets.Packet1Connect;
import packets.Packet2Body;
import packets.Packet3RequestBody;
import packets.Packet7WorldCreation;
import packets.Packet8WorldInfo;
import progeny.Progeny;
import utils.ObjectUtils;
import utils.Console;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import entities.Chunk;

public class ServerComms{
	private String configurableIP = "127.0.0.1";
	private int configurablePORT1 = 54555;
	private int configurablePORT2 = 54777;
	private GameWorld world = null;
	private Client client;
	private Packet1Connect packet1;
	private Packet8WorldInfo packet8;
	private Packet7WorldCreation packet7;
	private boolean logout = false;
	private boolean loginConfirm = false;
	private Integer[][] worldChunks;
	private int width;
	private boolean worldTransfer = false;
	
	public ServerComms() throws UnknownHostException, IOException{
		client = new Client();
		client.start();
		client.getKryo().register(Packet.class);
		client.getKryo().register(Shape.class);
		client.getKryo().register(CircleShape.class);
		client.getKryo().register(ChainShape.class);
		client.getKryo().register(EdgeShape.class);
		client.getKryo().register(PolygonShape.class);
		client.getKryo().register(Array.class);
		client.getKryo().register(Object[].class);
		client.getKryo().register(Vector2.class);
		client.getKryo().register(Fixture.class);
		client.getKryo().register(FixtureDef.class);
		client.getKryo().register(BodyDef.class);
		client.getKryo().register(BodyType.class);
		client.getKryo().register(Filter.class);
		client.getKryo().register(Packet1Connect.class);
		client.getKryo().register(Packet2Body.class);
		client.getKryo().register(Packet3RequestBody.class);
		client.getKryo().register(Packet8WorldInfo.class);
		client.getKryo().register(Packet7WorldCreation.class);
		client.getKryo().register(Integer[][].class);
		client.getKryo().register(Integer[].class);
		client.getKryo().register(float[].class);
		client.getKryo().register(Vector2.class);

		try{
			client.connect(5000, configurableIP, configurablePORT1, configurablePORT2);
		}catch(IOException e){
			Dialogs.printDialog("SERVER FAILED TO START, CANNOT CONNECT! \n PLEASE CONFIRM IP EXAMPLE:127.0.0.1:55565");
			logout();
		}
		if(!logout){
			packet1 = new Packet1Connect();
			//TODO RE-ADD LOGIN SYSTEM
			//LoginGui login = new LoginGui();
			//if(!login.hasHappened()){
			//	logout();
			//}
			packet1.setUsername("crehop");//login.getUsername());
			packet1.setPassword("password");//login.getPassword());
			client.sendTCP(packet1);
			this.initializeListener();
			if(logout){
				Gdx.app.exit();
			}else{
				packet7 = new Packet7WorldCreation();
				System.out.println("Asking for World.....");
				client.sendUDP(packet7);
				this.initialize();
			}
		}

			
	}
	private void initialize() {
		if(logout){
			logout();
			System.out.println("ATTEMPTED LOGOUT");
		}else{
			System.out.println("Initializing Server...." );
		}
	}
	private void initializeListener() {
		System.out.println("Initializing Listener...." );
	    client.addListener(new Listener() {
	    public void received (Connection connection, Object object) {
	    	if(object instanceof Packet){
	    		if(object instanceof Packet1Connect){
	    			packet1 = (Packet1Connect)object;
	    			if(packet1.logout()){
	    				Dialogs.printDialog("CONNECTION DENIED: BAD USERNAME/PASSWORD");
	    				Gdx.app.exit();
	    			}else{
	    				Dialogs.printDialog("CONNECTION CONFIRMED: " + packet1.getUsername() + "\n Welcome to Hopnet!");
	    				loginConfirm = true;
	    			}
	    		}else if(object instanceof Packet7WorldCreation){
	    			packet7 = (Packet7WorldCreation)object;
	    			if(packet7.worldRecieved()){
						System.out.println("World Recieved, Creating.....");
	    				worldChunks = packet7.getWorld();
	    				width = packet7.getWorldWidth();
	    			}else{
	    				Dialogs.printDialog("WORLD LOAD FAILED!");
	    				logout();
	    			}
	    		}else if(object instanceof Packet2Body){
	    			ObjectUtils.copy((Packet2Body)object);
	    		}else if(object instanceof Packet8WorldInfo){
	    			packet8 = (Packet8WorldInfo)object;
	    			packet8.GetWorld();
	    		}else{
	    			
	    		}
	    	}
	    }});		
	}
	public ArrayList<Chunk> getWorldChunks(){
		if(world == null){
			world = new GameWorld(worldChunks, width);
		}
		return this.world.worldChunk;
	}
	public GameWorld getWorld(){
		if(world == null){
			world = new GameWorld(worldChunks, width);
		}
		return world;
	}
	public void logout(){
		Progeny.getGame().dispose();
		this.logout  = true;
	}
	public boolean loggedIn() {
		return this.loginConfirm;
	}
	public void updateBodies(){
		if(!worldTransfer){
			new Packet8WorldInfo();
		}
		Packet3RequestBody ask = new Packet3RequestBody();
		ask.setID(0);
		client.sendTCP(ask);
	}
}
