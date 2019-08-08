package spaceshapes.forms;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.SwingWorker;

import spaceshapes.ImageRectangleShape;
import spaceshapes.CarrierShape;
import spaceshapes.ShapeModel;
import spaceshapes.forms.util.Form;
import spaceshapes.forms.util.FormHandler;

/**
 * @author Sreeniketh Raghavan
 * 
 */
public class ImageShapeFormHandler implements FormHandler {

	private ShapeModel _model;
	private CarrierShape _parentOfNewShape;

	public ImageShapeFormHandler(
			ShapeModel model,
			CarrierShape parent) {
		_model = model;
		_parentOfNewShape = parent;
	}


	@Override
	public void processForm(Form form) {
		MyImageWorker worker = new MyImageWorker(form);
		worker.execute();
	}


	private class MyImageWorker extends SwingWorker<BufferedImage, Void> {

		private Form _form;
		private long startTime;
		private File imageFile;
		private int width;
		private int deltaX;
		private int deltaY;
		private int fullImageWidth;
		private int fullImageHeight;
		private BufferedImage fullImage;


		private MyImageWorker(Form form) {

			_form = form;			
			startTime = System.currentTimeMillis();

			// Read field values from the form.
			imageFile = (File)_form.getFieldValue(File.class, ImageFormElement.IMAGE);
			width = _form.getFieldValue(Integer.class, ShapeFormElement.WIDTH);
			deltaX = _form.getFieldValue(Integer.class, ShapeFormElement.DELTA_X);
			deltaY = _form.getFieldValue(Integer.class, ShapeFormElement.DELTA_Y);

		}


		@Override
		protected BufferedImage doInBackground() {

			// Load the original image (ImageIO.read() is a blocking call).
			fullImage = null;
			try {
				fullImage = ImageIO.read(imageFile);
			} catch(IOException e) {
				System.out.println("Error loading image.");
			}

			fullImageWidth = fullImage.getWidth();
			fullImageHeight = fullImage.getHeight();	

			BufferedImage scaledImage = fullImage;

			// Scale the image if necessary.
			if(fullImageWidth > width) {
				double scaleFactor = (double)width / (double)fullImageWidth;
				int height = (int)((double)fullImageHeight * scaleFactor);

				scaledImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); 
				Graphics2D g = scaledImage.createGraphics();

				// Method drawImage() scales an already loaded image. The 
				// ImageObserver argument is null because we don't need to monitor 
				// the scaling operation.
				g.drawImage(fullImage, 0, 0, width, height, null);
			}

			return scaledImage;
		}



		@Override 
		protected void done() {

			BufferedImage scaledImage = null;

			try {
				scaledImage = get();
			}

			catch(ExecutionException e) {
				System.err.println(e);
			}

			catch(InterruptedException e) {
				System.err.println(e);
			}

			// Create the new Shape and add it to the model.
			ImageRectangleShape imageShape = new ImageRectangleShape(deltaX, deltaY, scaledImage);
			_model.add(imageShape, _parentOfNewShape);

			long elapsedTime = System.currentTimeMillis() - startTime;
			System.out.println("Image loading and scaling took " + elapsedTime + "ms.");

		}
	}
}
