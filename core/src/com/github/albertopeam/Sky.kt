package com.github.albertopeam

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.math.Vector2
import java.util.*


/**
 * Created by alberto.penas.amor on 12/2/18.
 */
class Sky(private val shapeRenderer: ShapeRenderer) {

    var stars:MutableList<Vector2>? = null

    init {
        val screenWidth = Gdx.graphics.getWidth()
        val screenHeight = Gdx.graphics.getHeight()
        val starCount:Int = (screenHeight * screenWidth * Configuration.starDensity).toInt()
        stars = mutableListOf()
        val random = Random()
        for (i in 0..starCount){
            val x:Float = random.nextInt(screenWidth).toFloat()
            val y:Float = random.nextInt(screenHeight).toFloat()
            stars!!.add(Vector2(x, y))
        }
    }

    fun update(){
        shapeRenderer.begin(ShapeType.Point)
        for (star in stars!!) {
            shapeRenderer.point(star.x, star.y, 0F)
        }
        shapeRenderer.end()
    }
}