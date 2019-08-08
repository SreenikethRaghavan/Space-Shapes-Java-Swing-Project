package spaceshapes.views;

import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelEvent.EventType;
import spaceshapes.ShapeModelListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

/**
 * Class uses the adapter pattern to make the two incompatible interfaces 
 * compatible with each other.
 * @author Sreeniketh Raghavan
 * 
 */
public class Task2 extends Task1 implements ShapeModelListener {

	public Task2(ShapeModel shapeModel) {

		super(shapeModel);
	}

	public TreeModelEvent convertToTreeModelEvent(ShapeModelEvent shapeModelEvent) {	

		Object sourceModelOfEvent = shapeModelEvent.source();		
		Object[] pathToParentShape = shapeModelEvent.parent().path().toArray();
		int[] indexOfShapeWithinParent = {shapeModelEvent.index()};
		Object[] shapeRelatedToEvent = {shapeModelEvent.operand()};

		return new TreeModelEvent(sourceModelOfEvent, pathToParentShape, indexOfShapeWithinParent, shapeRelatedToEvent);

	}


	public void update(ShapeModelEvent event) {

		TreeModelEvent treeModelEvent;

		try {

			treeModelEvent = convertToTreeModelEvent(event);
		}

		catch (NullPointerException n) {   // If the Shape object doesn't have a parent CarrierShape object

			return; 
		}

		if(event.eventType() == EventType.ShapeAdded) {

			for (TreeModelListener listener : _treeModelListeners) {

				listener.treeNodesInserted(treeModelEvent);
			}
		}

		else if (event.eventType() == EventType.ShapeRemoved) {

			for (TreeModelListener listener : _treeModelListeners) {

				listener.treeNodesRemoved(treeModelEvent);
			}
		}

		else {

			return;
		}

	}

}
