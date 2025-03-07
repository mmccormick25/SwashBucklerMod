package swashbuckler.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.cards.AbstractEasyCard;

import static swashbuckler.ModFile.makeID;

public class GraspingShadow extends AbstractEasyCard {
    public final static String ID = makeID("GraspingShadow");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public GraspingShadow() {
        super(ID, 2, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 14;
        this.isEthereal = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SMASH);
    }

    @Override
    public void upp() {
        upgradeDamage(4);
    }
}