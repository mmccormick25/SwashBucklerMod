package swashbuckler.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import swashbuckler.actions.MakeTreasureAction;
import swashbuckler.cards.tempCards.Treasure;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.*;

public class Pillage extends AbstractEasyCard {
    public final static String ID = makeID("Pillage");
    // intellij stuff skill, self, uncommon, , , , , ,

    public Pillage() {
        super(ID, 2, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY); // This card is a 2 cost basic attack targeting enemy
        cardsToPreview = new Treasure(); // Preview a miracle
        baseDamage = 8;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_VERTICAL);
        atb(new MakeTreasureAction());
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}