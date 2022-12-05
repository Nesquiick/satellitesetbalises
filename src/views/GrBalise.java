package views;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import events.PositionChanged;
import nicellipse.component.NiImage;
import nicellipse.component.NiLabel;

public class GrBalise extends GrElementMobile {
	private static final long serialVersionUID = -8672390241177685075L;
	private final NiLabel label = new NiLabel("0");

	public GrBalise(GrEther ether) {
		super(ether);
		File path = new File("balise.png");
		BufferedImage rawImage = null;
		try {
			rawImage = ImageIO.read(path);
			this.add(label);
			this.add(new NiImage(rawImage));
			this.setDimension(new Dimension(rawImage.getWidth(), rawImage.getHeight()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Change la localisation de l'image en fonction du placement de la balise
	 * Récupération de la taille des données afin de l'afficher
	 */
	@Override
	public void whenPositionChanged(PositionChanged arg) {
		this.setLocation(this.model.getPosition());
		if(!String.valueOf(this.model.getDataSize()).equals(label.getText())){
			label.setText(String.valueOf(this.model.getDataSize()));
		}
		this.repaint();
	}
}
