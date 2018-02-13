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
import com.badlogic.gdx.utils.viewport.*


/**
 * Created by Al on 10/02/2018.
 */
class MoonLanderGame : Game() {

    private var shapeRenderer: ShapeRenderer? = null
    private var viewport:Viewport? = null
    private var camera: OrthographicCamera? = null
    private var sky:Sky? = null
    private var input:Input? = null

    private var batch: SpriteBatch? = null
    private var rocketRect: Rectangle? = null


    override fun create() {
        shapeRenderer = ShapeRenderer()
        camera = OrthographicCamera()
        viewport = ExtendViewport(Gdx.graphics.getWidth().toFloat(),
                Gdx.graphics.getHeight().toFloat(),
                camera)
        viewport!!.setScreenBounds(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight())
        //camera!!.position.set(camera!!.viewportWidth / 2f, camera!!.viewportHeight / 2f, 0F)
        //camera!!.update()
        input = Input(camera!!, Configuration.rotationSpeed)
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
        sky?.resize(width, height)

        val aspectRatio = 1F * width / height
        camera?.setToOrtho(false, width.toFloat(), height.toFloat())
        //camera?.viewportWidth = width / 6F
        //camera?.viewportHeight = height / 6F * aspectRatio

    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        shapeRenderer?.projectionMatrix = camera?.combined
        input?.handleInput()
        camera?.update()
        sky!!.update()
    }

    override fun dispose() {
        shapeRenderer?.dispose()
        batch?.dispose()
    }
}
