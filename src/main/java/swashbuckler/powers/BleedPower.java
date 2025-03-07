package swashbuckler.powers;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static swashbuckler.util.Wiz.removePower;

public class BleedPower extends LambdaPower {
    public BleedPower(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, powerType, isTurnBased, owner, amount);
    }

    @Override
    public void atStartOfTurn() {
        if(!owner.hasPower("swashbuckler:LeechPower")) {
            removePower(this);
        }
    }

    @Override
    public float atDamageReceive(float damage, DamageInfo.DamageType type) {
        return damage + amount;
    }

    @Override
    public void updateDescription() {
        description = "Bleed " + amount;
    }
}

