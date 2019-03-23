package com.artgame.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Yama extends GameObject {
    public Yama(TextureRegion textureRegion, float x, float y, float width, float height) {
        super(textureRegion, x, y, width, height);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }
}
