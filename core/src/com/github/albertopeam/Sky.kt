package com.github.albertopeam

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3
import java.util.*


/**
 * Created by alberto.penas.amor on 12/2/18.
 */
class Sky(private val shapeRenderer: ShapeRenderer) {

    private var stars:MutableList<Vector3>? = null
    private val random = Random()

    init {
        val screenWidth = Gdx.graphics.getWidth()
        val screenHeight = Gdx.graphics.getHeight()
        val starCount:Int = (screenHeight * screenWidth * Configuration.starDensity).toInt()
        stars = mutableListOf()
        for (i in 0..starCount){
            val x:Float = random.nextInt(screenWidth).toFloat()
            val y:Float = random.nextInt(screenHeight).toFloat()
            val radius:Float = random.nextInt(3).toFloat()
            stars!!.add(Vector3(x, y, radius))
        }
    }

    fun update(){
        shapeRenderer.begin(ShapeType.Filled)
        shapeRenderer.color = Color.WHITE
        for (star in stars!!) {
            shapeRenderer.circle(star.x, star.y, star.z)
        }
        shapeRenderer.end()
    }
}