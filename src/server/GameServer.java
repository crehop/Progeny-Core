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

public class GameServer{
	private int configurableWorldSizeX;
	private int configurableWorldSizeY;
	private String configurableIP = "127.0.0.1";
	private int configurablePORT = 12253;
	private World world;
	private Client client;
	private Packet1Connect packet1;

	
	public GameServer() throws UnknownHostException, IOException{
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
		JOptionPane.showInputDialog("PLEASE LOGIN");
		String name = " DID NOT WORK ";
		packet1.setName(name);
		client.sendTCP(packet1);

		
		this.initialize();
	}
	private void initialize() {
		configurableWorldSizeX = 100;
		configurableWorldSizeY= 200;
		System.out.println("Initializing Server...." );
		 world = new World(configurableWorldSizeX,configurableWorldSizeY,new Texture("terrain/tiles.png"));
			System.out.println("World Created Successfully!" );
	}
	public ArrayList<Chunk> getWorldChunks(){
		return this.world.worldChunk;
	}
	public World getWorld(){
		return world;
	}
}
