package com.artgame.model;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;


public abstract class GameObject {
    Polygon bonds;
    Sprite object;
    Sprite back;
    Sprite yama;

    public GameObject(TextureRegion textureRegion, float x, float y, float width, float height){

        object = new Sprite(textureRegion);
        back = new Sprite(textureRegion);
        yama = new Sprite(textureRegion);

        object.setSize(width,height);
        object.setOrigin(width/2,height/2);
        object.setPosition(x, y);

        back.setSize(width,height);
        back.setPosition(x, y);

        yama.setSize(width,height);
        yama.setPosition(x, y);

        bonds = new Polygon(new  float[]{0f,0f,width,0f,width,height,0f,height});
        bonds.setPosition(x, y);
        bonds.setOrigin(width/2,height/2);



    }

    public void draw(SpriteBatch batch){
        object.setPosition(bonds.getX(),bonds.getY());
        object.setRotation(bonds.getRotation());
        object.draw(batch);

    }

    public Polygon getBonds() {
        return bonds;
    }
}
