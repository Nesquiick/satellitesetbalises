package views;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import events.PositionChanged;
import nicellipse.component.NiImage;
import nicellipse.component.NiLabel;

public class GrSatellite extends GrElementMobile {
	private static final long serialVersionUID = -8534493300853878234L;
	private final NiLabel label = new NiLabel("0");

	public GrSatellite(GrEther ether) {
		super(ether);
		File path = new File("satellite.png");
		BufferedImage rawImage = null;
		try {
			rawImage = ImageIO.read(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(label);
		this.add(new NiImage(rawImage));
		this.setDimension(new Dimension(rawImage.getWidth(), rawImage.getHeight()));
	}

	/**
	 * Change la localisation de l'image en fonction du placement de la balise
	 * Récupération de la taille des données afin de l'afficher
	 */
	@Override
	public void whenPositionChanged(PositionChanged arg) {
		this.setLocation(this.model.getPosition());
		if(!String.valueOf(this.model.dataSize()).equals(label.getText())){
			label.setText(String.valueOf(this.model.dataSize()));
		}
		this.repaint();
	}
	
}
