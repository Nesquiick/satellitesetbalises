package views;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import nicellipse.component.NiImage;

public class GrAntenne extends GrElement {
    private static final long serialVersionUID = -8672390241177685075L;

    public GrAntenne(GrEther ether) {
        super(ether);
        File path = new File("antenne.png");
        BufferedImage rawImage = null;
        try {
            rawImage = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(new NiImage(rawImage));
        this.setDimension(new Dimension(rawImage.getWidth(), rawImage.getHeight()));

    }
}