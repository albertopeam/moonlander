package com.github.albertopeam

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.graphics.glutils.ShapeRenderer




/**
 * Created by Al on 10/02/2018.
 */
class MoonLanderGame : Game() {

    private var shapeRenderer: ShapeRenderer? = null
    private var camera: OrthographicCamera? = null
    private var sky:Sky? = null

    private var batch: SpriteBatch? = null
    private var rocketRect: Rectangle? = null


    override fun create() {
        shapeRenderer = ShapeRenderer()
        camera = OrthographicCamera()
        sky = Sky(shapeRenderer!!,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight(),
                Configuration.starDensity,
                Configuration.moonRadius)

        batch = SpriteBatch()
        rocketRect = Rectangle()
        rocketRect?.x = 800f / 2 - 64 / 2
        rocketRect?.y = 20f
        rocketRect?.width = Configuration.rocketWidth
        rocketRect?.height = Configuration.rocketHeight
    }

    override fun resize(width: Int, height: Int) {
        val aspectRatio = 1F * width / height
        camera?.setToOrtho(false, width.toFloat(), height.toFloat())
        sky!!.resize(width, height)
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera?.update()
        shapeRenderer?.projectionMatrix = camera?.combined
        //batch?.projectionMatrix = camera?.combined

        sky!!.update()
    }

    override fun dispose() {
        shapeRenderer?.dispose()
        batch?.dispose()
    }
}
