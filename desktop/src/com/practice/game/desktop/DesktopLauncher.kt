package com.practice.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.practice.game.TruthOrDareGame

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        config.width = 1920
        config.height = 1080
        LwjglApplication(TruthOrDareGame(), config)
    }
}
