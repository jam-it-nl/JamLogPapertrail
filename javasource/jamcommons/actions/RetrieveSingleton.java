// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package jamcommons.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.mendix.core.Core;
import com.mendix.core.objectmanagement.member.MendixObjectReference;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.meta.IMetaAssociation;

public class RetrieveSingleton extends CustomJavaAction<IMendixObject>
{
	private IMendixObject parent;
	private java.lang.String entity;

	public RetrieveSingleton(IContext context, IMendixObject parent, java.lang.String entity)
	{
		super(context);
		this.parent = parent;
		this.entity = entity;
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE

		if (this.parent == null) {
			List<IMendixObject> mxObjects = Core.retrieveXPathQuery(getContext(), "//" + this.entity);
			if (mxObjects.size() == 0) {
				IMendixObject mendixObject = Core.instantiate(getContext(), this.entity);
				Core.commit(getContext(), mendixObject);
				return mendixObject;
			} else if (mxObjects.size() == 1) {
				return mxObjects.get(0);
			} else {
				throw new Exception("More then one instance was found for " + this.entity
						+ " with no parent object, while the singleton pattern was expected.");
			}
		} else {
			
			
			List<IMetaAssociation> associationsToChild = new ArrayList<IMetaAssociation>();

			
			Collection<? extends IMetaAssociation> metaAssociationsParent = this.parent.getMetaObject().getMetaAssociationsParent();
			for (IMetaAssociation metaAssociation : metaAssociationsParent)
			{
				if (this.entity.equals(metaAssociation.getChild().getName())){
					associationsToChild.add(metaAssociation);
				}			
			}
			
			if (associationsToChild.size() > 1){
				throw new Exception("More then one relation was found for " + this.parent.getType() + "." + this.entity
						+ " while the singleton pattern was expected.");
			}
			
			for (IMetaAssociation metaAssociation : associationsToChild)
			{
				List<IMendixObject> mxObjects = Core.retrieveByPath(this.getContext(), this.parent, metaAssociation.getName());
				
				if (mxObjects.size() == 0) {
					IMendixObject mendixObject = Core.instantiate(getContext(), this.entity);						
					this.parent.setValue(getContext(), metaAssociation.getName(), mendixObject.getId());
										
					Core.commit(getContext(), mendixObject);
					Core.commit(getContext(), this.parent);
					return mendixObject;
				} else if (mxObjects.size() == 1) {
					return mxObjects.get(0);
				} else {
					throw new Exception("More then one instance was found for " + this.parent.getType() + "." + this.entity
							+ " while the singleton pattern was expected.");
				}
			}
			
			throw new Exception("No association was found between " + this.parent.getType() + " and " + this.entity + ".");
		}

		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "RetrieveSingleton";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}