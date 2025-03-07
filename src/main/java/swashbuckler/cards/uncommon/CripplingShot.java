package swashbuckler.cards.uncommon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.powers.BleedPower;
import swashbuckler.powers.LambdaPower;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.applyToEnemy;
import static swashbuckler.util.Wiz.removePower;

public class CripplingShot extends AbstractEasyCard {
    public final static String ID = makeID("CripplingShot");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public CripplingShot() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 7;
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        applyToEnemy(m, new BleedPower(makeID("BleedPower"), "Bleed", AbstractPower.PowerType.DEBUFF, true, m, magicNumber));
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)m, 1, false), 3));
    }

    @Override
    public void upp() {
        upgradeDamage(3);
        upgradeMagicNumber(1);
    }
}