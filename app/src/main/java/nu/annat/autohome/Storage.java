package nu.annat.autohome;

import java.util.List;

import nu.annat.autohome.api.Sensor;
import nu.annat.autohome.api.SensorList;
import nu.annat.autohome.api.Unit;

public class Storage {
	private static Storage Instance = new Storage();
	private List<Unit> sensors;

	private Storage() {
	}

	public static Storage getInstance() {
		return Instance;
	}

	public Unit getSensorId(String id) {
		for (Unit sensor : sensors) {
			if(sensor.id.equals(id))
				return  sensor;
		}
		return null;
	}

	public void addSensors(List<Unit> sensors) {
		this.sensors = sensors;
	}
}
