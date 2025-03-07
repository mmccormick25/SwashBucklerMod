package swashbuckler.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.applyToEnemy;
import static swashbuckler.util.Wiz.removePower;

public class PiercingRoundsPower extends AbstractPower {
    public static final String POWER_ID = "PiercingRounds";

    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("Envenom");

    public static final String NAME = powerStrings.NAME;

    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public PiercingRoundsPower(AbstractCreature owner, int newAmount) {
        this.name = NAME;
        this.ID = "PiercingRounds";
        this.owner = owner;
        this.amount = newAmount;
        updateDescription();
        loadRegion("envenom");
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
        if (damageAmount > 0 && target != this.owner && info.type == DamageInfo.DamageType.NORMAL) {
            flash();
            applyToEnemy((AbstractMonster) target, new BleedPower(makeID("BleedPower"), "Bleed", AbstractPower.PowerType.DEBUFF, true, target, amount));
        }
    }
}
