package com.artgame.control;

import com.artgame.view.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;

public class CarController {

    private Polygon carBounds;
    private float carSpeed, speedVelocity = 10f,speedMax = 10f;
    private float rotationSpeed = 30f;

    public CarController(Polygon carBounds){
        this.carBounds = carBounds;

    }

    public void handle(){

        //Всё,что связано со ск-тью
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            carSpeed += speedVelocity * GameScreen.deltaCff;
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            carSpeed -= speedVelocity * GameScreen.deltaCff;
        else downSpeed();

        carSpeed = sliceSpeed();
        //

        //Всё,что связано с поворотом
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            carBounds.rotate(rotationSpeed * carSpeed * GameScreen.deltaCff);
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            carBounds.rotate(-rotationSpeed * carSpeed * GameScreen.deltaCff);
        ///

        carBounds.setPosition(carBounds.getX()+ MathUtils.cosDeg(carBounds.getRotation()+90) * carSpeed * GameScreen.deltaCff,
                            carBounds.getY()+ MathUtils.sinDeg(carBounds.getRotation()+90) * carSpeed * GameScreen.deltaCff);

    }
    private void downSpeed(){  //Гасим ск-ть
        if (carSpeed > speedVelocity * GameScreen.deltaCff)
            carSpeed -= speedVelocity * GameScreen.deltaCff;
        else if(carSpeed < -speedVelocity * GameScreen.deltaCff)
            carSpeed += speedVelocity * GameScreen.deltaCff;
        else carSpeed = 0f;

    }

    private float sliceSpeed(){  //Ограничеваем ск-ть
        if (carSpeed > speedMax)
            return speedMax;
        if(carSpeed < -speedMax)
            return -speedMax;

        return carSpeed;

    }
}
