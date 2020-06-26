package com.bustos.oscar.mathpower.game.service.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.bustos.oscar.mathpower.common.services.pythagoras.Pythagoras;
import com.google.gson.Gson;

@Component
public class PythagorasClient {

	public static Pythagoras generateRandomPythagoras() {
		Pythagoras pythagoras = null;
		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
		HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/random/pitagoras"))
				.header("Content-Type", "application/json").GET().build();
		CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,
				HttpResponse.BodyHandlers.ofString());
		try {
			pythagoras = new Gson().fromJson(response.get().body(), Pythagoras.class);

		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pythagoras;

	}

}
