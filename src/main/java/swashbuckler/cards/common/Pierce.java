package swashbuckler.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.actions.ExhaustTreasureAction;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.util.HelperFunctions;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;

public class Pierce extends AbstractEasyCard {
    public final static String ID = makeID("Pierce");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Pierce() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = damage = 6;
        baseMagicNumber = magicNumber = 15;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (HelperFunctions.hasTreasure()) {
            atb(new ExhaustTreasureAction());
            damage = magicNumber;
            dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        } else {
            dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        }
    }

    @Override
    public void upp() {
        upgradeDamage(3);
        upgradeMagicNumber(3);
    }
}