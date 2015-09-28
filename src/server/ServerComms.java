package server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import packets.Packet;
import packets.Packet1Connect;
import progeny.Progeny;
import screens.LoginGui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class ServerComms{
	private int configurableWorldSizeX;
	private int configurableWorldSizeY;
	private String configurableIP = "127.0.0.1";
	private int configurablePORT = 12253;
	private World world;
	private Client client;
	private Packet1Connect packet1;
	private boolean logout = false;
	private boolean loginConfirm = false;
	
	
	public ServerComms() throws UnknownHostException, IOException{
		client = new Client();
		client.start();
		client.getKryo().register(Packet.class);
		client.getKryo().register(Packet1Connect.class);
		try{
			client.connect(5000, "127.0.0.1", 54555, 54777);
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "SERVER FAILED TO START, CANNOT CONNECT! \n PLEASE CONFIRM IP EXAMPLE:127.0.0.1:55565");
			logout();
		}
		if(!logout){
			packet1 = new Packet1Connect();
			LoginGui login = new LoginGui();
			if(!login.hasHappened()){
				logout();
			}
			packet1.setUsername(login.getUsername());
			packet1.setPassword(login.getPassword());
			client.sendTCP(packet1);
			this.initializeListener();
			if(logout){
				Gdx.app.exit();
			}else{
				this.initialize();
			}
		}

			
	}
	private void initialize() {
		if(logout){
			logout();
			System.out.println("ATTEMPTED LOGOUT");
		}else{
			configurableWorldSizeX = 100;
			configurableWorldSizeY= 200;
			System.out.println("Initializing Server...." );
			world = new World(configurableWorldSizeX,configurableWorldSizeY,new Texture("terrain/tiles.png"));
		 	System.out.println("World Created Successfully!" );
		}
	}
	private void initializeListener() {
		System.out.println("Initializing Listener...." );
	    client.addListener(new Listener() {
	    public void received (Connection connection, Object object) {
	    	if(object instanceof Packet){
	    		if(object instanceof Packet1Connect){
	    			packet1 = (Packet1Connect)object;
	    			System.out.println();
	    			if(packet1.logout()){
		    			JOptionPane.showMessageDialog(null,"CONNECTION DENIED: BAD USERNAME/PASSWORD");
	    				Gdx.app.exit();
	    			}else{
	    				JOptionPane.showMessageDialog(null,"CONNECTION CONFIRMED: " + packet1.getUsername() + "\n Welcome to Hopnet!");
	    				loginConfirm = true;
	    			}
	    		}
	    	}
	    }});		
	}
	public ArrayList<Chunk> getWorldChunks(){
		return this.world.worldChunk;
	}
	public World getWorld(){
		return world;
	}
	public void logout(){
		Progeny.getGame().dispose();
		this.logout  = true;
	}
}
