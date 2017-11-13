package i18n_test

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.I18NBundle
import java.util.*

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class i18n_test : ApplicationAdapter() {
    lateinit private var batch: SpriteBatch
    lateinit private var image: Texture
    lateinit private var font: BitmapFont
    lateinit private var locale: Locale
    lateinit private var bundle:I18NBundle

    override fun create() {
        batch = SpriteBatch()
        image = Texture("badlogic.png")
        font = BitmapFont(Gdx.files.internal("dodum.fnt"))
        locale= Locale("kr")
        bundle= I18NBundle.createBundle(Gdx.files.internal("Bundle"),locale)
        font.color= Color.RED
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(image, 165f, 180f)
        font.draw(batch,bundle.format("GreetingMessage"),130f,150f)
        font.draw(batch,bundle.format("Time",0,0),130f,100f)

        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        image.dispose()
        font.dispose()
    }
}