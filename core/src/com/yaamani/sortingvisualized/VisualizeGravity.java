package com.yaamani.sortingvisualized;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.yaamani.sortingvisualized.MyUtils.*;
import static com.yaamani.sortingvisualized.Gravity.*;

public class VisualizeGravity {

    public static final String TAG = VisualizeGravity.class.getSimpleName();

    private int[] array;
    private int rows;
    private int poles;
    private byte[][] RP;

    private int i;
    private int j;

    private static int rectWidth;
    private static int rectHeight;

    public VisualizeGravity(int[] array) {
        this.array = array;
        this.rows = array.length;
        this.poles = max(array);
        RP = initializeRP(array, rows, poles);

        i = poles-1;

        rectWidth = (int) ((float) Gdx.graphics.getWidth() / (float) poles);
        rectHeight = (int) ((float) Gdx.graphics.getHeight() / (float) rows);
    }

    public void draw(ShapeRenderer shapeRenderer) {
        drawRB(shapeRenderer);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        if (i >= 0) {
            int alreadyOneIndex = rows;
            for (int c = rows-1; c >= 0; c--) {
                if (RP[c][i] == 1) {
                    alreadyOneIndex--;
                } else break;
            }
            if (alreadyOneIndex == 0) i = -1;
            if (j < alreadyOneIndex & i > -1) {
                if (RP[j][i] == 1) {
                    RP[j][i] = 0;
                    RP[alreadyOneIndex -1][i] = 1;
                    alreadyOneIndex--;
                    shapeRenderer.setColor(Color.BLUE);
                    shapeRenderer.rect(i*rectWidth, (rows-1-alreadyOneIndex-1)*rectHeight, rectWidth, rectHeight);
                }
            }
            j++;
            if (j >= alreadyOneIndex) {
                i--;
                j = 0;
            }
            shapeRenderer.setColor(Color.GREEN);
            shapeRenderer.rect(i*rectWidth, (rows-1-j)*rectHeight, rectWidth, rectHeight);
        }

        shapeRenderer.end();
    }

    public void drawRB(ShapeRenderer shapeRenderer) {
        drawRB(this.RP, shapeRenderer);
    }

    public static void drawRB(byte[][] RP, ShapeRenderer shapeRenderer) {
        int rows = RP.length;
        int poles = RP[0].length;

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < poles; j++)
                if (RP[i][j] == 1) shapeRenderer.rect(j*rectWidth, (rows-1-i)*rectHeight, rectWidth, rectHeight);
        shapeRenderer.end();
    }
}
