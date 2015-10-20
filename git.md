# git

 Cache login for a bit

	git config credential.helper cache
	
Next use of credentials cached for 900 seconds. To cache for specific period of time pass the `timeout=` option like

	git config credential.helper 'cache --timeout=300'	