package fiuba.algo3.starcraft.logic.templates;

public class ProtossBuilder extends Builder {

	public static ProtossBuilder instance = new ProtossBuilder();
	
	private ProtossBuilder() {
		templates.add(PilonTemplate.getInstance());
		templates.add(AccesoTemplate.getInstance());
		templates.add(PuertoEstelarTemplate.getInstance());
		templates.add(ArchivosTemplariosTemplate.getInstance());
		templates.add(NexoMineralTemplate.getInstance());
		templates.add(AsimiladorTemplate.getInstance());
	}
	
	public static ProtossBuilder getInstance(){
		return instance;
	}
}
