# git


#### Cache login

To save login credentials for a specified period of time on your local machine

	git config credential.helper cache
	
Next use of credentials cached for 900 seconds. To cache for specific period of time pass the `timeout=` option like

	git config credential.helper 'cache --timeout=300'	