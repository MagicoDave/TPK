package com.mygdx.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.Locale;

/**
 * Esta clase gestiona la carga de assets
 */
public class AssetLoader {

    /**
     * Archivos de idiomas
     */
    public static I18NBundle enBundle, esBundle, glBundle, myBundle;

    /**
     * Mapas
     */
    public static TiledMap level1, level2, level3, level4;
    /**
     * Creador de niveles
     */
    public static LevelCreator levelCreator;

    /**
     * Texturas de enemigos
     */
    public static Texture farmer, farmerSlowed, barbarian, barbarianSlowed, mage, mageSlowed, thief, thiefSlowed;
    /**
     * TextureRegion de enemigos
     */
    public static TextureRegion farmer1, farmer2, farmer3, farmer4, barbarian1, barbarian2, barbarian3, barbarian4, mage1, mage2, mage3, mage4, thief1, thief2, thief3, thief4;
    /**
     * TextureRegion de enemigos ralentizados
     */
    public static TextureRegion farmerSlowed1, farmerSlowed2, farmerSlowed3, farmerSlowed4, barbarianSlowed1, barbarianSlowed2, barbarianSlowed3, barbarianSlowed4, mageSlowed1, mageSlowed2, mageSlowed3, mageSlowed4, thiefSlowed1, thiefSlowed2, thiefSlowed3, thiefSlowed4;
    /**
     * Animación de enemigos
     */
    public static Animation farmerAnimation, barbarianAnimation, mageAnimation, thiefAnimation;
    /**
     * Animación de enemigos ralentizados
     */
    public static Animation farmerSlowedAnimation, barbarianSlowedAnimation, mageSlowedAnimation, thiefSlowedAnimation;

    /**
     * Texturas de torres
     */
    public static Texture arrowTower, witchTower, stickyTower, cyclopTower;
    /**
     * TextureRegions de torres
     */
    public static TextureRegion arrowTower1, arrowTower2, arrowTower3, arrowTower4, witchTower1, witchTower2, witchTower3, witchTower4, stickyTower1, stickyTower2, stickyTower3, stickyTower4, cyclopTower1, cyclopTower2, cyclopTower3, cyclopTower4;
    /**
     * Animaciones de torres
     */
    public static Animation arrowTowerAnimation, witchTowerAnimation, stickyTowerAnimation, cyclopTowerAnimation;

    /**
     * Texturas de proyectiles
     */
    public static Texture redBullet;
    /**
     * TextureRegion proyectil
     */
    public static TextureRegion redBullet1;

    /**
     * Skins (paquetes de fuente, color y otros parámetros) para labels y botones
     */
    public static Skin skinArcade, skinMother;

    /**
     * Musica
     */
    public static Music musicMainMenu, musicLevel1, musicLevel2, musicLevel3, musicLevel4;
    /**
     * Sonidos
     */
    public static Sound soundArrow, soundBuiltTower, soundCyclop, soundDead, soundDestroyTower, soundFundationSelected, soundRage, soundSticky, soundWitch;

    /**
     * Preferencias (para persistencia de datos)
     */
    public static Preferences preferences;

    /**
     * Texturas para los botones de los menus
     */
    public static TextureRegionDrawable flagEN, flagES, flagGL, backArrow, fundation;

    /**
     * Texturas del parallax del menú principal
     */
    public static Texture pBack, pCloseMount, pClouds, pFarMount, pRaid, pTPK, pWitch;

    /**
     * Carga de assets
     */
    public static void load(){

        //Parallax
        pBack = new Texture(Gdx.files.internal("parallax/pBack.png"));
        pCloseMount = new Texture(Gdx.files.internal("parallax/pCloseMount.png"));
        pClouds = new Texture(Gdx.files.internal("parallax/pClouds.png"));
        pFarMount = new Texture(Gdx.files.internal("parallax/pFarMount.png"));
        pRaid = new Texture(Gdx.files.internal("parallax/pRaid.png"));
        pTPK = new Texture(Gdx.files.internal("parallax/pTPK.png"));
        pWitch = new Texture(Gdx.files.internal("parallax/pWitch.png"));

        //Languages
        FileHandle baseFileHandler = Gdx.files.internal("i18n/strings");
        Locale locale = new Locale("es", "ES");
        esBundle = I18NBundle.createBundle(baseFileHandler, locale);
        locale = new Locale("en", "GB");
        enBundle = I18NBundle.createBundle(baseFileHandler, locale);
        locale = new Locale("gl", "ES");
        glBundle = I18NBundle.createBundle(baseFileHandler, locale);
        myBundle = enBundle;

        //Music
        musicMainMenu = Gdx.audio.newMusic(Gdx.files.internal("music/EggyToast_Condemned.mp3"));
        musicLevel1 = Gdx.audio.newMusic(Gdx.files.internal("music/EggyToast_DeathValley.mp3"));
        musicLevel2 = Gdx.audio.newMusic(Gdx.files.internal("music/EggyToast_Ghost.mp3"));
        musicLevel3 = Gdx.audio.newMusic(Gdx.files.internal("music/EggyToast_LoseYourHead.mp3"));
        musicLevel4 = Gdx.audio.newMusic(Gdx.files.internal("music/EggyToast_EnemiesOfThePeople.mp3"));

        //Sounds
        soundArrow = Gdx.audio.newSound(Gdx.files.internal("sounds/Arrow.mp3"));
        soundBuiltTower = Gdx.audio.newSound(Gdx.files.internal("sounds/BuiltTower.ogg"));
        soundCyclop = Gdx.audio.newSound(Gdx.files.internal("sounds/Cyclop.mp3"));
        soundDead = Gdx.audio.newSound(Gdx.files.internal("sounds/DeadSound.mp3"));
        soundDestroyTower = Gdx.audio.newSound(Gdx.files.internal("sounds/DestroyTower.ogg"));
        soundFundationSelected = Gdx.audio.newSound(Gdx.files.internal("sounds/FundationSelected.ogg"));
        soundRage = Gdx.audio.newSound(Gdx.files.internal("sounds/RageSound.mp3"));
        soundSticky = Gdx.audio.newSound(Gdx.files.internal("sounds/Sticky.mp3"));
        soundWitch = Gdx.audio.newSound(Gdx.files.internal("sounds/Witch.mp3"));

        //Menu ui
        flagEN = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("menu/EN.png"))));
        flagES = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("menu/ES.png"))));
        flagGL = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("menu/GL.png"))));
        backArrow = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("menu/backArrow.png"))));
        fundation = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("menu/fundation.png"))));

        //Levels
        levelCreator = new LevelCreator();
        level1 = new TmxMapLoader().load("maps/level1.tmx");
        level2 = new TmxMapLoader().load("maps/level2.tmx");
        level3= new TmxMapLoader().load("maps/level3.tmx");
        level4= new TmxMapLoader().load("maps/level4.tmx");

        //Skins
        skinArcade = new Skin(Gdx.files.internal("skin/arcade-ui.json"));
        skinMother = new Skin(Gdx.files.internal("skin/mother/terra-mother-ui.json"));

        //Farmer
        farmer = new Texture(Gdx.files.internal("enemies/farmer.png"));
        farmer.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        farmer1 = new TextureRegion(farmer, 0, 0, 24, 24);
        farmer2 = new TextureRegion(farmer, 24, 0, 24, 24);
        farmer3 = new TextureRegion(farmer, 48, 0, 24, 24);
        farmer4 = new TextureRegion(farmer, 72, 0, 24, 24);
        TextureRegion[] farmers = {farmer1, farmer2, farmer3, farmer4};
        farmerAnimation = new Animation(0.1f, farmers);
        farmerAnimation.setPlayMode(Animation.PlayMode.LOOP);

        farmerSlowed = new Texture(Gdx.files.internal("enemies/farmerSlowed.png"));
        farmerSlowed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        farmerSlowed1 = new TextureRegion(farmerSlowed, 0, 0, 24, 24);
        farmerSlowed2 = new TextureRegion(farmerSlowed, 24, 0, 24, 24);
        farmerSlowed3 = new TextureRegion(farmerSlowed, 48, 0, 24, 24);
        farmerSlowed4 = new TextureRegion(farmerSlowed, 72, 0, 24, 24);
        TextureRegion[] farmersSlowed = {farmerSlowed1, farmerSlowed2, farmerSlowed3, farmerSlowed4};
        farmerSlowedAnimation = new Animation(0.1f, farmersSlowed);
        farmerSlowedAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //Barbarian
        barbarian = new Texture(Gdx.files.internal("enemies/barbarian.png"));
        barbarian.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        barbarian1 = new TextureRegion(barbarian, 0, 0, 24, 24);
        barbarian2 = new TextureRegion(barbarian, 24, 0, 24, 24);
        barbarian3 = new TextureRegion(barbarian, 48, 0, 24, 24);
        barbarian4 = new TextureRegion(barbarian, 72, 0, 24, 24);
        TextureRegion[] barbarians = {barbarian1, barbarian2, barbarian3, barbarian4};
        barbarianAnimation = new Animation(0.1f, barbarians);
        barbarianAnimation.setPlayMode(Animation.PlayMode.LOOP);

        barbarianSlowed = new Texture(Gdx.files.internal("enemies/barbarianSlowed.png"));
        barbarianSlowed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        barbarianSlowed1 = new TextureRegion(barbarianSlowed, 0, 0, 24, 24);
        barbarianSlowed2 = new TextureRegion(barbarianSlowed, 24, 0, 24, 24);
        barbarianSlowed3 = new TextureRegion(barbarianSlowed, 48, 0, 24, 24);
        barbarianSlowed4 = new TextureRegion(barbarianSlowed, 72, 0, 24, 24);
        TextureRegion[] barbariansSlowed = {barbarianSlowed1, barbarianSlowed2, barbarianSlowed3, barbarianSlowed4};
        barbarianSlowedAnimation = new Animation(0.1f, barbariansSlowed);
        barbarianSlowedAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //Mage
        mage = new Texture(Gdx.files.internal("enemies/mage.png"));
        mage.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        mage1 = new TextureRegion(mage, 0, 0, 24, 24);
        mage2 = new TextureRegion(mage, 24, 0, 24, 24);
        mage3 = new TextureRegion(mage, 48, 0, 24, 24);
        mage4 = new TextureRegion(mage, 72, 0, 24, 24);
        TextureRegion[] mages = {mage1, mage2, mage3, mage4};
        mageAnimation = new Animation(0.1f, mages);
        mageAnimation.setPlayMode(Animation.PlayMode.LOOP);

        mageSlowed = new Texture(Gdx.files.internal("enemies/mageSlowed.png"));
        mageSlowed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        mageSlowed1 = new TextureRegion(mageSlowed, 0, 0, 24, 24);
        mageSlowed2 = new TextureRegion(mageSlowed, 24, 0, 24, 24);
        mageSlowed3 = new TextureRegion(mageSlowed, 48, 0, 24, 24);
        mageSlowed4 = new TextureRegion(mageSlowed, 72, 0, 24, 24);
        TextureRegion[] magesSlowed = {mageSlowed1, mageSlowed2, mageSlowed3, mageSlowed4};
        mageSlowedAnimation = new Animation(0.1f, magesSlowed);
        mageSlowedAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //Thief
        thief = new Texture(Gdx.files.internal("enemies/thief.png"));
        thief.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        thief1 = new TextureRegion(thief, 0, 0, 24, 24);
        thief2 = new TextureRegion(thief, 24, 0, 24, 24);
        thief3 = new TextureRegion(thief, 48, 0, 24, 24);
        thief4 = new TextureRegion(thief, 72, 0, 24, 24);
        TextureRegion[] thiefs = {thief1, thief2, thief3, thief4};
        thiefAnimation = new Animation(0.1f, thiefs);
        thiefAnimation.setPlayMode(Animation.PlayMode.LOOP);

        thiefSlowed = new Texture(Gdx.files.internal("enemies/thiefSlowed.png"));
        thiefSlowed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        thiefSlowed1 = new TextureRegion(thiefSlowed, 0, 0, 24, 24);
        thiefSlowed2 = new TextureRegion(thiefSlowed, 24, 0, 24, 24);
        thiefSlowed3 = new TextureRegion(thiefSlowed, 48, 0, 24, 24);
        thiefSlowed4 = new TextureRegion(thiefSlowed, 72, 0, 24, 24);
        TextureRegion[] thiefsSlowed = {thiefSlowed1, thiefSlowed2, thiefSlowed3, thiefSlowed4};
        thiefSlowedAnimation = new Animation(0.1f, thiefsSlowed);
        thiefSlowedAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //ArrowTower
        arrowTower = new Texture(Gdx.files.internal("towers/arrowtower.png"));
        arrowTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        arrowTower1 = new TextureRegion(arrowTower, 0, 0, 24, 24);
        arrowTower2 = new TextureRegion(arrowTower, 24, 0, 24, 24);
        arrowTower3 = new TextureRegion(arrowTower, 48, 0, 24, 24);
        arrowTower4 = new TextureRegion(arrowTower, 72, 0, 24, 24);
        TextureRegion[] atowers = {arrowTower1, arrowTower2, arrowTower3, arrowTower4};
        arrowTowerAnimation = new Animation(0.1f, atowers);
        arrowTowerAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //WitchTower
        witchTower = new Texture(Gdx.files.internal("towers/witchtower.png"));
        witchTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        witchTower1 = new TextureRegion(witchTower, 0, 0, 24, 24);
        witchTower2 = new TextureRegion(witchTower, 24, 0, 24, 24);
        witchTower3 = new TextureRegion(witchTower, 48, 0, 24, 24);
        witchTower4 = new TextureRegion(witchTower, 72, 0, 24, 24);
        TextureRegion[] wtowers = {witchTower1, witchTower2, witchTower3, witchTower4};
        witchTowerAnimation = new Animation(0.1f, wtowers);
        witchTowerAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //StickyTower
        stickyTower = new Texture(Gdx.files.internal("towers/stickytower.png"));
        stickyTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        stickyTower1 = new TextureRegion(stickyTower, 0, 0, 24, 24);
        stickyTower2 = new TextureRegion(stickyTower, 24, 0, 24, 24);
        stickyTower3 = new TextureRegion(stickyTower, 48, 0, 24, 24);
        stickyTower4 = new TextureRegion(stickyTower, 72, 0, 24, 24);
        TextureRegion[] stowers = {stickyTower1, stickyTower2, stickyTower3, stickyTower4};
        stickyTowerAnimation = new Animation(0.1f, stowers);
        stickyTowerAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //CyclopTower
        cyclopTower = new Texture(Gdx.files.internal("towers/cycloptower.png"));
        cyclopTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        cyclopTower1 = new TextureRegion(cyclopTower, 0, 0, 24, 24);
        cyclopTower2 = new TextureRegion(cyclopTower, 24, 0, 24, 24);
        cyclopTower3 = new TextureRegion(cyclopTower, 48, 0, 24, 24);
        cyclopTower4 = new TextureRegion(cyclopTower, 72, 0, 24, 24);
        TextureRegion[] ctowers = {cyclopTower1, cyclopTower2, cyclopTower3, cyclopTower4};
        cyclopTowerAnimation = new Animation(0.1f, ctowers);
        cyclopTowerAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //Redbullet
        redBullet = new Texture(Gdx.files.internal("bullets/redbullet.png"));
        redBullet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        redBullet1 = new TextureRegion(redBullet, 0, 0, 24, 24);

        //Preferences
        //Mediante el siguiente código, recupero las preferencias guardadas (records y opciones)
        preferences = Gdx.app.getPreferences("TPK");
            //Sonido
        if (!preferences.contains("sound")) {
            preferences.putBoolean("sound", true);
        }
        Stats.soundOn(preferences.getBoolean("sound"));
            //Musica
        if (!preferences.contains("music")) {
            preferences.putBoolean("music", true);
        }
        Stats.musicOn(preferences.getBoolean("music"));
            //Idioma
        if (!preferences.contains("language")) {
            preferences.putString("language", "EN");
        }
        switch (preferences.getString("language")){
            case "ES":
                myBundle = esBundle;
                break;
            case "EN":
                myBundle = enBundle;
                break;
            case "GL":
                myBundle = glBundle;
                break;
        }
            //Records
        if (!preferences.contains("highScore_level1")) {
            preferences.putInteger("highScore_level1", 0);
        }
        if (!preferences.contains("highScore_level2")) {
            preferences.putInteger("highScore_level2", 0);
        }
        if (!preferences.contains("highScore_level3")) {
            preferences.putInteger("highScore_level3", 0);
        }
        if (!preferences.contains("highScore_level4")) {
            preferences.putInteger("highScore_level4", 0);
        }
        preferences.flush();
    }

    /**
     * Liberación de recursos
     */
    public static void dispose(){
        level1.dispose();
        level2.dispose();
        level3.dispose();
        level4.dispose();

        skinArcade.dispose();
        skinMother.dispose();

        musicMainMenu.dispose();
        musicLevel1.dispose();
        musicLevel2.dispose();
        musicLevel3.dispose();
        musicLevel4.dispose();

        soundArrow.dispose();
        soundBuiltTower.dispose();
        soundCyclop.dispose();
        soundDead.dispose();
        soundDestroyTower.dispose();
        soundFundationSelected.dispose();
        soundRage.dispose();
        soundSticky.dispose();
        soundWitch.dispose();

        farmer.dispose();
        barbarian.dispose();
        thief.dispose();
        mage.dispose();

        farmerSlowed.dispose();
        barbarianSlowed.dispose();
        thiefSlowed.dispose();
        mageSlowed.dispose();

        arrowTower.dispose();
        witchTower.dispose();
        stickyTower.dispose();
        cyclopTower.dispose();

        redBullet.dispose();

    }

    public static LevelCreator getLevelCreator() {
        return levelCreator;
    }
}
