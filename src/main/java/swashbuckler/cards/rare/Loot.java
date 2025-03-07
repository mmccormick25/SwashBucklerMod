package swashbuckler.cards.rare;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.actions.ExhaustTreasureAction;
import swashbuckler.actions.LootAction;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.cards.tempCards.Treasure;
import swashbuckler.util.HelperFunctions;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;

public class Loot extends AbstractEasyCard {
    public final static String ID = makeID("Loot");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Loot() {
        super(ID, 3, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        this.exhaust = true;
        cardsToPreview = new Treasure(); // Preview a miracle
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new LootAction(false));
    }

    @Override
    public void upp() {
        upgradeBaseCost(2);
    }
}