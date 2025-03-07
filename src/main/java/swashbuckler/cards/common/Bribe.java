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

public class Bribe extends AbstractEasyCard {
    public final static String ID = makeID("Bribe");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Bribe() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = damage = 12;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (p.gold >= 5) {
            AbstractDungeon.player.loseGold(5);
            dmg(m, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
        }
    }

    @Override
    public void upp() {
        upgradeDamage(4);
    }
}