package com.github.albertopeam

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.math.Vector3
import java.util.*

/**
 * Created by alberto.penas.amor on 12/2/18.
 */
class Sky(private val shapeRenderer: ShapeRenderer,
          private var width:Int,
          private var height:Int,
          private val starDensity:Float,
          private val moonRadius:Float) {

    private var moon:Vector3? = null
    private var stars:MutableList<Vector3>? = null
    private val random = Random()

    init {
        resize(width, height)
    }

    fun resize(width:Int, height:Int){
        //TODO: improve resize behaviour,it adds random stars...
        this.width = width
        this.height = height
        val starCount:Int = (width * height * starDensity).toInt()
        stars = mutableListOf()
        for (i in 0..starCount){
            val x:Float = random.nextInt(width).toFloat()
            val y:Float = random.nextInt(height).toFloat()
            val radius:Float = random.nextInt(3).toFloat()
            stars!!.add(Vector3(x, y, radius))
        }
        moon = Vector3(width.toFloat() - moonRadius*1.5F, height.toFloat() - moonRadius*1.5F, moonRadius)
    }

    fun update(){
        shapeRenderer.begin(ShapeType.Filled)
        shapeRenderer.color = Color.WHITE
        for (star in stars!!) {
            shapeRenderer.circle(star.x, star.y, star.z)
        }
        shapeRenderer.circle(moon!!.x, moon!!.y, moon!!.z)
        shapeRenderer.end()
    }
}