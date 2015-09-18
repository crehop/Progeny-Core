package actors;

import progeny.Progeny;

//ADD A FUNCTION FOR THIS IN THE SWITCH!
import com.badlogic.gdx.Gdx;

public class ButtonFunctions {
	public static void function(int function){
		switch(function){
			case 1:
				Progeny.getGame();
				Progeny.getGame().setScreen(Progeny.player);
				Gdx.input.setInputProcessor(Progeny.controls);
				Gdx.input.setCursorCatched(true);
				break;
			default:
				System.out.println("BUTTON FUNCTION NOT FOUND: ButtonFunctions.java:4");
		}
	}
}
