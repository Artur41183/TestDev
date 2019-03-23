package com.artgame.view;

import com.artgame.model.Background;
import com.artgame.model.Car;
import com.artgame.model.Yama;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class GameScreen implements Screen {


    private TextureAtlas textureAtlas;
    private SpriteBatch batch;
    private Car car;
    private Background background;
    private Yama yama;
    private OrthographicCamera camera;


    public static float deltaCff;

    @Override
    public void show() {
        batch = new SpriteBatch();
        car = new Car(textureAtlas.findRegion("car"),0,0,2f,2*2.02f);
        background = new Background(textureAtlas.findRegion("grass"),0,0,15f,15f);
        yama = new Yama(textureAtlas.findRegion("yama"),0,0,192,183);


    }

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255,250,250,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        background.draw(batch);
        yama.draw(batch);
        car.draw(batch);
        batch.end();


    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float)height/width;
        camera = new OrthographicCamera(20f,20f*aspectRatio);
        camera.zoom = 1.5f;
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();


    }
}
