package org.richardclay.client;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface GWTServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.richardclay.client.GWTService
     */
    void addMessage( java.lang.String s, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.richardclay.client.GWTService
     */
    void getMessages( AsyncCallback<java.lang.String[]> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static GWTServiceAsync instance;

        public static final GWTServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (GWTServiceAsync) GWT.create( GWTService.class );
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "gwtservice" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
