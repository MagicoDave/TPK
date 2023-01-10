package com.mygdx.towers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.enemies.Enemy;

/**
 * Tower
 *
 * Esta clase abstracta contiene las propiedades comunes de todas las torres
 */
public abstract class Tower {

    Vector2 position = new Vector2();
    float damage;
    float range, projectileSpeed, fireRate = 0;
    Debuff debuff = new Debuff();
    Enemy target;
    int cost = 10;
    float rotation;

    int ID;
    int projectileSize;
    Color projectileColor;

    Tower(Tower model){
        this.position.set(model.position);
        this.damage = model.damage;
        this.debuff = new Debuff(model.debuff);
        this.range = model.range;
        this.projectileSpeed = model.projectileSpeed;
        this.cost = model.cost;
        this.fireRate = model.fireRate;
        this.ID = model.ID;
        this.projectileSize = model.projectileSize;
        this.projectileColor = model.projectileColor.cpy();
    }

    Tower(float x, float y, int ID){
        this.position.x = x + 15;
        this.position.y = y + 15;
        setToTower(ID);
    }

    public void setToTower(int ID) {
        this.ID = ID;
        if (ID == 1) {
            damage = 25;
            debuff.damage = 0;
            debuff.duration = 60;
            debuff.speedmulti = 1;
            projectileSpeed = 5;
            fireRate = 0.5f;
            range = 300;
            projectileColor.set(Color.RED);
            projectileSize = 3;
        } else if (ID == 2) {
            damage = 0;
            debuff.damage = 0.05f;
            debuff.duration = 60;
            debuff.speedmulti = 0.2f;
            projectileSpeed = 1;
            fireRate = 1;
            range = 150;
            projectileColor.set(Color.CYAN);
            projectileSize = 5;
        } else if (ID == 3) {
            damage = 0;
            debuff.damage = 0.2f;
            debuff.duration = 60;
            debuff.speedmulti = 0.7f;
            projectileSpeed = 1f;
            fireRate = 30;
            range = 100;
            projectileColor.set(Color.ORANGE);
            projectileSize = 8;
        } else if (ID == 4) {
            damage = 0.5f;
            debuff.damage = 0.05f;
            debuff.duration = 60;
            debuff.speedmulti = 0.7f;
            projectileSpeed = 10;
            fireRate = 30;
            range = 300;
            projectileColor.set(Color.YELLOW);
            projectileSize = 2;
        } else if (ID == 5) {
            damage = 0;
            debuff.damage = 0f;
            debuff.duration = 600;
            debuff.speedmulti = 0f;
            projectileSpeed = 2f;
            fireRate = 0.3f;
            range = 1000;
            projectileColor.set(Color.YELLOW);
        }
    }

}
