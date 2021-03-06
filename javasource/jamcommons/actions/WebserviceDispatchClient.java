// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package jamcommons.actions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import nl.jam.mendix.library.lib.http.HttpResponse;

/**
 * Call a webservice, defined by a WSDL, with a string request. This action returns the resulting xml as a string. The Mendix input mapper could be used to map the xml to Mendix objects.
 */
public class WebserviceDispatchClient extends CustomJavaAction<IMendixObject>
{
	private java.lang.String wsdlDocumentLocation;
	private java.lang.String endpointUrl;
	private java.lang.String namespace;
	private java.lang.String serviceName;
	private java.lang.String portName;
	private java.lang.String request;
	private java.lang.Boolean useAddressing;
	private java.lang.String soapActionUri;

	public WebserviceDispatchClient(IContext context, java.lang.String wsdlDocumentLocation, java.lang.String endpointUrl, java.lang.String namespace, java.lang.String serviceName, java.lang.String portName, java.lang.String request, java.lang.Boolean useAddressing, java.lang.String soapActionUri)
	{
		super(context);
		this.wsdlDocumentLocation = wsdlDocumentLocation;
		this.endpointUrl = endpointUrl;
		this.namespace = namespace;
		this.serviceName = serviceName;
		this.portName = portName;
		this.request = request;
		this.useAddressing = useAddressing;
		this.soapActionUri = soapActionUri;
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		nl.jam.mendix.library.lib.http.WebserviceDispatchClient webserviceDispatchClient = new nl.jam.mendix.library.lib.http.WebserviceDispatchClient(
				this.wsdlDocumentLocation, this.endpointUrl, this.namespace, this.serviceName, this.portName,
				this.useAddressing, this.soapActionUri);
		HttpResponse httpResponse = webserviceDispatchClient.invoke(this.request);

		system.proxies.HttpResponse httpResponseMendixObject = new system.proxies.HttpResponse(super.getContext());
		httpResponseMendixObject.setContent(httpResponse.getContent());

		Map<String, List<String>> responseHeaders = httpResponse.getResponseHeaders();
		for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
			system.proxies.HttpHeader httpHeader = new system.proxies.HttpHeader(this.getContext());
			httpHeader.setHttpHeaders(httpResponseMendixObject);
			httpHeader.setKey(entry.getKey());
			httpHeader.setValue(entry.getValue().stream().map(x -> x).collect(Collectors.joining(", ")));
		}

		return httpResponseMendixObject.getMendixObject();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "WebserviceDispatchClient";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
