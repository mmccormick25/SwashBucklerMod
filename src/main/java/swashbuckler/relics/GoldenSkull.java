package swashbuckler.relics;

import swashbuckler.CharacterFile;
import swashbuckler.cards.tempCards.Treasure;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.makeInHand;

public class GoldenSkull extends AbstractEasyRelic {
    public static final String ID = makeID("GoldenSkull");

    public GoldenSkull() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, CharacterFile.Enums.SWASHBUCKLER_COLOR);
    }

    public void atBattleStart() {
        makeInHand(new Treasure());
    }
}
