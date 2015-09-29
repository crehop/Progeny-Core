package game;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import packets.Packet;
import packets.Packet1Connect;
import packets.Packet7WorldCreation;
import progeny.Progeny;
import screens.LoginGui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class ServerComms{
	private String configurableIP = "127.0.0.1";
	private int configurablePORT = 12253;
	private GameWorld world = null;
	private Client client;
	private Packet1Connect packet1;
	private Packet7WorldCreation packet7;
	private boolean logout = false;
	private boolean loginConfirm = false;
	private Integer[][] worldChunks;
	
	
	public ServerComms() throws UnknownHostException, IOException{
		client = new Client();
		client.start();
		client.getKryo().register(Packet.class);
		client.getKryo().register(Packet1Connect.class);
		client.getKryo().register(Packet7WorldCreation.class);
		client.getKryo().register(Integer[][].class);
		client.getKryo().register(Integer[].class);
		try{
			client.connect(5000, "127.0.0.1", 54555, 54777);
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "SERVER FAILED TO START, CANNOT CONNECT! \n PLEASE CONFIRM IP EXAMPLE:127.0.0.1:55565");
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
		    			JOptionPane.showMessageDialog(null,"CONNECTION DENIED: BAD USERNAME/PASSWORD");
	    				Gdx.app.exit();
	    			}else{
	    				JOptionPane.showMessageDialog(null,"CONNECTION CONFIRMED: " + packet1.getUsername() + "\n Welcome to Hopnet!");
	    				loginConfirm = true;
	    			}
	    		}else if(object instanceof Packet7WorldCreation){
	    			packet7 = (Packet7WorldCreation)object;
	    			if(packet7.worldRecieved()){
						System.out.println("World Recieved, Creating.....");
	    				worldChunks = packet7.getWorld();
	    			}else{
	    				JOptionPane.showMessageDialog(null,"WORLD LOAD FAILED!");
	    				logout();
	    			}
	    		}
	    	}
	    }});		
	}
	public ArrayList<Chunk> getWorldChunks(){
		if(world == null){
			world = new GameWorld(worldChunks);
		}
		return this.world.worldChunk;
	}
	public GameWorld getWorld(){
		if(world == null){
			world = new GameWorld(worldChunks);
		}
		return world;
	}
	public void logout(){
		Progeny.getGame().dispose();
		this.logout  = true;
	}
}
