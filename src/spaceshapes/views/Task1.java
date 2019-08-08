package spaceshapes.views;

import spaceshapes.ShapeModel;
import javax.swing.tree.TreeModel;
import spaceshapes.CarrierShape;
import spaceshapes.Shape;
import javax.swing.tree.TreePath;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelListener;


/**
 * Class uses the adapter pattern to make the two incompatible interfaces 
 * compatible with each other.
 * @author Sreeniketh Raghavan
 * 
 */
public class Task1 implements TreeModel {

	private ShapeModel _shapeModel;

	protected List<TreeModelListener> _treeModelListeners = new ArrayList<TreeModelListener>();

	public Task1(ShapeModel shapeModel) {
		_shapeModel = shapeModel;
	}

	public Object getRoot() {		

		return _shapeModel.root();
	}

	public Object getChild(Object parent, int index) {

		Shape child = null;

		try {

			if(parent instanceof CarrierShape) {

				CarrierShape parentShape = (CarrierShape)parent;
				child = parentShape.shapeAt(index);
			}
		}

		catch (IndexOutOfBoundsException i) {

		}

		return child;
	}

	public int getChildCount(Object parent) {

		int shapeCount = 0;

		if(parent instanceof CarrierShape) {

			CarrierShape parentShape = (CarrierShape)parent;
			shapeCount = parentShape.shapeCount();
		}

		return shapeCount;

	}

	public boolean isLeaf(Object node) {

		return !(node instanceof CarrierShape );
	}

	public int getIndexOfChild(Object parent, Object child) {

		if(parent == null || child == null) {
			return -1;
		}

		if(parent instanceof CarrierShape && child instanceof Shape) {

			CarrierShape parentShape = (CarrierShape)parent;
			Shape shape = (Shape)child;
			return parentShape.indexOf(shape);
		}

		return -1;
	}

	public void addTreeModelListener(TreeModelListener l) {		
		_treeModelListeners.add(l);
	}

	public void removeTreeModelListener(TreeModelListener l) {
		_treeModelListeners.remove(_treeModelListeners.indexOf(l));
	}

	public void valueForPathChanged(TreePath path, Object newValue) {

	}


}