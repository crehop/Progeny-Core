package server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import com.badlogic.gdx.graphics.Texture;

public class GameServer{
	private int configurableWorldSizeX;
	private int configurableWorldSizeY;
	private String configurableIP = "127.0.0.1";
	private int configurablePORT = 12253;
	private World world;
	private Socket socket;
	private Scanner scanner;
	
	public GameServer() throws UnknownHostException, IOException{
		socket = new Socket(configurableIP , configurablePORT);
		scanner = new Scanner(socket.getInputStream());
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println("test");
		System.out.println("CONFIRM SENT PACKET!");
		scanner.nextLine();
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
