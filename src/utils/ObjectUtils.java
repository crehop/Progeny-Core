package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;

import packets.Packet2Body;
import utils.Console;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.RayCastCallback;

import entities.Ball;
import entities.Poly;
import entities.RenderBody;
import game.Location;

public class ObjectUtils {
	private static Packet2Body packet2;
	public static Vector2 p1 = new Vector2();
	public static Vector2 p2 = new Vector2();
	public static float radius;
	public static HashMap<Integer,RenderBody> objectMap = new HashMap<Integer,RenderBody>();
	public static ArrayList<RenderBody> renderBodies = new ArrayList<RenderBody>();
	static RayCastCallback callback = new RayCastCallback(){
		@Override
		public float reportRayFixture(Fixture col, Vector2 v1, Vector2 v2,
				float arg3) {
			System.out.println("RAY CHECK:" + v1.x + "/" + v1.y + "/" + col.toString());
			return 0;
		}
	};
	public static void copy(Packet2Body packet){
		if(packet.getID() == -1){
			return;
		}
		packet2 = packet;
		if(packet2.getRaidus() > 0){
			radius = packet2.getRaidus();
			System.out.println("RADIUS" + packet2.getRaidus());
		}else{
		}
		p1 = p1.set(packet2.getBodyDef().position.x, packet2.getBodyDef().position.y);
		p2 = p2.set((packet2.getBodyDef().position.x + 10.01f), packet2.getBodyDef().position.y);
		//Progeny.server.getWorld().getWorld().rayCast(callback, p1, p2);
		//if(collided != null)Console.setLine2("COLLISION" + collided.toString());		
		Console.setLine4("LOCATION = " + packet2.getBodyDef().position.x + "," + packet2.getBodyDef().position.y);
	}
	public static float roundDown3(float d) {
	    return (float) ((float)(d * 1e3) / 1e3);
	}
	public static void process(Packet2Body packet) {
		if(packet.getID() == -1){
			return;
		}else if(objectMap.containsKey(packet.getID())){
			Console.setLine5("GETCOUNT!:" + packet.getID());
			Console.setLine2("POLY?:" + packet.isPolygon());
			if(!packet.isPolygon()){
				Ball ball = (Ball)objectMap.get(packet.getID());
				ball.setLocation(new Location(packet.location.x,packet.location.y,0));
				ball.setRadius(packet.getRaidus());
				if(!renderBodies.contains(objectMap.get(packet.getID()))){
					renderBodies.listIterator().add(ball);
				}
			}else if(packet.isPolygon()){
				Poly poly = (Poly)objectMap.get(packet.getID());
				poly.setLocation(new Location(packet.location.x,packet.location.y,0));
				if(!renderBodies.contains(objectMap.get(packet.getID()))){
					renderBodies.listIterator().add(poly);
				}
			}
		}else{
			if(!packet.isPolygon()){
				objectMap.put(packet.getID(), new Ball(new Location(packet.location.x, packet.location.y, 0), packet.getRaidus()));
				renderBodies.listIterator().add(objectMap.get(packet.getID()));
			}else{
				objectMap.put(packet.getID(), new Poly(packet.getVertices(),new Location(packet.location.x, packet.location.y, 0)));
				renderBodies.listIterator().add(objectMap.get(packet.getID()));
			}
		}
	}
}
