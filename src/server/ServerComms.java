package server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import packets.Packet;
import packets.Packet1Connect;

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

	
	public ServerComms() throws UnknownHostException, IOException{
		client = new Client();
		client.start();
		try{
			client.connect(5000, "127.0.0.1", 54555, 54777);
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "SERVER FAILED TO START, CANNOT CONNECT! \n PLEASE CONFIRM IP EXAMPLE:127.0.0.1:55565");
		}
		client.getKryo().register(Packet.class);
		client.getKryo().register(Packet1Connect.class);
		packet1 = new Packet1Connect();
		String name = JOptionPane.showInputDialog("PLEASE LOGIN");
		packet1.setName(name);
		client.sendTCP(packet1);
		System.out.println("PACKET NAME IS" + packet1.name);
		this.initializeListener();
		this.initialize();
	}
	private void initialize() {
		configurableWorldSizeX = 100;
		configurableWorldSizeY= 200;
		System.out.println("Initializing Server...." );
		 world = new World(configurableWorldSizeX,configurableWorldSizeY,new Texture("terrain/tiles.png"));
			System.out.println("World Created Successfully!" );
	}
	private void initializeListener() {
		System.out.println("Initializing Listener...." );
	    client.addListener(new Listener() {
	    public void received (Connection connection, Object object) {
	    	if(object instanceof Packet){
	    		if(object instanceof Packet1Connect){
	    			packet1 = (Packet1Connect)object;
	    			System.out.println();
	    			JOptionPane.showInputDialog("CONNECTION CONFIRMED: " + packet1.getName());
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
}
