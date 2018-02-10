package com.github.albertopeam

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Rectangle


/**
 * Created by Al on 10/02/2018.
 */
class MoonLanderGame : Game() {

    private var batch: SpriteBatch? = null
    private var rocketTexture: Texture? = null
    private var rocketRect: Rectangle? = null
    private var camera: OrthographicCamera? = null

    override fun create() {
        batch = SpriteBatch()
        rocketTexture = Texture("RocketDouble1.png")
        camera = OrthographicCamera()
        camera?.setToOrtho(false, Configuration.width, Configuration.heigth)
        rocketRect = Rectangle()
        rocketRect?.x = 800f / 2 - 64 / 2
        rocketRect?.y = 20f
        rocketRect?.width = Configuration.rocketWidth
        rocketRect?.height = Configuration.rocketHeight
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera?.update()
        batch?.projectionMatrix = camera?.combined

        batch?.begin()
        batch?.draw(rocketTexture, 0f, 0f, Configuration.rocketWidth, Configuration.rocketHeight)
        batch?.end()
    }

    override fun dispose() {
        batch?.dispose()
        rocketTexture?.dispose()
    }
}