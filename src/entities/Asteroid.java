package entities;

import game.Location;

public class Asteroid {
	Integer[] points;
	Location location;

	public Asteroid(Location position){
		this.location = position;
	}
	public Integer[] getPoints(){
		return this.points;
	}
}

	