package com.mygdx.actors.towers;

import static com.mygdx.helpers.Stats.BASE_BULLET_SPEED;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.actors.enemies.Enemy;
import com.mygdx.gameworld.World;

/**
 * Esta clase gestiona las propiedades y comportamiento de los proyectiles disparados por las torres
 */
public class Bullet extends Image {

    private World world;
    private Tower tower;
    private Enemy target;

    private Vector2 position;
    private Vector2 moveVec;
    private int damage, speed;
    private Debuff debuff;
    private boolean alive;

    /**
     * Crea un nuevo bullet y asigna valores en función de la torre que dispara
     * @param world Referencia del nivel
     * @param tower La tower que disparó el bullet
     * @param target El enemy objetivo del disparo
     */
    public Bullet (World world, Tower tower, Enemy target){
        super();

        this.world = world;
        this.tower = tower;
        this.target = target;

        this.position = new Vector2();
        this.position.x = tower.getX() + (tower.getWidth() / 2);
        this.position.y = tower.getY() + (tower.getHeight() / 2);
        this.setBounds(this.position.x, this.position.y, 12, 12);

        this.moveVec = new Vector2();
        this.damage = tower.getDamage();
        this.speed = tower.getProjectileSpeed();
        this.debuff = tower.getDebuff();

        this.alive = true;

    }

    /**
     * Actualiza el estado del bullet. Si el objetivo muere antes de llegar, la bullet desaparece ('muere')
     * @param delta Tasa de refresco
     */
    public void update(float delta){
        if (target.isAlive()){
            fly(delta);
        } else {
            alive = false;
        }
    }

    /**
     * Mueve la bullet hacia su objetivo. Si impacta, hace daño y aplica debuff (si hay)
     * @param delta Tasa de refresco
     */
    public void fly(float delta){
        if (this.position.dst(target.getCenter()) <= speed && alive) {
            if (this.debuff != null){
                target.setTimeDebuffed(0);
                target.setDebuff(debuff);
            }
            target.setHp(target.getHp() - damage);
            this.alive = false;
        } else {
            moveVec.set(BASE_BULLET_SPEED * speed * delta, 0);
            moveVec.setAngleRad((float) Math.atan2(target.getCenter().y - this.position.y, target.getCenter().x - this.position.x));
            position.add(moveVec);
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public boolean isAlive() {
        return alive;
    }
}
