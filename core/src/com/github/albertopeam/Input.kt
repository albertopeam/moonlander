package com.github.albertopeam

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.Input.Keys

/**
 * Created by alberto.penas.amor on 13/2/18.
 */
class Input(private val camera: OrthographicCamera, private val rotationSpeed:Float){

    fun handleInput() {
        if (Gdx.input.isKeyPressed(Keys.A)) {
            camera.zoom += 0.02F
        }
        if (Gdx.input.isKeyPressed(Keys.Q)) {
            camera.zoom -= 0.02F
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            camera.translate(-3F, 0F, 0F)
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            camera.translate(3F, 0F, 0F)
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            camera.translate(0F, -3F, 0F)
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            camera.translate(0F, 3F, 0F)
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            camera.rotate(-rotationSpeed, 0F, 0F, 1F)
        }
        if (Gdx.input.isKeyPressed(Keys.E)) {
            camera.rotate(rotationSpeed, 0F, 0F, 1F)
        }

//        camera.zoom = MathUtils.clamp(camera.zoom, 0.1F, 100 / camera.viewportWidth)
//
//        val effectiveViewportWidth = camera.viewportWidth * camera.zoom
//        val effectiveViewportHeight = camera.viewportHeight * camera.zoom
//
//        camera.position.x = MathUtils.clamp(camera.position.x, effectiveViewportWidth / 2f, 100 - effectiveViewportWidth / 2f)
//        camera.position.y = MathUtils.clamp(camera.position.y, effectiveViewportHeight / 2f, 100 - effectiveViewportHeight / 2f)
    }
}