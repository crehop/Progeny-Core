package utils;

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
	public static int count = 0;
	private static Packet2Body packet2;
	public static Vector2 p1 = new Vector2();
	public static Vector2 p2 = new Vector2();
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
		System.out.println(packet.getID());
		if(packet.getID() == -1){
			count = 0;
			Console.setLine2("CONFIRM RESET");
		}else{
			Progeny.server.getWorld().getWorld().getBodies(bodies);
			packet2 = packet;
			BodyDef bdef = packet2.getBodyDef();
			FixtureDef fdef = new FixtureDef();
			CircleShape shape2 = new CircleShape();
			p1 = p1.set(packet2.getBodyDef().position.x, packet2.getBodyDef().position.y);
			p2 = p2.set((packet2.getBodyDef().position.x + 10.01f), (packet2.getBodyDef().position.y));
			Progeny.server.getWorld().getWorld().rayCast(callback, p1, p2);
			if(collided != null)Console.setLine2("COLLISION" + collided.toString());
			shape2.setRadius(20.0f);
			fdef.shape = shape2;
			fdef.density = 200;
			fdef.friction = 1000;
			System.out.println("BODY RECIEVED" + bdef.position.x + "/" + bdef.position.y + " ID:" +  packet.getID());
			bdef.position.set(bdef.position.x - Gdx.graphics.getWidth()/2, bdef.position.y - Gdx.graphics.getHeight()/2);
			Body body = Progeny.server.getWorld().getWorld().createBody(bdef);
			body.createFixture(fdef);
			count++;
		}
	}

	public static int getCount() {
		return count;
	}
}
