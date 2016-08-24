package nu.annat.autohome.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import nu.annat.autohome.api.DimmerUnit;
import nu.annat.autohome.api.SwitchUnit;
import nu.annat.autohome.api.Unit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Server {
	public static Server instance;

	public static class r<T> implements TypeAdapterFactory {
		private final Class<?> baseClass = Unit.class;

		@Override
		public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
			if (type.getRawType() != baseClass) return null;

			//TypeAdapter<SwitchUnit> delegateAdapter = gson.getDelegateAdapter(this, TypeToken.get(SwitchUnit.class));
			return new TypeAdapter<T>() {
				@Override
				public void write(JsonWriter out, T value) throws IOException {

				}

				@Override
				public T read(JsonReader in) throws IOException {
					JsonElement jsonElement = Streams.parse(in);
					String labelJsonElement = jsonElement.getAsJsonObject().get("type").getAsString();
					Class<?> cls= getClassFromLabel(labelJsonElement);
					TypeAdapter<?> delegateAdapter = gson.getAdapter(TypeToken.get(cls));
					return (T) delegateAdapter.fromJsonTree(jsonElement);
				}

				private Class<?> getClassFromLabel(String labelJsonElement) {
					switch (labelJsonElement){
						case "SwitchUnit":return SwitchUnit.class;
						case "DimmerUnit":return DimmerUnit.class;
						default: return Unit.class;
					}
				}
			};
		}
	}

	private Api service;
	private Retrofit retrofit;

	public Server() {
		Retrofit.Builder builder = new Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create(getGson()))
			.baseUrl("http://192.168.1.125:5443/api/");
		retrofit = builder.build();
		service = retrofit.create(Api.class);
	}

	public static Server getInstance() {
		if (instance == null) {
			instance = new Server();
		}
		return instance;
	}

	private Gson getGson() {
		Gson gson = new GsonBuilder()
			.registerTypeAdapterFactory(new r<Unit>())
			.create();

		return gson;
	}

	public Api getService() {
		return service;
	}
}
