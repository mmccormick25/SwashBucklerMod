package swashbuckler.cards.rare;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.actions.ExhaustTreasureAction;
import swashbuckler.cards.AbstractEasyCard;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.HelperFunctions.countTreasure;
import static swashbuckler.util.Wiz.atb;

public class CashIn extends AbstractEasyCard {
    public final static String ID = makeID("CashIn");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public CashIn() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        baseMagicNumber = magicNumber = 6;
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int count = countTreasure();

        for (int i = 0; i < count; i++) {
            atb(new ExhaustTreasureAction());
        }

        AbstractDungeon.player.gainGold(count * magicNumber);

    }

    @Override
    public void upp() {
        upgradeMagicNumber(2);
    }
}