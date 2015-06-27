package fiuba.algo3.starcraft.integration.player;

import fiuba.algo3.starcraft.logic.map.Map;
import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.map.exceptions.NoResourcesToExtract;
import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.builders.TerranBuilder;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.terran.BarracaTemplate;
import fiuba.algo3.starcraft.logic.templates.structures.terran.DepositoSuministroTemplate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructionQueueTest {

    Player player;
    Map map;
    ConstructionStructure barraca;
    Structure deposito;
    @Before
    public void before() {
        map = new Map(1000, null);
        player = new Player("Pepe", null, new TerranBuilder(), new Point(1,1), new Resources(500,500), map);
        barraca = new BarracaTemplate().create(new Point(10,10));
        deposito = new DepositoSuministroTemplate().create(new Point(20,20));
    }

    @Test
    public void testDestroyingAConstructionStructureDestroysAllQueuedUnits() throws NoResourcesToExtract, InsufficientResources, TemplateNotFound, MissingStructureRequired, QuotaExceeded {
        player.receiveNewStructure(deposito);
        player.receiveNewStructure(barraca);
        player.newUnitWithName("Marine", barraca);
        barraca.reduceLife(9999);
        for (int i = 0; i < 20; i++) {
            player.newTurn();
        }
        assertEquals(player.numberOfUnits(), 0);
    }
}
