package server;

import java.util.ArrayList;

public class ServerComms {
	private static Server server;
	private static boolean started = false;
	public static void decode(String string){
		
	}
	public static String encode(){
		return null;
	}
	public static ArrayList<Chunk> getWorld(){
		if(started){
			return server.getWorldChunks();
		}else{
			server = new Server();
			started = true;
			return server.getWorldChunks();
		}
	}
}
