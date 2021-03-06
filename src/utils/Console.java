package utils;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Console{
	private static boolean consoleOn = true;
	private static String line1 = "1";
	private static String line2 = "2";
	private static String line3 = "3";
	private static String line4 = "4";
	private static String line5 = "5";
	private static String line6 = "6";
	private static String line7 = "7";
	private static String line8 = "8";
	private static String line9 = "9";
	private static String line10 = "10";
	private static int x = 5;
	private static int y = Gdx.graphics.getHeight() - 5;
	private static BitmapFont font = new BitmapFont();
	private static boolean enabled = true;
	private static boolean initiated = false;
	static SpriteBatch batch = new SpriteBatch();
	static Random rand = new Random();
	

	public static void render() {
		if(initiated == false){
			initiated = true;
			font.setScale(1.25f);
		}
		if(enabled){
			checkConsole();
			batch.begin();
			font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			font.draw(batch, line1, x, y); 
			y -= font.getCapHeight() + 3;
			font.draw(batch, line2, x, y); 
			y -= font.getCapHeight() + 3;
			font.draw(batch, line3, x, y); 
			y -= font.getCapHeight() + 3;
			font.draw(batch, line4, x, y); 
			y -= font.getCapHeight() + 3;
			font.draw(batch, line5, x, y); 
			y -= font.getCapHeight() + 3;
			font.draw(batch, line6, x, y); 
			y -= font.getCapHeight() + 3;
			font.draw(batch, line7, x, y); 
			y -= font.getCapHeight() + 3;
			font.draw(batch, line8, x, y); 
			y -= font.getCapHeight() + 3;
			font.draw(batch, line9, x, y); 
			y -= font.getCapHeight() + 3;
			font.draw(batch, line10, x, y); 
			y -= font.getCapHeight() + 3;
			batch.end();
		}
	}
	public static void checkConsole(){
		if(consoleOn){
			y = Gdx.graphics.getHeight() - 5;
			x = 5;
			
			if(line1 == null){
				line1 = "null";
			}
			if(line2 == null){
				line2 = "null";
			}
			if(line3 == null){
				line3 = "null";
			}
			if(line4 == null){
				line4 = "null";
			}
			if(line5 == null){
				line5 = "null";
			}
			if(line6 == null){
				line6 = "null";
			}
			if(line7 == null){
				line7 = "null";
			}
			if(line8 == null){
				line8 = "null";
			}
			if(line9 == null){
				line9 = "null";
			}
			if(line10 == null){
				line10 = "null";
			}
		}
	}
	public static boolean isConsoleOn() {
		return consoleOn;
	}
	public static void setConsoleOn(boolean consoleOn) {
		Console.consoleOn = consoleOn;
	}
	public static String getLine1() {
		return line1;
	}
	public static void setLine1(String line1) {
		Console.line1 = line1;
	}
	public static String getLine2() {
		return line2;
	}
	public static void setLine2(String line2) {
		Console.line2 = line2;
	}
	public static String getLine3() {
		return line3;
	}
	public static void setLine3(String line3) {
		Console.line3 = line3;
	}
	public static String getLine4() {
		return line4;
	}
	public static void setLine4(String line4) {
		Console.line4 = line4;
		line4 = "" + rand.nextInt(20);
	}
	public static String getLine5() {
		return line5;
	}
	public static void setLine5(String line5) {
		Console.line5 = line5;
	}
	public static String getLine6() {
		return line6;
	}
	public static void setLine6(String line6) {
		Console.line6 = line6;
	}
	public static String getLine7() {
		return line7;
	}
	public static void setLine7(String line7) {
		Console.line7 = line7;
	}
	public static String getLine8() {
		return line8;
	}
	public static void setLine8(String line8) {
		Console.line8 = line8;
	}
	public static String getLine9() {
		return line9;
	}
	public static void setLine9(String line9) {
		Console.line9 = line9;
	}
	public static String getLine10() {
		return line10;
	}
	public static void setLine10(String line10) {
		Console.line10 = line10;
	}
}
