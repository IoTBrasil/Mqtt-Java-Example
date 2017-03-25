import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import mqtt.MQTTConnect;
import mqtt.MQTTPublisher;

/**
 * Created by wahrons on 24/03/17.
 */
public class PublicherRunner {
    public static void main(String[] args) throws InterruptedException, MqttException {
        MQTTConnect mqttConnect = new MQTTConnect();
        MQTTPublisher publisher = new MQTTPublisher();

        MqttClient connect = mqttConnect.connect(publisher);
        String topic = mqttConnect.getTopic();
        for (int i = 1; i <= 1000; i++) {
            String message = "{\"pubmsg\":" + i + "}";
            publisher.publishMessage(connect, topic, message);
            System.out.println(message);
        }
    }
}
