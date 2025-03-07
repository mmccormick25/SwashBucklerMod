package swashbuckler.cards.rare;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.actions.ExhaustTreasureAction;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.util.HelperFunctions;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;

public class HeavyShot extends AbstractEasyCard {
    public final static String ID = makeID("HeavyShot");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public HeavyShot() {
        super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = damage = 20;
        baseMagicNumber = magicNumber = 30;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (HelperFunctions.hasTreasure()) {
            atb(new ExhaustTreasureAction());
            damage = magicNumber;
            dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        } else {
            dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        }
    }

    @Override
    public void upp() {
        upgradeDamage(10);
        upgradeMagicNumber(10);
    }
}