package swashbuckler.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.cards.AbstractEasyCard;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;

public class TalkToTheDead extends AbstractEasyCard {
    public final static String ID = makeID("TalkToTheDead");
    // intellij stuff skill, self, uncommon, , , , , ,

    public TalkToTheDead() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF); // This card is a 2 cost basic attack targeting enemy
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int drawSize = AbstractDungeon.player.drawPile.size();
        int limit = 0;
        if (drawSize < magicNumber) {
            limit = drawSize;
        } else {
            limit = magicNumber;
        }
        for (int n = 0; n < limit; n++) {
            AbstractCard c = AbstractDungeon.player.drawPile.getNCardFromTop(n);
            if (!c.isEthereal) {
                c.isEthereal = true;
                c.rawDescription = c.rawDescription.concat(" NL Ethereal.");
                c.initializeDescription();
            }
        }
        atb(new DrawCardAction(magicNumber));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}