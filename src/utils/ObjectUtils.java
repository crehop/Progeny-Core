package utils;

import java.util.HashMap;

import packets.Packet2Body;
import utils.Console;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.RayCastCallback;

public class ObjectUtils {
	private static Packet2Body packet2;
	public static Vector2 p1 = new Vector2();
	public static Vector2 p2 = new Vector2();
	private static HashMap<Integer,Body> bodiesMap = new HashMap<Integer,Body>();
	static RayCastCallback callback = new RayCastCallback(){
		@Override
		public float reportRayFixture(Fixture col, Vector2 v1, Vector2 v2,
				float arg3) {
			System.out.println("RAY CHECK:" + v1.x + "/" + v1.y + "/" + col.toString());
			return 0;
		}
	};
	public static void copy(Packet2Body packet){
		Console.setLine5("GETCOUNT!:" + packet.getID());
		if(packet.getID() == -1){
			return;
		}
		packet2 = packet;
		p1 = p1.set(packet2.getBodyDef().position.x, packet2.getBodyDef().position.y);
		p2 = p2.set((packet2.getBodyDef().position.x + 10.01f), packet2.getBodyDef().position.y);
		//Progeny.server.getWorld().getWorld().rayCast(callback, p1, p2);
		//if(collided != null)Console.setLine2("COLLISION" + collided.toString());		
		Console.setLine4("LOCATION = " + packet2.getBodyDef().position.x + "," + packet2.getBodyDef().position.y);
	}
	public static float roundDown3(float d) {
	    return (float) ((float)(d * 1e3) / 1e3);
	}
}
