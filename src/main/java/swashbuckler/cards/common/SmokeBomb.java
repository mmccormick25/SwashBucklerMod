package swashbuckler.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.cards.tempCards.Treasure;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;
import static swashbuckler.util.Wiz.makeInHand;

public class SmokeBomb extends AbstractEasyCard {
    public final static String ID = makeID("SmokeBomb");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public SmokeBomb() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = 10;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (p.gold >= 5) {
            AbstractDungeon.player.loseGold(5);
            atb(new GainBlockAction(AbstractDungeon.player, baseBlock));
        }
    }

    @Override
    public void upp() {
        upgradeBlock(4);
    }
}