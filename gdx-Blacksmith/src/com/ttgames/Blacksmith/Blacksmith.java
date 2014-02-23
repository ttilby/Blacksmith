package com.ttgames.Blacksmith;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.FPSLogger;
import com.ttgames.Blacksmith.Screens.AbstractScreen;
import com.ttgames.Blacksmith.Screens.ChooseProfileScreen;
import com.ttgames.Blacksmith.Screens.GameOptionsScreen;
import com.ttgames.Blacksmith.Screens.InventoryScreen;
import com.ttgames.Blacksmith.Screens.LoadingScreen;
import com.ttgames.Blacksmith.Screens.MainScreen;
import com.ttgames.Blacksmith.Screens.MenuScreen;
import com.ttgames.Blacksmith.Screens.OptionsScreen;
import com.ttgames.Blacksmith.Screens.SplashScreen;
import com.ttgames.Blacksmith.Screens.StartGameScreen;
import com.ttgames.Blacksmith.Screens.TraderListScreen;
import com.ttgames.Blacksmith.Screens.TraderScreen;
import com.ttgames.Blacksmith.Services.ProfileManager;

public class Blacksmith extends Game {

	/* Debugging variables */ 
	public static final boolean DEV_MODE = true;
	private static final boolean SHOW_FPS = false;
	
	/* used for logging */
	
	public static final String TITLE = Blacksmith.class.getSimpleName();
	public static final String VERSION = "0.0a";
	public static final String LOG = TITLE + " v" + VERSION;
	
	//Logs FPS each second
	private FPSLogger fpsLogger;
	
	private AssetManager assetManager;
	
	private ProfileManager profileManager;
	private float width;
	private float height;
	
	private LoadingScreen loadingScreen;
	private SplashScreen splashScreen;
	private MenuScreen menuScreen;
	private StartGameScreen startGameScreen;
	private OptionsScreen optionsScreen; 			// General Options
	private GameOptionsScreen gameOptionsScreen;	// Profile specific Options + General Options
	private MainScreen mainScreen;
	private InventoryScreen inventoryScreen;
	private ChooseProfileScreen chooseProfileScreen;
	//private TraderListScreen traderListScreen;
	//private TraderScreen traderScreen;
	
	
	public Blacksmith(){
		
	}
	
	
	public LoadingScreen getLoadingScreen(){
		if(loadingScreen == null) loadingScreen = new LoadingScreen(this);
		return loadingScreen;
	}
	
	public SplashScreen getSplashScreen(){
		if(splashScreen == null) splashScreen = new SplashScreen(this);
		return splashScreen;
	}
	
	public MenuScreen getMenuScreen(){
		if(menuScreen == null) menuScreen = new MenuScreen(this);
		return menuScreen;
	}
	
	public StartGameScreen getStartGameScreen(){
		if(startGameScreen == null) startGameScreen = new StartGameScreen(this);
		return startGameScreen;
	}
	
	public OptionsScreen getOptionsScreen(){
		if(optionsScreen == null) optionsScreen = new OptionsScreen(this);
		return optionsScreen;
	}
	
	public GameOptionsScreen getGameOptionsScreen(){
		if(gameOptionsScreen == null) gameOptionsScreen = new GameOptionsScreen(this);
		return gameOptionsScreen;
	}
	
	public MainScreen getMainScreen(){
		if(mainScreen == null) mainScreen = new MainScreen(this);
		return mainScreen;
	}
	
	public InventoryScreen getInventoryScreen(){
		if(inventoryScreen == null) inventoryScreen = new InventoryScreen(this);
		return inventoryScreen;
	}
	
	public ChooseProfileScreen getChooseProfileScreen(){
		if(chooseProfileScreen == null) chooseProfileScreen = new ChooseProfileScreen(this);
		return chooseProfileScreen;
	}
	
//	public TraderListScreen getTraderListScreen(){
//		if(traderListScreen == null) traderListScreen = new TraderListScreen(this);
//		return traderListScreen;
//	}
	
	public TraderScreen getTraderScreen(com.ttgames.Blacksmith.Characters.Character characterTradeWith){
		return new TraderScreen(this, characterTradeWith);
	}
	
	public ProfileManager getProfileManager(){
		if(profileManager == null){
			Gdx.app.log(Blacksmith.LOG, "Profile not yet setup! Creating new Profile Manager.");
			profileManager = new ProfileManager();
		}
		return profileManager;
	}
	
	public AssetManager getAssetManager(){
		if(assetManager == null){
			assetManager = new AssetManager();
		}
		return assetManager;
	}
	
	@Override
	public void create() {
		Gdx.app.log(Blacksmith.LOG, "Creating game");
		
		profileManager = new ProfileManager();
		
		fpsLogger  = new FPSLogger();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(Blacksmith.LOG, "Resizing game to: W" + width + " x H" + height);
		super.resize(width, height);
		this.height = height;
		this.width = width;
		
		if(getScreen() == null) setScreen(getLoadingScreen());
	}

	@Override
	public void render() {
		super.render();
		
		if(SHOW_FPS){
			fpsLogger.log();
		}
	}

	@Override
	public void pause() {
		
		Gdx.app.log(Blacksmith.LOG, "Pausing game");
		super.pause();
		
		profileManager.persist();
	}

	@Override
	public void resume() {
		
		Gdx.app.log(Blacksmith.LOG, "Resuming game");
		super.resume();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.badlogic.gdx.Game#setScreen(com.badlogic.gdx.Screen)
	 * 
	 */
	public void setScreen(Screen screen){
		Gdx.app.log(Blacksmith.LOG, "Setting screen: " + screen.getClass().getSimpleName());
		super.setScreen(screen);
	}

	@Override
	public void dispose() {
		Gdx.app.log(Blacksmith.LOG, "Disposing game");
		super.dispose();
	}
	
	public float getHeight(){
		return height;
	}
	
	public float getWidth(){
		return width;
	}

}
