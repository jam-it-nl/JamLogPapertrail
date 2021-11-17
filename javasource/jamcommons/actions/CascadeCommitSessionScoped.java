// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package jamcommons.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

public class CascadeCommitSessionScoped extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject anyObject;

	public CascadeCommitSessionScoped(IContext context, IMendixObject anyObject)
	{
		super(context);
		this.anyObject = anyObject;
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		new FilteredCascadeCommit("JamCommons.SessionScoped|JamCommons.SessionScopedImage", this.getContext()).cascadeCommit(anyObject);		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "CascadeCommitSessionScoped";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}