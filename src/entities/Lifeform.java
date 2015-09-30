package entities;

import game.DNA;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public abstract class Lifeform {
	//biofunctions
	private float health;
	private float temperature;
	private float food;
	private ArrayList<DNA> dna;
	private float energy;
	private float mass;
	private float toxicity;
	private float reproductionTime;

	//movement functions;
	private float rotation;
	private float rotationalInertia;
	private float inertia;
	private Vector2 inertiaVector;
	
	private ArrayList<Vector2> bodyParts;
	private ArrayList<Color> bodyColors;
	
	public abstract int getID();
	public abstract void draw(float x, float y, float z);
	
	public  void update(Lifeform update){
		this.health = update.health;
		this.temperature = update.temperature;
		this.food = update.food;
		this.dna = update.dna;
		this.energy = update.energy;
		this.mass = update.mass;
		this.toxicity = update.toxicity;
		this.rotation = update.rotation;
		this.rotationalInertia = update.rotationalInertia;
		this.inertia = update.inertia;
		this.inertiaVector = update.inertiaVector;
		this.bodyParts = update.bodyParts;
		this.bodyColors = update.bodyColors;
		this.reproductionTime = reproductionTime;
	}
}
