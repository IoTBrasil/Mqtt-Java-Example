package mqtt;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Created by wahrons on 24/03/17.
 */
public class MQTTConnect {

    private static final String BROKER_URL = "tcp://localhost:1883";
    private static final String DOMAIN = "<Insert m2m.io domain here>";
    private static final String USERNAME = "guest";
    private static final String PASSWORD = "guest";

    public MqttClient connect() throws MqttException {
        return connect(null);
    }

    public MqttClient connect(MqttCallback callback) throws MqttException {
        MqttConnectOptions connOpt = new MqttConnectOptions();

        connOpt.setCleanSession(true);
        connOpt.setKeepAliveInterval(30);
        connOpt.setUserName(USERNAME);
        connOpt.setPassword(PASSWORD.toCharArray());

        MqttClient client = new MqttClient(BROKER_URL, MqttClient.generateClientId());

        if (callback != null)
            client.setCallback(callback);
        client.connect(connOpt);

        return client;
    }

    public String getTopic() {
        return DOMAIN;
    }
}
