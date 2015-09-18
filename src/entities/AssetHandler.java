package entities;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;

public class AssetHandler {
	public AssetManager assets;
	public HashMap<String,Model> loadedModels = new HashMap<String,Model>();
	public ArrayList<Model> dispose = new ArrayList<Model>();
	public AssetHandler(){
		assets = new AssetManager();
		assets.finishLoading();
	}
	public AssetManager getAssetManager(){
		return assets;
	}
	public void storeModel(Model model, String key){
		dispose.add(model);
		loadedModels.put(key,model);
	}
	public Model getModel(String string) {
		if(loadedModels.containsKey(string)){
			return loadedModels.get(string);
		}
		else{
			try {
				throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public void dispose() {
		for(Model model:dispose){
			model.dispose();
		}
	}
	public void addDisposable(Model model){
		dispose.add(model);
	}
}
