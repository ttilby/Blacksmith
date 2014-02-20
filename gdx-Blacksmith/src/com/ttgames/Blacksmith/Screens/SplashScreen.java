package com.ttgames.Blacksmith.Screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
//import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ttgames.Blacksmith.Blacksmith;

public class SplashScreen extends AbstractScreen {
	
	private Texture splashTexture;
	//private TextureRegion splashTextureRegion;
	
	public SplashScreen(Blacksmith game){
		super(game);
	}
	
	public void show(){
		super.show();
		
		//splashTexture = new Texture("data/images/splashscreen/anvilhammer.png");
		splashTexture = game.getAssetManager().get("data/images/splashscreen/anvilhammer.png", Texture.class);
		
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
	}
	
	public void resize(int width, int height){
		super.resize(width, height);
		
		
		super.resize( width, height );

        // in the image atlas, our splash image begins at (0,0) of the
        // upper-left corner and has a dimension of 512x301
        TextureRegion splashRegion = new TextureRegion( splashTexture, 10, 10, 500, 370);

        // here we create the splash image actor and set its size
        //Image splashImage = new Image( splashRegion, com.badlogic.gdx.utils.Scaling.fillX);
        Image splashImage = new Image(splashRegion);
        splashImage.setWidth(width);
        splashImage.setHeight(height);

        // this is needed for the fade-in effect to work correctly; we're just
        // making the image completely transparent
        splashImage.getColor().a = 0f;

        // configure the fade-in/out effect on the splash image (much faster if DEV_MODE)
        if(Blacksmith.DEV_MODE){
        	splashImage.addAction(sequence(fadeIn(0.1f), delay(0.5f), fadeOut(0.1f), 
    	        new Action(){
    	        	@Override
    	        	public boolean act(float delta){
    	        		game.setScreen( new MenuScreen(game));
    	        		return true;
    	        	}
    	        }
			));
        }else{
        	splashImage.addAction(sequence(fadeIn(0.75f), delay(1.75f), fadeOut(0.75f), 
    	        new Action(){
    	        	@Override
    	        	public boolean act(float delta){
    	        		game.setScreen( new MenuScreen(game));
    	        		return true;
    	        	}
    	        }
			));
        }
        

        // and finally we add the actor to the stage
        stage.addActor( splashImage );
	}
	
	
	
	public void dispose(){
		splashTexture.dispose();
		super.dispose();
		
	}
}
