package com.apitraining.Automation.interfac;

public interface APIInterface {
	
	void apigetcall();
	void apipostcall();
	void apipatchcall();
	void apiputcall();
	void apideletecall();
	
	void bearerauth();
	void basicauth();
	void akamaiauth();
	void awsauth();
	void digestauth();
	void hawkauth();
	void jwtauth();
	void apikeyauth();
	void ntmlauth();
	void oauth1();
	void oauth2();
}

