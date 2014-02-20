package com.ttgames.Blacksmith.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ttgames.Blacksmith.Screens.AbstractScreen;
import com.ttgames.Blacksmith.Screens.MainScreen;

public class MenuBuilder {

	public static ScrollPane buildGameMenu(final MainScreen screen) {
		//Texture fontTexture = new Texture(
				//Gdx.files.internal("fonts/irisUPC.png"));
		//fontTexture.setFilter(TextureFilter.Linear,
				//TextureFilter.MipMapLinearLinear);
		//TextureRegion fontRegion = new TextureRegion(fontTexture);
		//BitmapFont font = new BitmapFont(
				//Gdx.files.internal("fonts/irisUPC.fnt"), fontRegion, false);
		BitmapFont font = new BitmapFont();
		font.setUseIntegerPositions(false);

		ButtonStyle style = new ButtonStyle();
		//style.up = new TextureRegionDrawable(new TextureRegion(new Texture(
				//Gdx.files.internal("textures/misc/button_down.png"))));
		style.unpressedOffsetX = 5f;
		style.pressedOffsetX = style.unpressedOffsetX + 1f;
		style.pressedOffsetY = -1f;

		LabelStyle lStyle = new LabelStyle();
		lStyle.font = font;

		Table mainTable = new Table();
		mainTable.defaults().width(80);

		ScrollPane scrollPane = new ScrollPane(mainTable);
		scrollPane.setFillParent(false);
		scrollPane.setX(-10);
		scrollPane.setY(screen.stage.getHeight() - 200);

		Button b1 = new Button(style);
		b1.add(new Label("Trade", lStyle));
		b1.left();
		b1.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				// screen.selectedMove();
				screen.menuTrade();
			}
		});
		mainTable.add(b1);
		mainTable.row();

		Button b2 = new Button(style);
		b2.add(new Label("Inventory", lStyle));
		b2.left();
		b2.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				screen.menuInventory();
			}
		});
		mainTable.add(b2);
		mainTable.row();
		
		Button b3 = new Button(style);
		b3.add(new Label("Settings", lStyle));
		b3.left();
		b3.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				screen.menuSettings();
			}
		});
		mainTable.add(b3);
		mainTable.row();
		
		Button b4 = new Button(style);
		b4.add(new Label("Exit", lStyle));
		b4.left();
		b4.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				screen.menuExit();
			}
		});
		mainTable.add(b4);
		mainTable.row();

		// Make a bunch of filler buttons
//		for (int i = 0; i < 10; i++) {
//			Button b = new Button(style);
//			b.add(new Label("Wait", lStyle));
//			b.left();
//			b.addListener(new ChangeListener() {
//				public void changed(ChangeEvent event, Actor actor) {
//					System.out.println("Wait");
//				}
//			});
//			mainTable.add(b);
//			mainTable.row();
//		}

		return scrollPane;
	}
}
