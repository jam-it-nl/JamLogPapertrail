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
import java.util.List;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Splits this string around matches of the given regular expression.
 * Trailing empty strings are not included in the resulting array.
 * 
 * The string "boo:and:foo", for example, yields the following results with these expressions:
 * 
 * Regex	Result
 * :	{ "boo", "and", "foo" }
 * o	{ "b", "", ":and:f" }
 */
public class StringSplit extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private java.lang.String string;
	private java.lang.String regex;

	public StringSplit(IContext context, java.lang.String string, java.lang.String regex)
	{
		super(context);
		this.string = string;
		this.regex = regex;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		List<IMendixObject> result = new ArrayList<IMendixObject>();
		for (String splittedString : this.string.split(this.regex)){
			jamcommons.proxies.String stringMendixObejct = new jamcommons.proxies.String(this.getContext());
			stringMendixObejct.setValue(splittedString);
			result.add(stringMendixObejct.getMendixObject());
		}
		return result;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "StringSplit";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
