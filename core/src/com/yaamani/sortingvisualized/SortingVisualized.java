package com.yaamani.sortingvisualized;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.TimeUtils;

import static com.yaamani.sortingvisualized.MyUtils.*;
import static com.yaamani.sortingvisualized.Quick.*;
import static com.yaamani.sortingvisualized.Gravity.*;

public class SortingVisualized extends ApplicationAdapter {

    public static final String TAG = SortingVisualized.class.getSimpleName();

    private ShapeRenderer shapeRenderer;
    private VisualizeGravity visualizeGravity;

	@Override
	public void create () {

	    shapeRenderer = new ShapeRenderer();
	    visualizeGravity = new VisualizeGravity(generateRandomArray((int) (Gdx.graphics.getHeight()/10f), 0, (int) (Gdx.graphics.getWidth()/10f)));


        //testChoosePivot();
        //testInitializeRP(true);
        //testSimulateGravity(true);
        //compareGravityQuick();
    }


	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//visualizeGravity.drawRB(shapeRenderer);
		visualizeGravity.draw(shapeRenderer);
	}
	
	@Override
	public void dispose () {
        shapeRenderer.dispose();
	}
}
