package swashbuckler.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.actions.ExhaustTreasureAction;
import swashbuckler.actions.MakeTreasureAction;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.cards.tempCards.Treasure;
import swashbuckler.util.HelperFunctions;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;
import static swashbuckler.util.Wiz.makeInHand;

public class Evade extends AbstractEasyCard {
    public final static String ID = makeID("Evade");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Evade() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 10;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new GainBlockAction(AbstractDungeon.player, baseBlock));
        atb(new MakeTreasureAction());
    }

    @Override
    public void upp() {
        upgradeBlock(4);
    }
}