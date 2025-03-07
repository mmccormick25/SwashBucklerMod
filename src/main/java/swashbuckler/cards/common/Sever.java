package swashbuckler.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.powers.BleedPower;
import swashbuckler.powers.LambdaPower;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.*;

public class Sever extends AbstractEasyCard {
    public final static String ID = makeID("Sever");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Sever() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 6;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_VERTICAL);
        //addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new BleedPower((AbstractCreature)m, 3, false), 3));
        applyToEnemy(m, new BleedPower(makeID("BleedPower"), "Bleed", AbstractPower.PowerType.DEBUFF, true, m,3));
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}