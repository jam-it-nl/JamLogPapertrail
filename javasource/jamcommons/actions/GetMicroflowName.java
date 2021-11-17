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
import com.mendix.webui.CustomJavaAction;

/**
 * Use GetMicroflowName when a Microflow name needs to be passed as String but you don't want to loose the Find Usages functionality. 
 */
public class GetMicroflowName extends CustomJavaAction<java.lang.String>
{
	private java.lang.String microflow;

	public GetMicroflowName(IContext context, java.lang.String microflow)
	{
		super(context);
		this.microflow = microflow;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		return this.microflow;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetMicroflowName";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
