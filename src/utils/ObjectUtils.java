package utils;

import java.util.HashMap;

import packets.Packet2Body;
import progeny.Progeny;
import utils.Console;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.badlogic.gdx.utils.Array;

public class ObjectUtils {
	private static Array<Body> bodies = new Array<Body>();
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
	private static Fixture collided;

	public static void copy(Packet2Body packet){
		Console.setLine5("GETCOUNT!:" + packet.getID());
		packet2 = packet;
		p1 = p1.set(packet2.getBodyDef().position.x, packet2.getBodyDef().position.y);
		p2 = p2.set((packet2.getBodyDef().position.x + 10.01f), packet2.getBodyDef().position.y);
		//Progeny.server.getWorld().getWorld().rayCast(callback, p1, p2);
		//if(collided != null)Console.setLine2("COLLISION" + collided.toString());
		CircleShape shape = new CircleShape();
		shape.setRadius(10.0f);
		FixtureDef fdef = new FixtureDef();
		fdef.shape = shape;
		Progeny.server.getWorld().getWorld().getBodies(bodies);
		Body body;
		if(!(bodiesMap.containsKey(packet2.getID()))){
			body = Progeny.server.getWorld().getWorld().createBody(packet.getBodyDef());
			bodiesMap.put(packet2.getID(), body);
			body.createFixture(fdef);
		}
		else{
			body = bodiesMap.get(packet2.getID());
			body.setTransform(p1,packet2.getAngle());
			
			Console.setLine4("LOCATION = " + packet2.getBodyDef().position.x + "," + packet2.getBodyDef().position.y);
		}
	}
}
